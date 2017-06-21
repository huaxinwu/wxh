/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.ArrayList;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/**
 * 节拍模型
 * @author wxh
 * @version $Id: BeatModel.java, v 0.1 2017年6月20日 下午2:51:44 wxh Exp $
 */
public class BeatModel implements BeatModelInterface, MetaEventListener {

    Sequencer sequencer;
    ArrayList beatObservers = new ArrayList();
    ArrayList bpmObservers  = new ArrayList();
    int       bpm           = 90;
    // 其他实例变量
    Sequence  sequence;
    Track     track;

    /** 
     * @param meta
     * @see javax.sound.midi.MetaEventListener#meta(javax.sound.midi.MetaMessage)
     */
    @Override
    public void meta(MetaMessage meta) {
        if (meta.getType() == 47) {
            beatEvent();
            sequencer.start();
            setBPM(getBPM());
        }
    }

    /** 
     * 设置定序器和节拍音轨
     * @see com.wxh.designmode.BeatModelInterface#initialize()
     */
    @Override
    public void initialize() {
        setUpMidi();
        buildTrackAndStart();
    }

    /** 
     * 
     * @see com.wxh.designmode.BeatModelInterface#on()
     */
    @Override
    public void on() {
        sequencer.start();
        setBPM(90);
    }

    /** 
     * 
     * @see com.wxh.designmode.BeatModelInterface#off()
     */
    @Override
    public void off() {
        setBPM(0);
        sequencer.stop();
    }

    /** 
     * @param bpm
     * @see com.wxh.designmode.BeatModelInterface#setBPM(int)
     */
    @Override
    public void setBPM(int bpm) {
        this.bpm = bpm;
        sequencer.setTempoInBPM(getBPM());
        notifyBPMObservers();
    }

    /** 
     * @return
     * @see com.wxh.designmode.BeatModelInterface#getBPM()
     */
    @Override
    public int getBPM() {
        return bpm;
    }

    void beatEvent() {
        notifyBeatObservers();
    }

    public void notifyBPMObservers() {
        for (int i = 0; i < bpmObservers.size(); i++) {
            BPMObserver observer = (BPMObserver) bpmObservers.get(i);
            observer.updateBPM();
        }
    }

    public void notifyBeatObservers() {
        for (int i = 0; i < beatObservers.size(); i++) {
            BeatObserver observer = (BeatObserver) beatObservers.get(i);
            observer.updateBeat();
        }
    }

    /** 
     * @param o
     * @see com.wxh.designmode.BeatModelInterface#regeisterObserver(com.wxh.designmode.BeatObserver)
     */
    @Override
    public void regeisterObserver(BeatObserver o) {
        beatObservers.add(o);
    }

    /** 
     * @param o
     * @see com.wxh.designmode.BeatModelInterface#removeObserver(com.wxh.designmode.BeatObserver)
     */
    @Override
    public void removeObserver(BeatObserver o) {
        int i = beatObservers.indexOf(o);
        if (i >= 0) {
            beatObservers.remove(i);
        }
    }

    /** 
     * @param o
     * @see com.wxh.designmode.BeatModelInterface#regeisterObserver(com.wxh.designmode.BPMObserver)
     */
    @Override
    public void regeisterObserver(BPMObserver o) {
        bpmObservers.add(o);
    }

    /** 
     * @param o
     * @see com.wxh.designmode.BeatModelInterface#removeObserver(com.wxh.designmode.BPMObserver)
     */
    @Override
    public void removeObserver(BPMObserver o) {
        int i = bpmObservers.indexOf(o);
        if (i >= 0) {
            bpmObservers.remove(i);
        }
    }

    /**
     * 定序器
     */
    public void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addMetaEventListener(this);
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(getBPM());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 节拍音轨
     */
    public void buildTrackAndStart() {
        int[] trackList = { 35, 0, 46, 0 };
        sequence.deleteTrack(null);
        track = sequence.createTrack();
        makeTracks(trackList);
        track.add(makeEvent(192, 9, 1, 0, 4));
        try {
            sequencer.setSequence(sequence);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 制作音轨
     * @param list
     */
    public void makeTracks(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int key = list[i];
            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i + 1));
            }
        }
    }

    /**
     * 制作事件
     * @param cmd
     * @param chan
     * @param one
     * @param two
     * @param tick
     * @return
     */
    public MidiEvent makeEvent(int cmd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage msg = new ShortMessage();
            msg.setMessage(cmd, chan, one, two);
            event = new MidiEvent(msg, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }
}

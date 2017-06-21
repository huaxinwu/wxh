/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.ArrayList;
import java.util.Random;

/**
 * 心跳模型
 * @author wxh
 * @version $Id: HeartModel.java, v 0.1 2017年6月20日 下午3:57:11 wxh Exp $
 */
public class HeartModel implements HeartModelInterface, Runnable {

    ArrayList beatObservers = new ArrayList();
    ArrayList bpmObservers  = new ArrayList();
    int       time          = 1000;
    int       bpm           = 90;
    Random    random        = new Random(System.currentTimeMillis());
    Thread    thread;

    public HeartModel() {
        thread = new Thread(this);
        thread.start();
    }

    /** 
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        int lastrate = -1;
        for (;;) {
            int change = random.nextInt(10);
            if (random.nextInt(2) == 0) {
                change = 0 - change;
            }
            int rate = 60000 / (time + change);
            if (time < 120 && time > 50) {
                time += change;
                notifyBeatObservers();
                if (rate != lastrate) {
                    lastrate = rate;
                    notifyBPMObservers();
                }
            }
            try {
                Thread.sleep(time);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /** 
     * @param o
     * @see com.wxh.designmode.HeartModelInterface#regeisterObserver(com.wxh.designmode.BeatObserver)
     */
    @Override
    public void regeisterObserver(BeatObserver o) {
        beatObservers.add(o);
    }

    /** 
     * @param o
     * @see com.wxh.designmode.HeartModelInterface#removeObserver(com.wxh.designmode.BeatObserver)
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
     * @see com.wxh.designmode.HeartModelInterface#regeisterObserver(com.wxh.designmode.BPMObserver)
     */
    @Override
    public void regeisterObserver(BPMObserver o) {
        bpmObservers.add(o);
    }

    /** 
     * @param o
     * @see com.wxh.designmode.HeartModelInterface#removeObserver(com.wxh.designmode.BPMObserver)
     */
    @Override
    public void removeObserver(BPMObserver o) {
        int i = bpmObservers.indexOf(o);
        if (i >= 0) {
            bpmObservers.remove(i);
        }
    }

    /** 
     * 1分钟=60秒=60000毫秒
     * @return
     * @see com.wxh.designmode.HeartModelInterface#getHeartRate()
     */
    @Override
    public int getHeartRate() {
        return 60000 / time;
    }

    public void notifyBeatObservers() {
        for (int i = 0; i < beatObservers.size(); i++) {
            BeatObserver observer = (BeatObserver) beatObservers.get(i);
            observer.updateBeat();
        }
    }

    public void notifyBPMObservers() {
        for (int i = 0; i < bpmObservers.size(); i++) {
            BPMObserver observer = (BPMObserver) bpmObservers.get(i);
            observer.updateBPM();
        }
    }

}

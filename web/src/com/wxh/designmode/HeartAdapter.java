/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: HeartAdapter.java, v 0.1 2017年6月20日 下午3:48:05 wxh Exp $
 */
public class HeartAdapter implements BeatModelInterface {

    HeartModelInterface heart;

    public HeartAdapter(HeartModelInterface heart) {
        this.heart = heart;
    }

    /** 
     * 
     * @see com.wxh.designmode.BeatModelInterface#initialize()
     */
    @Override
    public void initialize() {
    }

    /** 
     * 
     * @see com.wxh.designmode.BeatModelInterface#on()
     */
    @Override
    public void on() {
    }

    /** 
     * 
     * @see com.wxh.designmode.BeatModelInterface#off()
     */
    @Override
    public void off() {
    }

    /** 
     * @param bpm
     * @see com.wxh.designmode.BeatModelInterface#setBPM(int)
     */
    @Override
    public void setBPM(int bpm) {
    }

    /** 
     * @return
     * @see com.wxh.designmode.BeatModelInterface#getBPM()
     */
    @Override
    public int getBPM() {
        return heart.getHeartRate();
    }

    /** 
     * @param o
     * @see com.wxh.designmode.BeatModelInterface#regeisterObserver(com.wxh.designmode.BeatObserver)
     */
    @Override
    public void regeisterObserver(BeatObserver o) {
        heart.regeisterObserver(o);
    }

    /** 
     * @param o
     * @see com.wxh.designmode.BeatModelInterface#removeObserver(com.wxh.designmode.BeatObserver)
     */
    @Override
    public void removeObserver(BeatObserver o) {
        heart.removeObserver(o);
    }

    /** 
     * @param o
     * @see com.wxh.designmode.BeatModelInterface#regeisterObserver(com.wxh.designmode.BPMObserver)
     */
    @Override
    public void regeisterObserver(BPMObserver o) {
        heart.regeisterObserver(o);
    }

    /** 
     * @param o
     * @see com.wxh.designmode.BeatModelInterface#removeObserver(com.wxh.designmode.BPMObserver)
     */
    @Override
    public void removeObserver(BPMObserver o) {
        heart.removeObserver(o);
    }

}

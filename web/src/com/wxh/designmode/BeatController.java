/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 控制器
 * @author wxh
 * @version $Id: BeatController.java, v 0.1 2017年6月20日 下午3:35:49 wxh Exp $
 */
public class BeatController implements ControllerInterfacr {

    BeatModelInterface model;
    DJView             view;

    public BeatController(BeatModelInterface model) {
        this.model = model;
        view = new DJView(this, model);
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
        model.initialize();
    }

    /** 
     * 
     * @see com.wxh.designmode.ControllerInterfacr#start()
     */
    @Override
    public void start() {
        model.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();
    }

    /** 
     * 
     * @see com.wxh.designmode.ControllerInterfacr#stop()
     */
    @Override
    public void stop() {
        model.off();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }

    /** 
     * @param bpm
     * @see com.wxh.designmode.ControllerInterfacr#setBPM(int)
     */
    @Override
    public void setBPM(int bpm) {
        model.setBPM(bpm);
    }

    /** 
     * 
     * @see com.wxh.designmode.ControllerInterfacr#increaseBPM()
     */
    @Override
    public void increaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm + 1);
    }

    /** 
     * 
     * @see com.wxh.designmode.ControllerInterfacr#decreaseBPM()
     */
    @Override
    public void decreaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm - 1);
    }

}

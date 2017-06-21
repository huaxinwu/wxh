/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: HeartController.java, v 0.1 2017年6月20日 下午3:52:01 wxh Exp $
 */
public class HeartController implements ControllerInterfacr {
    HeartModelInterface model;
    DJView              view;

    public HeartController(HeartModelInterface model) {
        this.model = model;
        view = new DJView(this, new HeartAdapter(model));
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }

    /** 
     * 
     * @see com.wxh.designmode.ControllerInterfacr#start()
     */
    @Override
    public void start() {
    }

    /** 
     * 
     * @see com.wxh.designmode.ControllerInterfacr#stop()
     */
    @Override
    public void stop() {
    }

    /** 
     * @param bpm
     * @see com.wxh.designmode.ControllerInterfacr#setBPM(int)
     */
    @Override
    public void setBPM(int bpm) {
    }

    /** 
     * 
     * @see com.wxh.designmode.ControllerInterfacr#increaseBPM()
     */
    @Override
    public void increaseBPM() {
    }

    /** 
     * 
     * @see com.wxh.designmode.ControllerInterfacr#decreaseBPM()
     */
    @Override
    public void decreaseBPM() {
    }

}

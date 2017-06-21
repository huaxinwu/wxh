/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 控制器接口
 * @author wxh
 * @version $Id: ControllerInterfacr.java, v 0.1 2017年6月20日 下午3:11:15 wxh Exp $
 */
public interface ControllerInterfacr {
    /**
     * 启动
     */
    void start();

    /**
     * 停止
     */
    void stop();

    /**
     * 设置BPM值
     * @param bpm
     */
    void setBPM(int bpm);

    /**
     * 增加BPM值
     */
    void increaseBPM();

    /**
     * 减少BPM值
     */
    void decreaseBPM();

}

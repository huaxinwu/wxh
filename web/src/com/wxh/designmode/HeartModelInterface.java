/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * Heart Model Interface
 * @author wxh
 * @version $Id: HeartModelInterface.java, v 0.1 2017年6月20日 下午3:48:53 wxh Exp $
 */
public interface HeartModelInterface {
    /**
    *
    * @return
    */
    int getHeartRate();

    void regeisterObserver(BeatObserver o);

    void removeObserver(BeatObserver o);

    void regeisterObserver(BPMObserver o);

    void removeObserver(BPMObserver o);

}

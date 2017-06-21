/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 设计模式是MVC的钥匙
 * 节拍模型接口
 * @author wxh
 * @version $Id: BeatModelInterface.java, v 0.1 2017年6月20日 下午2:43:42 wxh Exp $
 */
public interface BeatModelInterface {

    void initialize();

    void on();

    void off();

    void setBPM(int bpm);

    int getBPM();

    void regeisterObserver(BeatObserver o);

    void removeObserver(BeatObserver o);

    void regeisterObserver(BPMObserver o);

    void removeObserver(BPMObserver o);
}

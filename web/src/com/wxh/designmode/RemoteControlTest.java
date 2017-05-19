/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 遥控器测试
 * @author wxh
 * @version $Id: RemoteControlTest.java, v 0.1 2017年4月19日 下午3:36:39 wxh Exp $
 */
public class RemoteControlTest {

    public static void main(String[] args) {
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        // 命令电灯去打开开关
        Light light = new Light();
        LightOnCommand lightOn = new LightOnCommand(light);
        remoteControl.setCommand(lightOn);
        remoteControl.buttonWasPressed();

        // 命令车库门开启
        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
        remoteControl.setCommand(garageDoorOpen);
        remoteControl.buttonWasPressed();
    }
}

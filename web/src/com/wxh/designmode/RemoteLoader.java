/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 遥控加载器
 * @author wxh
 * @version $Id: RemoteLoader.java, v 0.1 2017年4月20日 下午5:14:05 wxh Exp $
 */
public class RemoteLoader {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        /** 
         * 将所有装置创建在合适的地方
         */

        // 灯在客厅
        Light lightRoomLight = new Light("Living Room");
        // 灯在厨房
        Light kitchenLight = new Light("Kitchen");
        // 天花风扇
        CeilingFan ceilingFan = new CeilingFan("Living Room");

        // 车库门
        GarageDoor garageDoor = new GarageDoor("");

        // 音响
        Stereo stereo = new Stereo("Living Room");

        /**
         * 创建所有电灯的命令对象
         */
        LightOnCommand livingRoomLightOn = new LightOnCommand(lightRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(lightRoomLight);

        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        /**
         * 创建吊扇的开与关的命令对象
         */
        CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        /**
         * 创建车门的上与下命令对象
         */
        GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);

        /**
         * 创建音响的开与关的命令对象
         */
        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        StereoOffWithCDCommand stereoOffWithCD = new StereoOffWithCDCommand(stereo);

        /**
         * 将所有的命令对象加载到插槽中
         */
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
        remoteControl.setCommand(3, stereoOnWithCD, stereoOffWithCD);

        System.out.println(remoteControl.toString());
        System.out.println("-------------------极致分隔线---------------------");

        /**
         * 触发按钮，执行操作
         */
        remoteControl.onButtonWasPressed(0);
        remoteControl.offButtonWasPressed(0);
        remoteControl.onButtonWasPressed(1);
        remoteControl.offButtonWasPressed(1);
        remoteControl.onButtonWasPressed(2);
        remoteControl.offButtonWasPressed(2);
        remoteControl.onButtonWasPressed(3);
        remoteControl.offButtonWasPressed(3);

        System.out.println("-------------------极致分隔线---------------------");
        RemoteControlWithUndo remoteControlWithUndo = new RemoteControlWithUndo();
        remoteControlWithUndo.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        /**
         * 打开电灯，关闭电灯，插销
         */
        remoteControlWithUndo.onButtonWasPressed(0);
        remoteControlWithUndo.offButtonWasPressed(0);
        System.out.println(remoteControlWithUndo.toString());
        remoteControlWithUndo.undoButtonWasPressed();

        /**
         * 关闭电灯，打开电灯，撤销
         */
        remoteControlWithUndo.offButtonWasPressed(0);
        remoteControlWithUndo.onButtonWasPressed(0);
        System.out.println(remoteControlWithUndo.toString());
        remoteControlWithUndo.undoButtonWasPressed();

        System.out.println("-------------------极致分隔线---------------------");
        CeilingFan ceilingFan2 = new CeilingFan("Living Room");
        CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan2);
        CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan2);
        CeilingFanOffCommand ceilingFanOff2 = new CeilingFanOffCommand(ceilingFan2);

        remoteControlWithUndo.setCommand(0, ceilingFanMedium, ceilingFanOff2);
        remoteControlWithUndo.setCommand(1, ceilingFanHigh, ceilingFanOff2);
        /**
         * 开启中速、关闭、撤销
         */
        remoteControlWithUndo.onButtonWasPressed(0);
        remoteControlWithUndo.offButtonWasPressed(0);
        System.out.println(remoteControlWithUndo.toString());
        remoteControlWithUndo.undoButtonWasPressed();

        /**
         * 开启高速、撤销
         */
        remoteControlWithUndo.onButtonWasPressed(1);
        System.out.println(remoteControlWithUndo.toString());
        remoteControlWithUndo.undoButtonWasPressed();

        System.out.println("-------------------极致分隔线---------------------");
        Light light = new Light("Living Room");
        TV tv = new TV("Living Room");
        Stereo stereo2 = new Stereo("Living Room");
        Hottub hottub = new Hottub();

        LightOnCommand lightOn = new LightOnCommand(light);
        TVOnCommand tvOn = new TVOnCommand(tv);
        StereoOnCommand stereoOn = new StereoOnCommand(stereo2);
        HottubOnCommand huttubOn = new HottubOnCommand(hottub);

        LightOffCommand lightOff = new LightOffCommand(light);
        TVOffCommand tvOff = new TVOffCommand(tv);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo2);
        HottubOffCommand huttubOff = new HottubOffCommand(hottub);
        /**
         * 用宏命令执行大量操作
         */
        Command[] partyOn = { lightOn, tvOn, stereoOn, huttubOn };
        Command[] partyOff = { lightOff, tvOff, stereoOff, huttubOff };

        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);
        remoteControlWithUndo.setCommand(0, partyOnMacro, partyOffMacro);
        System.out.println(remoteControlWithUndo.toString());
        System.out.println("-----------Pushing Macro On------------");
        remoteControlWithUndo.onButtonWasPressed(0);
        System.out.println("-----------Pushing Macro Off------------");
        remoteControlWithUndo.offButtonWasPressed(0);
    }
}

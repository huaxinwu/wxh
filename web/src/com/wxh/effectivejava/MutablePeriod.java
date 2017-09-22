/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 创建一个可变的PeriodSerialized是可能的：创建一个PeriodSerialized字节流作为开始，在附加两个额外的引用，
 * 指向PeriodSerialized内部私有域Date，攻击者从ObjectInputStream中读取PeriodSerialized实例
 * @author wxh
 * @version $Id: MutablePeriod.java, v 0.1 2017年9月22日 上午10:06:00 wxh Exp $
 */
public class MutablePeriod {
    public final PeriodSerialized period;
    public final Date             start;
    public final Date             end;

    public MutablePeriod() {
        try {
            // 字节数组输出流---字节流
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            // 对象输出流--字节流
            ObjectOutputStream out = new ObjectOutputStream(bos);
            // 序列化PeriodSerialized实例
            out.writeObject(new PeriodSerialized(new Date(), new Date()));
            /*
             * 伪造一个字节流，
             * 这个字节流以一个有效的Period实例所产生的字节流作为开始，
             * 然后附加上两个额外的引用，指向Period实例中的两个内部私有Date域，
             * 攻击者通过引用攻击内部域
             */
            byte[] ref = { 0x71, 0, 0x7e, 0, 5 };
            bos.write(ref);
            ref[4] = 4;
            bos.write(ref);

            // 读取刚才伪造的数据--- 装饰模式
            ObjectInputStream in = new ObjectInputStream(
                new ByteArrayInputStream(bos.toByteArray()));
            period = (PeriodSerialized) in.readObject();
            start = (Date) in.readObject();
            end = (Date) in.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    public static void main(String[] args) {
        MutablePeriod mp = new MutablePeriod();
        PeriodSerialized p = mp.period;
        Date pEnd = mp.end;

        pEnd.setYear(78);
        System.out.println(p);

        System.out.println("--------------------------------------------------------------");

        pEnd.setYear(69);
        System.out.println(p);

    }
}

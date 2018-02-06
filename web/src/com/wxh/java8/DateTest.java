/**
 * wxh Inc.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.wxh.java8;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * jdk1.8特性：Java 8 在包java.time下包含了一组全新的时间日期API。新的日期API和开源的Joda-Time库差不多
 * @author wxh
 * @version $Id: DateTest.java, v 0.1 2018年2月6日 下午4:25:32 wxh Exp $
 */
public class DateTest {

    public static void main(String[] args) {

        // 1.Clock 时钟

        // Clock类提供了访问当前日期和时间的方法，Clock是时区敏感的，可以用来取代 System.currentTimeMillis() 来获取当前的微秒数
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);

        // 2.Timezones 时区

        // 在新API中时区使用ZoneId来表示。时区可以很方便的使用静态方法of来获取到。 
        // 时区定义了到UTS时间的时间差，在Instant时间点对象到本地日期对象之间转换的时候是极其重要的
        System.out.println(ZoneId.getAvailableZoneIds());
        // 打印所有可用的时区ID
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

        // 3.LocalTime 本地时间
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        System.out.println(now1.isBefore(now2));

    }

}

/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于监视器模式的车辆追踪
 * @author wxh
 * @version $Id: MonitorVehicleTracker.java, v 0.1 2017年10月25日 下午3:25:45 wxh Exp $
 */
@NotThreadSafe
public class MonitorVehicleTracker {

    @GuardedBy("this")
    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> location) {
        this.locations = deepCopy(location);
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id) {
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }

    public synchronized void setLocation(String id, int x, int y) {
        MutablePoint loc = locations.get(id);
        if (loc == null) {
            throw new IllegalArgumentException("No Such ID:" + id);
        }
        loc.x = x;
        loc.y = y;
    }

    /**
     * 深度拷贝
     * 对象赋值：
     * 1.直接赋值-- A a1 = a2,赋的该对象的引用，存在一个问题，a1内容改变，a2内容也跟着改变，因为它们内容是一样的
     * 2.浅度拷贝---Object.clone方法(创建一个新对象然后将当前对象的非静态字段复制到新对象，如果字段是值类型，
     * 那么直接对该字段执行复制，如果字段是引用类型，则复制引用但不复制引用的对象(对象内容)因为原始对象和副本对象都引用同一个对象了，
     * 就是对象中依赖对象，对象中的对象，堆中的内容改变，对象中对象复制给其他引用对象时，此时两个对象引用同一个对象)
     * 3.深度拷贝---创建一个新对象，然后将当前对象的非静态字段复制到该新对象，无论该字段是值类型还是引用类型，都会进行复制。
     * 就是对象中的对象，将对象中对象setter方法时候从新new一个对象在放入进行设值
     * @param location
     * @return Map<String, MutablePoint>
     */
    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> locations) {
        Map<String, MutablePoint> map = new HashMap<String, MutablePoint>();
        for (String id : map.keySet()) {
            map.put(id, new MutablePoint(locations.get(id)));
        }
        return Collections.unmodifiableMap(map);
    }

}

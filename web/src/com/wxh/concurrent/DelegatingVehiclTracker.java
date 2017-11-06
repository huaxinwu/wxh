/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 将线程安全委托给ConcurrentHashMap
 * @author wxh
 * @version $Id: DelegatingVehiclTracker.java, v 0.1 2017年10月26日 上午9:45:10 wxh Exp $
 */
@ThreadSafe
public class DelegatingVehiclTracker {

    private final ConcurrentMap<String, Point> locations;
    private final Map<String, Point>           unmodifiableMap;

    public DelegatingVehiclTracker(Map<String, Point> points) {
        // 如果使用MutablePoint而不是Point，将会破坏Java的封装性，因为类的成员变量没有保持原子性(同步锁/volatile/final)
        locations = new ConcurrentHashMap<String, Point>(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, Point> getLocations() {
        return unmodifiableMap;
    }

    public Point getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (locations.replace(id, new Point(x, y)) == null) {
            throw new IllegalArgumentException("invalid vehicle name:" + id);
        }
    }
}

/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 一段时间
 * 保护性地编写readObject方法
 * @author wxh
 * @version $Id: PeriodSerialized.java, v 0.1 2017年9月22日 上午9:47:52 wxh Exp $
 */
public final class PeriodSerialized implements Serializable {

    private Date start;
    private Date end;

    private void readObject(ObjectOutputStream out) throws IOException, ClassNotFoundException {
        out.defaultWriteObject();
        // 防止被伪造，保护性拷贝
        start = new Date(start.getTime());
        end = new Date(end.getTime());

        if (start.compareTo(end) > 0) {
            throw new InvalidObjectException(start + "after" + end);
        }
    }

    public PeriodSerialized(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(start + ">" + end);
        }
    }

    public Date start() {
        // 克隆对象
        return (Date) start.clone();
    }

    public Date end() {
        return (Date) end.clone();
    }

    @Override
    public String toString() {
        return start + "-" + end;
    }

}

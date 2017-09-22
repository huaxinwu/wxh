/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 字符串列表
 * @author wxh
 * @version $Id: StringList.java, v 0.1 2017年9月21日 下午3:26:13 wxh Exp $
 */
public class StringList implements Serializable {

    /** */
    private static final long serialVersionUID = -3903653843880317336L;
    private transient int     size             = 0;
    private transient Entry   head             = null;

    private static class Entry {
        String date;
        Entry  next;
        Entry  previous;
    }

    /**
     * 序列化
     *
     * @param out
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(size);
        for (Entry e = head; e != null; e = e.next) {
            out.writeObject(e);
        }
    }

    /**
     * 反序列化
     *
     * @param out
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int numElements = in.readInt();
        for (int i = 0; i < numElements; i++) {
            add((String) in.readObject());
        }
    }

    public void add(String s) {

    }

}

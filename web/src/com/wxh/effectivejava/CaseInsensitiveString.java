/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

/**
 * equals对称性
 * @author wxh
 * @version $Id: CaseInsensitiveString.java, v 0.1 2017年9月5日 下午3:51:40 wxh Exp $
 */
public final class CaseInsensitiveString {
    private String s;

    public CaseInsensitiveString(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        // 如果是CaseInsensitiveString实例
        if (o instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        }
        if (o instanceof String) {
            return s.equalsIgnoreCase((String) o);
        }
        return false;
    }

    /**
     * 两个对象比较，字符数值顺序比较
     *
     * @param o
     * @return
     */
    public int CompareTo(Object o) {
        CaseInsensitiveString cis = (CaseInsensitiveString) o;
        return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
    }
}

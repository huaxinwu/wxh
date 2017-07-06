/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.virtual.machine;

/**
 * 没有权限的栈检查
 * @author wxh
 * @version $Id: Exampl2b.java, v 0.1 2017年7月5日 下午2:59:25 wxh Exp $
 */
public class Exampl2b {

    public static void main(String[] args) {
        TextFileDisplayer tfd = new TextFileDisplayer("answer.txt");
        Friend friend = new Friend(tfd, true);
        Stranger stranger = new Stranger(friend, true);
        stranger.doYourThing();
    }
}

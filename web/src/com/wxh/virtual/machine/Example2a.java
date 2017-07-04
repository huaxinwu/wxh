/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.virtual.machine;

/**
 * 栈检查
 * @author wxh
 * @version $Id: Example2a.java, v 0.1 2017年7月4日 上午11:44:21 wxh Exp $
 */
public class Example2a {

    public static void main(String[] args) {

        TextFileDisplayer tfd = new TextFileDisplayer("question.txt");
        Friend friend = new Friend(tfd, true);
        Stranger stranger = new Stranger(friend, true);
        stranger.doYourThing();
    }
}

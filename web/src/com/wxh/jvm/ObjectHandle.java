/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.Color;
import java.awt.Point;

/**
 * 一个模拟：垃圾收集堆
 * 对象操作
 * @author wxh
 * @version $Id: ObjectHandle.java, v 0.1 2017年12月19日 下午4:06:05 wxh Exp $
 */
public class ObjectHandle {

    /** 是否释放了 */
    public boolean  free;
    public int      objectPos;
    public FishIcon fish;

    //public boolean currentGCMarkNode;  

    /**  GC遍历中的前一个节点是鱼或本地变量根节点 */
    public boolean  previousNodeInGCTraversalIsAFish;
    public int      previousFishInGCTraversal;

    public Color    myColor;
    public Color    myFriendLineColor;
    public Color    myLunchLineColor;
    public Color    mySnackLineColor;

    public boolean  gotFriend;
    public Point    myFriendLineStart;
    public Point    myFriendLineEnd;

    public boolean  gotLunch;
    public Point    myLunchLineStart;
    public Point    myLunchLineEnd;

    public boolean  gotSnack;
    public Point    mySnackLineStart;
    public Point    mySnackLineEnd;

}

/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 一个模拟：垃圾收集堆
 * 鱼堆字符串
 * @author wxh
 * @version $Id: HeapOfFishStrings.java, v 0.1 2017年12月19日 下午4:04:10 wxh Exp $
 */
public class HeapOfFishStrings {

    // 鱼堆模式中各种字符串常量定义 
    public final static String allocateFish               = "Allocate Fish";
    public final static String assignReferences           = "Assign References";
    public final static String garbageCollect             = "Garbage Collect";
    public final static String compactHeap                = "Compact Heap";
    public final static String swim                       = "Swim";

    public final static String objectPool                 = "Object Pool";
    public final static String handlePool                 = "Handle Pool";
    public final static String newRedFish                 = "new RedFish()";
    public final static String newBlueFish                = "new BlueFish()";
    public final static String newYellowFish              = "new YellowFish()";
    public final static String allocateFishInstructions   = "Click on a button to allocate a new fish object.";
    public final static String newRedFishAllocated        = "A new RedFish was allocated successfully.";
    public final static String newRedFishNotAllocated     = "Unable to allocate a new RedFish.\nEither there were no free handles left in the handle pool, or there\nwas not enough contiguous free space left in the object pool.";
    public final static String newBlueFishAllocated       = "A new BlueFish was allocated successfully.";
    public final static String newBlueFishNotAllocated    = "Unable to allocate a new BlueFish.\nEither there were no free handles left in the handle pool, or there\nwas not enough contiguous free space left in the object pool.";
    public final static String newYellowFishAllocated     = "A new YellowFish was allocated successfully.";
    public final static String newYellowFishNotAllocated  = "Unable to allocate a new YellowFish.\nEither there were no free handles left in the handle pool, or there\nwas not enough contiguous free space left in the object pool.";
    public final static String moveFish                   = "Move Fish";
    public final static String linkFish                   = "Link Fish";
    public final static String unlinkFish                 = "Unlink Fish";

    public final static String localVariables             = "Local Variables";
    public final static String redFishLocalVar            = "RedFish rf;";
    public final static String blueFishLocalVar           = "BlueFish bf;";
    public final static String yellowFishLocalVar         = "YellowFish yf;";

    public final static String moveFishInstructions       = "To move a fish, click on the fish you wish to move and drag it\nto a new position.";
    public final static String linkFishInstructions       = "To link two fish, click on a fish and drag the mouse to another\nfish. A line will appear between the linked fish. You can also\nlink a local variable to a fish by clicking on the local variable and\ndragging to the fish.";
    public final static String unlinkFishInstructions     = "To unlink two fish, click on the line connecting them and the\nlink will be broken. You can also break the link between a local\nvariable and a fish by clicking on the line connecting them.";

    public final static String step                       = "Step";
    public final static String reset                      = "Reset";

    public final static String traversingYellowRoot       = "Traversing references starting from YellowFish local variable root.";
    public final static String traversingBlueRoot         = "Traversing references starting from BlueFish local variable root.";
    public final static String traversingRedRoot          = "Traversing references starting from RedFish local variable root.";
    public final static String garbageCollectionDone      = "Garbage Collection is done.";

    public final static String garbageCollectInstructions = "Click on the Step button to watch each step in the mark and sweep\ngarbage collection process. Click on Reset to do restart the garbage\ncollecting process.";

    public final static String doneWithYellowRoot         = "Done traversing references starting from YellowFish local variable root.";
    public final static String doneWithBlueRoot           = "Done traversing references starting from BlueFish local variable root.";
    public final static String doneWithRedRoot            = "Done traversing references starting from RedFish local variable root.";

    public final static String readyToSweepUnmarkedFish   = "Ready to sweep all unmarked fish. These fish are shown in white.\nThey are unreachable by the program and therefore can be freed.";
    public final static String sweptFish0                 = "Freed memory occupied by ";
    public final static String sweptFish1                 = " unreachable fish object(s).";

    public final static String slide                      = "Slide";
    public final static String compactHeapInstructions    = "Click the Slide button to move one object so that it is\ncontiguous to its neighbor.";
    public final static String slidSuccessfully           = "Successfully slid one object.";
    public final static String cantSlideAnymore           = "No more objects to slide. Heap is already compacted.";

}

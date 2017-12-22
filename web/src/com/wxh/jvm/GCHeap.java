/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 一个模拟：垃圾收集堆
 * GC堆
 * @author wxh
 * @version $Id: GCHeap.java, v 0.1 2017年12月19日 下午4:00:28 wxh Exp $
 */
public class GCHeap {

    /** 处理池的大小   */
    private int            handlePoolSize;
    /** 对象池的大小   */
    private int            objectPoolSize;
    private ObjectHandle[] handlePool;
    private int[]          objectPool;

    /**
     * 在构造方法初始化参数
     * @param hndlPoolSize
     * @param objPoolSize
     */
    public GCHeap(int hndlPoolSize, int objPoolSize) {

        handlePoolSize = hndlPoolSize;
        objectPoolSize = objPoolSize;

        objectPool = new int[objectPoolSize];
        handlePool = new ObjectHandle[handlePoolSize];

        // 初始化对象池将一头在第0个int的位置，表明该对象池阵列整个剩余是一个大的连续内存块 
        objectPool[0] = formMemBlockHeader(true, objectPoolSize);

        for (int i = 0; i < handlePoolSize; ++i) {
            handlePool[i] = new ObjectHandle();
            handlePool[i].free = true;
        }
    }

    /**
     * 获取处理池的大小
     * @return
     */
    public int getHandlePoolSize() {
        return handlePoolSize;
    }

    /**
     * 获取对象池的大小
     * @return
     */
    public int getObjectPoolSize() {
        return objectPoolSize;
    }

    /**
     * 获取对象处理信息
     * @param i
     * @return
     */
    public ObjectHandle getObjectHandle(int i) {
        return handlePool[i - 1];
    }

    /**
     * 获取对象池数量
     * @param i
     * @return
     */
    public int getObjectPool(int i) {
        return objectPool[i];
    }

    public void setObjectPool(int i, int value) {
        objectPool[i] = value;
    }

    /**
     * 内存块头部是使int包含两条信息，
     * 内存块的长度和内存块是否空闲。int
     * 是块的头，并在块之前立即存储。
     * ObjectPool阵列。这些头形成了一个链表的内存块。
     * 因为可以通过向索引中添加长度来跳转到下一个头。
     * 当前块头获取索引到下一个块的头。长度
     * 变量是在单位的整数；它告诉多少整数长的内存块，
     * 包括标题int。
     * 一个内存块头部的第0个比特用来表示自由。如果比特
     * 是一个，内存块是空闲的。位1到31是内存块的长度。
     * 在一些整数。 
     * 
     */
    private int formMemBlockHeader(boolean free, int length) {
        int retVal = length << 1;
        if (free) {
            retVal |= 1;
        }
        return retVal;
    }

    /**
     * 内存块的长度包括标题int
     * @param header
     * @return
     */
    public int getMemBlockLength(int header) {
        return header >> 1;
    }

    /**
     * 获取内存块空闲区域
     * @param header
     * @return
     */
    public boolean getMemBlockFree(int header) {
        boolean retVal = false;
        if ((header & 0x1) == 0x1) {
            retVal = true;
        }
        return retVal;
    }

    /**
     * 分配对象
     * @param bytesNeeded
     * @param fish
     * @return
     */
    public int allocateObject(int bytesNeeded, FishIcon fish) {

        // 将返回值初始化为0，表示新对象没有足够的可用内存 
        int retVal = 0;

        /** 因为ObjectPool是int的数组，所有的物体都是int对齐。
         * 计算通过基于传递的字节数的新对象所需的整型数必修的.
         * 这是通过添加3（sizeof（int）- 1）的bytesneeded和除以4
         */
        int intsNeeded = (bytesNeeded + 3) / 4;

        int i = 0;
        while (i < objectPoolSize) {
            int header = objectPool[i];
            boolean free = false;
            if (getMemBlockFree(header)) {
                free = true;
            }
            int length = getMemBlockLength(header);

            if (!free) {

                /**
                 * 这个内存块不是空闲的，所以继续看下一个内存。
                 * 块。将当前索引的长度添加到常量池中以获得下一个内存块头的索引  
                 */
                i += length;
                continue;
            }

            // 我们找到了一块空闲的地方。首先，将其他空闲块可能与此相邻
            while ((i + length) < objectPoolSize && getMemBlockFree(objectPool[i + length])) {

                /**
                 * / /下一个内存块是免费的，所以将与前一个连接。这是通过扩展前一个内存块的大小来完成的。
                 */
                length += getMemBlockLength(objectPool[i + length]);
                objectPool[i] = formMemBlockHeader(true, length);
            }

            /**
             * 这个内存块是空闲的，但对于FAT对象来说还不够大。
             * 请求了哪些内存。继续看下一个内存块。
             * 将当前索引的长度添加到常量池中获取下一个内存块头的索引
             */
            if (length - 1 < intsNeeded) {
                i += length;
                continue;
            }

            /**
             * 当前空闲块足够大，用于我们的新对象。
             * 首先，检查看看如果这个块中的内存超过实际需要的内存由新对象 
             */
            int extraMem = length - intsNeeded - 1;
            if (extraMem > 0) {

                /**
                 * 空闲块内存不足，所以我们必须把它拆分成两块。
                 * 第一块正好适合我们的尺寸。新的对象。第二个会包含剩下的东西。
                 * 这种分裂通过将原始标题的长度更改为精确完成。
                 * 与新对象所需的相等，然后添加一个剩余内存头 
                 */
                objectPool[i] = formMemBlockHeader(true, intsNeeded + 1);
                objectPool[i + intsNeeded + 1] = formMemBlockHeader(true, extraMem);
            }

            /**
             * 在这一点上ObjectPool数组正为新对象大小合适。
             * 我们现在需要做的就是将句柄分配给内存。
             * 添加一个通过前向allochandle到我，因为我目前指向头。
             * 对象句柄应该指向对象开始处的头和本身
             */
            retVal = allocateHandle(i + 1, fish);
            if (retVal > 0) {
                objectPool[i] = formMemBlockHeader(false, intsNeeded + 1);
            }
            break;
        }
        return retVal;
    }

    /**
     * 分配操作
     * @param objectHandle
     * @param fishHandle
     * @return
     */
    public int allocateHandle(int objectHandle, FishIcon fishHandle) {
        int retVal = 0;
        for (int i = 0; i < handlePoolSize; ++i) {
            if (handlePool[i].free) {
                handlePool[i].free = false;
                handlePool[i].objectPos = objectHandle;
                handlePool[i].fish = fishHandle;
                retVal = i + 1; // Add one because zero means failure.  
                break;
            }
        }
        return retVal;
    }

    /**
     * 释放对象
     * @param handle
     */
    public void freeObject(int handle) {
        if (!handlePool[handle - 1].free) {
            handlePool[handle - 1].free = true;
            handlePool[handle - 1].fish = null;
            int objectTableIndex = handlePool[handle - 1].objectPos;
            int header = getObjectPool(objectTableIndex - 1);
            int length = getMemBlockLength(header);
            header = formMemBlockHeader(true, length);
            setObjectPool(objectTableIndex - 1, header);
        }
    }

    /**
     * 向下滑动非连续对象
     * @return
     */
    public boolean slideNextNonContiguousObjectDown() {

        boolean retVal = false;

        int i = 0;
        while (i < objectPoolSize) {
            int header = objectPool[i];
            boolean free = false;
            if (getMemBlockFree(header)) {
                free = true;
            }
            int length = getMemBlockLength(header);

            if (!free) {

                i += length;
                continue;
            }

            while ((i + length) < objectPoolSize && getMemBlockFree(objectPool[i + length])) {

                length += getMemBlockLength(objectPool[i + length]);
                objectPool[i] = formMemBlockHeader(true, length);
            }
            if (i + length >= objectPoolSize) {
                break;
            }

            int sliderLength = getMemBlockLength(objectPool[i + length]);
            for (int j = 1; j < sliderLength; ++j) {
                objectPool[i + j] = objectPool[i + length + j];
            }

            objectPool[i] = formMemBlockHeader(false, sliderLength);
            objectPool[i + sliderLength] = formMemBlockHeader(true, length);

            for (int j = 0; j < handlePoolSize; ++j) {
                if (!handlePool[j].free && handlePool[j].objectPos == i + length + 1) {
                    handlePool[j].objectPos = i + 1;
                    break;
                }
            }

            retVal = true;
            break;
        }
        return retVal;
    }

}

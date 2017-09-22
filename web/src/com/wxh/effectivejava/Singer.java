/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.applet.AudioClip;

/**
 * 歌唱家
 * 抽离成两个接口好处，一个类可以是歌唱家，也可以是作曲家
 * @author wxh
 * @version $Id: Singer.java, v 0.1 2017年9月8日 上午9:50:29 wxh Exp $
 */
public interface Singer {
    AudioClip sing(Song s);
}

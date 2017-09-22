/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.applet.AudioClip;

/**
 * 歌唱家、作曲家
 * 复用性更好
 * 骨架实现：AbstractInterface,比如Collection Framework 的List、et etc.
 * @author wxh
 * @version $Id: SingerSongWriter.java, v 0.1 2017年9月8日 上午9:56:02 wxh Exp $
 */
public interface SingerSongWriter extends Singer, SongWriter {
    AudioClip strum(Song s);

    void actSensitive();
}

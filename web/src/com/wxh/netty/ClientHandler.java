/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * client处理器
 * @author wxh
 * @version $Id: ClientHandler.java, v 0.1 2017年11月22日 上午10:05:03 wxh Exp $
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * 通道中读取数据
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            // 将接受的消息转换成字节缓冲区
            ByteBuf buffer = (ByteBuf) msg;
            byte[] data = new byte[buffer.readableBytes()];
            // 将读取的数据写入缓冲区
            buffer.readBytes(data);

            System.out.println("client:" + new String(data).trim());
        } finally {
            // 释放消息
            ReferenceCountUtil.release(msg);
        }

    }

    /**
     * 引起异常原因
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 将日志写入堆栈中
        cause.printStackTrace();
        // 关闭通道上下文处理器
        ctx.close();
    }

}

/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * netty服务处理器
 * @author wxh
 * @version $Id: ServerHandler.java, v 0.1 2017年11月21日 下午5:24:14 wxh Exp $
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 通道中读取数据
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        // 将接受的消息转换成字节缓冲区
        ByteBuf buffer = (ByteBuf) msg;
        byte[] data = new byte[buffer.readableBytes()];
        // 将读取的数据写入缓冲区
        buffer.readBytes(data);
        // 以utf-8编码读取数据
        String request = new String(data, "utf-8");

        System.out.println("server:" + request);
        //写给客户端  
        String response = "我是响应的信息";
        // 写入通道上下文处理器
        ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));
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

/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * netty client
 * @author wxh
 * @version $Id: Client.java, v 0.1 2017年11月22日 上午10:00:58 wxh Exp $
 */
public class NettyClient {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workerGroup).channel(NioSocketChannel.class)
            .handler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    // 打开通道处理业务
                    socketChannel.pipeline().addLast(new ClientHandler());
                }
            });
        // 启动类绑定主机和端口
        ChannelFuture future = bootstrap.connect("127.0.0.1", 8379).sync();
        // 写给服务端
        String request = "我是请求的信息";
        future.channel().writeAndFlush(Unpooled.copiedBuffer(request.getBytes()));
        // 关闭通道并同步
        future.channel().closeFuture().sync();
        // 终止线程
        workerGroup.shutdownGracefully();
    }

}

/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Netty是基于Java NIO client-server的网络应用框架
 * @author wxh
 * @version $Id: NettyServer.java, v 0.1 2017年11月21日 下午4:58:57 wxh Exp $
 */
public class NettyServer {

    private int port;

    /**
     * 初始化参数
     */
    public NettyServer(int port) {
        this.port = port;
    }

    /**
     * 运行
     */
    public void run() {
        // 用于处理服务器端接收客户端连接 
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 进行网络通信（读写） 
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // 辅助工具类，用于服务器通道的一系列配置 
            ServerBootstrap bootstrap = new ServerBootstrap();
            // 绑定两个线程组 --父子线程
            bootstrap.group(bossGroup, workerGroup)
            // 指定NIO的模式 
                .channel(NioServerSocketChannel.class)
                // 配置具体的数据处理方式 
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        // 打开通道处理业务
                        socketChannel.pipeline().addLast(new ServerHandler());
                    }
                });
            /** 
            * 对于ChannelOption.SO_BACKLOG的解释： 
            * 服务器端TCP内核维护有两个队列，我们称之为A、B队列。客户端向服务器端connect时，会发送带有SYN标志的包（第一次握手），服务器端 
            * 接收到客户端发送的SYN时，向客户端发送SYN ACK确认（第二次握手），此时TCP内核模块把客户端连接加入到A队列中，然后服务器接收到 
            * 客户端发送的ACK时（第三次握手），TCP内核模块把客户端连接从A队列移动到B队列，连接完成，应用程序的accept会返回。也就是说accept 
            * 从B队列中取出完成了三次握手的连接。 
            * A队列和B队列的长度之和就是backlog。当A、B队列的长度之和大于ChannelOption.SO_BACKLOG时，新的连接将会被TCP内核拒绝。 
            * 所以，如果backlog过小，可能会出现accept速度跟不上，A、B队列满了，导致新的客户端无法连接。要注意的是，backlog对程序支持的 
            * 连接数并无影响，backlog影响的只是还没有被accept取出的连接 
            */
            //  设置TCP缓冲区  
            bootstrap.option(ChannelOption.SO_BACKLOG, 128);
            // 设置发送数据缓冲大小  
            bootstrap.option(ChannelOption.SO_SNDBUF, 32 * 1024);
            // 设置接受数据缓冲大小
            bootstrap.option(ChannelOption.SO_RCVBUF, 32 * 1024);
            // 保持连接  
            bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
            // 绑定端口，并设置同步
            ChannelFuture future = bootstrap.bind(port).sync();
            // 关闭通道并同步
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 停止线程
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    /**
     * 测试netty框架
     * @param args
     */
    public static void main(String[] args) {
        new NettyServer(8379).run();
    }
}

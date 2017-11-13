package com.example.demo.netty;

import com.example.demo.netty.Handler.HelloServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Netty 服务端代码
 */
public class HelloServer {
    /**
     * 服务端监听的端口地址
     */
    private static final int portNumber = 7878;

    public static void main(String args[]) {
        System.out.println("服务器已经启动，监听的端口是: "+portNumber);
        //1.第一个线程组是用于接收Client端连接的
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //2.第二个线程组是用于实际的业务处理的
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup); //绑定两个线程池
            b.channel(NioServerSocketChannel.class); //指定NIO的模式，如果是客户端就是NioSocketChannel
            //b.option(ChannelOption.SO_BACKLOG, 1024);//TCP的缓冲区设置
            // b.option(ChannelOption.SO_SNDBUF, 32*1024);//设置发送缓冲的大小
            // b.option(ChannelOption.SO_RCVBUF, 32*1024);//设置接收缓冲区大小
            //b.option(ChannelOption.SO_KEEPALIVE, true);//保持连续
            b.childHandler(new HelloServerInitializer());

            // 服务器绑定端口监听,使用同步
            ChannelFuture f = b.bind(portNumber).sync();
            // 监听服务器关闭监听
            f.channel().closeFuture().sync(); //等待关闭(程序阻塞在这里等待客户端请求)
            // 可以简写为
            /* b.bind(portNumber).sync().channel().closeFuture().sync(); */
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭线程
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }


}

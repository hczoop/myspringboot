package com.example.demo.netty.Handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Created by xing on 2017/7/10.
 */
public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ChannelPipeline pipeline = ch.pipeline();
        // 以("\n")为结尾分割的 解码器
        //pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        // 字符串解码 和 编码
         pipeline.addLast("decoder", new StringDecoder());//定义接收类型为字符串把ByteBuf转成String
         pipeline.addLast("encoder", new StringEncoder());
        // 自己的逻辑Handler
         pipeline.addLast("handler", new HelloServerHandler());
    }
}

package com.example.zhou.mypowerbee.netty;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;

/**
 * Created by zhou on 17-3-2.
 */
public class ClientNetty {
    private Channel channel;
    public String host;
    public int port;
    private static ClientNetty ourInstance = new ClientNetty();

    public static ClientNetty getInstance() {
        return ourInstance;
    }

    private ClientNetty() {
    }

    public void connect(String host, int port) {

        try {
            EventLoopGroup eventExecutors = new NioEventLoopGroup();
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host, port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast("decoder", new ByteArrayDecoder());            //定义发送数据类型
                            pipeline.addLast("encoder", new ByteArrayEncoder());            //定义接收数据的类型
                            pipeline.addLast("handler", new ClientNettyHandler());
//                        pipeline.addLast("myHandler", new MyHandler());
                        }
                    });
            channel = bootstrap.connect(host, port).sync().channel();
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

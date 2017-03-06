package com.zhou.mypowerbee.netty;

import android.util.Log;

import com.orhanobut.logger.Logger;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.timeout.ReadTimeoutException;
import io.netty.handler.timeout.WriteTimeoutException;

/**
 * Created by zhou on 17-3-2.
 */
public class ClientNetty {
    private static final String TAG = "ClientNetty";
    private Channel channel;

    final AtomicReference<Thread> thread = new AtomicReference<>();
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private static ClientNetty ourInstance = new ClientNetty();

    public static ClientNetty getInstance() {
        return ourInstance;
    }

    private ClientNetty() {
    }

    public class MyHandler extends ChannelDuplexHandler {
        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
                throws Exception {
            if (cause instanceof WriteTimeoutException) {
                Log.d(TAG, "写超时");
            } else if (cause instanceof ReadTimeoutException) {
                Log.d(TAG, "读超时");

            } else {
                super.exceptionCaught(ctx, cause);
            }
        }
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
//                            pipeline.addLast("handler", new ClientNettyHandler());
                            pipeline.addLast("myHandler", new MyHandler());
                        }
                    });
            channel = bootstrap.connect(host, port).sync().channel();
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (thread.get() != null) {
            thread.get().interrupt();
        }
        if (channel != null && channel.isOpen()) {
            channel.close();
            channel = null;
        }
    }
}

package com.hwy.client;

import com.hwy.handler.DemoHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/6/1 15:10
 **/
public class DemoNettyClient {

    private int port;

    private String ip;

    private String message;

    public DemoNettyClient(String ip, int port, String message) {
        this.port = port;
        this.ip = ip;
        this.message = message;
    }

    public void start() {
        System.out.println("netty client start...");
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new DemoHandler());
                        }
                    });
            ChannelFuture future = bootstrap.connect(ip, port).sync();
            future.channel().writeAndFlush(Unpooled.copiedBuffer(message.getBytes()));
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}

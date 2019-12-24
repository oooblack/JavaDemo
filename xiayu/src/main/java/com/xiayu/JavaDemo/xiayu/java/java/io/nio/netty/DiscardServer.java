package com.xiayu.JavaDemo.xiayu.java.java.io.nio.netty;

import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @author: test_
 * @date: 2019/8/29
 */
public class DiscardServer {
    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    public void run() {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
    }
}

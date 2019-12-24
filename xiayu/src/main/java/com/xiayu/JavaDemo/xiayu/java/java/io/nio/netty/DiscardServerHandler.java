package com.xiayu.JavaDemo.xiayu.java.java.io.nio.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 最简单的协议不是"Hello World",而是DISCARD(抛弃服务)
 * @author: test_
 * @date: 2019/8/28
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //super.channelRead(ctx, msg);
        System.out.println("run");
        ((ByteBuf)msg).release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        cause.fillInStackTrace();
        ctx.close();
    }
}

package org.hqu.elevatorManage.websocket.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hqu.elevatorManage.websocket.server.initalizer.WebSocketServerChannelInitializer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


/**
 * <p>
 * websocket服务类
 * <p>
 *
 * @author hqully
 * @version 1.0
 * @date 2022-10-06 08:39
 */
@Data
@Component
@ConfigurationProperties(prefix = "websocket")
@Slf4j
public class WebSocketServer implements ApplicationRunner {

    private int port;

    private NioEventLoopGroup bossGroup;
    private NioEventLoopGroup workerGroup;
    private WebSocketServerChannelInitializer wsChannelInitializer = new WebSocketServerChannelInitializer();
    private Channel channel;

    public void init() {
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap()
                    .group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(wsChannelInitializer);

            ChannelFuture f = serverBootstrap.bind(port).addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    log.info("websocket start successful at " + channel.localAddress());
                }
            });
            channel = f.channel();
            channel.closeFuture().addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    workerGroup.shutdownGracefully();
                    bossGroup.shutdownGracefully();
                }
            });
        } catch (Exception e) {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            log.error("websocket start fail, cause: {}", e);

        }
    }


    public void destroy() {
        if (null == channel) {
            return;
        }
        channel.close();
        log.info("webSocket server closed");
    }

    public void sendMessage(String msg, Channel channel) {
        channel.writeAndFlush(new TextWebSocketFrame(msg));
    }

    @Override
    @Async
    public void run(ApplicationArguments args) throws Exception {
        init();

    }

}

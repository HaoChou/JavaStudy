package local;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.local.LocalAddress;
import io.netty.channel.local.LocalChannel;
import io.netty.channel.local.LocalEventLoopGroup;
import io.netty.channel.local.LocalServerChannel;

/**
 * @author zhou
 * Created on 2018/7/13
 */
public class LocalServer {
    private String localAddress;

    public LocalServer(String localAddress) {
        this.localAddress = localAddress;
    }

    public void start() throws InterruptedException {
        EventLoopGroup eventLoopGroup = new LocalEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(eventLoopGroup);
            b.channel(LocalServerChannel.class);
            b.childHandler(new ChannelInitializer<LocalChannel>() {
                @Override
                protected void initChannel(LocalChannel ch) throws Exception {
                    ch.pipeline().addLast(new LocalByteToMsgDecoder())
//                    ch.pipeline().addLast(new LocalMessageToByteEncoder());
                            .addLast(new LocalMessageToMessageDecoder())
                            .addLast(new LocalServerHandler())
                            .addLast(new LocalMessageToByteEncoder());
                }
            });
            LocalAddress address = new LocalAddress(this.localAddress);
            b.bind(address).addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    System.out.println("local server successively bind");
                }
            });
        } catch (Exception e) {
            System.out.println("error !" + e);
        }
    }
}

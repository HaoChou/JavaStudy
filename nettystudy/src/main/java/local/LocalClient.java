package local;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.local.LocalAddress;
import io.netty.channel.local.LocalChannel;
import io.netty.channel.local.LocalEventLoopGroup;

/**
 * @author zhou
 * Created on 2018/7/13
 */
public class LocalClient {

    private String remoteAddress;
    private String clientNam;

    public LocalClient(String remoteAddress, String clientNam) {
        this.remoteAddress = remoteAddress;
        this.clientNam = clientNam;
    }

    public void start() {
        EventLoopGroup eventLoopGroup = new LocalEventLoopGroup();
        try {
//            LocalClient client = this;
            Bootstrap b = new Bootstrap();
            b.group(eventLoopGroup);
            b.channel(LocalChannel.class);
            b.handler(new ChannelInitializer<LocalChannel>() {
                @Override
                protected void initChannel(LocalChannel ch) throws Exception {
                    ch.pipeline()
                            .addLast(new LocalMessageToMessageDecoder())
//                            .addLast(new  LocalByteToMsgDecoder())
                            .addLast(new ClientHandler(LocalClient.this))
                            .addLast(new LocalMessageToByteEncoder());

                }
            });
            LocalAddress address = new LocalAddress(this.remoteAddress);
            ChannelFuture future = b.connect(address).sync();
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            System.out.println("error !" + e);
        }
    }

    public String getClientNam() {
        return clientNam;
    }
}

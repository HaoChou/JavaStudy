package local;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author zhou
 * Created on 2018/7/13
 */
public class ClientHandler extends SimpleChannelInboundHandler<String> {

    private LocalClient localClient;

    public ClientHandler(LocalClient localClient) {
        this.localClient = localClient;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
//        System.out.println(ctx.channel().hashCode());
        System.out.println("client [" + localClient.getClientNam() + "] connected");
        ctx.writeAndFlush("client [" + localClient.getClientNam() + "] Netty rocks").addListener(future -> {
            System.out.println("client [" + localClient.getClientNam() + "] write has been finished");
        });

        ctx.write("zhouhao".getBytes());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("client received : " + msg);
    }
}
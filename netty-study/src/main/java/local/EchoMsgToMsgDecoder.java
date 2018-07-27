package local;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * @author zhou
 * Created on 2018/7/13
 */
public class EchoMsgToMsgDecoder extends MessageToMessageDecoder<String> {
    @Override
    protected void decode(ChannelHandlerContext ctx, String msg, List<Object> out) throws Exception {
        System.out.println("received:" + msg);
        ctx.channel().writeAndFlush(Unpooled.wrappedBuffer("msg received".getBytes()));

    }
}

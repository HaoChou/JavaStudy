package local;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * @author zhou
 * Created on 2018/7/13
 */
public class LocalMessageToMessageDecoder extends MessageToMessageDecoder<String> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println(ctx.channel().hashCode());
        System.out.println("server channel active");
        super.channelActive(ctx);
    }
    @Override protected void decode(ChannelHandlerContext ctx, String msg, List<Object> out) throws Exception {
        System.out.println("LocalMessageToMessageDecoder:"+msg);
        out.add(msg);//这句话不写 LocalServerHandler无法收到信息
    }


}

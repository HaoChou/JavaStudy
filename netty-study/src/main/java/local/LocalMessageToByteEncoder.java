package local;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author zhou
 * Created on 2018/7/13
 */
public class LocalMessageToByteEncoder extends MessageToByteEncoder<String>{
    @Override
    protected void encode(ChannelHandlerContext ctx, String msg, ByteBuf out) throws Exception {

        out.writeBytes(msg.getBytes("UTF-8"));
    }


    public static void main(String[] args) {
        String aaa = "zhouzhouhao";
        byte[] bytes = aaa.getBytes();

        String s = new String(bytes);
        System.out.println(s);
    }
}

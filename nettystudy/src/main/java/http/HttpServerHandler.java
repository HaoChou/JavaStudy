package http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import org.apache.commons.collections.CollectionUtils;
import org.codehaus.jackson.map.ObjectMapper;


import java.io.IOException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.sql.DataTruncation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpHeaders.Names.DATE;
import static io.netty.handler.codec.http.HttpHeaders.Values.KEEP_ALIVE;


/**
 * @author lone
 * @date 2015/10/5
 * @time 19:45
 */
public class HttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    private static final String HAND_URI = "/node";
    private static final String PUB_HAND_URI = "/backend/pub";
    private static final String QUERY_HAND_URI = "/backend/query";
    private static ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        QueryStringDecoder decoder = new QueryStringDecoder(msg.getUri());
        String path = decoder.path();
        System.out.println("HttpServerHandler path=" + path);
        Map<String, String> paramMap = new RequestParamsParser(msg).parse();
        if (HAND_URI.equalsIgnoreCase(path))
        {
            Map<String, List<String>> parameters = decoder.parameters();
            List<String> deviceIds = parameters.get("deviceId");
        }
        else if (PUB_HAND_URI.equalsIgnoreCase(path) || QUERY_HAND_URI.equalsIgnoreCase(path))
        {
            if (PUB_HAND_URI.equalsIgnoreCase(path))
            {
                System.out.println(paramMap.get("zhou"));
            }
            else if (QUERY_HAND_URI.equalsIgnoreCase(path))
            {
                System.out.println(paramMap.get("zhou"));

            }
        }
        else
        {
            sendResponse(ctx, Ret.NOT_FOUNT);
        }
//        msg.release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        sendResponse(ctx, Ret.PROCESS_FAIL);
    }


    private void sendJsonContent(ChannelHandlerContext ctx, Map<String,Object> retMap) throws IOException {
        String jsonStr = objectMapper.writeValueAsString(retMap);
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                Unpooled.copiedBuffer(jsonStr,CharsetUtil.UTF_8));
        response.headers().set(CONTENT_TYPE, "application/json;charset=UTF-8");
        response.headers().set(CONTENT_LENGTH, response.content().readableBytes());
//        response.headers().set(DATE, new Date());
//        response.headers().setDateHeader(null,,null,new Date());
//        response.headers().set(KEEP_ALIVE, response.content().readableBytes());
//        response.headers().setDate(DATE, System.currentTimeMillis());
        ctx.writeAndFlush(response);
    }




    private void sendResponse(ChannelHandlerContext ctx, Ret ret)
    {
        Map<String, Object> retMap = new HashMap<>();
        Ret.setRet(retMap, ret);
        ctx.writeAndFlush(buildHttpResponse(retMap)).addListener(ChannelFutureListener.CLOSE);
//        ctx.channel().disconnect();
//        ctx.disconnect();
//        ctx.close();
    }

    public static FullHttpResponse buildHttpResponse(Map retMap)
    {
        String jsonStr = "";
        try
        {
            jsonStr = objectMapper.writeValueAsString(retMap);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                Unpooled.copiedBuffer(jsonStr, CharsetUtil.UTF_8));
//        response.headers().set(CONTENT_TYPE, "application/json;charset=UTF-8");
        response.headers().set(CONTENT_TYPE, "text/html;charset=UTF-8");
        response.headers().set(CONTENT_LENGTH, response.content().readableBytes());
        response.headers().set(DATE, new Date());

        return response;
    }

    public static void main(String[] args) throws ParseException {


        BigDecimal test = new BigDecimal(105.668);
        int b =test.intValue();
        System.out.println(((System.currentTimeMillis()%100)/100+0.01)*10);
    }
}

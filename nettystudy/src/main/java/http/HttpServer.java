package http;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * TCP_NODELAY和TCP_CORK基本上控制了包的“Nagle化”，这里我们主要讲TCP_NODELAY.Nagle化在这里的含义是采用Nagle算法把较小的包组装为更大的帧。JohnNagle是Nagle算法的发明人，后者就是用他的名字来命名的，他在1984年首次用这种方法来尝试解决福特汽车公司的网络拥塞问题（欲了解详情请参看IETF RFC 896）。他解决的问题就是所谓的silly window syndrome，中文称“愚蠢窗口症候群”，具体含义是，因为普遍终端应用程序每产生一次击键操作就会发送一个包，而典型情况下一个包会拥有一个字节的数据载荷以及40个字节长的包头，于是产生4000%的过载，很轻易地就能令网络发生拥塞,。Nagle化后来成了一种标准并且立即在因特网上得以实现。它现在已经成为缺省配置了，但在我们看来，有些场合下把这一选项关掉也是合乎需要的。


 */

public class HttpServer {

    private final EventLoopGroup bossGroup;
    private final EventLoopGroup workGroup;
    private final int port;

    public HttpServer() {
        this(new NioEventLoopGroup());
    }

    public HttpServer(EventLoopGroup workGroup) {
        this.bossGroup = new NioEventLoopGroup();
        this.workGroup = workGroup;
        port = 7022;
    }

    public void start() {
        try {
            System.setProperty("io.netty.allocator.type", "pooled");
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.DEBUG))
                    .childHandler(new HttpInitializer())
                    .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .option(ChannelOption.TCP_NODELAY, true)//禁用nagle算法 降低延迟
//                    .option(ChannelOption.TCP_NODELAY, false)//启用nagle算法 利用贷款 可能怎加延迟
                    .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .childOption(ChannelOption.AUTO_READ, true);
//                    .childOption(ChannelOption.SO_LINGER, 1);
            //在设置SO_LINGER选项时，指定等待时间为0，此时调用主动关闭时不会发送FIN来结束连接，而是直接将连接设置为CLOSE状态，清除套接字中的发送和接收缓冲区，直接对对端发送RST包。 导致ab工具一直超时

            System.out.println(1);
            ChannelFuture future = b.bind(port).sync();
            System.out.println(2);
            future.channel().closeFuture().sync();
            System.out.println(3);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }


    }

    public void shutdown() {
        System.out.println("http server shutdown...");
        bossGroup.shutdownGracefully();
        workGroup.shutdownGracefully();
        System.out.println("http server closed. port=" +port);
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        HttpServer httpServer = new HttpServer();
        httpServer.start();
    }

}

package jdkstudy.nio.clientserver;




import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author zhou
 * Created on 2018/9/10
 */
public class MyServer {


    public static void main(String[] args) {

        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

            serverSocketChannel.configureBlocking(false);

            serverSocketChannel.bind(new InetSocketAddress(8888));

            Selector selector  = Selector.open();

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
//            serverSocketChannel.register(selector, SelectionKey.OP_READ);

            while(selector.select()>0){

                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                while (iterator.hasNext()){


                    SelectionKey next = iterator.next();

                    if(next.isAcceptable()){


                        //10、 若“接收就绪”，获取客户端连接
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        if(null!=socketChannel) {
                            //11、 切换非阻塞模式
                            socketChannel.configureBlocking(false);
                            //12、 将该通道注册到选择器上
                            socketChannel.register(selector, SelectionKey.OP_READ);
                        }
                    }else if(next.isReadable()) {
                        SocketChannel channel = (SocketChannel) next.channel();

                        //14、 指定缓冲区大小，读取数据
                        ByteBuffer buf = ByteBuffer.allocate(1024);
                        int length = 0;

                        while ((length = channel.read(buf)) > 0) {  //sChannel 读取数据到ByteBuffer
                            buf.flip(); //切换到读取模式
                            String str = new String(buf.array(), 0, length);  //读取
                            System.out.println("str:" + str);
                            buf.clear();
                        }

                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

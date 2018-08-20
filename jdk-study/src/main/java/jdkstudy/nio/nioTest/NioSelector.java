package jdkstudy.nio.nioTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author zhou
 * Created on 2018/8/16
 */
public class NioSelector {


    public static void main(String[] args) throws IOException {
        try (Selector selector = Selector.open();
             ServerSocketChannel channel = ServerSocketChannel.open();) {


            //绑定本地端口
            channel.socket().bind(new InetSocketAddress(2222),1024);

            channel.configureBlocking(false);
            SelectionKey register = channel.register(selector, SelectionKey.OP_ACCEPT);

            boolean isRunning =true;

            while (isRunning){
                selector.select();

                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                while (iterator.hasNext()){

                    final SelectionKey key = iterator.next();
                    key.channel();
                    iterator.remove();
                    if(key.isAcceptable()) {

                        final SocketChannel socketChannel = channel.accept();
                        //todo
                        // a connection was accepted by a ServerSocketChannel.
                    } else if (key.isConnectable()) {
                        // a connection was established with a remote server.
                    } else if (key.isReadable()) {
                        // a channel is ready for reading
                    } else if (key.isWritable()) {
                        // a channel is ready for writing
                    }

                }
            }
        }
    }
}

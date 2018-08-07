package jdkstudy.nio.nioTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhou
 * Created on 2018/8/7
 */
public class NioTransfer {

    //Transfer 转让转移 过户


    public static void main(String[] args) throws FileNotFoundException {

        URL resource = NioTransfer.class.getClassLoader().getResource("nioFile/fromFile.txt");
        String fromFileStr=resource.getFile();
        URL resource1 = NioTransfer.class.getClassLoader().getResource("./");
        String baseDir = resource1.getPath();
        System.out.println("baseDir:"+baseDir);
        String toFileStr = baseDir+"nioFile/toFile.txt";

        try(

                RandomAccessFile fromFile = new RandomAccessFile(fromFileStr, "rw");
                RandomAccessFile toFile = new RandomAccessFile(toFileStr, "rw");
        ){

            FileChannel fromFileChannel= fromFile.getChannel();
            FileChannel toFileChannel= toFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(20);

            long position = 0;
            long count = fromFileChannel.size();

            toFileChannel.transferFrom(fromFileChannel,position,count);
            System.out.println("over");//去target目录下看 toFile 文件已经有了
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

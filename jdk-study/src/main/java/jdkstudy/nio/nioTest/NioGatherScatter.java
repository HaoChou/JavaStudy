package jdkstudy.nio.nioTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * @author zhou
 * Created on 2018/8/7
 */
public class NioGatherScatter {

    public static void main(String[] args)  {
        RandomAccessFile aFile = null;
        try {
            //这个文件可以忽略
            aFile = new RandomAccessFile("src/main/java/jdkstudy/nioFile/nioTest/nioTest2.txt", "rw");

            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer header = ByteBuffer.allocate(128);
            ByteBuffer body = ByteBuffer.allocate(1024);
            ByteBuffer[] byteBufferArray = {header, body};

            fileChannel.read(byteBufferArray);//scattering reads

            fileChannel.write(byteBufferArray);//gathering write
        }
        catch (Exception e)
        {

        }
        finally {
            try {
                if (aFile != null) {
                    aFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

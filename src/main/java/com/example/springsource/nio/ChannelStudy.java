package com.example.springsource.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelStudy {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("D:\\桌面\\note\\note\\spring源码解析\\pic\\AnnotationAwareAspectJAutoProxyCreator.png"));
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\桌面\\note\\note\\spring源码解析\\pic\\test.png");
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();
        while (inChannel.read(buffer) > 0){
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
    }

}

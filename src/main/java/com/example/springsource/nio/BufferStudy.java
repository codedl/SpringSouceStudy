package com.example.springsource.nio;

import java.nio.ByteBuffer;

public class BufferStudy {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String str = "helloworld";
        buffer.put(str.getBytes());
        buffer.flip();
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println("read data:"+new String(bytes));
    }
}

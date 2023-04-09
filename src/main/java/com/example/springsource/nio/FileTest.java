package com.example.springsource.nio;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) throws IOException {

            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            byteArray.write("hello".getBytes(StandardCharsets.UTF_8));
            File file = new File(System.currentTimeMillis() + ".wav");
            System.out.println(file.getAbsolutePath());
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(byteArray.toByteArray());
            outputStream.flush();

            outputStream.close();
            byteArray.close();

            file.delete();

    }
}

package com.example.springsource.img;

import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;


public class ImgNewTest {

    public static void main(String[] args) {
        copyToPathWithPress(new File("11.jpg"),
                ".","demo.jpg",2 * 1014 * 1024);
    }


    public static void copyToPathWithPress(File file, String targetPath, String targetName, long maxLen) {
        if (file.length() <= maxLen) {
            outPutImg(file, targetPath, targetName);
            return;
        }
        String type = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        byte[] bytes = pressImg(file, maxLen, type);
        try {
            outPutImg(bytes, targetPath, targetName);
            System.out.printf("文件:" + file.getAbsolutePath() + " 成功压缩到:" + targetPath + File.separator + targetName);
        } catch (Exception e) {
           System.out.printf("压缩报错，不压缩,直接传原大小文件:{}", e.getMessage());
            outPutImg(file, targetPath, targetName);
        }
    }

    public static void outPutImg(byte[] bytes, String targetPath, String targetName) {
        File file = new File(targetPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileImageOutputStream fileImageOutputStream = null;
        try {
            fileImageOutputStream = new FileImageOutputStream(new File(targetPath, targetName));
            fileImageOutputStream.write(bytes, 0, bytes.length);
            fileImageOutputStream.flush();
        } catch (IOException e) {
           System.out.printf(e.getMessage());
        } finally {
            closeIo(fileImageOutputStream);
        }
    }

    public static void outPutImg(File fileSource, String targetPath, String targetName) {
        File file = new File(targetPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(fileSource);
            File file1 = new File(targetPath, targetName);
            fileOutputStream = new FileOutputStream(file1);
            IOUtils.copy(fileInputStream, fileOutputStream);
           System.out.printf("文件复制成功{}  到 {}", fileSource.getAbsolutePath(), file1.getAbsoluteFile());
        } catch (FileNotFoundException e) {
           System.out.printf(e.getMessage());
        } catch (IOException e) {
           System.out.printf(e.getMessage());
        } finally {
            try {
                IOUtils.close(fileInputStream, fileOutputStream);
            } catch (IOException e) {
               System.out.printf(e.getMessage());
            }
        }
    }


    public static byte[] pressImg(File file, long maxLen, String type) {
        byte[] imgByte = null;
        double scale = 0.9;
        if (file.length() > maxLen) {
            do {
                try {
                    BufferedImage bi = ImageIO.read(new BufferedInputStream(new FileInputStream(file)));
                    int width = (int) (bi.getWidth() * scale);
                    int hight = (int) (bi.getHeight() * scale);
                    Image img = bi.getScaledInstance(width, hight, Image.SCALE_SMOOTH);

                    BufferedImage tag = new BufferedImage(width, hight, BufferedImage.TYPE_INT_RGB);

                    Graphics g = tag.getGraphics();
                    g.setColor(Color.red);
                    g.drawImage(img, 0, 0, null);
                    g.dispose();
                    ByteArrayOutputStream bOut = new ByteArrayOutputStream();
//                    ImageIO.write(tag, "png", bOut);
                    ImageIO.write(tag, "jpg", bOut);
                    bOut.flush();
                    imgByte = bOut.toByteArray();
                } catch (Exception e) {
                   System.out.printf(e.getMessage());
                }
            } while (imgByte.length > maxLen);
        }
        return imgByte;
    }


    public static void closeIo(Closeable... closeables) {
        if (closeables == null) {
            return;
        }
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                   System.out.printf(e.getMessage());
                }
            }
        }
    }
}

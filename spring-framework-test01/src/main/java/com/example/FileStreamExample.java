package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamExample {
    public static void main(String[] args) {
        // 定义文件路径
        String filePath = "example.txt";

        // 写入文件
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            String content = "Hello, World! 我来了";
            fos.write(content.getBytes());
        } catch (IOException e) {
            System.out.println("写入文件失败");
        }

        // 读取文件
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = fis.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, length));
            }
        } catch (IOException e) {
            System.out.println("读取文件失败");
        }
    }
}

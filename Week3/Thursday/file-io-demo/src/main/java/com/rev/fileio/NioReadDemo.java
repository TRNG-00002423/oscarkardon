package com.rev.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NioReadDemo {
    public static void main(String[] args) {
        Path path = Path.of("output.txt");
        String content;
        try {
            content = Files.readString(path);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

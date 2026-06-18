package com.rev.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NioWriteDemo {
    public static void main(String[] args) {
        Path path = Path.of("output.txt");
        try {
            Files.writeString(path, "Hello NIO");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Data written to file");
        
    }
}

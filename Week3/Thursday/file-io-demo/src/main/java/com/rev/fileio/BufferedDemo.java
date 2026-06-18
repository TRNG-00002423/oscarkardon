package com.rev.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedDemo {
    public static void main(String[] args) {
        try(
            BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("example_buffer.txt"));
        ){
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

        
    }
    
}

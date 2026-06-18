package com.rev.fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadFileExample {
    public static void main(String[] args) {
        try(FileReader fileReader = new FileReader("example.txt")){
            try(FileWriter fileWriter = new FileWriter("example_output.txt")) {
                int ch;
                while ((ch=fileReader.read()) != -1){
                    //System.out.println((char) ch);
                    fileWriter.write(ch);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
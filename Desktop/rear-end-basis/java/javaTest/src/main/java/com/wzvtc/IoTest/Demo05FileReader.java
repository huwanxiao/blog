package com.wzvtc.IoTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo05FileReader {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("chinese.txt");
            int len = 0;
            while((len = reader.read())!=-1){
                System.out.print((char) len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

package com.wzvtc.IoTest;

import java.io.FileWriter;
import java.io.IOException;

public class Demo06FileWriter {
    public static void main(String[] args) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("writer.txt",true);
            int len =0;
            writer.write("轻轻地我走了，\r\n");
            writer.write("正如我轻轻地来，\r\n");
            writer.write("我轻轻地招手，\r\n");
            writer.write("作别天边的云彩，\r\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

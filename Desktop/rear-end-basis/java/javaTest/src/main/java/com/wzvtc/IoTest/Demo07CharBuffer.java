package com.wzvtc.IoTest;

import java.io.*;

public class Demo07CharBuffer {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter wr = null;
        try {
            br = new BufferedReader(new FileReader("chinese.txt"));
            wr = new BufferedWriter(new FileWriter("writer.txt",true));
            String str = null;
            while((str = br.readLine() )!= null){       //现在为止，这个readline我只在这个io类中见过
                wr.write("###########华丽的分割线#########");
                wr.newLine();
                wr.write(str);
                wr.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                wr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}

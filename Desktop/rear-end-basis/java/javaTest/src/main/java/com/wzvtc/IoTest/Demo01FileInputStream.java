package com.wzvtc.IoTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class Demo01FileInputStream {
    public static void main(String[] args) {
        FileInputStream in = null;
        FileInputStream in1 = null;
        try{
            in = new FileInputStream("a.txt");
            in1 = new FileInputStream("chinese.txt");
            int len = 0;
            while((len = in.read()) != -1){       //字节指的是ASCII码,一个汉字有三个字节组成,用字节流打印一个汉字会被拆成三个
                System.out.println(len);         //这里的len的值是ASCII码
                System.out.println((char) len);
            }
            System.out.println("##########################");
            byte[] bytes = new byte[1024];        //太大太小都不好，一般习惯于搬运1kb的字节
            while((len = in1.read(bytes)) != -1){       //用字节流输出中文这样是一种解决方案
                System.out.println(len);
                System.out.println(new String(bytes));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

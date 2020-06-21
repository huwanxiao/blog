package com.wzvtc.IoTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo04FileCopy {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        //测试使用了字节数组的效率
//        try {
//            in = new FileInputStream("1.jpg");
//            out = new FileOutputStream("11.jpg");
//            byte[] bytes = new byte[64];
//            int len = 0;
//            long beginTime = System.currentTimeMillis();
//            System.out.println(beginTime);
//            while((len = in.read(bytes)) != -1){
//                out.write(bytes,0,len);
//            }
//            long endTime = System.currentTimeMillis();
//            System.out.println(endTime);
//            System.out.println("这次操作一共耗费了"+(endTime-beginTime)+"s");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            in.close();
//            out.close();
//        }
       System.out.println("###########华丽的分割线###############");
        //测试不用字节数组的时间
        try {
            in = new FileInputStream("1.jpg");
            out = new FileOutputStream("111.jpg");
//            byte[] bytes = new byte[64];
            int len = 0;
            long beginTime = System.currentTimeMillis();
            System.out.println(beginTime);
            while((len = in.read()) != -1){
                out.write(len);
            }
            long endTime = System.currentTimeMillis();
            System.out.println(endTime);
            System.out.println("这次操作一共耗费了"+(endTime-beginTime)+"ms");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            in.close();
            out.close();
        }

    }
}

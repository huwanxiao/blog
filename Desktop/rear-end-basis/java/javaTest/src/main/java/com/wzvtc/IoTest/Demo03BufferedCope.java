package com.wzvtc.IoTest;
import java.io.*;

public class Demo03BufferedCope {
    public static void main(String[] args) throws IOException {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream("1.jpg"));     //缓冲流以字节流为基础
            out = new BufferedOutputStream(new FileOutputStream("22.jpg"));
//          byte[] bytes = new byte[64];           //自带byte的buffer流
            int len = 0;                          //缓冲流内部定义了一个大小为8192的字节数组
            long beginTime = System.currentTimeMillis();
            System.out.println(beginTime);
            while((len = in.read()) != -1){
                out.write(len);
            }
            long endTime = System.currentTimeMillis();
            System.out.println(endTime);
            System.out.println("这次操作一共耗费了"+(endTime-beginTime)+"s");  //15ms

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            in.close();
            out.close();
        }

    }
}

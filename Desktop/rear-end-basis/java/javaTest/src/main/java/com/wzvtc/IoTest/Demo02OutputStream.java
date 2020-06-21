package com.wzvtc.IoTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo02OutputStream {
    public static void main(String[] args) {
        try(FileOutputStream out = new FileOutputStream("b.txt",true);){ //这是jdk7之后的特性，写在try后面可以不用close()，因为出了try作用域自动释放，简化了代码
            byte[] bytes = new byte[1024];     //true的意思是文字会继续往后面写而不是直接覆盖掉
            int len = 0;
            out.write("你好".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

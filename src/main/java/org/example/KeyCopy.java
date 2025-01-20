package org.example;

import lombok.Cleanup;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class KeyCopy {

    //bad code
    public static void main(String[] args) throws Exception{
        InputStream in = System.in;

        @Cleanup
        OutputStream fos = new FileOutputStream("C:\\zzz\\input.txt");

        System.out.println("한글을 입력해보세요");
        for (int i = 0; i < 10; i++) {
            int data = in.read();//1바이트 내용물
            System.out.println(data);

            if (data == 10) {
                break;
            }

            fos.write(data);

        }


    }
}

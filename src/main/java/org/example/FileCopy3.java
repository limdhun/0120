package org.example;

import lombok.Cleanup;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

//bad code
public class FileCopy3 {//바이트 크기 정도 빼고는 이게 표준
    public static void main(String[] args) throws Exception{

        @Cleanup
        InputStream fin = new FileInputStream("C:\\zzz\\test.txt");

        byte[] buffer = new byte[5];//1028 * 8 (8KB씩 많이 함)
        OutputStream fos = new FileOutputStream("copy.txt");
        while (true){
            int count = fin.read(buffer);//괄호 비우면 자동으로 1바이트씩 읽는 것

            if(count == -1){
                break;
            }
            fos.write(buffer,0,count);//이러면 잔여 바이트 자동 채움 없어짐
            //0 : 맨 처음부터, 새롭게 채워진 숫자 만큼만 쓰라는 이야기.
        }


    }
}

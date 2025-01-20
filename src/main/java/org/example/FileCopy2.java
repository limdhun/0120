package org.example;

import lombok.Cleanup;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy2 {

    //try ~ catch ~ finally
    public static void main(String[] args)throws Exception {
        //옛날방식 1 (try catch finally)
//        try {
//            InputStream in = new FileInputStream("C:\\zzz\\aaa.jpg");
//        }catch(Exception e){//문제가 발생하면 catch 로 빠짐
//
//        }finally {//문제가 발생하던, 발생하지 않던 close를 해야 함.
//            //근데 in이 try ~ catch에 잇으므로 in.close가 안됨.
//            //그래서 변수 선언을 바깥쪽으로  빼서 InputStream in = null;로 선언했었음
//        }
//        //그냥 try catch finally가 있다 정도만 알아두자.

        //옛날방식 2
        //(try with resource // auto close)
//        try(InputStream in = new FileInputStream("")){
//            
//        }catch(Exception e){
//            
//        }
//        //얘는 finally 없어도 close가 됨. 
        
        //우린 롬복을 쓰자
        @Cleanup//자동으로 try catch finally 구문 만들어줌
        InputStream in = new FileInputStream("C:\\zzz\\aaa.jpg");
        //문제가 생겨도 close는 실행하는 것


        @Cleanup//자동으로 try catch finally 구문 만들어줌
        OutputStream out = new FileOutputStream("C:\\zzz\\bbb.jpg");

        while (true){
            int data = in.read();//+255 음수가 나올 수 없게 설계.

            //System.out.println(data);
            if(data == -1){ //더 이상 읽어야 할 데이터가 없는 경우
                break;
            }
            out.write(data);//읽은 데이터를 씀. copy의 일련의 과정

        }



    }


}

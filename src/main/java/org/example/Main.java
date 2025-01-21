package org.example;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Main {

    //bad code. 입출력이 중요한거라 크게 신경 안써도됨. 아래 동작의 좋은 예시 코드는 Fileopy2.java 클래스에 잇음
    public static void main(String[] args) throws Exception{



        String path = "https://mp4.cine21.com/cine21.com/movie/trailer/2025/01/suho_tr.mp4";
        URL url = new URL(path);
        InputStream in = url.openStream();//모든 inputstream애들은 need메서드가 구현되어잇음
        //빨대가, 쿠팡이라는 웹사이트에서 인풋을 얻어옴. 이후 output을 내가 지정
        //InputStream in = System.in;

        //파일에서 데이터를 읽고 싶다?
        //InputStream in = new FileInputStream("C:\\zzz\\aaa.jpg"); //throws Exception 없으면 예외 오류 발생.
        OutputStream out = new FileOutputStream("C:\\zzz\\copied3.jpg"); //throws Exception 없으면 예외 오류 발생.

        while (true){
            int data = in.read();//+255 음수가 나올 수 없게 설계.

            //System.out.println(data);
            if(data == -1){ //더 이상 읽어야 할 데이터가 없는 경우
                break;
            }
            out.write(data);//읽은 데이터를 씀. copy의 일련의 과정

        }




        //외부 연결인데, 만약 파일이 없다면 어떻게 할 것이냐?에 관한 문제.

        //모든 빨대는 사용 후에 닫는다. close라는 가장 중요한 기능.
        in.close();
        out.close();
        //in, out을 다르게 하면 웹을 통해서 데이터를 가져오고 보내든, 네트워크를 구현하든, 카피를 하든, 다 됨
    }

    //==============================================

    //예외처리 : 직접과 보고.
    //직접 - try ~ catch ~ finally같은거
    //보고 -> throws.
    //조치 후 보고 -> try ~ catch ~
    //throw new xxxx
    
    

}
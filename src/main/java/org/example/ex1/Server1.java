package org.example.ex1;

import lombok.Cleanup;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {
    //bad code
    public static void main(String[] args)throws Exception{
        //서버소켓은 가게. IP는 따로 지정하지 않음.

        //5555번으로 가게 열기
        @Cleanup
        ServerSocket serverSocket = new ServerSocket(5555);

        //BlockedI/O 설명
        System.out.println("Server Opened...");


        for (int i = 0; i < 100; i++) {
            //serverSocket.close(); //CleanUp으로 정리
            @Cleanup
            Socket clientSocket = serverSocket.accept();//손님도 소켓이라 close 필요.. 그래서 얘도 클린업으로 뺴줌
            //serverSocket.accept도 BLockedI/O라 멈춤.
            //진짜 5555로 입력이 들어오면 아래 코드들 실행됨
            //그 연결을 누가 하냐? 바로 브라우저가 함


            System.out.println(clientSocket);
            @Cleanup
            InputStream inputStream = clientSocket.getInputStream();
            Scanner inScanner = new Scanner(inputStream);
            String line = inScanner.nextLine();
            System.out.println(line);
//            OutputStream outputStream = clientSocket.getOutputStream();
            //보낼 때 쓰는 게 write

            //a
//            outputStream.write(97);//연결 되고 a라는 데이터 보냄
            //클라이언트 프로그램에선 연결 되자마자 한 바이트 읽었을 때 97이어야 함
        }



    }
}

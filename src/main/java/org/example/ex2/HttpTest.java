package org.example.ex2;

import lombok.Cleanup;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpTest {

    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(5555);

        for (int i = 0; i < 100; i++) {

         byte[] arr = new byte [100*8];
         //브라우저가 보낸 정보를 한번에 읽어서 문자열로 출력하기 위함
            @Cleanup Socket client = serverSocket.accept();
            @Cleanup InputStream in = client.getInputStream();
            @Cleanup OutputStream out = client.getOutputStream();
            int count = in.read(arr); //몇 개나 새로운 데이터가 채워졌는지

            String str = new String(arr,0,count);

            System.out.println(str);
            System.out.println("============");
            String response = """
                            HTTP/1.1 200 OK
                            Content-Type: text/html; charset=UTF-8
                            
                            """;//트리플코텐션 - 줄바꿈 없는거임
            response += "<h1> " + WiseSayingService.INSTANCE.getOne() + "</h1>";
            byte[] msgArr = response.getBytes();
            out.write(msgArr);


        }

    }

}

package org.example.ex5;

import lombok.Cleanup;
import org.example.ex2.WiseSayingService;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class HttpLottoServer {
    public static void main(String[] args) throws Exception {


        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Server On, run..");

        while(true){
            byte[] arr = new byte[1024*8];
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
            for (int i = 0; i < 6; i++) {
                response += "<h1> " + (int)(Math.random() * 45) + "</h1>";
            }

            byte[] msgArr = response.getBytes();
            out.write(msgArr);


        }



    }

}

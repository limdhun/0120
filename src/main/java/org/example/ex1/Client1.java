package org.example.ex1;

import lombok.Cleanup;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client1 {
    //bad code
    public static void main(String[] args)throws Exception {
        //실행되자마자 연결
        @Cleanup
        Socket socket = new Socket("127.0.0.1", 5555);
        System.out.println(socket);

        @Cleanup
        InputStream inputStream = socket.getInputStream();

        @Cleanup OutputStream outputStream = socket.getOutputStream();

        String msg = "너 자신을 알라\n";//하나는 줄바꿈. 역슬래시 자체를 표시하기 위해 두 개 입력
        byte[] arr = msg.getBytes();
        outputStream.write(arr);

//        int data = inputStream.read();
//
//        System.out.println(data);


    }
}

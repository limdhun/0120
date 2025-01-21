package org.example.ex3;

import lombok.Cleanup;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class FTClient {
    public static void main(String[] args) throws Exception{
        //소켓 연결. 내 서버에
        @Cleanup
        Socket socket = new Socket("127.0.0.1",5555);
        
        @Cleanup
        InputStream in = socket.getInputStream();

        @Cleanup
        FileOutputStream fos = new FileOutputStream("today.jpg");
        //출력하기 전에, 데이터가 오는지 구경부터 해보자
        byte[] buffer = new byte[1024];
        System.out.println("전송된 데이터 읽기 시작");
        while (true){

            int count = in.read(buffer);
            System.out.println(count);
            if (count==-1){break;}
            fos.write(buffer,0,count);

        }//end while



    }
}

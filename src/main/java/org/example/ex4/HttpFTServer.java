package org.example.ex4;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpFTServer {
    //이번엔 롬복 안쓰고 만들어보자.
    //이따가 시간 되면 로또 데이터 만들어서 브라우저로 쏴보는거 해보기.

    //ul, li라는 태그에 대해 나중에 공부해보기
    //bad code
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("FTServer run.....");

        while (true) {
            //브라우저와 연결해서 소켓을 생성해야 한다. - accept() (예외처리는 생각하지말자)
            Socket socket = serverSocket.accept();

            //보내고 싶으니 OutputStream을 생성한다.
            OutputStream outputStream = socket.getOutputStream();

            //읽고 싶은 파일에 빨대 InputStream을 준비한다.
            File target = new File("C:\\zzz\\RING.mp4");
            InputStream inputStream = new FileInputStream(target);


            //http에 맞는  ing/jpeg 헤더 메시지를 outputStream에 기록
            outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
            outputStream.write("Content-Type: video/mp4;\r\n".getBytes());
            outputStream.write(("Content-Length: " + target.length() + "\r\n").getBytes());
            outputStream.write("\r\n".getBytes());

            //파일 데이터를 읽어서 outputStream에 write()해야 함 - byte[]이용하면 1000배빨라짐
            byte[] buffer = new byte[1024 * 8];//8kb. Scanner가 내부적으로 이걸 써서 느린 거임
            while (true) {
                try {
                    int count = inputStream.read(buffer);//내용물은 buffer에 있고, 숫자 count만 나옴
                    if (count == -1) {
                        break;
                    }
                    outputStream.write(buffer, 0, count);
                } catch (Exception e) {
                    System.out.println("Exception");
                    break;
                }


            }//end while
            outputStream.close();
            socket.close();

        }


    }
}

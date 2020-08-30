package cn.test.testredis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RedisPipelineTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 6379);
        OutputStream outputStream = socket.getOutputStream();
        StringBuilder sb = new StringBuilder();
        sb.append("*2").append("\r\n");
        sb.append("$3").append("\r\n");
        sb.append("get").append("\r\n");
        sb.append("$4").append("\r\n");
        sb.append("key1").append("\r\n");
        outputStream.write(sb.toString().getBytes());
        InputStream inputStream = socket.getInputStream();
        byte[] repo = new byte[1024];
        int read = inputStream.read(repo);
        System.out.println(new String(repo,0,read));
    }

}

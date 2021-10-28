package com.xt.se.net.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xt
 * @Desc
 */
public class PicServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10087);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("copy.jpg"));
        int read = 0;
        while ((read = is.read()) != -1) {
            fos.write(read);
        }
        socket.shutdownInput();

        OutputStream os = socket.getOutputStream();
        os.write("图片上传成功".getBytes());
        socket.shutdownOutput();

        os.close();
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}

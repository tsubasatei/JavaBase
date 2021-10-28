package com.xt.se.net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * @author xt
 * @Desc
 */
public class PicClient {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("madara.jpg"));
        Socket socket = new Socket("127.0.0.1", 10087);
        OutputStream os = socket.getOutputStream();
        int read = 0;
        while ((read = fis.read()) != -1) {
            os.write(read);
        }
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int length = is.read(bytes);
        System.out.println(new String(bytes, 0, length));
        socket.shutdownInput();

        is.close();
        os.close();
        fis.close();
        socket.close();
    }
}

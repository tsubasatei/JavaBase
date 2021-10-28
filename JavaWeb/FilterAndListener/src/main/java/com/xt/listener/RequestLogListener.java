package com.xt.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xt
 * @Desc
 */
@WebListener
public class RequestLogListener implements ServletRequestListener {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // 获得请求发出的IP
        // 获得请求的URL
        // 获得请求产生的时间
        PrintWriter writer = null;
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        String host = request.getRemoteHost();
        String url = request.getRequestURL().toString();
        String format = sdf.format(new Date());
        try {
            writer = new PrintWriter(new FileOutputStream(new File("d://my.txt"), true));
            writer.write(host + "\t" + url + "\t" + format + "\n");
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

    }
}

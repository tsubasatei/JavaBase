package com.xt.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.io.Serializable;

/**
 * @author xt
 * @Desc
 */
/*
 * 可以监听具体的某个session对象的事件的
 *
 * HttpSessionListener 只要在web.xml中配置或者通过@WebListener注解就可以注册监听所有的Session对象
 * HttpSessionBindingListener 必须要通过setAttribute方法和某个session对象绑定之后,监听单独的某个Session对象
 * */
@WebListener
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener,
        HttpSessionBindingListener, HttpSessionActivationListener, Serializable {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("任何一个Session对象创建");
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("任何一个Session对象的销毁");
    }
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("任何一个Session对象中添加了数据");
    }
    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("任何一个Session对象中移除了数据");
    }
    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("任何一个Session对象中修改了数据");
    }

    // 把session序列化到磁盘时触发
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println(se.getSession().hashCode() + "session即将钝化");
    }
    // 从磁盘读取session时触发
    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println(se.getSession().hashCode() + "session活化完毕");
    }

    // 绑定方法
    /*
    session.setAttribute("mySessionBindingListener", new MySessionBindingListener())
     */
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("监听器和某个session对象绑定了");
    }
    // 解除绑定方法
    /*
     * 当发生如下情况,会触发该方法的运行
     * 1 session.invalidate(); 让session不可用
     * 2 session到达最大不活动时间,session对象回收 ;
     * 3 session.removeAttribute("mySessionBindingListener");手动解除绑定
     * */
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("监听器和某个session对象解绑了");
    }
}

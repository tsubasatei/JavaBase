package com.xt.snake;

import javax.swing.*;
import java.awt.*;

/**
 * @author xt
 * @Desc
 */
public class SnakeGame {
    static int GAME_WIDTH = 800;
    static int GAME_Height = 800;
    public static void main(String[] args) {
        // 创建窗体
        JFrame frame = new JFrame();
        // 设置标题
        frame.setTitle("贪吃蛇 by xt");
        // 设置坐标及宽高
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        frame.setBounds((width - GAME_WIDTH) / 2, (height - GAME_Height) / 2, GAME_WIDTH, GAME_Height);
        // 关闭窗口大小调节
        frame.setResizable(false);
        // 添加退出事件
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 添加面板
        Panel panel = new SnakePanel();
        frame.add(panel);

        // 设置可见
        frame.setVisible(true);
    }
}

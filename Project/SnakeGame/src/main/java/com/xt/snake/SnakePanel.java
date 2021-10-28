package com.xt.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author xt
 * @Desc
 */
public class SnakePanel extends Panel {
    int length;
    int[] snakeX = new int[200];
    int[] snakeY = new int[200];
    Direction direction;
    boolean isStart = false; // 是否开始
    Timer timer; // 定时器

    int foodX;
    int foodY;

    int score; // 积分
    boolean isDie; // 死亡状态

    public void init() {
        length = 3;

        snakeX[0] = 175;
        snakeY[0] = 275;

        snakeX[1] = 150;
        snakeY[1] = 275;

        snakeX[2] = 125;
        snakeY[2] = 275;

        direction = Direction.Right;

        foodX = 300;
        foodY = 200;

        score = 0;
        isDie = false;
    }

    public SnakePanel() {
        init();
        //将焦点定位在当前操作的面板上
        this.setFocusable(true);
        //加入监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (isDie) {
                        init();
                    } else {
                        isStart = !isStart;
                        repaint(); //重绘动作
                    }

                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    direction = Direction.Right;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    direction = Direction.Left;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    direction = Direction.Up;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    direction = Direction.Down;
                }
            }
        });

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isStart && !isDie) {
                    for (int i = length - 1; i > 0 ; i--) {
                        snakeX[i] = snakeX[i - 1];
                        snakeY[i] = snakeY[i - 1];
                    }
                    switch (direction) {
                        case Right:
                            snakeX[0] += 25;
                            break;
                        case Left:
                            snakeX[0] -= 25;
                            break;
                        case Up:
                            snakeY[0] -= 25;
                            break;
                        case Down:
                            snakeY[0] += 25;
                            break;
                    }
                    if (snakeX[0] > 750) {
                        snakeX[0] = 25;
                    }
                    if (snakeX[0] < 25) {
                        snakeX[0] = 750;
                    }
                    if (snakeY[0] > 725) {
                        snakeY[0] = 100;
                    }
                    if (snakeY[0] < 100) {
                        snakeY[0] = 725;
                    }
                    // 检测碰撞的动作：
                    // 食物的坐标和蛇头的坐标一样的时候，才是碰撞了
                    if (foodX == snakeX[0] && foodY == snakeY[0]) {
                        length++;

                        // x [25, 725]
                        foodX = ((int)((Math.random() * 30)) + 1) * 25;;

                        // y [100,725] -> [4,29]*25
                        foodY = ((int)(Math.random() * 26) + 4) * 25;

                        // 迟到一次食物，积分加 10
                        score += 10;

                    }

                    // 判定死亡状态
                    for (int i = 1; i < length; i++) {
                        if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                            isDie = true;
                            break;
                        }
                    }
                    repaint();
                }
            }
        });
        timer.start();
    }

    // paintComponent这个方法比较特殊，这个方法就属于图形版的main方法
    // 自动调用
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 填充背景颜色
        this.setBackground(new Color(208, 220, 226));
        // 画头部图片
        Images.headerIcon.paintIcon(this, g, -33, 10);
        // 画矩形
        Color c = g.getColor();
        g.setColor(new Color(219, 226, 219));
        g.fillRect(10, 70, 770, 685);
        g.setColor(c);

        // 画小蛇
        switch (direction) {
            case Right:
                Images.rightIcon.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case Left:
                Images.leftIcon.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case Up:
                Images.upIcon.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case Down:
                Images.downIcon.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
        }
        for (int i = 1; i < length; i++) {
            Images.bodyIcon.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

        if (!isStart) {
            //画一个文字：
            g.setColor(new Color(114, 98, 255));
            //三个参数：字体，加粗，字号
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            //画文字：三个参数：文字内容，x轴坐标，y轴坐标
            g.drawString("点击空格开始游戏",250,330);
        }

        // 画食物
        Images.foodIcon.paintIcon(this, g, foodX, foodY);

        // 画积分
        g.setColor(new Color(173, 34, 34));
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        g.drawString("积分：" + score,620,40);

        // 画死亡状态
        if(isDie){
            g.setColor(new Color(255, 82, 68));
            g.setFont(new Font("微软雅黑", Font.BOLD,20));
            g.drawString("小蛇死亡，游戏停止，按下空格重新开始游戏",200,330);
        }
    }
}

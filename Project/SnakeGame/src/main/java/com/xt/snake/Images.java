package com.xt.snake;

import javax.swing.*;
import java.net.URL;

/**
 * @author xt
 * @Desc
 */
public class Images {
    public static URL bodyUrl = Images.class.getResource("/image/body.png");
    public static ImageIcon bodyIcon = new ImageIcon(bodyUrl);
    public static URL downUrl = Images.class.getResource("/image/down.png");
    public static ImageIcon downIcon = new ImageIcon(downUrl);
    public static URL upUrl = Images.class.getResource("/image/up.png");
    public static ImageIcon upIcon = new ImageIcon(upUrl);
    public static URL leftUrl = Images.class.getResource("/image/left.png");
    public static ImageIcon leftIcon = new ImageIcon(leftUrl);
    public static URL rightUrl = Images.class.getResource("/image/right.png");
    public static ImageIcon rightIcon = new ImageIcon(rightUrl);
    public static URL foodUrl = Images.class.getResource("/image/food.png");
    public static ImageIcon foodIcon = new ImageIcon(foodUrl);
    public static URL headerUrl = Images.class.getResource("/image/header.png");
    public static ImageIcon headerIcon = new ImageIcon(headerUrl);
}

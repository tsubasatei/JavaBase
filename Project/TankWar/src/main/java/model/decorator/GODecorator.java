package model.decorator;

import model.GameObject;

import java.awt.*;

/**
 * @author xt
 * @Desc
 */
public abstract class GODecorator extends GameObject{
    GameObject go;

    public GODecorator(GameObject go) {
        this.go = go;
    }

    public void paint(Graphics g){
        go.paint(g);
    }

}

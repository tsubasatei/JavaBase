package model;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @Desc
 */
public class TankFrame extends Frame {

    public static final int GAME_WIDTH = PropertyMgr.getInt("gameWidth");
    public static final int GAME_HEIGHT = PropertyMgr.getInt("gameHeight");
    private GameModel gameModel = new GameModel();

    public TankFrame() throws HeadlessException {
        setTitle("tank war");
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setVisible(true);
        addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // 解决双缓冲
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics graphics = offScreenImage.getGraphics();
        Color color = graphics.getColor();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        graphics.setColor(color);
        paint(graphics);
        g.drawImage(offScreenImage, 0, 0, null);

    }

    @Override
    public void paint(Graphics g) {
        gameModel.paint(g);
    }

    class MyKeyListener extends KeyAdapter {
        boolean bU = false;
        boolean bL = false;
        boolean bD = false;
        boolean bR = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch(keyCode){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    gameModel.tank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch(keyCode){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;

                default:
                    break;
            }
            setMainTankDir();
        }

        public void setMainTankDir() {
            Tank tank = gameModel.getMainTank();
            if (!bU && !bL && !bD && !bR) {
                tank.setMoving(false);
            } else {
                tank.setMoving(true);
                if (bU) {
                    tank.setDir(Dir.UP);
                }
                if (bL) {
                    tank.setDir(Dir.LEFT);
                }
                if (bD) {
                    tank.setDir(Dir.DOWN);
                }
                if (bR) {
                    tank.setDir(Dir.RIGHT);
                }
            }
        }
    }
}

package v1;


import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class AudioPlayer {
    //第一步定义
    private Player player ;//播放对象
    private String name;

    public AudioPlayer(String name) {
        this.name = name;
        new Thread(new MyRunnable()).start();
    }

    //第二步：核心在这里 自定义线程类,来播放音乐
    private class MyRunnable implements Runnable{ //1.实现Runnable接口
        public void run() {//2.重写run方法
            try {
                if(null != player) {player.close();}//如果有音乐在播放先关闭,一次只放一首歌
                player = new Player(AudioPlayer.class.getClassLoader().getResourceAsStream(name));
                player.play();//播放
            } catch (JavaLayerException e1) {
                e1.printStackTrace();
            }
        }
    }
}

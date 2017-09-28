package com.runoob;

/**
 * 实现了MediaPlayer接口的适配器
 *
 * Created by yrd on 2017/9/28.
 */
public class MediaAdapter implements MediaPlayer {

    AdvancedMeidaPlayer advancedMeidaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMeidaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMeidaPlayer = new Mp4Player();
        }
    }

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMeidaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMeidaPlayer.playMp4(fileName);
        }
    }
}

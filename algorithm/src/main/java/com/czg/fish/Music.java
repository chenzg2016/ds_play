package com.czg.fish;

/**
 * @author chenzhigong
 * @date 2018-08-12 14:40
 * @description
 **/
import java.applet.Applet;
import java.applet.AudioClip;

public class Music{
    private AudioClip shot,shot1,shot2,shot3;


    public void playBgMusic(){
        shot=Applet.newAudioClip(Music.class.getClassLoader().getResource("music/startMusic.wav"));
        shot.loop();
    }

    public void playBubblesMusic(){
        shot2=Applet.newAudioClip(Music.class.getClassLoader().getResource("music/bubbles.wav"));
        shot2.play();
    }

    public void playEatMusic(){
        shot1=Applet.newAudioClip(Music.class.getClassLoader().getResource("music/bite3.wav"));
        shot1.play();
    }
    public void playMusic(){
        shot3=Applet.newAudioClip(Music.class.getClassLoader().getResource("music/wave2.wav"));
        shot3.play();
    }

}

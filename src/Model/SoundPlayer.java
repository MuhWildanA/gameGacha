/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.IOException;
import javax.sound.sampled.*;
import java.net.URL;

public class SoundPlayer {
    private static Clip clip;
    public static void play(String path){
        try{
            if(clip!=null && clip.isRunning()){
                clip.stop();
                clip.close();
            }
            
            URL soundURL = SoundPlayer.class.getResource(path);
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        }catch(UnsupportedAudioFileException
                | IOException
                | LineUnavailableException e){
            e.printStackTrace();
        }
    }
    
    public static void stop(){
        if(clip!=null){
            clip.stop();
            clip.close();
        }
    }
}

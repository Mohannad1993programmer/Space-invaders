
package resources;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



public class Audio {
    
    private Clip clip;
    
    public Audio(String sound)
    {
        try{
        AudioInputStream audio=AudioSystem.getAudioInputStream(getClass().getResource(sound));
        clip=AudioSystem.getClip();
        clip.open(audio);
        }catch(Exception e){}
    }

    public Clip getClip() {return clip;}
    
    public void play() {clip.start();}
    public void stop() {clip.stop();}
    
    public static void playSound(String sound)
    {
        Audio s=new Audio(sound);
        s.play();
    }
}
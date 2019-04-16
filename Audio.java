import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/* Notes for myself. Make the Clip a global local variable within this class. Then write a stoploop object or function :D */

public class Audio
{
  
  public void playloop(String audiofile) {
    try {
      
      
      
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource(audiofile));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY); // There are several different amounts of time you can loop it, so you can change this if you want, or you can just use clip.stop() whenever you want.
        
       /* if(stoploop = true)
      {
       clip.stop(); 
      } */
      
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      
      
      
    }
  
  
  public void playsound(String audiofile) {
    try {
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource(audiofile));
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
      clip.loop(0); // There are several different amounts of time you can loop it, so you can change this if you want, or you can just use clip.stop() whenever you want.
      
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
}

//ALL OF THIS CODE WAS RIPPED DIRECTLY FROM: 
// https://stackoverflow.com/questions/42798276/java-multi-threading-sound-clips-to-play-at-same-time
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio
{
  private Clip clip;
  
  
  public void playloop(String audiofile) {
    try {
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource(audiofile));
      clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
      clip.loop(Clip.LOOP_CONTINUOUSLY);
    } catch (Exception ex) 
    {
      ex.printStackTrace();
    }
  }
  
  public void playsound(String audiofile) {
    try {
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource(audiofile));
      Clip clipshort = AudioSystem.getClip();
      clipshort.open(audioInputStream);
      clipshort.start();
      
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
  public void stopmusic()
  {
    clip.stop(); 
  }
  
}

//Code was based upon this -  https://stackoverflow.com/questions/42798276/java-multi-threading-sound-clips-to-play-at-same-time
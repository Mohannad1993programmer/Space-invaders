
package resources;

import java.util.logging.Level;
import java.util.logging.Logger;
import play.Main;

public class Chrono implements Runnable {
    
    private final int PAUSE=5;
    public static int techmeters=0;

    @Override
    public void run() {
    while(Main.play==true){
        techmeters++;
        Main.scene.repaint();
        try {
            Thread.sleep(PAUSE);
        } catch (InterruptedException e) {}
    }
    }
    
    
    
}

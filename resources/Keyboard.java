
package resources;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import play.Main;


public class Keyboard implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        if(Main.scene.vessel.isLiving()){
     if(e.getKeyCode()==KeyEvent.VK_RIGHT) Main.scene.vessel.setDx(+Constant.dx_vessel);
     else if(e.getKeyCode() == KeyEvent.VK_LEFT) Main.scene.vessel.setDx(-Constant.dx_vessel);
     else if(e.getKeyCode() == KeyEvent.VK_SPACE){
	if(Main.scene.shootingspacecraft.isShippulls()== false) {
            Audio.playSound("/Sound/sonTirVaisseau.wav");
            Main.scene.shootingspacecraft.setYpos(Constant.Y_Pos_vessel - Constant.spacecraftshootingheight);
	    Main.scene.shootingspacecraft.setXpos(Main.scene.vessel.getXpos() + Constant.width_vessel/2 - 1);	
	    Main.scene.shootingspacecraft.setShippulls(true);
			}
	    }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
     Main.scene.vessel.setDx(0);
    }
    
      @Override
    public void keyTyped(KeyEvent e) {

    }
    
    
}

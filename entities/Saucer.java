
package entities;


import java.awt.Graphics;
import javax.swing.ImageIcon;
import resources.Audio;
import resources.Chrono;
import resources.Constant;

public class Saucer extends Entity {
   
    public Audio musicSaucer=new Audio("/Sound/sonSoucoupePasse.wav");
    public Audio musicDestroySaucer=new Audio("/Sound/sonDestructionSoucoupe.wav");
    
  
    private int counter=0;
    
    public Saucer() {
        super.xpos=Constant.X_Pos_Saucer;
        super.ypos=Constant.Y_Pos_Saucer;
        super.width=Constant.width_Saucer;
        super.height=Constant.height_Saucer;
        super.dx=Constant.DX_Saucer;
        super.dy=0;
        
        super.imgstr1="/images/soucoupe.png";
        super.imgstr2="/images/soucoupe100.png";
        super.imgstr3="";
        
        super.ico=new ImageIcon(getClass().getResource(super.imgstr1));
        super.img=this.ico.getImage();
        super.living=true;
        
        this.musicSaucer.play();
        this.musicDestroySaucer.stop();
        this.counter=0;
    }
    
    
	public int deplacementSaucer() {
		
		if(this.living && Chrono.techmeters%2==0){
                    if(this.xpos> 0) this.xpos -= this.dx;
		else this.xpos = Constant.X_Pos_Saucer;
                }return this.xpos;
	}
        
        public void designSaucer(Graphics g)
        {
            if(this.living==false) this.destructionSaucer();
            g.drawImage(this.img, this.deplacementSaucer(), this.ypos, null);
        }
        
             public void destructionSaucer()
        {
            if(counter<300){
                super.ico=new ImageIcon(getClass().getResource(super.imgstr2));
                super.img=this.ico.getImage();
                counter++;
            }else this.xpos=Constant.X_Pos_Saucer;
        }
    
}


package entities;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import play.Main;
import resources.Chrono;
import resources.Constant;


public class Vessel extends Entity {

    
    private int counter=0;
    
    public Vessel() {
        super.xpos=Constant.X_Pos_vessel;
        super.ypos=Constant.Y_Pos_vessel;
        super.width=Constant.width_vessel;
        super.height=Constant.height_vessel;
        super.dx=0;
        super.dy=0;
        
        super.imgstr1="/images/vaisseau.png";
        super.imgstr2="/images/vaisseauDetruit1.png";
        super.imgstr3="/images/vaisseauDetruit2.png";
        
        super.ico=new ImageIcon(getClass().getResource(super.imgstr1));
        super.img=this.ico.getImage();
        super.living=true;
    }
    
  
	public int deplacementVessel() {
		
		if(this.dx < 0){if(this.xpos> Constant.Left_vessel_limit) {this.xpos = this.xpos + this.dx;}
		}else if(dx > 0) {if(this.xpos + this.dx < Constant.Right_vessel_limit) {this.xpos = this.xpos + this.dx;}}
		return this.xpos;
	}
        
        public void designvessel(Graphics g)
        {
            if(this.living==false) this.destructionvessel();
            g.drawImage(this.img, this.deplacementVessel(), this.ypos, null);
        }
        
        public void destructionvessel()
        {
            if(counter<300){
                if(Chrono.techmeters%2==0) super.ico=new ImageIcon(getClass().getResource(super.imgstr2));
                else super.ico=new ImageIcon(getClass().getResource(super.imgstr3));
                counter++;
            }else Main.play=false;
            super.img=this.ico.getImage();
        }
}

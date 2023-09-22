
package entities;


import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;
import play.Main;
import resources.Audio;
import resources.Chrono;
import resources.Constant;


public class Alienshot extends Entity {
    
    Random chance=new Random();
    
    public Alienshot(int [] tabpositionalien)
    {
         super.xpos=tabpositionalien[0]+Constant.width_alien/2-1;
        super.ypos=tabpositionalien[1]+Constant.height_alien;
        super.width=Constant.width_alien_shot;
        super.height=Constant.height_alien_shot;
        super.dx=0;
        super.dy=Constant.DY_alien_shot;
        
        super.imgstr1="/images/tirAlien1.png";
        super.imgstr2="/images/tirAlien2.png";
        super.imgstr3="";
        
        if(chance.nextInt(2)==0) super.ico=new ImageIcon(getClass().getResource(super.imgstr1));
        else super.ico=new ImageIcon(getClass().getResource(super.imgstr2)); 
        super.img=this.ico.getImage();
    }
    
    public int deplacementalienshot() 
    {
                if(Chrono.techmeters%4==0)
		if(this.ypos < 600) this.ypos =this.ypos+Constant.DY_alien_shot;
                
		return this.ypos;
    }
        
    public void designalienshot(Graphics g)
    {
            g.drawImage(this.img,this.xpos, this.deplacementalienshot(),null);
    }
    
    
    private boolean alienshotcastle()
    {
        if(this.ypos<Constant.Y_POS_castle+Constant.castle_height &&
                this.ypos+this.height>Constant.Y_POS_castle) return true;
        else return false;
    }
    
    private int closecastle()
    {
        int numbercastle=-1,column=-1;
        while(numbercastle==-1 && column<4){
            column++;
            if(this.xpos+this.width-1>Constant.window_margin+Constant.X_POS_castle+column*(Constant.castle_width+Constant.castle_cap) && 
                    this.xpos+1<Constant.castle_width+Constant.window_margin+Constant.X_POS_castle+column*(Constant.castle_width+Constant.castle_cap))
                numbercastle=column;
        }
        return numbercastle;
    }
    
    private int abscissacontactshootingaliencastle(Castle castle)
    {
        int Xposalienshoot=-1;
        if(this.xpos+this.width>castle.getXpos() && this.xpos<castle.getXpos()+Constant.castle_width)
         Xposalienshoot=this.xpos; 
        return Xposalienshoot;
 
    }
    
    public int[] alienshotcastlekey()
    {
        int tabrep[]={-1,-1};
        if(this.alienshotcastle()==true)
            tabrep[0]=this.closecastle();
        if(tabrep[0]!=-1)
            tabrep[1]=this.abscissacontactshootingaliencastle(Main.scene.tabCastle[tabrep[0]]);
        return tabrep;
            
    }
    
    public void ShootingAlienDestroyCastle(Castle tabCastle[]) {
		int[] tab = this.alienshotcastlekey();
		if(tab[0] != -1) { 
			if(tabCastle[tab[0]].findblockcastle(tabCastle[tab[0]].findcolumncastle(tab[1])) != -1
				&& tabCastle[tab[0]].findblockcastle(tabCastle[tab[0]].findcolumncastle(tab[1])) != 27) {
				tabCastle[tab[0]].blockbreakcastle(tab[1]); 	
				this.ypos = 700; 
			}
		}
	}
        
    public boolean findvessel(Vessel vessel)
    {
        if(this.ypos<vessel.getYpos()+vessel.getHeight() && this.ypos+this.height>vessel.getYpos() &&
                this.xpos+this.width>vessel.getXpos() && this.xpos<vessel.getXpos()+vessel.getWidth()){
            this.ypos=700;
            Audio.playSound("/Sound/sonDestructionVaisseau.wav");
            return true;
       }
        else return false;
    }

}
package entities;

import javax.swing.ImageIcon;
import resources.Constant;

    public class Alien extends Entity{
    
    public Alien(int xpos,int ypos,String imgstr1,String imgstr2){
        super.xpos=xpos;
        super.ypos=ypos;
        super.width=Constant.width_alien;
        super.height=Constant.height_alien;
        super.dx=0;
        super.dy=0;
        super.living=true;
        
        super.imgstr1=imgstr1;
        super.imgstr2=imgstr2;
        super.imgstr3="/images/alienMeurt.png";
        
        super.ico=new ImageIcon(getClass().getResource(super.imgstr1));
        super.img=this.ico.getImage();
    }
    
    public void choiceImage(boolean pos1)
    {
        if(this.living==true){
        if(pos1==true) super.ico=new ImageIcon(getClass().getResource(super.imgstr1));
        else super.ico=new ImageIcon(getClass().getResource(super.imgstr2));
        }else super.ico=new ImageIcon(getClass().getResource(super.imgstr3));
        super.img=this.ico.getImage();
        
    }
    
}

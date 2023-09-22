
package entities;

import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Entity {
    
    protected int width,height,xpos,ypos,dx,dy;
    protected boolean living;
    protected String imgstr1,imgstr2,imgstr3;
    protected ImageIcon ico;
    protected Image img;

    public int getWidth() {return width; }

    public int getHeight() {return height;}

    public int getXpos() {return xpos;}

    public int getYpos() {return ypos;}

    public int getDx() {return dx;}

    public int getDy() {return dy;}

    public boolean isLiving() {return living;}

    public String getImgstr1() {return imgstr1;}

    public String getImgstr2() {return imgstr2; }

    public String getImgstr3() {return imgstr3;}

    public ImageIcon getIco() {return ico;}

    public Image getImg() {return img;}

    public void setWidth(int width) {this.width = width;}

    public void setHeight(int height) {this.height = height; }

    public void setXpos(int xpos) {this.xpos = xpos;}

    public void setYpos(int ypos) {this.ypos = ypos;}

    public void setDx(int dx) {this.dx = dx;}

    public void setDy(int dy) {this.dy = dy;}

    public void setLiving(boolean living) {this.living = living;}

    public void setImgstr1(String imgstr1) {this.imgstr1 = imgstr1;}

    public void setImgstr2(String imgstr2) {this.imgstr2 = imgstr2;}

    public void setImgstr3(String imgstr3) {this.imgstr3 = imgstr3;}

    public void setIco(ImageIcon ico) {this.ico = ico;}

    public void setImg(Image img) {this.img = img;}
 
    
    
}


package play;

import entities.Alienshot;
import entities.Castle;
import entities.GroupAliens;
import entities.Saucer;
import entities.Vessel;
import entities.shootingspacecraft;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import resources.Chrono;
import resources.Constant;
import resources.Keyboard;

public class Scene extends JPanel {

    public GroupAliens groupalien;
    
    public Vessel vessel=new Vessel();
    public GroupAliens GroupAliens=new GroupAliens();
    public shootingspacecraft shootingspacecraft=new shootingspacecraft();
    
    public Alienshot alienshot1,alienshot2,alienshot3;
    
    public Saucer saucer;
   
   
    private Font attachscore=new Font("Arial",Font.PLAIN,20);
    private Font attachtext=new Font("Arial",Font.PLAIN,80);
    
    public int score;
   
    public Castle[] tabCastle=new Castle[4];
   
	

  public Scene() {
      
      super();
      
      for(int column=0;column<4;column++)
          this.tabCastle[column]=new Castle(Constant.window_margin+Constant.X_POS_castle+column*(Constant.castle_width+Constant.castle_cap));
      
      this.setFocusable(true);
      this.requestFocusInWindow();
      this.addKeyListener(new Keyboard());
      
      Thread chronoEcron=new Thread(new Chrono());
      chronoEcron.start();
  
  }

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2 = (Graphics2D) g;
		
		
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, Constant.Window_width, Constant.Window_hauler);
		
		g2.setColor(Color.GREEN);
		g2.fillRect(30, 530, 535, 5);
                
                g2.setFont(attachscore);
                g2.drawString("Score: "+score, 400, 25);

                
                this.vessel.designvessel(g2);
                this.GroupAliens.dessinAliens(g2);
                this.shootingspacecraft.designshippulls(g2);
                this.GroupAliens.shipfirealienbutton(this.shootingspacecraft);
                
                for(int column=0;column<4;column++) this.tabCastle[column].designcastle(g2);
                
                if(Chrono.techmeters<500)
                {
                    g2.setFont(attachtext);
                    g2.drawString("GOOD LUCK !", 50, 100);
                }
                
                this.shootingspacecraft.tirVaisseauDetruitChateau(tabCastle);
                
                if(Chrono.techmeters%500==0)
                    alienshot1=new Alienshot(this.GroupAliens.alienchoiceshooting());
                if(this.alienshot1!=null) {
                    this.alienshot1.designalienshot(g2);
                    this.alienshot1.ShootingAlienDestroyCastle(tabCastle);
                    if(this.alienshot1.findvessel(vessel)==true) this.vessel.setLiving(false);
                }
                 if(Chrono.techmeters%750==0)
                    alienshot2=new Alienshot(this.GroupAliens.alienchoiceshooting());
                if(this.alienshot2!=null){
                    this.alienshot2.designalienshot(g2);
                    this.alienshot2.ShootingAlienDestroyCastle(tabCastle);
                    if(this.alienshot2.findvessel(vessel)==true) this.vessel.setLiving(false);
                }
                
                if(Chrono.techmeters%900==0)
                    alienshot3=new Alienshot(this.GroupAliens.alienchoiceshooting());
                if(this.alienshot3!=null){
                    this.alienshot3.designalienshot(g2);
                    this.alienshot3.ShootingAlienDestroyCastle(tabCastle);
                    if(this.alienshot3.findvessel(vessel)==true) this.vessel.setLiving(false);
                }
                
                 if(Chrono.techmeters%2500==0) saucer=new Saucer();
               
                if(this.saucer!=null)
                    if(this.saucer.getXpos()>0){
                        if(this.shootingspacecraft.DestroySaucer(this.saucer)==true){
                            if(this.saucer.getDx()!=0) this.score+=Constant.Scorevalue; 
                            this.saucer.setDx(0);
                            this.saucer.setLiving(false);
                            this.saucer.musicSaucer.stop();
                            this.saucer.musicDestroySaucer.play();
                            

                        }
                    this.saucer.designSaucer(g);}
                    else this.saucer=null;
                   
                if(this.vessel.isLiving()==false){
                    g2.setFont(attachtext);
                    g2.drawString("Game Over :)", 50, 100);
                }
                
             //   if(this.groupalien.getNumber_alien()==0) groupalien=new GroupAliens();
                //if(this.groupalien.PositionAlienbusiest()>Constant.Y_Pos_vessel) this.vessel.destructionvessel();
               
        }
        
  	
	
}
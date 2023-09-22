
package entities;

import java.awt.Graphics;
import java.util.Random;
import play.Main;
import resources.Audio;
import resources.Chrono;
import resources.Constant;


public class GroupAliens {
    
 
  
	private Alien tabAlien[][] = new Alien [5][10];
	private boolean right, pos1;
	private int speed;
        private int []tabalien_dead={-1,-1};
        
        Random chance=new Random();
        
        private int number_alien=Constant.number_alien;
        private int countersoundalien=0;
        

	
	public GroupAliens() {	
		
		this.initTableauAliens();
		this.right = true;
		this.pos1 =true;
		this.speed = Constant.Alien_speed;
	}

        

		
	private void initTableauAliens() {
		
		for(int column=0; column<10; column++) {
			this.tabAlien[0][column] = new Alien(Constant.X_POS_INIT_ALIEN + (Constant.width_alien + Constant.ALIEN_COLUMNS_GAP) * column, 
					Constant.ALI_INIT_ALIEN, "/images/alienHaut1.png", "/images/alienHaut2.png");
			for(int line=1; line<3; line++) {
				this.tabAlien[line][column] = new Alien(Constant.X_POS_INIT_ALIEN + (Constant.width_alien+ Constant.ALIEN_COLUMNS_GAP) *
						column, Constant.ALI_INIT_ALIEN + Constant.ALIEN_LINES_GAP* line, "/images/alienMilieu1.png", "/images/alienMilieu2.png");
			}
			for(int line=3; line<5; line++) {	
				this.tabAlien[line][column] = new Alien(Constant.X_POS_INIT_ALIEN + (Constant.width_alien + Constant.ALIEN_COLUMNS_GAP)
					* column, Constant.ALI_INIT_ALIEN + Constant.ALIEN_LINES_GAP * line, "/images/alienBas1.png", "/images/alienBas2.png");
			}	
		}
	}
	
	public void dessinAliens(Graphics g) {
		if(Chrono.techmeters % (100 - 10 * this.speed) == 0) {this.deplacementAliens();}

		for(int column=0; column<10; column++) {
			for(int line=0; line<5; line++) {
                            if(this.tabAlien[line][column]!=null){
				this.tabAlien[line][column].choiceImage(pos1);
				g.drawImage(this.tabAlien[line][column].getImg(), this.tabAlien[line][column].getXpos(), this.tabAlien[line][column].getYpos(),
					null);
			
                        }
                        }
		}		
	}
		
	private boolean LeftEdgekey() {
	
		boolean reponse = false;
		for(int column=0; column<10; column++) {
			for(int line=0; line<5; line++) {
                            if(this.tabAlien[line][column]!=null){
				if(this.tabAlien[line][column].getXpos() < Constant.window_margin){
					reponse = true;
					break;
                                }
                            }
			}
		}
		return reponse;
	}
	
	private boolean RightEdgekey() {
		
		boolean reponse = false;
		for(int column=0; column<10; column++) {
			for(int line=0; line<5; line++) {
                           if(this.tabAlien[line][column]!=null){
			     if(this.tabAlien[line][column].getXpos() > 
				Constant.Window_width - Constant.width_alien - Constant.DX_ALIEN - Constant.window_margin) {
					reponse = true;
					break;
				}
                                     }
                        
			}
		}
		return reponse;
	}
	
	public void alienTourneEtDescend() {
		
		if(this.RightEdgekey() == true) {			
			for(int column=0; column<10; column++) {
				for(int line=0; line<5; line++) {
                                    if(this.tabAlien[line][column]!=null)
					this.tabAlien[line][column].setYpos(this.tabAlien[line][column].getYpos() + Constant.DY_ALIEN);
				}
			}
			this.right = false;
			if(this.speed < 9) {this.speed++;}
		} else {
			if(this.LeftEdgekey()== true) {			
				for(int column=0; column<10; column++) {
					for(int line=0; line<5; line++) {
                                          if(this.tabAlien[line][column]!=null)
                                            this.tabAlien[line][column].setYpos(
			                    this.tabAlien[line][column].getYpos() + Constant.DY_ALIEN);
					}
				}
				this.right = true;
				if(this.speed < 9) {this.speed++;}
			}
		}
	}
	
	public void deplacementAliens() {
		
            
                if(this.tabalien_dead[0]!=-1){
                    elimintealien(tabalien_dead);
                    tabalien_dead[0]=-1;
                }
		if(this.right == true) { 
			for(int column=0; column<10; column++) {
				for(int line=0; line<5; line++) {
                                   if(this.tabAlien[line][column]!=null)
					this.tabAlien[line][column].setXpos(this.tabAlien[line][column].getXpos() + Constant.DX_ALIEN);
                                             
                                }
			}
		}else{
			for(int column=0; column<10; column++) {
				for(int line=0; line<5; line++) {
                                             if(this.tabAlien[line][column]!=null)
					this.tabAlien[line][column].setXpos(this.tabAlien[line][column].getXpos() - Constant.DX_ALIEN);
				}
			}
		}
                
                this.playaliensounds();
                this.countersoundalien++;
		
		if(this.pos1 == true) {this.pos1 = false;} 
		else {this.pos1 = true;}
		
		this.alienTourneEtDescend();
	}
        
        
        public void shipfirealienbutton(shootingspacecraft shootingspacecraft)
        {
            	for(int column=0; column<10; column++) {
				for(int line=0; line<5; line++) {
			          if(this.tabAlien[line][column]!=null){
                                  if(shootingspacecraft.killalien(this.tabAlien[line][column])==true){
                                      this.tabAlien[line][column].living=false;
                                      shootingspacecraft.ypos=-1;
                                      this.tabalien_dead[0]=line;
                                      this.tabalien_dead[1]=column;
                                      if(line==0)
                                          Main.scene.score+=Constant.highalienvalue;
                                      else if(line>0 && line<3)  
                                               Main.scene.score+=Constant.middlealienvalue;
                                      else
                                               Main.scene.score+=Constant.lowalienvalue;
                                      break;
                                                                  
                                     }
                                   }
                                  }
				}
                
        }
        
        private void elimintealien(int []tabalien_dead)
        {
            this.tabAlien[tabalien_dead[0]][tabalien_dead[1]]=null;
            this.number_alien--;
        }
        
        public int [] alienchoiceshooting()
        {
            int positionalien[]={-1,-1};
            if(this.number_alien!=0){
                do{int column=chance.nextInt(10);
                for(int line=4;line>=0;line--)
                {
                    if(this.tabAlien[line][column]!=null){
                        positionalien[0]=this.tabAlien[line][column].getXpos();
                        positionalien[1]=this.tabAlien[line][column].getYpos();
                        break;
                    } 
                }
               } while(positionalien[0]==-1);
            }
                return positionalien;
        }
        
        private void playaliensounds()
        {
            int counter=this.countersoundalien%4;
            if(counter==0) Audio.playSound("/Sound/sonAlien1.wav");
            else if(counter==1) Audio.playSound("/Sound/sonAlien2.wav");
            else if(counter==2) Audio.playSound("/Sound/sonAlien3.wav");
            else Audio.playSound("/Sound/sonAlien4.wav");   
        }

    public int getNumber_alien() {return number_alien;}
        
    public int PositionAlienbusiest ()
    {
        int posBus=0,posBusfinal=0;
        for(int column=1; column<10; column++) {
	 for(int line=4; line>0; line--) {
	   if(this.tabAlien[line][column]!=null){
               posBus=this.tabAlien[line][column].ypos+this.tabAlien[line][column].height;
               break;
           }
         }
          if(posBus>posBusfinal) posBusfinal=posBus;                     
        }
        return posBusfinal;
    }
}

        
     


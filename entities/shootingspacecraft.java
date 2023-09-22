package entities;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import play.Main;
import resources.Audio;
import resources.Constant;


public class shootingspacecraft extends Entity {
    
    private boolean shippulls=false;
 
	

	public shootingspacecraft() {
            

		
	        super.xpos= 0;
		super.ypos = Constant.Y_Pos_vessel - Constant.spacecraftshootingheight;
		super.width = Constant.spacecraftshootingwidth;
		super.height = Constant.spacecraftshootingheight;
		super.dx = 0;
		super.dy = Constant.DY_SHOOT_spacecraft;
		
		super.imgstr1 = "/images/tirVaisseau.png";
		super.imgstr2 = "";
		super.imgstr3 = "";
		super.ico = new ImageIcon(getClass().getResource(super.imgstr1));
		super.img = this.ico.getImage();
	}

        public boolean isShippulls() {return shippulls;}

        public void setShippulls(boolean shippulls) {this.shippulls = shippulls;}
	
	
	
	public int deplacementshippulls() {
		if(this.shippulls == true) {
			if(this.ypos > 0) this.ypos=this.ypos- Constant.DY_SHOOT_spacecraft;
			else this.shippulls = false;
		}		
		return ypos;
	}
	
	public void designshippulls(Graphics g) {
		if(this.shippulls == true) {
			g.drawImage(this.img, this.xpos, this.deplacementshippulls(), null);}	
	}
        
        public boolean killalien(Alien alien)
        {
            if(this.ypos<alien.getYpos()+alien.getHeight() && this.ypos+this.height>alien.getYpos() && this.xpos+this.width>alien.getXpos() && this.xpos<alien.getXpos()+alien.getWidth())
            {Audio.playSound("/Sound/sonAlienMeurt.wav");
                return true;
            }
            else
            return false;
        }
        
        /*
       private boolean castlehighshipshooting()
        {
            if(this.ypos<Constant.Y_POS_castle+Constant.castle_height && this.ypos+this.height>Constant.Y_POS_castle) return true;
            else return false;
        }
        
        private int closecastle()
        {
            int castlenumber=-1,column=-1;
            while(castlenumber==-1 && column<4){
                column++;
                if(this.ypos+this.width>Constant.window_margin+Constant.X_POS_castle+column*(Constant.castle_width+Constant.castle_cap) && this.xpos<Constant.window_margin+Constant.X_POS_castle+Constant.castle_width+column*(Constant.castle_width+Constant.castle_cap))
                    castlenumber=column;
        }
            return castlenumber;
        }
        
        private int abscissacontactshootingcastle(Castle castle)
        {
            int xpostirvessel=-1;
            if(this.xpos + this.width > castle.getXpos() && this.xpos < castle.getXpos() + Constant.castle_width) xpostirvessel= this.xpos;	
		return xpostirvessel;
	}
        
        
       public int [] shiphitcastle()
        {
            int [] tabrep={-1,-1};
		if(this.castlehighshipshooting() == true) { 		
			tabrep[0] = this.closecastle(); 			
                        if(tabrep[0] != -1) 
	                tabrep[1] = this.abscissacontactshootingcastle(Main.scene.tabCastle[tabrep[0]]);		 
		}		
		return tabrep;
        }
  
        public void shotShipDestroyedCastle(Castle tabCastle[]) {
		int[] tab = this.shiphitcastle();
		if(tab[0] != -1) { 
		 if(tabCastle[tab[0]].findblock(tabCastle[tab[0]].findcolumncastle(tab[1])) != -1) 
                 {
                     tabCastle[tab[0]].blockbreaker(tab[1]);								
		     this.ypos = -1;} 
			}
		}
*/
        
        public boolean DestroySaucer(Saucer saucer)
        {
            if(this.ypos<saucer.getYpos()+saucer.getHeight() && this.ypos+this.height>saucer.getYpos()
                    && this.xpos+this.width>saucer.getXpos() && this.xpos<saucer.getXpos()+saucer.getWidth())
            {this.shippulls=false;
            return true;}
            else return false;
        }
        
             public void tirVaisseauDetruitChateau(Castle tabChateaux[]) {
		int[] tab = this.tirVaisseauToucheChateau(); // Contient (-1,-1) ou le numéro du château touché et l'abscisse du contact tirVaisseau et château
		if(tab[0] != -1) { // Un château est touché
			if(tabChateaux[tab[0]].trouveBrique(tabChateaux[tab[0]].findcolumncastle(tab[1])) != -1) {
				tabChateaux[tab[0]].blockbreaker(tab[1]); // Détruit les briques du château touché									
				this.ypos = -1; // On tue le tir et on réactive le canon du vaisseau
			}
		}
       }
        
        private boolean tirVaisseauAHauteurDeChateau() { 
		// Renvoie vrai si le tir du vaisseau est à hauteur des châteaux
		if(this.ypos < Constant.Y_POS_castle + Constant.castle_height && this.ypos + this.height > Constant.Y_POS_castle) {return true;}
		else {return false;}	
	}
	
	private int chateauProche() {
		// Renvoie le numéro du château (0,1,2 ou 3) dans la zone de tir du vaisseau
		int numeroChateau = -1;
		int colonne = -1;
		while (numeroChateau == -1 && colonne < 4) {
			colonne++;			
			if(this.xpos + this.width > Constant.window_margin + Constant.X_POS_castle + colonne * 
					(Constant.castle_width + Constant.castle_cap) 
			   && this.xpos < Constant.window_margin + Constant.X_POS_castle + Constant.castle_width + colonne * 
			   (Constant.castle_width + Constant.castle_cap)) {	
				numeroChateau = colonne;
			}
		}
		return numeroChateau;
	}
		
	private int abscisseContactTirChateau(Castle chateau) {
		// Renvoie l'abscisse du tir du vaisseau lors du contact avec un château
		int xPosTirVaisseau = -1;
		if(this.xpos + this.width > chateau.getXpos() && this.xpos < chateau.getXpos() + Constant.castle_width){xPosTirVaisseau = this.xpos;}	
		return xPosTirVaisseau;
	}
	
	public int[] tirVaisseauToucheChateau() {
		// Renvoie numéro château touché et abscisse du tir
		int[] tabRep = {-1, -1}; 
		if(this.tirVaisseauAHauteurDeChateau() == true) { // Le tir du vaisseau est à hauteur du château		
			tabRep[0] = this.chateauProche(); // enregistre le numéro du château touché dans tabRep[0]
			if(tabRep[0] != -1) {
				//enregistre l'abscisse du tir du vaisseau lors du contact avec le château dans tabRep[1]
				tabRep[1] = this.abscisseContactTirChateau(Main.scene.tabCastle[tabRep[0]]);
			}		 
		}		
		return tabRep;
	}
	
	
	
        
}

      

package entities;

import java.awt.Color;
import java.awt.Graphics;
import resources.Audio;
import resources.Constant;


public class Castle extends Entity {
    private final int number_lines=Constant.castle_height/Constant.Dimension_cube;
    private final int number_column=Constant.castle_width/Constant.Dimension_cube;
    
    boolean tabcastle[][]=new boolean[number_lines][number_column];

    public Castle(int xpos)
    {
        super.xpos=xpos;
        super.ypos=Constant.Y_POS_castle;
        
        this.inittabcastle();
    }
                
    
    public void inittabcastle(){
        for(int line=0;line<number_lines;line++){
            for(int column=0;column<number_column;column++)
                tabcastle[line][column]=true;}
        
        for(int column=0;column<6;column++){
           for(int line=0;line<2;line++){
                tabcastle[line][column]=false;
                tabcastle[line][number_column-column-1]=false;
          }
        }
        
         for(int column=0;column<4;column++){
          for(int line=2;line<4;line++){
                tabcastle[line][column]=false;
                tabcastle[line][number_column-column-1]=false;
          }
         }
                
         for(int column=0;column<2;column++){
           for(int line=4;line<6;line++){
                tabcastle[line][column]=false;
                tabcastle[line][number_column-column-1]=false;
          }
         }
         
          
            for(int line=18;line<number_lines;line++){
              for(int column=10;column<number_column-10;column++){
                tabcastle[line][column]=false;
              
          }
         }
           
           for(int column=12;column<number_column-12;column++){
            for(int line=16;line<18;line++){
                tabcastle[line][column]=false;
                tabcastle[line][number_column-column-1]=false;
          }
         }
           
          for(int column=14;column<number_column-14;column++){
            for(int line=14;line<16;line++){
                tabcastle[line][column]=false;
                tabcastle[line][number_column-column-1]=false;
          }
         }
            
             for(int column=0;column<2;column++){
               for(int line=4;line<6;line++){
                tabcastle[line][column]=false;
                tabcastle[line][number_column-column-1]=false;
          }
         }
    
    }    
        
             public void designcastle(Graphics g2)
             {
          for(int line=0;line<number_lines;line++){
            for(int column=0;column<number_column;column++){
                if(tabcastle[line][column]==true) g2.setColor(Color.GREEN);
                else g2.setColor(Color.BLACK);
          
          g2.fillRect(this.xpos+Constant.Dimension_cube*column, this.ypos+Constant.Dimension_cube*line, Constant.Dimension_cube, Constant.Dimension_cube);
            }
          }
             }
             
             public int findcolumncastle(int rocket)
             {
                 int column=-1;
                 column=(rocket-this.xpos)/ Constant.Dimension_cube;
                 return column;
             }
        
             public int trouveBrique(int colonne) {
		// Trouve la première brique en paratnt du bas de la colonne du tableau associé au château ou renvoie -1
		int ligne = number_lines-1;
		while(ligne >= 0 &&  tabcastle[ligne][colonne] == false) {ligne--;}		
		return ligne;		
	}
             public int findblock(int column)
             {
                int line = number_lines-1;
		while(line >= 0 && tabcastle[line][column] == false) line--;	
		return line;		
             }
         
                 
             public int findblockcastle(int column)
             {
                 int line=0;
                 if(column!=-1)
                  while(line<number_lines && tabcastle[line][column]==false) line++;
                 return line;
                 
             }
           
             private void removeblock(int line,int column)
             {
                 for(int count=0;count<6;count++){
                     if(line-count>=0){
                         tabcastle[line-count][column]=false;
                         if(column<number_column-1) tabcastle[line-count][column+1]=false;
                         
                     }
                 }   
             }
                 
             private void removeblockcastle(int line,int column)
             {
                 for(int counter=0;counter<6;counter++){
                     if(line+counter<number_lines && column!=-1)
                         tabcastle[line+counter][column]=false;
                     if(column<number_column-1)
                         tabcastle[line+counter][column+1]=false;
                         }
             }
         
           
             public void blockbreaker(int xTir)
             {
                 Audio.playSound("/Sound/sonCasseBrique.wav");
                 int column=this.findcolumncastle(xTir);
                 this.removeblock(findblock(column), column);
             }
             
             public void blockbreakcastle(int xTir)
             {
                 Audio.playSound("/Sound/sonCasseBrique.wav");
                 int column=this.findcolumncastle(xTir);
                 this.removeblockcastle(findblockcastle(column), column);
             }
             public int trouveBriqueHaut(int colonne) {
		// Trouve la première brique en partant du haut de la colonne du tableau 
		// associé au château ou renvoie -1
		int ligne = 0;
		if(colonne != -1) {
		  while(ligne < number_lines && tabcastle[ligne][colonne] == false) {ligne++;}}			
		return ligne;		
	}
	
	private void enleveBriquesHaut(int ligne, int colonne) {
		// Elimination des 6 premières briques de la colonne en partant du haut si elles existent
		for(int compteur=0; compteur < 6; compteur++) {
			if(ligne + compteur < number_lines && colonne != -1) {
				tabcastle[ligne + compteur][colonne] = false;
				if(colonne < number_column - 1) {
					tabcastle[ligne + compteur][colonne + 1] = false;}
			}			
		}	
	}
	
	public void casseBriquesHaut(int xTir) {
	
		int column = this.findcolumncastle(xTir);
		this.enleveBriquesHaut(trouveBriqueHaut(column), column);
	}	
             
                    
          
}
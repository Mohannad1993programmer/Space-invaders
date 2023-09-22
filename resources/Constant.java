
package resources;


public abstract class Constant {
    
    public static final int Window_width=600;
    public static final int Window_hauler =600;
    public static final int window_margin=50;
    
    
    public static final int width_vessel=39,height_vessel=24,dx_vessel=1,Y_Pos_vessel=490,X_Pos_vessel=(Window_width-width_vessel)/2;
    public final static int Left_vessel_limit=60,Right_vessel_limit =500;
   
    
    public static final int width_alien=33,height_alien=25;
    public final static int ALI_INIT_ALIEN=120,X_POS_INIT_ALIEN=29+window_margin,ALIEN_LINES_GAP=40,ALIEN_COLUMNS_GAP=10,DX_ALIEN=2,DY_ALIEN=20,Alien_speed=1;
    public static final int spacecraftshootingwidth=3,spacecraftshootingheight=13;
    public final static int DY_SHOOT_spacecraft=2;
    
    public static final int LARGEUR_TIR_VAISSEAU = 3;
    public static final int HAUTEUR_TIR_VAISSEAU = 13,number_alien=50;	
	

    public final static int DY_TIR_VAISSEAU = 2,Dimension_cube=2,castle_width=72,castle_height=54,Y_POS_castle=400,X_POS_castle=39,castle_cap=42;

    public static final int width_alien_shot=5,height_alien_shot=15,DY_alien_shot=3;
    public static int X_Pos_Saucer=Window_width;
    public static int Y_Pos_Saucer=50;
    public static int width_Saucer=42;
    public static int height_Saucer=22;
    public static int DX_Saucer=1;
    
    public static final int highalienvalue=50,middlealienvalue=40,lowalienvalue=20,Scorevalue=100; 
}

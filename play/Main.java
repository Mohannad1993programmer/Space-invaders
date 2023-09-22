
package play;

import javax.swing.JFrame;
import resources.Constant;


public class Main {
    
    public static Scene scene;
    public static boolean play=true;
    
    
    public static void main(String[]args)
    {
         
        
        JFrame windows=new JFrame("space invaders");
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windows.setSize(Constant.Window_width,Constant.Window_hauler);
        windows.setLocationRelativeTo(null);
        windows.setResizable(false);
        windows.setAlwaysOnTop(true);
        
        scene=new Scene();
        windows.setContentPane(scene);
        
        windows.setVisible(true);

    }
}

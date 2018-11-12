package cardgame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Hamid
 */
public class Tools {
   public static void setFormLocation(JFrame jf)
{
    double x=Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    double y=Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    x=(x-jf.getWidth())/2;
    y=(y-jf.getHeight())/2;
    jf.setLocation((int)x,(int)y);
} 
}

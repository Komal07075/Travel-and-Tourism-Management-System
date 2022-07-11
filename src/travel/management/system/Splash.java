
package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class Splash extends JFrame implements Runnable{
    Thread thread;//Declaring thread 
    
    //Constructor of Splash class
    Splash() {
        //Instantiating new ImageIcon object for getting splash image from system resource 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);//Setting splash image dimensions equal to frame
        
        //converting image into ImageIcon because we can't add image(i2) on JLabel
        ImageIcon i3 = new ImageIcon(i2);
        
        //Instantiating JLabel class and adding image on it
        JLabel image = new JLabel(i3);
        add(image);
        
        setVisible(true);//setting frame visible
        
        thread = new Thread(this);//Instantiating thread object
        thread.start();//It internally calls run() method
    }
    
    @Override
    public void run() {
        try {
            //Making frame invisible after 7 seconds and calling Login frame
            Thread.sleep(7000);
            //new Login();
            setVisible(false);
        } catch (Exception e) {}
    }
    
    public static void main(String[] args) {
        
        Splash frame = new Splash();//Instantiating new object
       
        //Setting frame and it's location dynamically
        int x = 1;
        for(int i = 1; i<=500; x += 7, i += 6) {
            frame.setLocation(750 - (x + i)/2, 400 - (i/2));
            frame.setSize(x + i, i);
            try {
                Thread.sleep(10);
            } catch (Exception e) {}
        }
    }
}

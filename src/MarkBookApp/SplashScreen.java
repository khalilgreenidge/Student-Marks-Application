/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarkBookApp;

import javax.swing.JWindow; 
import javax.swing.ImageIcon; 
import java.awt.Graphics; 
import java.awt.Image; 
import java.awt.Toolkit;




/**
 *
 * @author khalil
 */
public class SplashScreen extends JWindow{
    Image img = Toolkit.getDefaultToolkit().getImage("splash.png"); 
    ImageIcon imgicon=new ImageIcon(img); 
    
    public SplashScreen(){
        try { 
                setSize(633,300); 
                setLocationRelativeTo(null); 
                show(); Thread.sleep(5000); 
                dispose();
                javax.swing.JOptionPane.showMessageDialog((java.awt.Component) null,"Welcome", "Welcome Screen:", 
                        javax.swing.JOptionPane.DEFAULT_OPTION); 
        } 
        catch(Exception exception) { 
            javax.swing.JOptionPane.showMessageDialog((java.awt.Component) null,"Error"+exception.getMessage(), "Error:", 
                    javax.swing.JOptionPane.DEFAULT_OPTION);
        } 

       /* public void paint(Graphics g) { 
            g.drawImage(img,0,0,this);
        } */
    
    }
    /*
    public static void main(String[]args) { 
        SplashScreen sp=new SplashScreen(); 
    }*/


}

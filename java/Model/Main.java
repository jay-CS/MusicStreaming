package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samantharain
 */
import SignUp.*;
public class Main {
    
    //Create sign up instance
    public static void main(String[] args){
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SignUp dialog = new SignUp(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
        
            }
         });  
    }
    
    void mp3play(String file) {
        try {
            // It uses CECS327InputStream as InputStream to play the song 
             InputStream is = new CECS327InputStream(file);
             Player mp3player = new Player(is);
             mp3player.play();
	     }
	     catch (JavaLayerException exception) 
         {
	       exception.printStackTrace();
	     }
         catch (IOException exception)
         {
             exception.printStackTrace();
         }  
    }
     
     
    public static void main(String[] args) {
        Integer i;
        Main player = new Main();
        player.mp3play("imperial.mp3");
    }
 

}



package testare;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.event.WindowEvent;    
import java.awt.event.WindowListener;   
import java.util.EventListener;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class fararezultat implements WindowListener {
    JFrame eroare=new JFrame();
    JLabel ero=new JLabel("Nu a fost gasit niciun rezultat.");
    JButton buton=new JButton("Ok");
    fararezultat(){
        
        eroare.setTitle("E-biblioteca");
        ImageIcon image=new ImageIcon("carte.jpg");
        eroare.setIconImage(image.getImage());
        inapoi ab=new inapoi();
        eroare.setSize(300,200);
        eroare.setResizable(false);
        eroare.setVisible(true);
        eroare.setLayout(null);
        ero.setBounds(70,20,200,30);
        buton.setBounds(90,80,100,30);
        buton.addActionListener(ab);
        eroare.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        eroare.add(ero);
        eroare.add(buton);
        eroare.addWindowListener(this);
        
        
    }
    
    public class inapoi implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)  {
            if(e.getSource()==buton){
                eroare.dispose();
                Primafereastra ac=new Primafereastra();
  
            }    
        }        
    }
    
    
  

    @Override
    public void windowClosing (WindowEvent arg0) {    
    eroare.dispose();
     Primafereastra ac=new Primafereastra();    
}    
          
    @Override
    public void windowDeactivated (WindowEvent arg0) {    
    
}    
    @Override
    public void windowActivated (WindowEvent arg0) {        
}
    @Override       
    public void windowDeiconified (WindowEvent arg0) {       
}   
    
    @Override
    public void windowIconified(WindowEvent arg0) {      
}    
  

    @Override    
    public void windowOpened(WindowEvent arg0) {       
    } 
    
    @Override
    public void windowClosed (WindowEvent arg0) {       
}    
    

}

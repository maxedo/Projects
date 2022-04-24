
package testare;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class Returnare {
    JLabel cnp=new JLabel("CNP");
    JFrame ret=new JFrame();
    JButton caut=new JButton();
    JTextField cn=new JTextField(20);
    public   ArrayList<String> magazie;
    public  String datam;
    Returnare(){
       actiune cautare=new actiune();
       ret.setTitle("E-biblioteca");
       ImageIcon image=new ImageIcon("carte.jpg");
       ret.setIconImage(image.getImage());
       ret.setResizable(false);
       ret.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ret.setSize(300,120);
       ret.setLayout(null);
       ret.setVisible(true);
       cnp.setBounds(2,2,50,30);
       cnp.setFont(new Font(null,Font.PLAIN,18));
       ret.add(cnp); 
       cn.setBounds(50,2,200,30);
       ret.add(cn);
       caut.setBounds(80,40,120,30);
       caut.setText("Cauta");
       ret.add(caut);
       caut.setFocusable(false); 
       caut.addActionListener(cautare);
       ret.getContentPane().setBackground(new Color(123,50,250));
       caut.setBackground(Color.gray); 
       magazie=new ArrayList<>();
    }
    public class actiune implements ActionListener{
     @Override
	public void actionPerformed(ActionEvent e)  {
            int i;
            File fisier=new File("imprumutate.txt");
        try {
            Scanner scan=new Scanner(fisier);
            String datam=cn.getText();
            if(datam.length()==13){
            if(e.getSource()==caut) {
                        
			while(scan.hasNextLine()){
                            if(datam == null ? scan.nextLine() == null : datam.equals(scan.nextLine())){
                               for(i=0;i<3;i++){
                                magazie.add(scan.nextLine());
                               }
                            Ultframe ac=new Ultframe(magazie,datam);       
                            ret.dispose();    
                            break;
                            }
                            
                            
                        }
                        
                        scan.close();
                        
               //ret.dispose();
               //fararezultat ab=new fararezultat();
               
		}}
                     
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Returnare.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          
       
             
          
	
	}
    
    
    }
}

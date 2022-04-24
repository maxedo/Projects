
package testare;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Primafereastra extends JFrame implements ActionListener{
        JButton buton=new JButton();
        JButton buton2=new JButton();
        JFrame frame=new JFrame();
       
        
        Primafereastra(){
        
       this.setTitle("E-biblioteca");
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setResizable(false);
       this.setSize(400,200);
       this.setVisible(true);
       this.setLayout(null);       
       buton.setBounds(50,50,120,40);
       buton.addActionListener(this);
       buton.setBackground(Color.gray);
       this.add(buton);
       buton.setFocusable(false);
       buton.setText("Imprumut");  
       buton2.setBounds(220,50,120,40);
       buton2.addActionListener(this);
       buton2.setBackground(Color.gray);    
       this.add(buton2);
       buton2.setFocusable(false);
       buton2.setText("Returnare");
       ImageIcon image=new ImageIcon("carte.jpg");
       this.setIconImage(image.getImage());
       this.getContentPane().setBackground(new Color(123,50,250));
       
        }
      @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buton) {
                        this.dispose();
			Adaugare fr=new Adaugare();
                        
		}
                
                if(e.getSource()==buton2) {
                        this.dispose();
			Returnare fr=new Returnare();
                        
		}
                
	}
 
    }
    
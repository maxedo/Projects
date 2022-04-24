
package testare;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class Ultframe implements WindowListener {
   JFrame rez=new JFrame();
   JLabel np=new JLabel("Nume si prenume");
   JLabel cnp=new JLabel("CNP");
   JLabel carti=new JLabel("Carti imprumutate");
   JLabel plata=new JLabel("Plata");
   JButton ok=new JButton("OK");
   String numar;
   ArrayList<String> mult;
   public static String newline = System.getProperty("line.separator");
   double x;
    Ultframe(ArrayList<String> magazie,String datam){
        ImageIcon image=new ImageIcon("carte.jpg");
        rez.setIconImage(image.getImage());
        String cop=magazie.get(2);
        double z=0;
        for(int i=0;i<cop.length();i++)
            if(cop.charAt(i)==93)
               z++; 
        okay okey=new okay();
        LocalDate d2 = LocalDate.now();
        LocalDate d1 = LocalDate.parse(magazie.get(1), DateTimeFormatter.ISO_LOCAL_DATE);
        Duration diff = Duration.between(d2.atStartOfDay(), d1.atStartOfDay());
        double diffDays = diff.toDays();
        x=diffDays/2*z;
        JTextArea patru=new JTextArea(x+" Ron");
        rez.setSize(300,300);
        rez.setResizable(false);
        rez.setVisible(true);
        rez.setLayout(null);
        rez.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        rez.setTitle("E-biblioteca");
        JTextArea unu=new JTextArea(magazie.get(0));
        JTextArea doi=new JTextArea(datam);
        JTextArea trei=new JTextArea(magazie.get(2));
        unu.setEditable(false);
        doi.setEditable(false);
        trei.setEditable(false);
        patru.setEditable(false);
        np.setBounds(0,0,100,30);
        cnp.setBounds(0,50,100,30);
        carti.setBounds(0,100,120,30);
        plata.setBounds(0,150,70,30);
        unu.setBounds(130,0,150,30);
        doi.setBounds(130,50,150,30);
        JScrollPane jsp=new JScrollPane(trei,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setBounds(130,90,150,50);
        patru.setBounds(50,150,80,30);
        ok.setBounds(100,200,100,30);
        unu.setBackground(Color.GRAY);
        doi.setBackground(Color.GRAY);
        rez.add(np);
        rez.add(cnp);
        rez.add(carti);
        rez.add(unu);
        rez.add(doi);
        rez.add(jsp);
        rez.add(plata);
        rez.add(patru);
        ok.addActionListener(okey);
        rez.add(ok);
        numar=datam;
        mult=magazie;
        rez.getContentPane().setBackground(new Color(123,50,250));
        ok.setBackground(Color.gray); 
        rez.addWindowListener(this);
    }
    
    public class okay implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==ok){
                rez.dispose();
                Primafereastra ae=new Primafereastra();
                try {
			File fis = new File("arhiva.txt");
                        FileWriter fr = new FileWriter(fis, true);
			fr.write(numar+newline+mult.get(0)+newline+mult.get(1)+newline+mult.get(2)+newline+x+" Ron"+newline+newline);
			fr.close();
		} 
		catch (IOException b) {
			b.printStackTrace();
		}

        try{
File fisier = new File("imprumutate.txt");
File tempFile = new File("myTempFile.txt");

BufferedReader reader = new BufferedReader(new FileReader(fisier));
BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

String currentLine;

while((currentLine = reader.readLine()) != null) {

    String trimmedLine = currentLine;
    if(trimmedLine.equals(numar)) continue;
    if(trimmedLine.equals(mult.get(0))) continue;
    if(trimmedLine.equals(mult.get(1))) continue;
    if(trimmedLine.equals(mult.get(2))) continue;
    writer.write(currentLine + System.getProperty("line.separator"));
}
writer.close(); 
reader.close();
fisier.delete();
boolean successful = tempFile.renameTo(fisier);
    }catch (IOException b) {
			b.printStackTrace();
		}
                
                
                
                
        }
        
        
        
    }
    }
    
     @Override
    public void windowClosing (WindowEvent arg0) {    
    rez.dispose();
                Primafereastra ae=new Primafereastra();
                try {
			File writer = new File("arhiva.txt");
                        FileWriter fr = new FileWriter(writer, true);
			fr.write(numar+newline+mult.get(0)+newline+mult.get(1)+newline+mult.get(2)+newline+x+" Ron"+newline+newline);
			fr.close();
		} 
		catch (IOException b) {
			b.printStackTrace();
		}

        try{
File fisier = new File("imprumutate.txt");
File tempFile = new File("myTempFile.txt");

BufferedReader reader = new BufferedReader(new FileReader(fisier));
BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

String currentLine;

while((currentLine = reader.readLine()) != null) {

    String trimmedLine = currentLine;
    if(trimmedLine.equals(numar)) continue;
    if(trimmedLine.equals(mult.get(0))) continue;
    if(trimmedLine.equals(mult.get(1))) continue;
    if(trimmedLine.equals(mult.get(2))) continue;
    writer.write(currentLine + System.getProperty("line.separator"));
}
writer.close(); 
reader.close();
fisier.delete();
boolean successful = tempFile.renameTo(fisier);
    }catch (IOException b) {
			b.printStackTrace();
		}
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
    
    
    
    
    
    
    
    
    


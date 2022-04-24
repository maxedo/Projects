
package testare;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Adaugare{
    JFrame frame=new JFrame();
    JLabel label=new JLabel("Nume si prenume");
    JLabel label2=new JLabel("Carte de identitate: CNP");
    JLabel datar=new JLabel("Data de returnare");
    JLabel alg=new JLabel("Alege carti");
    JButton fin=new JButton();
    public static String newline = System.getProperty("line.separator");
    JTextField id=new JTextField(20);
    JTextField numesiprenume=new JTextField(20);
    JTextField dr=new JTextField(20);
    JComboBox comboBox;
    JTextArea area=new JTextArea();
    ArrayList<String> carti = new ArrayList<String>(); 
    String[] ar=carti.toArray(new String[carti.size()]);
    ArrayList<String> cart;
    JLabel exemplu=new JLabel("Exemplu: 2022-09-29");
    Adaugare(){
       Notepad not=new Notepad();
       carti.add("------------------");
       carti.add("[Ion] ");
       carti.add("[Morometii] ");
       carti.add("[Plumb] ");
       carti.add("[Moara cu Noroc] ");
       carti.add("[Luceafarul] ");
       carti.add("[Baltagul] ");
       String[] ar=carti.toArray(new String[carti.size()]);
       frame.setTitle("E-biblioteca");
       ImageIcon image=new ImageIcon("carte.jpg");
       frame.setIconImage(image.getImage());
       label.setBounds(2,0,250,30);
       label.setFont(new Font(null,Font.PLAIN,18));
       frame.add(label);
       frame.setResizable(false);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(420,460);
       frame.setLayout(null);
       frame.setVisible(true);
       numesiprenume.setBounds(170,2,200,30);
       frame.add(numesiprenume);
       label2.setBounds(2,60,230,30);
       label2.setFont(new Font(null,Font.PLAIN,18));
       frame.add(label2);
       id.setBounds(210,60,150,30);
       frame.add(id);
       datar.setBounds(2,300,250,30);
       datar.setFont(new Font(null,Font.PLAIN,18));
       frame.add(datar);
       dr.setBounds(170,300,150,30);
       frame.add(dr);
       fin.setBounds(150,380,120,30);
       fin.setText("Imprumuta");
       frame.add(fin);
       alg.setBounds(2,150,150,30);
       alg.setFont(new Font(null,Font.PLAIN,18));
       frame.add(alg);
       fin.setFocusable(false);
       fin.addActionListener(not);
       area.setEditable(false);
       comboBox=new JComboBox(ar);
       comboBox.addItemListener(not);
       comboBox.setBounds(100,157,100,18);
       area.setBounds(220,120,100,160);
       exemplu.setBounds(170,330,120,30);
       frame.add(exemplu);
       frame.add(comboBox);
       frame.add(area);
       frame.getContentPane().setBackground(new Color(123,50,250));
       fin.setBackground(Color.gray); 
       cart=new ArrayList<>();
    }
 
    
    
    public class Notepad implements ActionListener,ItemListener{
    @Override
	public void itemStateChanged(ItemEvent event) {
        if(comboBox.getSelectedIndex()>0){
	if(event.getStateChange()==ItemEvent.SELECTED){
            
            String ar=String.valueOf(comboBox.getSelectedItem());
            area.append(ar+newline);
           cart.add((String)event.getItem());
        }}}
        @Override
        public void actionPerformed(ActionEvent e){
        String np=numesiprenume.getText();
        String cnp=id.getText();
        String datar=dr.getText();
            
            if(e.getSource()==fin) {
                
        if(!np.isEmpty() && cnp.length()==13 && !datar.isEmpty() && !cart.isEmpty()){        
                
                
         frame.dispose();
       
        Abonat ab=new Abonat(np,cnp,datar);
        Imprumut ip=new Imprumut(cart);
        
        
        
        int i;
            try {
			File writer = new File("imprumutate.txt");
                        FileWriter fr = new FileWriter(writer, true);
			fr.write(ab.getB()+newline+ab.getA()+newline+ab.getC()+newline);
                        for(i=0;i<ip.getCarte().size();i++)
                        //fr.write(cart.get(i).toString());
                        fr.write(ip.getCarte().get(i));
                        fr.write(newline+newline);
			fr.close();
		} 
		catch (IOException b) {
			b.printStackTrace();
		}	
        
        Primafereastra ax=new Primafereastra();
            }
                     
	}
    
        }
}
}
        
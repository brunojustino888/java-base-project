package umc.socket;

// Importa os pacotes necess�rios
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

/** 
 * @Disciplina Sistemas Distrib�dos
 * @description Essa Classe foi desenvolvida para representar a Interface de Input (via Socket) do Cliente.
 * @Orientador Professor Desir� 
 * @Autor Bruno Alves Justino 
 * @Data � Out - 2013
 */

public class InterfaceInputX extends JFrame {

		private static final long serialVersionUID = 8L;
	    private JButton btnResultado, btn4, btnMenos, btnMais, btn1, btn7, btn2, btn0, btn6, btn5, btn8, btn3, btnC, btn9, btnDiv;
	    private JTextField tjf;
	    private JButton btnX;
	    private String text,n1,n2,OP ="";
	    private String aux;
	    
	    public InterfaceInputX() {
	    	text="";
	    	n1 = "";
	    	n2 = "";
	    	OP = "";
	    	
	    	
	    	
	    	 //Propriedades da Janela
	    	 this.getContentPane().setLayout(null);
	         this.getContentPane().setBackground(new Color(0, 153, 255));
	         java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	         this.setSize(new java.awt.Dimension(188, 230));
	         this.setLocation((screenSize.width-188)/2,(screenSize.height-230)/2);
	         this.setTitle("Desir�");
	         this.setResizable(false);
	      
	         
	         
             //Controles da Janela
	         tjf = new JTextField();
	         tjf.setBounds(new Rectangle(3, 3, 175, 32));
	         tjf.setBackground(Color.BLACK);
	         tjf.setForeground(Color.WHITE);
	         tjf.setFont(new Font("Jokerman", Font.ITALIC, 19));
	         this.getContentPane().add(tjf, null);
	        
	         
	         btnResultado = new JButton("=");
	         btnResultado.setBounds(new Rectangle(91, 167, 87, 29));
	         btnResultado.setFont(new Font("Rockwell", Font.BOLD, 19));
	         this.getContentPane().add(btnResultado, null);
	         btnResultado.addActionListener (new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	        
	            	
	            		n2=tjf.getText();
		            	pedirResposta();
	            		
	            		text="";
	            		n1="";
	            		n2="";
	            		OP="";
	     
	             }
	         });
	         btn4 = new JButton("4");
	         btn4.setBounds(new Rectangle(3, 103, 41, 30));
	         btn4.setFont(new Font("Rockwell", Font.BOLD, 15));
	         this.getContentPane().add(btn4, null);
	         btn4.addActionListener (new ActionListener() {
	             public void actionPerformed(ActionEvent e) {

	            		 text += "4";
	            		 tjf.setText(text);
	            
	             }
	         });
	         btnMenos = new JButton("-");
	         btnMenos.setBounds(new Rectangle(137, 71, 41, 30));
	         btnMenos.setFont(new Font("Rockwell", Font.BOLD, 15));
	         this.getContentPane().add(btnMenos, null);
	         btnMenos.addActionListener (new ActionListener() {
	             public void actionPerformed(ActionEvent e) {

	            	 if(OP.length()==1){
	            		 
	            		 n2 = tjf.getText();
			             pedirResposta();
			             
	            	 }else{
	            	 
	        		 n1=tjf.getText();
            		 OP="-";
            		 tjf.setText("-");
            		 text="";
            		 
	            	 }
	            	 
	             }
	         });
	         btnMais = new JButton("+");
	         btnMais.setFont(new Font("Rockwell", Font.BOLD, 14));
	         btnMais.setBounds(new Rectangle(137, 103, 41, 30));
	         this.getContentPane().add(btnMais, null);
	         btnMais.addActionListener (new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	              
	            	 if(OP.length()==1){
	            		 
	            		 n2 = tjf.getText();
			             pedirResposta();
			             
	            	 }else{
	            	 
	        		 n1=tjf.getText();
            		 OP="+";
            		 tjf.setText("+");
            		 text="";
            		 
	            	 }

	             }
	         });
	         btn1 = new JButton("1");
	         btn1.setBounds(new Rectangle(3, 135, 41, 30));
	         btn1.setFont(new Font("Rockwell", Font.BOLD, 15));
	         this.getContentPane().add(btn1, null);
	         btn1.addActionListener (new ActionListener() {
	             public void actionPerformed(ActionEvent e) {

	             	 
	            		 text += "1";
	            		 tjf.setText(text);
	            	
	             }
	         });
	         btn7 = new JButton("7");
	         btn7.setBounds(new Rectangle(3, 71, 41, 30));
	         btn7.setFont(new Font("Rockwell", Font.BOLD, 15));
	         this.getContentPane().add(btn7, null);
	         btn7.addActionListener (new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	                
	             	
	            		 text += "7";
	            		 tjf.setText(text);
	            	
	            	 
	             }
	         });
	         btn2 = new JButton("2");
	         btn2.setBounds(new Rectangle(47, 135, 41, 30));
	         btn2.setFont(new Font("Rockwell", Font.BOLD, 15));
	         this.getContentPane().add(btn2, null);
	         btn2.addActionListener (new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	          
	             	
	            		
	            		 text += "2";
	            		 tjf.setText(text);
	            	
	            	  	
	             }
	         });
	         btn0 = new JButton("0");
	         btn0.setBounds(new Rectangle(3, 167, 85, 29));
	         btn0.setFont(new Font("Rockwell", Font.BOLD, 15));
	         this.getContentPane().add(btn0, null);
	         btn0.addActionListener (new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	            
	             	
	            		
	            		 text += "0";
	            		 tjf.setText(text);
	            	 
	            	  
	             }
	         });
	         btn6 = new JButton("6");
	         btn6.setBounds(new Rectangle(91, 103, 41, 30));
	         btn6.setFont(new Font("Rockwell", Font.BOLD, 15));
	         this.getContentPane().add(btn6, null);
	         btn6.addActionListener (new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	                
	             	
	            		 text += "6";
	            		 tjf.setText(text);
	            	
	             }
	         });
	         btn5 = new JButton("5");
	         btn5.setBounds(new Rectangle(47, 103, 41, 30));
	         btn5.setFont(new Font("Rockwell", Font.BOLD, 15));
	         this.getContentPane().add(btn5, null);
	         btn5.addActionListener (new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	           
	             	
	            		 text += "5";
	            		 tjf.setText(text);
	            	
	             }
	         });
	         btn8 = new JButton("8");
	         btn8.setBounds(new Rectangle(47, 71, 41, 30));
	         btn8.setFont(new Font("Rockwell", Font.BOLD, 15));
	         this.getContentPane().add(btn8, null);
	         btn8.addActionListener (new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	             	
	            		 text += "8";
	            		 tjf.setText(text);
	            	
	             }
	         });
	         btn3 = new JButton("3");
	         btn3.setBounds(new Rectangle(91, 135, 41, 30));
	         btn3.setFont(new Font("Rockwell", Font.BOLD, 15));
	         this.getContentPane().add(btn3, null);
	         btn3.addActionListener (new ActionListener() {
	             public void actionPerformed(ActionEvent e) {

	             	 
	            		 text += "3";
	            		 tjf.setText(text);
	            	
	             }
	         });
	         btnC = new JButton("C");
	         btnC.setBounds(new Rectangle(3, 40, 129, 29));
	         btnC.setFont(new Font("Rockwell", Font.BOLD, 15));
	         this.getContentPane().add(btnC, null);
	         btnC.addActionListener (new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	            	 text = "";
	            	 n1="";
	            	 n2="";
	            	 OP="";
	            	 tjf.setText(text);
	             }
	         });
	         btn9 = new JButton("9");
	         btn9.setBounds(new Rectangle(91, 71, 41, 30));
	         btn9.setFont(new Font("Rockwell", Font.BOLD, 15));
	         this.getContentPane().add(btn9, null);
	         btn9.addActionListener (new ActionListener() {
	             public void actionPerformed(ActionEvent e) {

	            	
	            		 text += "9";
	            		 tjf.setText(text);
	            	
	          
	             }
	         });
	         btnDiv = new JButton("/");
	         btnDiv.setBounds(new Rectangle(137, 40, 41, 29));
	         btnDiv.setFont(new Font("Rockwell", Font.BOLD, 15));
	         this.getContentPane().add(btnDiv, null);
	         btnDiv.addActionListener (new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	            	
	            	 if(OP.length()==1){
	            		 
	            		 n2 = tjf.getText();
			             pedirResposta();
			             
	            	 }else{
	            	 
	        		 n1=tjf.getText();
            		 OP="/";
            		 tjf.setText("/");
            		 text="";
            		 
	            	 }
	            	 
	             }
	         });
	         
	         btnX = new JButton("*");
	         btnX.setBounds(new Rectangle(137, 135, 41, 30));
	         btnX.setFont(new Font("Rockwell", Font.BOLD, 15));
	         this.getContentPane().add(btnX, null);
	         btnX.addActionListener (new ActionListener() {
	             public void actionPerformed(ActionEvent e) {
	            	
	            	 if(OP.length()==1){
	            		 
	            		 n2 = tjf.getText();
			             pedirResposta();
			             
	            	 }else{
	            	 
	        		 n1=tjf.getText();
            		 OP="*";
            		 tjf.setText("*");
            		 text="";
            		 
	            	 }
	            	 
	             }
	         });
	         
	         
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
    }

	    public void pedirResposta(){
	    	if(n1.length()>0 &&n2.length()>0 &&OP.length()>0){

	    		tjf.setText("");
	    		
	    		try {
	    			Socket s = new Socket("localhost", 9999);
	    			InputStream i = s.getInputStream();
	    			OutputStream o = s.getOutputStream();
	    			String str = n1+"@"+OP+"@"+n2;
	    		
	    				byte[] line = new byte[100];
	    				byte[] line2 = new byte[100];
	    				line = str.getBytes();
	    				o.write(line);
	    				
	    				i.read(line2);
	    				o.write("bye".getBytes());
	    				
	    				str = new String(line2);
	    				str = str.trim();
	    				str = str.replace("O RESULTADO � ", "");
	    				String auxu ="";
	    				
	    				int j = 0;
	    				
	    					while(str.charAt(j)!='.'){
	    						auxu += str.charAt(j);
	    						j++;
	    					}

	    				tjf.setText(auxu);

	    			s.close();
	    			OP="";
		    		text="";
		    		n1="";
		    		n2="";
	    		}
	    		catch (Exception err) {
	    			System.err.println(err);
	    		}
	    		
	    	}else{
	    		OP="";
	    		text="";
	    		n1="";
	    		n2="";
	    		tjf.setText("");
	    		JOptionPane.showMessageDialog(null, "Digite os n�meros corretamente","Tente novamente!",1);
	    	}
	    	
	    }

    public static void main(String args[]) {
    	try {
    			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
    		}catch(Exception e){
    			
    		} 
        new InterfaceInputX();
    }
}
package umc;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class Prototype extends JFrame {

    // Bloco 1 - Dados dos Objetos da Janela
    private JButton objeto0;
    private JButton objeto1;
    private JButton objeto2;
    private JButton objeto3;

    public Prototype() {
        // Bloco 2 - Dados da Cria��o da Janela
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(new Color(153, 51, 255));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); //cria uma vari�vel do tipo dimens�o
        this.setSize(new java.awt.Dimension(800, 600)); //tamanho do frame
        this.setLocation((screenSize.width-800)/2,(screenSize.height-600)/2);  //serve para abrir no meio do screen
        this.setTitle("Prot�tipo SAI - Sistema de Aprendizagem Infantil - Tela Aprender");
        this.setResizable(false); //habilita tela inteira
        ImageIcon img = new ImageIcon("red.jpg");
        objeto3 = new JButton(img);
        try {
        	
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
      
        
        
        
        // Bloco 3 - Dados da Cria��o dos Controles na Janela
        objeto0 = new JButton("Ingl�s");
        objeto0.setBounds(new Rectangle(104, 55, 100, 100));
        this.getContentPane().add(objeto0, null);
        objeto1 = new JButton("Cores");
        objeto1.setBounds(new Rectangle(551, 440, 100, 100));
        this.getContentPane().add(objeto1, null);
        objeto2 = new JButton("N�meros");
        objeto2.setBounds(new Rectangle(551, 55, 100, 100));
        this.getContentPane().add(objeto2, null);
        objeto3 = new JButton("Letras");
        objeto3.setBounds(new Rectangle(104, 440, 100, 100));
        this.getContentPane().add(objeto3, null);
        
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                aoFechar();
            }
        });
        this.setVisible(true);
    }

    private void aoFechar() {
        System.exit(0);
    }

    // Insira aqui os m�todos para os eventos

    public static void main(String args[]) {
        
    	//TelaLogin d = new TelaLogin();
    	
    	new Prototype();
        

        
        
       /* try {  
            // Define o look and feel   
            UIManager.setLookAndFeel(new SubstanceBusinessLookAndFeel());  
        	

        }catch (UnsupportedLookAndFeelException ex) {  
            ex.printStackTrace();  
        }  */
        
        
        /*JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);*/

    }
}
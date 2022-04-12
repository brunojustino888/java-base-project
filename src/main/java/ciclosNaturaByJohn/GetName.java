package ciclosNaturaByJohn;


// Importa os pacotes necess�rios
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.*;

public class GetName extends JFrame {

    // Bloco 1 - Dados dos Objetos da Janela
    private JLabel Label1;
    private JTextField JTextFieldLocal;
    private JLabel Label3;
    private JTextField JTextFieldDestino;
    private JTextField JTextFieldStatus;
    private JLabel Label2;
    private JButton ButtonGerar;
    private JButton ButtonLimpar;	

    public GetName() {
    	
        // Bloco 2 - Dados da Cria��o da Janela
    	this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(new Color(255, 153, 51));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new java.awt.Dimension(336, 230));
        this.setLocation((screenSize.width-336)/2,(screenSize.height-230)/2);
        this.setTitle("Ciclos Natura ");
        this.setResizable(true);


        // Bloco 3 - Dados da Cria��o dos Controles na Janela
	Label1 = new JLabel("Especifique a pasta onde est�o os arquivos de �udio:");
        Label1.setBounds(new Rectangle(3, 3, 300, 13));
        this.getContentPane().add(Label1, null);
        JTextFieldLocal = new JTextField();
        JTextFieldLocal.setBounds(new Rectangle(3, 18, 300, 21));
        this.getContentPane().add(JTextFieldLocal, null);
        Label3 = new JLabel("Especifique a pasta de sa�da para o arquivo:");
        Label3.setBounds(new Rectangle(3, 50, 300, 13));
        this.getContentPane().add(Label3, null);
        JTextFieldDestino = new JTextField();
        JTextFieldDestino.setBounds(new Rectangle(3, 64, 300, 21));
        this.getContentPane().add(JTextFieldDestino, null);
        JTextFieldStatus = new JTextField();
        JTextFieldStatus.setBounds(new Rectangle(130, 170, 60, 21));
        this.getContentPane().add(JTextFieldStatus, null);
        Label2 = new JLabel("STATUS:");
        Label2.setBounds(new Rectangle(135, 157, 57, 13));
        this.getContentPane().add(Label2, null);
        ButtonGerar = new JButton("Gerar");
        ButtonGerar.setBounds(new Rectangle(40, 112, 100, 30));
        this.getContentPane().add(ButtonGerar, null);
        ButtonGerar.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Chamada a um m�todo
            	if (	(JTextFieldLocal.getText().equals("") || JTextFieldDestino.getText().equals("")) 	){
            		JTextFieldStatus.setText("FAILURE!");
            		JOptionPane.showMessageDialog(null, "Especif�que os caminhos corretamente.","ERRO",0);
            		JTextFieldStatus.setText("");
            	}else{
            	
            	
            	  Writer writer = null;

            	  try {
            	      
            	        //Vari�vel "file" recebe a pasta onde est�o as mensagens do ciclo da natura.
            		    String local = JTextFieldLocal.getText();
            			File file = new File(local);
            			String[] fileName = file.list();
            			//Vari�vel "fileout" escreve o arquivo de sa�da formatado.(promociclo.txt)
            			String destino = JTextFieldDestino.getText();
            			File fileout = new File(destino+"//Ciclo Atual.rtf");
            			writer = new BufferedWriter(new FileWriter(fileout));
            			int i = 0;
            			//Laco faz a leitura de todo o vetor string at� o fim.
            			
		            			while (i!=fileName.length){
		            				writer.write("keyValues['" + fileName[i].substring(0,6) + "']='" + fileName[i] + "';\n");
		            		  		System.out.println ("keyValues['" + fileName[i].substring(0,6) + "']='" + fileName[i] + "';\n");
		            		  		i++;
		            		  	}
		            			if(fileName.length>0){
		            				JTextFieldStatus.setText("Success!");
		            			}else{
		            				JTextFieldStatus.setText("FAILURE!");
		            			}
		            			
            			}
            	  catch (FileNotFoundException ex) {
            		  		JTextFieldStatus.setText("FAILURE!");
            	            ex.printStackTrace();
            	        } catch (IOException ex) {
            	        	JTextFieldStatus.setText("FAILURE!");
            	            ex.printStackTrace();
            	        } finally {
            	            try {
            	                if (writer != null) {
            	                    writer.close();
            	                }
            	            } catch (IOException ex) {
            	            	JTextFieldStatus.setText("FAILURE!");
            	                ex.printStackTrace();
            	            }
            	        }

            	}
            }
        });
        ButtonLimpar = new JButton("Limpar");
        ButtonLimpar.setBounds(new Rectangle(185, 112, 100, 30));
        this.getContentPane().add(ButtonLimpar, null);
        ButtonLimpar.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Chamada a um m�todo
            	JTextFieldDestino.setText("");
            	JTextFieldLocal.setText("");
            	JTextFieldStatus.setText("");
            }
        });	

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
        new GetName();
    }
}
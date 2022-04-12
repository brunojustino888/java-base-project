package paradox4SQL;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

public class Interface extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblParadox, lblImage;
    private JTextField jtfParadox;
    private JButton btnOrigem,btnConverter,btnTuto;
    ArrayList<String> nometabelasPX = new ArrayList<String>();

    
    public Interface() {
    	
    	 this.getContentPane().setLayout(null);
         this.getContentPane().setBackground(new Color(0,0,0));
         java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
         this.setSize(new java.awt.Dimension(807, 622));
         this.setLocation((screenSize.width-800)/2,(screenSize.height-600)/2);
         this.setTitle("MSIT - Paradox 4 SQL");
         this.setResizable(false);
         this.setModal(true);
         ImageIcon icon = new ImageIcon("C:/Application4Paradox/img/xbtn.png");
         this.setIconImage(icon.getImage());
         
         lblParadox = new JLabel("Base Paradox:");
         lblParadox.setBounds(new Rectangle(114, 273, 94, 13));
         this.getContentPane().add(lblParadox, null);
        
         jtfParadox = new JTextField();
         jtfParadox.setToolTipText("Selecionar o diret�rio da Base Paradox");
         jtfParadox.setEditable(false);
         jtfParadox.setBounds(new Rectangle(230, 270, 350, 21));
         this.getContentPane().add(jtfParadox, null);
         btnOrigem = new JButton("Origem");
         btnOrigem.setToolTipText("Selecionar o diret�rio da Base Paradox");
         btnOrigem.setBounds(new Rectangle(603, 270, 90, 21));
         this.getContentPane().add(btnOrigem, null);
         btnOrigem.addActionListener (new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                
            	 
            	 JFileChooser arquivo = new JFileChooser();  
                 arquivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
                 if(arquivo.showOpenDialog(arquivo) != JFileChooser.APPROVE_OPTION){ 
                	jtfParadox.setForeground(Color.red); 
                 	jtfParadox.setText("Por favor selecione o diret�rio dos arquivos da Base Paradox");
                 }else{
                	 String sdiretorio = arquivo.getSelectedFile().getPath();
                	 jtfParadox.setForeground(new Color(34, 139, 34)); 
                	 jtfParadox.setText(sdiretorio);
                	 loadComboBox(sdiretorio);
                 }
             }
         });


         btnConverter = new JButton("Converter");
         btnConverter.setBounds(new Rectangle(347, 522, 100, 30));
         btnConverter.setToolTipText("Clique para converter a tabela selecionada ao lado");
         this.getContentPane().add(btnConverter, null);
         btnConverter.addActionListener (new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                if(jtfParadox.getForeground().equals(new Color(34, 139, 34))){
                	String pastaparadox = jtfParadox.getText();
                	System.out.println("Pasta Paradox: "+pastaparadox);
                	setVisible(false);
        			new ConexaoTest(jtfParadox.getText(),nometabelasPX);
                   	new Congratulations();
                }else{
                	JOptionPane.showMessageDialog(null, "Por favor selecione os diret�rios corretamente para prosseguir.","MSIT - Paradox 4 TXT",0);
                }
             }
         });
         btnTuto = new JButton("Tutorial");
         btnTuto.setToolTipText("Tutorial para a convers�o...");
         btnTuto.setBounds(new Rectangle(347, 185, 100, 30));
         this.getContentPane().add(btnTuto, null);
         btnTuto.addActionListener (new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 setVisible(false);
            	 new Tutorial();
                 
             }
         });
         ImageIcon background = new ImageIcon("C:/Application4Paradox/img/backgroun.jpg");
         lblImage = new JLabel(background);
         lblImage.setBounds(new Rectangle(0, -5, 800, 600));
         this.getContentPane().add(lblImage);
         this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	int	resp =  JOptionPane.showConfirmDialog(null, "Tem certeza que deseja encerrar a Aplica��o?","MSIT - Paradox 4 TXT",0);
             	
        		if(resp==0){
        			aoFechar();
        		}else{
        			System.err.println(resp);
        		}
            }
        });
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }

    private void aoFechar() {
    	System.exit(0);
    }
    
    public void loadComboBox(String s){
    	File file = new File(s); 
    	File array[] = file.listFiles(); 
    	boolean b = false;
  	
    	for (int i = 0; i < array.length; i++) { 
    		if(array[i].getName().contains(".DB")){
    			b = true;
        	}
    	} 
    	
    	for (int i = 0; i < array.length; i++) { 
    		if(array[i].getName().contains(".DB")){
    			nometabelasPX.add(array[i].getName());
    			btnOrigem.setVisible(false);
        	}
    	} 
    	
    	for (int i = 0; i < nometabelasPX.size(); i++) { 
    		    nometabelasPX.get(i);
    			System.out.println(array[i].getName());

        	}
    	
    	
    	if(!b){
    		jtfParadox.setForeground(Color.red); 
         	jtfParadox.setText("Por favor selecione o diret�rio dos arquivos da Base Paradox");
    	}
    	
    }

    public static void main(String args[]) {

        new Interface();
    }
}
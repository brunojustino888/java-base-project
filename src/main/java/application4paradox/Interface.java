package application4paradox;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Interface extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblParadox, lblTXT, lblTabela, lblImage;
    private JComboBox<String> jcbTabela;
    private JTextField jtfParadox,jtfTXT;
    private JButton btnOrigem,btnDestino,btnConverter,btnTuto;
    private Musica m;
    
    public Interface() {
    	
    	 this.getContentPane().setLayout(null);
         this.getContentPane().setBackground(new Color(0,0,0));
         java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
         this.setSize(new java.awt.Dimension(807, 622));
         this.setLocation((screenSize.width-800)/2,(screenSize.height-600)/2);
         this.setTitle("MSIT - Paradox 4 TXT");
         this.setResizable(false);
         this.setModal(true);
         ImageIcon icon = new ImageIcon("C:/Application4Paradox/img/xbtn.png");
         this.setIconImage(icon.getImage());

         //Tocando uma m�sica utilizando a classe Musica.
         try {
 			m = null;
 			m = new Musica("C:/Application4Paradox/audio/Jesters of the Moon.mp3");
 			m.play();
 	     }catch ( Exception e2) {
 			e2.printStackTrace();
 		 }
         
         lblParadox = new JLabel("Base Paradox:");
         lblParadox.setBounds(new Rectangle(114, 273, 94, 13));
         this.getContentPane().add(lblParadox, null);
         lblTXT = new JLabel("Destino do TXT:");
         lblTXT.setBounds(new Rectangle(114, 333, 98, 13));
         this.getContentPane().add(lblTXT, null);
         lblTabela = new JLabel("Tabela:");
         lblTabela.setBounds(new Rectangle(194, 428, 57, 13));
         this.getContentPane().add(lblTabela, null);
         jcbTabela = new JComboBox<String>();
        
         jcbTabela.addItem("Selecionar tabela da Base Paradox  > > > > > > > >");
         jcbTabela.setBounds(new Rectangle(314, 424, 315, 22));

         this.getContentPane().add(jcbTabela, null);
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
         jtfTXT = new JTextField();
         jtfTXT.setToolTipText("Selecionar o diret�rio de destino do arquivo TXT");
         jtfTXT.setBounds(new Rectangle(230, 330, 350, 21));
         jtfTXT.setEditable(false);
         this.getContentPane().add(jtfTXT, null);
         btnDestino = new JButton("Destino");
         btnDestino.setToolTipText("Selecionar o diret�rio de destino do arquivo TXT");
         btnDestino.setBounds(new Rectangle(603, 330, 90, 22));
         this.getContentPane().add(btnDestino, null);
         btnDestino.addActionListener (new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 
            	 
            	 JFileChooser arquivo = new JFileChooser();  
                 arquivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
                 if(arquivo.showOpenDialog(arquivo) != JFileChooser.APPROVE_OPTION){ 
                	jtfTXT.setForeground(Color.red); 
                 	jtfTXT.setText("Por favor selecione a pasta onde ser� criado o TXT");
                 }else{
                	 String sdiretorio = arquivo.getSelectedFile().getPath();
                	 jtfTXT.setForeground(new Color(34, 139, 34)); 
                	 sdiretorio = sdiretorio+"\\Arquivo de dados.txt"; 
                	 jtfTXT.setText(sdiretorio);
                	 
                 }
            	 
             }
         });
         btnConverter = new JButton("Converter");
         btnConverter.setBounds(new Rectangle(347, 522, 100, 30));
         btnConverter.setToolTipText("Clique para converter a tabela selecionada ao lado");
         this.getContentPane().add(btnConverter, null);
         btnConverter.addActionListener (new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                if(jtfParadox.getForeground().equals(new Color(34, 139, 34))&&jtfTXT.getForeground().equals(new Color(34, 139, 34))){
                	String tabela = jcbTabela.getSelectedItem().toString();
                	tabela = tabela.substring(0,tabela.length()-3);
                	System.out.println("Tabela: "+tabela);
                	String pastatxt = jtfTXT.getText();
                	System.out.println("Pasta txt: "+pastatxt);
                	String pastaparadox = jtfParadox.getText();
                	System.out.println("Pasta Paradox: "+pastaparadox);
                	setVisible(false);
                	new ConexaoTest(pastatxt, pastaparadox, tabela);
                	m.stop();
                	m.close();
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
            	 m.stop();
            	 m.close();
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
    			jcbTabela.removeAllItems();
    			b = true;
        	}
    	} 
    	
    	for (int i = 0; i < array.length; i++) { 
    		if(array[i].getName().contains(".DB")){
    			jcbTabela.addItem(array[i].getName());
    			btnOrigem.setVisible(false);
        	}
    	} 
    	
    	if(!b){
    		jtfParadox.setForeground(Color.red); 
         	jtfParadox.setText("Por favor selecione o diret�rio dos arquivos da Base Paradox");
    	}
    	
    }

    public static void main(String args[]) {
    	
    	
    	/*InfoNodeLookAndFeelTheme theme =
    	        new InfoNodeLookAndFeelTheme("INFONOdE",
    	                                     new Color(143,143,189),
    	                                     new Color(0, 170, 0),
    	                                     new Color(80, 80, 80),
    	                                     Color.BLACK,
    	                                     new Color(0, 170, 0),
    	                                     Color.WHITE,
    	                                     0.8);
    	    try {UIManager.setLookAndFeel(new InfoNodeLookAndFeel(theme));}catch(UnsupportedLookAndFeelException e1) {e1.printStackTrace();}
    	*/
    	
    	
    	  //Quaqua - Mac 
    	 /* System.setProperty("Quaqua.tabLayoutPolicy","wrap");
    	  try { UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());}catch(Exception e) {}
    	*/
    	
    	
		//try {UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");}catch(Exception e){} 
    	

        new Interface();
    }
}
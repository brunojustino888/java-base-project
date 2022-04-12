package gidestock.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import gidestock.controller.PainelTable;

public class ViewConsultaProduto extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private ImageIcon icone, background;
	private JLabel lblImageBackground, btnVoltar;
	private JButton btnAlterar, btnApagar, btnNovo;
	private PainelTable painel;
	
	public ViewConsultaProduto(){
		    this.getContentPane().setLayout(null);
		    this.getContentPane().setBackground(new Color(255, 255, 255));
		    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		    this.setSize(new java.awt.Dimension(806, 628));
	        this.setLocation((screenSize.width-806)/2,(screenSize.height-628)/2);
		    this.setTitle("Menu Principal - GideStock");
		    this.setResizable(false);
		    icone = new ImageIcon("C:\\GideStock\\img\\xbtn.png");
		    this.setIconImage(icone.getImage());
		    this.setLayout(null);
		    
		    painel = new PainelTable(); 
	        painel.setBounds(new Rectangle(34,103, 733,196));
			JScrollPane scrollPane = new JScrollPane(painel);

			this.getContentPane().add(scrollPane);
	        
	        this.getContentPane().add(painel); 
		    
		    btnAlterar = new JButton("Alterar");
		    btnAlterar.setVisible(true);
		    btnAlterar.setBounds(new Rectangle(166,372, 105,39));
		    this.getContentPane().add(btnAlterar, null);
		    
		    btnApagar = new JButton("Apagar");
		    btnApagar.setVisible(true);
		    btnApagar.setBounds(new Rectangle(345,372, 105,39));
		    this.getContentPane().add(btnApagar, null);
		    
		    btnNovo = new JButton("Novo");
		    btnNovo.setVisible(true);
		    btnNovo.setBounds(new Rectangle(530,372, 105,39));
		    this.getContentPane().add(btnNovo, null);
		    btnNovo.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(painel.getTable().getSelectedRow());
				Object[][] dados = painel.getData();
				System.out.println(dados[painel.getTable().getSelectedRow()][0]);
			}});
		    
		    
		    btnVoltar = new JLabel("Voltar");
		    btnVoltar.setBounds(new Rectangle(30,500,56,15));
		    btnVoltar.setFont(new Font("Arial",Font.BOLD,11));
		    btnVoltar.setForeground(Color.black);
		    this.getContentPane().add(btnVoltar, null);
		    btnVoltar.addMouseListener(new MouseListener() {  
		        public void mouseReleased(MouseEvent e) {} 
		        public void mousePressed(MouseEvent e) {}  
		        public void mouseExited(MouseEvent e) {  
		           btnVoltar.setForeground(Color.black);
		        }  
		        public void mouseEntered(MouseEvent e) {btnVoltar.setForeground(Color.blue);}  
		        public void mouseClicked(MouseEvent e) {
		        	setVisible(false);
		        	new ViewPrincipal();
		        }});
		    
		    background = new ImageIcon("C:\\GideStock\\img\\BackgroundConsultaProduto.fw.png");
	        lblImageBackground = new JLabel(background);
	        lblImageBackground.setBounds(new Rectangle(0,0,800,600));
	        this.getContentPane().add(lblImageBackground, null);
		    
		    
		    this.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	            	Toolkit.getDefaultToolkit().beep();
	            	int	resp =  JOptionPane.showConfirmDialog(null, "Tem certeza que deseja encerrar o Sistema?");
	    			if(resp==0){
	    				System.exit(0);
	    			}
	            }
	        });
	        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        this.setVisible(true);
	}
	
}

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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import gidestock.model.Produto;

public class CadastraProduto extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private ImageIcon icone, background;
	private JLabel lblImageBackground, btnVoltar;
	private JTextField txtNome, txtQtd, txtEstoque, txtPreco;
	private JTextArea areaDescricao;
	private JButton btnCadastrar;
	private int quantidade, estoquemin;
	private String nome, descricao;
	private double preco;
	private Produto novoproduto;

	public CadastraProduto(){
	    this.getContentPane().setLayout(null);
	    this.getContentPane().setBackground(new Color(255, 255, 255));
	    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	    this.setSize(new java.awt.Dimension(806, 628));
        this.setLocation((screenSize.width-806)/2,(screenSize.height-628)/2);
	    this.setTitle("Cadastrar Produto - GideStock");
	    this.setResizable(false);
	    icone = new ImageIcon("C:\\GideStock\\img\\xbtn.png");
	    this.setIconImage(icone.getImage());
	    
	    txtNome = new JTextField();
	    txtNome.setBounds(new Rectangle(182,172,280,34));
	    txtNome.setFont(new Font("Arial",Font.BOLD,12));
	    txtNome.setForeground(Color.black);
	    this.getContentPane().add(txtNome, null);
	    
	    txtQtd = new JTextField();
	    txtQtd.setBounds(new Rectangle(590,172,99,34));
	    txtQtd.setFont(new Font("Arial",Font.BOLD,12));
	    txtQtd.setForeground(Color.black);
	    this.getContentPane().add(txtQtd, null);
	    
	    txtEstoque = new JTextField();
	    txtEstoque.setBounds(new Rectangle(590,240,99,34));
	    txtEstoque.setFont(new Font("Arial",Font.BOLD,12));
	    txtEstoque.setForeground(Color.black);
	    this.getContentPane().add(txtEstoque, null);
	    
	    txtPreco = new JTextField();
	    txtPreco.setBounds(new Rectangle(182,239,99,34));
	    txtPreco.setFont(new Font("Arial",Font.BOLD,12));
	    txtPreco.setForeground(Color.black);
	    this.getContentPane().add(txtPreco, null);
	    
	    btnCadastrar = new JButton("Cadastrar");
	    btnCadastrar.setBounds(new Rectangle(375,473,93,27));
	    btnCadastrar.setFont(new Font("Arial",Font.BOLD,11));
	    btnCadastrar.setForeground(Color.black);
	    this.getContentPane().add(btnCadastrar, null);
	    btnCadastrar.addActionListener (new ActionListener() {
		  
		public void actionPerformed(ActionEvent e) {
		        if(validacao()){
		        	novoproduto = new Produto(nome, quantidade, preco, estoquemin, descricao);
		        	setVisible(false);
		        	novoproduto.cadastraProduto();
		        	JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!","Produto Cadastrado!",1);
		        	new ViewPrincipal();
		        }
		   }});
	    
	    areaDescricao = new JTextArea();
	    areaDescricao.setBounds(new Rectangle(219,310,469,132));
	    areaDescricao.setFont(new Font("Arial",Font.BOLD,12));
	    areaDescricao.setForeground(Color.black);
	    areaDescricao.setEditable(true);
	    
		JScrollPane scrollPane = new JScrollPane(areaDescricao);
		this.getContentPane().add(scrollPane);
		this.getContentPane().add(areaDescricao,null);
	    
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
	    
	    background = new ImageIcon("C:\\GideStock\\img\\BackgroundCadastraProduto.fw.png");
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
	
	public boolean validacao(){
		   if(txtNome.getText()!=null&&txtPreco.getText()!=null&&txtQtd.getText()!=null&&txtEstoque.getText()!=null){
			   try{
				 nome 		=  txtNome.getText();
				 descricao  =  areaDescricao.getText();
				 preco		=  Double.parseDouble(txtPreco.getText());
				 estoquemin =  Integer.parseInt(txtEstoque.getText());
				 quantidade =  Integer.parseInt(txtQtd.getText());
				 System.out.println("Valores:\n"+nome+"\n"+ quantidade+"\n"+ preco+"\n"+estoquemin+"\n"+descricao);
			   }catch(Exception e){
				   JOptionPane.showMessageDialog(null, "Por favor verifique todos os campos!","ERRO DE BD...",0);
				   return false;
			   }	   
			   return true;
		   }
	   return false;
	}
	
}

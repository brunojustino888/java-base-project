package interfaceXmlEnergiza;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/*	
* Essa classe � respons�vel pela Interface que ser� mostrada ao usu�rio quando ele clicar em "Incluir Feriado" ap�s logado.
*/

public class CadastraNovoFeriado extends JDialog {
	
	//Objetos da Janela
	private static final long serialVersionUID = 1L;
    private JLabel lblFeriado;
    private JLabel lblTrabalha;
    private JLabel lblInicio;
    private JLabel lblTermino;
    private JTextField jtfDia;
    private JTextField jtfInicio;
    private JTextField jtfTermino;
    private JCheckBox checkTrabalha;
    private JButton btnIncluir;
    private JLabel lblStatus;
    private JLabel lblCondition;
    private String nomeXML, privilegio;
    
    
    public CadastraNovoFeriado(String xml , String privilegioDoUsuario) {
        //Dados da Cria��o da Janela
    	nomeXML=xml;
    	privilegio = privilegioDoUsuario;
    	ImageIcon wittelIcon = new ImageIcon(getClass().getResource("img/xbtn.png"));
    	this.setIconImage(wittelIcon.getImage());
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(new Color(44, 71, 124));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new java.awt.Dimension(254, 168));
        this.setLocation((screenSize.width-254)/2,(screenSize.height-168)/2);
        this.setTitle("Incluir novo Feriado");
        this.setResizable(false);
        this.setModal(true);

        //Controles da Janela
        lblFeriado = new JLabel("Feriado: ");
        lblFeriado.setForeground(Color.white);
        lblFeriado.setFont(new Font("Calibri",Font.BOLD, 15 ));
        lblFeriado.setBounds(new Rectangle(15, 15, 57, 15));
        this.getContentPane().add(lblFeriado, null);
        lblTrabalha = new JLabel("Trabalha: ");
        lblTrabalha.setForeground(Color.white);
        lblTrabalha.setFont(new Font("Calibri",Font.BOLD, 15 ));
        lblTrabalha.setBounds(new Rectangle(14, 45, 60, 15));
        this.getContentPane().add(lblTrabalha, null);
        lblInicio = new JLabel("In�cio:");
        lblInicio.setForeground(Color.white);
        lblInicio.setFont(new Font("Calibri",Font.BOLD, 15 ));
        lblInicio.setBounds(new Rectangle(15, 75, 57, 15));
        this.getContentPane().add(lblInicio, null);
        lblTermino = new JLabel("T�rmino:");
        lblTermino.setForeground(Color.white);
        lblTermino.setFont(new Font("Calibri",Font.BOLD, 15 ));
        lblTermino.setBounds(new Rectangle(14, 105, 57, 13));
        this.getContentPane().add(lblTermino, null);
        jtfDia = new JTextField();
        jtfDia.setBounds(new Rectangle(85, 12, 50, 20));
        this.getContentPane().add(jtfDia, null);
        jtfInicio = new JTextField();
        jtfInicio.setBounds(new Rectangle(85, 72, 50, 20));
        this.getContentPane().add(jtfInicio, null);
        jtfTermino = new JTextField();
        jtfTermino.setBounds(new Rectangle(85, 102, 50, 20));
        this.getContentPane().add(jtfTermino, null);
        checkTrabalha = new JCheckBox();
        checkTrabalha.setBounds(new Rectangle(81, 42, 20, 19));
        this.getContentPane().add(checkTrabalha, null);
        btnIncluir = new JButton("Incluir");
        btnIncluir.setFont(new Font("Calibri",Font.BOLD, 15 ));
        btnIncluir.setBounds(new Rectangle(160, 11, 78, 30));
        this.getContentPane().add(btnIncluir, null);
        btnIncluir.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(jtfDia.getText().equals("")||jtfInicio.getText().equals("")||jtfTermino.getText().equals("")){
                	JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos!","Tente Novamente",1);
                }else{
                	btnIncluir.setVisible(false);
                	lblCondition.setVisible(true);
                	new AlterarXML(nomeXML,jtfDia.getText(),String.valueOf(checkTrabalha.isSelected()),jtfInicio.getText(),jtfTermino.getText());
                }
            }
        });
        lblStatus = new JLabel("Status");
        lblStatus.setForeground(Color.white);
        lblStatus.setFont(new Font("Calibri",Font.BOLD, 15 ));
        lblStatus.setBounds(new Rectangle(176, 75, 57, 13));
        this.getContentPane().add(lblStatus, null);
        lblCondition = new JLabel("Feriado Salvo!");
        lblCondition.setFont(new Font("Calibri",Font.BOLD, 15 ));
        lblCondition.setForeground(new Color(153, 255, 153));
		lblCondition.setText("Feriado Salvo!");
		lblCondition.setVisible(false);
        lblCondition.setBounds(new Rectangle(155, 95, 88, 13));
        this.getContentPane().add(lblCondition, null);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	new InterfaceWittel2(privilegio);
            }
        });
        ImageIcon icWttl = new ImageIcon(getClass().getResource("img/wttl.png"));
        this.setVisible(true);
        this.setIconImage(icWttl.getImage());
    }

}
package umc.passosBlueJ;
// Importa os pacotes necess�rios
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/** AlunoTela
 * Projeto..: PassosBlueJ
 * [ coloque aqui a descri��o da classe ]
 * @author Fernando Anselmo � Out - 2012
 * @version 1.0
 */
public class AlunoTela extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Bloco 1 - Objetos da Janela
    private JTextField JTextFieldNome;
    private JComboBox<String> JComboBox;
    private JLabel LabelNome;
    private JLabel objeto3;
    private JButton JButtonIncluir;
    private JLabel LabelInclusos;
    private JButton JButtonVer;
    private JButton JButtonApagar;
    private JButton JButtonFechar;
    private JLabel LabelDetalheDois;
    private JLabel LabelDetalheUm;

    public AlunoTela() {

        // Bloco 2 - Defini��o dos dados da Janela
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(new Color(255, 0, 55));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new java.awt.Dimension(336, 230));
        this.setLocation((screenSize.width-336)/2,(screenSize.height-230)/2);
        this.setTitle("Inclus�o de Alunos - Ricardo Passos");
        this.setResizable(false);

        // Bloco 3 - Cria��o dos Objetos na Janela
        JTextFieldNome = new JTextField();
        JTextFieldNome.setBounds(new Rectangle(58, 16, 150, 21));
        this.getContentPane().add(JTextFieldNome, null);
        JComboBox = new JComboBox<String>();
        JComboBox.setBounds(new Rectangle(19, 88, 170, 30));
        this.getContentPane().add(JComboBox, null);
        JComboBox.addFocusListener (new FocusAdapter() {
        });
        JComboBox.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Chamada a um m�todo
              
            }
        });

        
        LabelNome = new JLabel("Nome:");
        LabelNome.setBounds(new Rectangle(8, 19, 58, 13));
        this.getContentPane().add(LabelNome, null);
        objeto3 = new JLabel("-------------------------------------------------------------------------");
        objeto3.setBounds(new Rectangle(12, 50, 300, 13));
        this.getContentPane().add(objeto3, null);
        JButtonIncluir = new JButton("Incluir");
        JButtonIncluir.setBounds(new Rectangle(219, 14, 90, 24));
        this.getContentPane().add(JButtonIncluir, null);
        JButtonIncluir.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Chamada a um m�todo
            	  Aluno oAluno = new Aluno(JTextFieldNome.getText()); //criando um novo objetorecebendo como parametros o texto recuperado da JTextField
                  JComboBox.addItem(oAluno.getNome());  //pega o nome do aluno e adiciona no JComBomBox
            }
        });
        LabelInclusos = new JLabel("Inclusos");
        LabelInclusos.setBounds(new Rectangle(135, 65, 57, 13));
        this.getContentPane().add(LabelInclusos, null);
        JButtonVer = new JButton("Ver");
        JButtonVer.setBounds(new Rectangle(205, 75, 108, 110));
        this.getContentPane().add(JButtonVer, null);
        JButtonVer.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Chamada a um m�todo
            	Aluno oAluno = new Aluno("d");
            	oAluno.imprimir(JComboBox.getSelectedItem());
            	
            }
        });
        JButtonApagar = new JButton("Apagar");
        JButtonApagar.setBounds(new Rectangle(57, 128, 100, 30));
        this.getContentPane().add(JButtonApagar, null);
        JButtonApagar.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Chamada a um m�todo
            	
            	 if(JComboBox.getSelectedIndex()>-1){
                     JComboBox.removeItemAt(JComboBox.getSelectedIndex());
            	 }  else {
                     JOptionPane.showMessageDialog(null,"N�o existem alunos para serem apagados!","Erro",0);
             }
            	
            }
        });
        JButtonFechar = new JButton("Fechar");
        JButtonFechar.setBounds(new Rectangle(70, 165, 73, 20));
        this.getContentPane().add(JButtonFechar, null);
        JButtonFechar.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Chamada a um m�todo
            	dispose();
            }
        });
        LabelDetalheDois = new JLabel("-------------");
        LabelDetalheDois.setBounds(new Rectangle(146, 170, 57, 13));
        this.getContentPane().add(LabelDetalheDois, null);
        LabelDetalheUm = new JLabel("--------------");
        LabelDetalheUm.setBounds(new Rectangle(9, 170, 57, 13));
        this.getContentPane().add(LabelDetalheUm, null);

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
        new AlunoTela();
    }
}
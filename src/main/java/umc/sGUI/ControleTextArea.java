package umc.sGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ControleTextArea extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JTextArea jtaTexto = new JTextArea();
	
	public ControleTextArea(){
		super("Editor de Texto");
 
        
        jtaTexto.setFont(new Font("Arial",Font.BOLD,38));
        jtaTexto.setForeground(Color.RED);
        jtaTexto.setVisible(true);
        JScrollPane scroll = new JScrollPane(jtaTexto);
        JButton btnAbrirArquivo = new JButton();
        btnAbrirArquivo.setFont(new Font("Comic Sans",Font.BOLD|Font.ITALIC,12));
        btnAbrirArquivo.setForeground(Color.blue);
        btnAbrirArquivo.setText("Abrir Arquivo");
        btnAbrirArquivo.addActionListener(this);
        
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(BorderLayout.CENTER,scroll);
        c.add(BorderLayout.SOUTH, btnAbrirArquivo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setSize(new java.awt.Dimension(600, 400));
        setLocation((screenSize.width-600)/2,(screenSize.height-400)/2);
        setVisible(true);
	}
	
	public static void main(String[] args) {
		new ControleTextArea();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(this);
		File arquivo = fc.getSelectedFile();
		try{
			Path path = Paths.get(arquivo.getAbsolutePath());
			String sStringona = new String(Files.readAllBytes(path));
			jtaTexto.setText(sStringona);
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "N�o foi poss�vel carregar este arquivo.\n        Tente novamente!","Erro ao abrir o arquivo...",0);
		}
		
	}

}

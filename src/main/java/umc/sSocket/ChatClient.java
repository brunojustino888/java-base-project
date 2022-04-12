package umc.sSocket;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChatClient extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JTextField jtf;
	PrintWriter pw;
	Socket s;
	
	public ChatClient(){
		super("Chat Client");
		
		jtf = new JTextField();
		jtf.setSize(200, 200);
		JButton botao = new JButton("Enviar");
		Container envio = new JPanel();
		
		
		envio.setLayout(new BorderLayout());
		envio.add(BorderLayout.CENTER,jtf);
		envio.add(BorderLayout.SOUTH, botao);
		
		
		configurarRede();
		
		botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
    	        
            	pw.println(jtf.getText());
            	pw.flush();
            	jtf.setText("");
            	jtf.requestFocus();
 
         }
     });
		
		
		getContentPane().add(BorderLayout.SOUTH,envio);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ChatClient();

	}

	private void configurarRede(){
		try {
			s = new Socket ("192.168.0.11", 7056);
			pw = new PrintWriter(s.getOutputStream());
			
		} catch (UnknownHostException e) {e.printStackTrace();} catch (IOException e) {e.printStackTrace();}
		
	
	}
	
	
}

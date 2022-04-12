package umc.sSocket;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ThreadChatClient extends JFrame{

	private static final long serialVersionUID = 1L;
	JTextField jtf;
	PrintWriter pw;
	Socket s;
	JTextArea jta;
	Scanner escutador;
	
	public ThreadChatClient(){
		super("Chat Client");
		
		jtf = new JTextField();
		jtf.setSize(200, 200);
		JButton botao = new JButton("Enviar");
		Container envio = new JPanel();
		
		jta= new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		
		getContentPane().add(BorderLayout.CENTER,jsp);
		
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
		new ThreadChatClient();

	}

	private void configurarRede(){
		try {
			s = new Socket ("localhost", 7056);
			pw = new PrintWriter(s.getOutputStream());
			escutador = new Scanner(s.getInputStream());
			new Thread(new EscutaDoServidor()).start();
		} catch (UnknownHostException e) {e.printStackTrace();} catch (IOException e) {e.printStackTrace();}
	}
	
	private class EscutaDoServidor implements Runnable{

		@Override
		public void run() {
			String texto;
			while((texto = escutador.nextLine())!=null){
				jta.append(texto);
			}
			
		}
		
	}
	
}

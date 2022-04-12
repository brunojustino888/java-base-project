package umc.musica.outro;

import java.awt.EventQueue;  
import java.awt.FlowLayout;  
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
  
public class MyFrame extends JFrame {  

	private static final long serialVersionUID = 1L;

	// Local onde atualizaremos a hora  
    private JLabel lblHora;  
  
    // Formatador da hora  
    private static final DateFormat FORMATO = new SimpleDateFormat("HH:mm:ss");  
  
    public MyFrame() {  
        // Constru�mos nosso frame  
        super("Exemplo");  
        setLayout(new FlowLayout());  
        getContentPane().add(getLblHora());  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(200, 75);  
        setVisible(true);  
  
        // Iniciamos a thread do rel�gio. Tornei uma deamon thread para que seja  
        // automaticamente finalizada caso a aplica��o feche.  
        Thread clockThread = new Thread(new ClockRunnable(), "Clock thread");  
        clockThread.setDaemon(true);  
        clockThread.start();  
    }  
  
    private JLabel getLblHora() {  
        if (lblHora == null) {  
            lblHora = new JLabel();  
        }  
        return lblHora;  
    }  
  
    /** 
     * M�todo para atualizar a hora no formul�rio. N�o � thread-safe, portanto, 
     * se o utilizado fora da thread da AWT, deve-se utilizar um dos comandos da 
     * EventQueue (invokeLater ou invokeAndWait). 
     */  
    public void setHora(Date date) {  
        getLblHora().setText(FORMATO.format(date));  
    }  
  
    /** 
     * Runnable que cont�m o c�digo que atuar� na nossa thread. Basicamente, ele 
     * chama o m�todo setHora de segundo em segundo, passando a data atual. 
     */  
    private class ClockRunnable implements Runnable {  
        public void run() {  
            try {  
                while (true) {  
                    // Aqui chamamos o setHora atrav�s da EventQueue da AWT.  
                    // Conforme dito, isso garante Thread safety para o Swing.  
                    EventQueue.invokeLater(new Runnable() {  
                        public void run() {  
                            // S� podemos chamar setHora diretamente dessa  
                            // forma, pois esse Runnable � uma InnerClass n�o  
                            // est�tica.  
                            setHora(new Date());  
                        }  
                    });  
                    // Fazemos nossa thread dormir por um segundo, liberando o  
                    // processador para outras threads processarem.  
                    Thread.sleep(1000);  
                }  
            }  
            catch (InterruptedException e) {  
            }  
        }  
    }  
  
    public static void main(String args[]) {  
        new MyFrame();  
    }  
}  
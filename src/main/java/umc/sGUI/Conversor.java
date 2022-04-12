package umc.sGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class Conversor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnConverter;
	private JPanel panel;
	private JLabel lblFahrenheit;
	private JLabel lblClcius;
	private JTextField jtfGraus;
	private JTextField jtfResultado;


	public static void main(String[] args) {

		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		    	System.out.println(info.getName());
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }else{
		        	UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		        }
		    }
		} catch (Exception e) {	}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Conversor() {
		super("Conversor � de Fahrenheit para � Celcius");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 171);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		btnConverter = new JButton("Converter");
		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double fahrenheit = Double.parseDouble(jtfGraus.getText());
				double celsius = (fahrenheit -32) / 1.8;
				jtfResultado.setText(String.valueOf(celsius));
			}
		});
		btnConverter.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 26));
		btnConverter.setIcon(new ImageIcon(Conversor.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		contentPane.add(btnConverter, BorderLayout.SOUTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 5, 5));
		
		lblFahrenheit = new JLabel("Fahrenheit:");
		lblFahrenheit.setHorizontalAlignment(SwingConstants.CENTER);
		lblFahrenheit.setFont(new Font("Rockwell", Font.BOLD, 26));
		panel.add(lblFahrenheit);
		
		jtfGraus = new JTextField();
		jtfGraus.setHorizontalAlignment(SwingConstants.CENTER);
		jtfGraus.setFont(new Font("Rockwell Condensed", Font.PLAIN, 26));
		panel.add(jtfGraus);
		jtfGraus.setColumns(10);
		
		lblClcius = new JLabel("Celcius:");
		lblClcius.setHorizontalAlignment(SwingConstants.CENTER);
		lblClcius.setFont(new Font("Rockwell", Font.BOLD, 26));
		panel.add(lblClcius);
		
		jtfResultado = new JTextField();
		jtfResultado.setHorizontalAlignment(SwingConstants.CENTER);
		jtfResultado.setFont(new Font("Rockwell Condensed", Font.PLAIN, 26));
		panel.add(jtfResultado);
		jtfResultado.setColumns(10);
	}

}

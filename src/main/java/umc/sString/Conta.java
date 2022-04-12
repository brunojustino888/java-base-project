package umc.sString;

import javax.swing.JOptionPane;

public class Conta {

	private String cliente;
	private double saldo;
	
	public Conta(String c, double s){
		cliente =c;
		saldo = s;
	}
	
	void exibeSaldo() {
		System.out.println(saldo);
	}
	
	public String getCliente(){
		return cliente;
	}
	
	public double getSaldo(){
		return saldo;
	}
	
	void saque() {
		String s = JOptionPane.showInputDialog(null,"Digite o valor que deseja sacar","Saque",2);
		double ss = Double.parseDouble(s);
		JOptionPane.showMessageDialog(null, saldo - ss,"Saldo Atual",2);
	}
	
	void deposito() {
		String d = JOptionPane.showInputDialog(null,"Digite o valor que deseja depositar","Dep�sito",2);
		double dd = Double.parseDouble(d);
		JOptionPane.showMessageDialog(null, saldo+dd,"Saldo Atual",2);
	}

}

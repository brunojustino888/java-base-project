package umc.primeirosemestre;

import javax.swing.JOptionPane;

public class Conta {

	String cliente;
	double saldo;
	
	void exibeSaldo() {
		System.out.println(saldo);
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

package umc.sCRUD;

import java.util.Random;

public class Conta {

	int numero;
	String cliente;
	double saldo;
	
	public Conta(){
		numero = new Random().nextInt(99);
		cliente = "John"+new Random().nextInt(99);
		saldo = 2600.00+new Random().nextInt(99);
	}
	
	public Conta(int number, String client, double rs){
		this.numero = number;
		this.cliente = client;
		this.saldo= rs;
	}
	
}
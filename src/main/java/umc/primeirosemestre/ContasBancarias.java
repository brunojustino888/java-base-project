package umc.primeirosemestre;

public class ContasBancarias {

	String cliente;
	double saldo;
	
	void exibir() {
	System.out.println(saldo);
	}

	void sacar(double valors){
		saldo -= valors;
	}
	
	void deposita(double valord){
		saldo += valord;
	}
	
	void transfere(ContasBancarias destino ,double valort){
		this.sacar(valort);
		destino.deposita(valort);
	}
}
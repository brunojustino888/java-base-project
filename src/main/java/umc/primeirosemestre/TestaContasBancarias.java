package umc.primeirosemestre;


public class TestaContasBancarias {

	public static void main (String[] args) {
		
		ContasBancarias bradesco = new ContasBancarias();
		bradesco.cliente = "John";
		bradesco.saldo = 800.00;
		bradesco.sacar(100);
		bradesco.exibir();
		
		ContasBancarias destino = new ContasBancarias();
		destino.cliente = "Bruno";
		destino.saldo = 900.00;
		bradesco.transfere(destino, 100);
		bradesco.exibir();
		destino.exibir();
	}
}

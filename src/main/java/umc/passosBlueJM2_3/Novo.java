package umc.passosBlueJM2_3;

public class Novo extends Imovel{

	private double valorAdicional;
	
	//M�todo de acesso do valor adicional.
	public double getValorAdicional(){
		return (valorAdicional+this.getPreco());
	}

	//M�todo para mostrar o valor adicional do im�vel novo.
	public void mostrarValor(){
		System.out.println("O valor do im�vel novo (com adicional incluso � de: R$)"+(valorAdicional+this.getPreco()));
	}
	
}

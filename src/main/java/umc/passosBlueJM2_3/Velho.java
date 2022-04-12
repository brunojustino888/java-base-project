package umc.passosBlueJM2_3;

public class Velho extends Imovel{
	
	private double desconto;
	
	//M�todo de acesso do desconto.
	public double getDesconto(){
		return (this.getPreco()-desconto);
	}

	//M�todo para mostrar o valor do desconto do im�vel novo.
	public void mostrarValor(){
		System.out.println("O valor do im�vel velho (com desconto incluso � de: R$)"+(this.getPreco()-desconto));
	}
	

}

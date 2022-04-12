package umc.passosBlueJ;

import javax.swing.JOptionPane;

public class CompararTest {

	public static void main(String[] args) {
		Comparar s = new Comparar();
		int opcao;
		
		double d1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o primeiro n�mero - Exemplo: 2.5"));
		double d2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o segundo n�mero - Exemplo: 2.5"));
		double d3 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o terceiro n�mero - Exemplo: 2.5"));
		opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o que voc� vai querer:\n1-Maior N�mero\n2-Menor N�mero \n3-Media dos N�meros"));
		
		if (opcao ==1){
		System.out.println(s.maior(d1,d2,d3));
		}

		if (opcao ==2){
		System.out.println(s.menor(d1,d2,d3));
		}
		
		if (opcao ==3){
		System.out.println(s.media(d1,d2,d3));
		}
		
		
		
}
}

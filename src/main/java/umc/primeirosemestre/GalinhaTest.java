package umc.primeirosemestre;

import javax.swing.JOptionPane;

public class GalinhaTest {

	public static void main(String[] args) {
	

		Galinha g1 = new Galinha();
		g1.botar().botar().botar().botar().botar();
		
		Galinha g2 = new Galinha();
		g2.botar();
		g2.botar();
		
		System.out.println("A galinha G1 botou "+g1.ovos+" ovos.");
		System.out.println("A galinha g2 botou "+g2.ovos+" ovos.");
		
		int resposta = Galinha.media(2);
		JOptionPane.showMessageDialog(null,"A m�dia de ovos perante a quantidade passada como parametro � de "+resposta+" ovo(s) por galinha.","X-X M�dia de Ovos X-X",1);
		
	}

}

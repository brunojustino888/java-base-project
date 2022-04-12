package interfaceXmlEnergiza;
import javax.swing.UIManager;

/*	
*  Essa classe foi desenvolvida como a principal do Projeto.
*/

public class Main {

	public static void main(String[] args) {
		//Com a linha abaixo, ocorre a mudan�a do look and feel do JAVA.
		try {UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");}catch(Exception e){} 
		new TelaLogin();
	}

}

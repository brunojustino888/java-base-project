package applicationgi;

import javax.swing.UIManager;

/** Main:
 * Essa � a primeira classe que � chamada na execu��o do projeto. 
 * Serve apenas para modificar o look and feel padr�o da JVM.
 * @author Bruno Alves Justino
 * @date � Mar�o - 2014
 */


public class Main {

	public static void main(String[] args) {
		try {UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");}catch(Exception e){} 
		new TelaStart();
	}

}

package umc.sai;
import javax.swing.UIManager;

import umc.sai.controller.ControllerConexaoDB;
import umc.sai.controller.ControllerMusica;
import umc.sai.view.AmbienteAplicacao;
import umc.sai.view.TelaLogin;
import umc.sai.view.ViewTelaInicio;

/** <h1>ControllerMain</h1>
 * <h5><strong>Projeto: SAI</strong> - Sistema de Aprendizagem Infantil </h5>
 * <p>Essa classe � primeira � ser chamada pela aplica��o.</p> 
 * <p>Ao iniciar, verifica-se a possibilidade de conex�o com uma base de dados.</p> 
 * <p>Caso aplica��o consiga estabelecer uma conex�o com uma base de dados, dever� ser instanciada a classe TelaLogin com o par�metro true.</p> 
 * <p>Caso contr�rio, a classe TelaLogin ser� instanciada com o par�mentro false.</p>  
 * @author Bruno Alves Justino
 * @date � Ago - 2014
 * @version 8.0
 * @see TelaLogin
 */
public class ControllerMain {

	/**
	 * <p>O m�todo main do projeto deve fazer uma tentativa de conex�o com a base de dados para verificar o par�metro que ser� passado ao instanciar a classe.<p>
	 * <p>Caso aplica��o consiga estabelecer uma conex�o com uma base de dados, dever� ser instanciada a classe TelaLogin com o par�metro true.</p> 
	 * <p>Caso contr�rio, a classe TelaLogin ser� instanciada com o par�mentro false.</p>  
	 * <p>Esse par�metro dever� possibilitar uma nova janela do sistema, de realizar a altera��o das configura��es pertinentes ao banco de dados.</p> 
	 */

    public static void main(String args[]) {
    	
    	
    	ControllerMusica musica = null;
    	/**<p>Look and Feel "Liquid" do Java. Muda-se o look and feel padr�o da JVM para dar um Layout decorado para a aplica��o.</p>*/
    	try {UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");}catch(Exception e){} 
    	
    	/**<p>Inst�ncia da classe Conexao para verificar uma poss�vel conex�o com a base SQL</p>*/
    	ControllerConexaoDB c = new ControllerConexaoDB();
    	
    	
     
    	//Tocando a m�sica fazendo uso do Objeto Musica.
       try {	
            
   			musica = new ControllerMusica("C:\\SAI\\audio\\music\\Jesters of the Moon.mp3");
   			musica.play();
   	    }catch( Exception e) {e.printStackTrace();}

		try {	
            
   			ControllerMusica musica2 = new ControllerMusica("C:\\SAI\\audio\\voice\\inicio.mp3");
   			musica2.play();
   	    }catch( Exception e2) {e2.printStackTrace();}


    	ViewTelaInicio inicio = new ViewTelaInicio();
    	inicio.setVisible(true);
    	try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {e.printStackTrace();}
    	inicio.setVisible(false); 
		 

    	/**<p>O m�todo AbrirConexao() da classe Conexao est� sendo usado para verificar se � poss�vel ter acesso � base de dados.</p>*/
    	/**<p>Caso aplica��o consiga estabelecer uma conex�o com uma base de dados, dever� ser instanciada a classe TelaLogin com o par�metro true.</p>*/
    	if(c.testarConexao()){
    		System.out.println("Base de Dados Acess�vel");
    		new TelaLogin(musica);
    	}else{
    		System.err.println("Base de Dados n�o Acess�vel");
    		new AmbienteAplicacao(false, musica);
    	}
    }
}

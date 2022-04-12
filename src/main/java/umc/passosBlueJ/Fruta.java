package umc.passosBlueJ;

import javax.swing.*;

	public class Fruta{                   
	 
		private String sFruta;
		//m�todo construtor que recebe com par�metro o nome e a massa da fruta
	public Fruta(String f, double m) { 
        sFruta = f;
    }

	//m�todo construtor que recebe com par�metro o nome da fruta
	public Fruta (String f)    {
        sFruta = f;
    }
    
	//m�todo get que retorna o nome da fruta
    public String getFruta()  {
        return sFruta;
    }
    
    //m�todo que recebe com par�metro o um Objeto
    public void imprimirFruta(Object o)    {
           sFruta = o.toString();  //fun��o que vai capturar o valor do objeto e converte-lo em string
           JOptionPane.showMessageDialog(null,"A fruta eh="+sFruta,"msg",0);
    }
    
}


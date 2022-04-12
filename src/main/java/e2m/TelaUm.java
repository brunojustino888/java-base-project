package e2m;


import java.awt.Desktop;
import java.net.URI;

public class TelaUm {


	String ativo;
	String descricao;
	double ultimo;
	double var;
	double compra;
	double venda;
	double fechamentoant;
	double c,v;
	String comprar,vender;


	public static void main (String[] args) {
	
	
	
	Desktop d = Desktop.getDesktop();   
	try{   
	    d.browse(new URI("http://www.google.com"));   
	}   
	catch(Exception e){   
	    e.printStackTrace();   
	} 
	
}

}
package umc.sai.controller;
import umc.sai.model.Usuario;
import umc.sai.view.TelaAvaliacaoAlfabeto;
import umc.sai.view.TelaAvaliacaoVogais;

public class ControllerAvaliacao {
	
	private Usuario userx;
	
	public ControllerAvaliacao(int i,Usuario user){
		userx=user;
		if (i==1){
		    new TelaAvaliacaoAlfabeto(userx);	
		}else{
			new TelaAvaliacaoVogais(userx);
		}
	}
	
}
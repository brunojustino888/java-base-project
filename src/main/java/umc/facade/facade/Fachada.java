package umc.facade.facade;

import umc.facade.model.Guys;
import umc.facade.model.Umc;
import umc.facade.model.Work;

public class Fachada {

	public Fachada(){
		executarAtividades();
	}
	
	public void executarAtividades(){
		Work trabalho = new Work();
		Guys amigos = new Guys();
		Umc facul   = new Umc();
		trabalho.enrolar();
		trabalho.trabalhar();
		amigos.beber();
		amigos.conversar();
		facul.realizarAvaliacao();
		facul.aula();
	}
		
	public static void main(String[] args) {
		new Fachada();
	}

}

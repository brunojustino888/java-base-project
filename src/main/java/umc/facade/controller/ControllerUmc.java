package umc.facade.controller;

import umc.facade.model.Umc;

public class ControllerUmc {

	public void executarAtividades(){
	 Umc faculdade = new Umc();	
	 faculdade.aula();
	 faculdade.realizarAvaliacao();
	}
	
}
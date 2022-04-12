/*
 * Programa que usa as classes; Carro,Motor,CarroTest
 */
package umc.primeirosemestre;

/**
 * @author Bruno Alves Justino
 * Date: 28/10/2012
 */
public class Carro {

	String sModelo;
	int iVelocidadeMaxima;
        Motor oMotor;

	public Carro() {
	}
	
	public Carro(String modelo, int velocidade) {
		sModelo = modelo;
		iVelocidadeMaxima = velocidade;	
	}
}
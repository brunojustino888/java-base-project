package umc.passosBlueJ;

/* desenvolva uma classe denominada Comparar. esta classe dever� ter tr�s atributos do tipo double
 * esta classe dever� ter um metodo denominado maior, ele dever� retornar o maior valor entre os tres.
 * dever� ter o metodo media tambem, ele vai calcular a mesdia aritmetica entre os tres valores
 * dever� ter o metodo menor tambem, que retornar� o menor dos valores
 * 
 */


public class Comparar {

	public double d1;
	public double d2;
	public double d3;
	
	
	
	public double maior(double um ,double dois, double tres){
		
		double omaior;
		
			if (um>dois){
			omaior = um;
			} else {
			omaior = dois;
			}
		
	 	if(omaior>tres) {

			} else {
				omaior = tres;
			}
	
		return omaior;
		
	}
	
	public double media(double um,double dois, double tres){
		
		double smedia = (um+dois+tres)/3;
		return smedia;
				
	}
	
	public double menor(double um,double dois, double tres) {
		double omenor; 
		if(um<dois){
		omenor = um; 
		} else {
			omenor = dois;
		}
		if (omenor<tres){

		} else {
			omenor = tres;
		}
		
		return omenor;
	}
	
	
}

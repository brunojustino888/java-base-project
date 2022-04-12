package umc.passosBlueJ;

public class Continente {

	String sNomeContinente;
	Pais paises[];
	double dArea;
	
	
		
public void construirContinente(){
	
  paises = new Pais[13];
  
  for(int i =0;i<13;i++){
	  paises[i] = new Pais (); 
  }
	paises[0].setNome("Brasil");
	paises[1].setNome("Argentina");
	paises[2].setNome("Venezuela");
	paises[3].setNome("Guiana Francesa");
	paises[4].setNome("Paraguai");
	paises[5].setNome("Bol�via");
	paises[6].setNome("Uruguai");
	paises[7].setNome("Peru");
	paises[8].setNome("Col�mbia");
	paises[9].setNome("Suriname");
	paises[10].setNome("Equador");
	paises[11].setNome("Guiana");
	paises[12].setNome("Chile");
	
	paises[0].setDimensao(50.098);
	paises[1].setDimensao(50.098);
	paises[2].setDimensao(50.098);
	paises[3].setDimensao(50.098);
	paises[4].setDimensao(50.098);
	paises[5].setDimensao(50.098);
	paises[6].setDimensao(50.098);
	paises[7].setDimensao(50.098);
	paises[8].setDimensao(50.098);
	paises[9].setDimensao(50.098);
	paises[10].setDimensao(50.098);
	paises[11].setDimensao(50.098);
	paises[12].setDimensao(50.098);
	  
}
		
 public double calcularArea(){
	 for (int i = 0 ; i<13;i++){
	 dArea = dArea + paises[i].getDimensao();
	 }
	 return dArea;
 }
	
	
	
}

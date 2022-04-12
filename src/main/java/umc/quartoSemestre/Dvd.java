package umc.quartoSemestre;
 
public class Dvd extends Midia{
   
	int numeroFaixas;
	
	
	
	public Dvd(){
		numeroFaixas = 12;
	}
	
	public Dvd(int c, double p, String n, int f){
		numeroFaixas = f;
		super.codigo = c;
		super.nome = n;
		super.preco = p;
			
		}
			
	
	
    public void setFaixas(int f)  {
    	
    	numeroFaixas = f;
    
    }

   
 
}
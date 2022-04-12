package umc.quartoSemestre;
 
public class Cd extends Midia{
   
	int numeroMusicas;
	
	
	
	public Cd(){
		numeroMusicas = 12;
	}
	
	public Cd(int c, double p, String n, int m){
		numeroMusicas = m;
		super.codigo = c;
		super.nome = n;
		super.preco = p;
			
		}
			
	
	
    public void setMusicas(int m)  {
    	
    	numeroMusicas = m;
    
    }
    
}
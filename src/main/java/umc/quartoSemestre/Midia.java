package umc.quartoSemestre;

public abstract class Midia {
    
    int codigo;
    double preco; 
    String nome;
    
    public Midia()    {
        
    }
    
    public Midia(int c, double p, String n) {
        
        codigo = c;
        preco = p;
        nome = n;
        
    }
    
    public String getDetalhes(){
     
        return nome;
        
    }
    
    public void setDados(int c , double p , String n){
     
        codigo = c;
        preco = p;
        nome = n;
        
    }
    
    public void printDados(){
     
        System.out.println("Codigo = "+codigo);
        System.out.println("Preco = "+preco);
        System.out.println("Nome = "+nome);
        
    }

    
  }

package umc.passosBlueJ;


public class TestCachorro { 
	
		
		
        public static void main (String[] args) {
         
        	Canil john = new Canil(5);   // aqui est� criado um canil chamado john
        	
        	john.matilha[2]= new Cachorro(); //cada posicao do array precisa ser instanciada
        	
        	john.matilha[2].raca = "Fera"; //atribuindo um valor para o segundo cachorro do canil john
        	
        	System.out.println(john.matilha[2].raca);
        	
        	john.informacoes(); //o canil chama seu m�todo
        	
        	
        	
            Cachorro pudow = new Cachorro();
            
            pudow.tamanho = 12;
            pudow.raca = "PUDOW";
            pudow.latir();
        
            
          
        }
    }
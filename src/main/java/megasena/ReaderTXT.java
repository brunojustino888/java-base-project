package megasena;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReaderTXT {

	private ArrayList<String> sequencias;
	
	//Esse m�todo � respons�vel por ler o txt de resultados da megasena e verificar se a seuq�ncia j� foi sorteada antes.
	//O par�metro deste m�todo precisa ser 55-15-65-85-74-47
	public boolean isResultadoJaSaiu(String resultado){
    	boolean existe = false;
    	String linha = "";
    	FileReader frLeitor;
    	BufferedReader bfLeitor;
    	try {
				frLeitor = new FileReader("X:\\Workspace\\John888\\src\\Resultados.txt");
				bfLeitor = new BufferedReader(frLeitor);
				sequencias = new ArrayList<String>();
					
				while((linha = bfLeitor.readLine()) != null) {
					sequencias.add(linha);
					if(linha.toString().equals(resultado)){
						//System.err.println("Sequ�ncia j� Sorteada = "+linha.toString());
						existe =true;
					}else{
						
						//System.out.println("Sequ�ncia ainda n�o Sorteada = "+resultado);
					}

				}

				bfLeitor.close();
				frLeitor.close();
				
    	}catch(Exception eef){
    			eef.printStackTrace();
    			return false;
    		}
    	return existe;
    }
	

	
}

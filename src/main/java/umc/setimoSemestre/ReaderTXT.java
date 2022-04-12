package umc.setimoSemestre;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReaderTXT {

	private ArrayList<String> linhas;
	

	public boolean isLinhaExiste(String linhaprocurada){
    	boolean existe = false;
    	String linha = "";
    	FileReader frLeitor;
    	BufferedReader bfLeitor;
    	try {
				frLeitor = new FileReader("X:\\Users.txt");
				bfLeitor = new BufferedReader(frLeitor);
				linhas = new ArrayList<String>();
					
				while((linha = bfLeitor.readLine()) != null) {
					linhas.add(linha);
					if(linha.toString().equals(linhaprocurada)){
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

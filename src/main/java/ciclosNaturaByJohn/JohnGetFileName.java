 /**
 * Esta aplica��o faz a leitura dos nomes dos arquivos na pasta
 * que � especificada em tempo de execu��o, formatando para promociclo.txt
 * @author: Bruno Justino												
 * @date: 03/07/2013.													
 */
package ciclosNaturaByJohn;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.io.IOException;

  public class JohnGetFileName  {

  public static void main(String[] args){
  Writer writer = null;

  try {
      
        //Vari�vel "file" recebe a pasta onde est�o as mensagens do ciclo da natura.
		File file = new File("d:\\temp");
		String[] fileName = file.list();
		//Vari�vel "fileout" escreve o arquivo de sa�da formatado.(promociclo.txt)
		File fileout = new File("d:\\temp\\promociclo11.rtf");
		writer = new BufferedWriter(new FileWriter(fileout));
		int i = 0;
		//Laco faz a leitura de todo o vetor string at� o fim.
		while (i!=fileName.length){
	  		writer.write("keyValues['" + fileName[i].substring(0,6) + "']='" + fileName[i] + "';\n");
	  		System.out.println ("keyValues['" + fileName[i].substring(0,6) + "']='" + fileName[i] + "';\n");
	  		i++;
	  		}
  	}
  catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 }
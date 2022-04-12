package application4paradox;
//Importa os pacotes e as classes necess�rias.
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * A classe m�sica foi criada com a inten��o de permitir a execu��o de um determinado som, �udio ou m�sica na aplica��o.
 * Essa classe possui um objeto Thread para garantir a execu��o simult�nea do �udio e das outras atividades da classe. 
 * @author Bruno Alves Justino
 */


public class Musica {

		private boolean isPlay;                              //Usada para saber se um determinado �udio est� tocando.
		private String sCaminho;							 //Vari�vel usada para saber onde est� o arquivo mp3.
		private File musicFile;								 //File servir� para armazenar o arquivo mp3. 
		private SourceDataLine sdLinhaFile;					 //Linha que ser� usada para escrever o arquivo mp3.
		private AudioInputStream aIOStream;					 //Manipula inputs de �udio na JVM.
		private Thread tAux;								 //Um objeto Thread auxiliar manter� as outras atividades da classe "rodando" mesmo executando o arquivo mp3..

		
	/**O construtor lan�a as "exceptions", os arquivos de �udio ser�o "buscados" na pasta da aplica��o. Isso garante que n�o ocorrer� nenhuma exception em tempo de execu��o.*/ 	
	public Musica(String path) throws UnsupportedAudioFileException, IOException,LineUnavailableException {

		
		this.sCaminho = path;												//O caminho do �udio � declarado.
		musicFile = new File(sCaminho);										//A JVM "cria" o arquivo mp3 em mem�ria.
		buildMusic();														//Esse m�todo serve para construir a m�sica carregada.
		tAux = new Thread(new Runnable() {public void run() {}});			//Nesse ponto, instanciamos a thread auxiliar, declaramos ela como Runnable e implementamos o m�todo run da classe Runnable.
	
		
	}

	
	/**M�todo usado para trocar a m�sica da classe.*/
	public void setMusica(String musica) {									//Recebe como par�metro o caminho da m�sica que ser� tocada.
		this.sCaminho = musica;												//Coloca o caminho na vari�vel global da classe.
		musicFile = new File(this.sCaminho);								// cria um arquivo atrav�s do novo caminho e atribui � uma vari�vel global da classe. 
	}

	
	/**M�todo usado para "construir" o arquvio carregado*/
	private void buildMusic() throws UnsupportedAudioFileException, IOException,LineUnavailableException {
		AudioInputStream ASin = AudioSystem.getAudioInputStream(musicFile); 	//O arquivo � carregado em um objeto para a manipula��o do �udio.
		AudioInputStream ASaux = null;											//Temos um objeto auxiliar para armazenar o arquivo carregado e a decodifica��o que ser� usada pela JVM
		
		if (ASin != null) {														//Verificamos se o arquivo carregado foi mesmo carregado.
			AudioFormat format = ASin.getFormat();								//Criamos um objeto para formato de �udio. Ele � respons�vel por armazenar o formato do audio do arquivo carregado. 
			/**A linha abaixo prepara o formato do arquivo carregado para que ele possa ser transformado na linha que ser� interpretada posteriormente**/
			AudioFormat formatoPreparado = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,format.getSampleRate(),16,format.getChannels(),format.getChannels()*2, format.getSampleRate(),false);
			ASaux = AudioSystem.getAudioInputStream(formatoPreparado, ASin);    //Constru�do o Stream da M�sica que ser� tocada...
			sdLinhaFile = getLine(formatoPreparado);                            //Vamos armazenar o formato da m�sica preparada para us�-la posteriormente.
			aIOStream = ASaux;
		}
	}
	
	
		
	/** Usado para tocar ou continuar uma determinada m�sica.
	 * Faremos usos de uma thread auxiliar para manter o programa rodando enquanto toca a m�sica.*/
	public void play() throws IOException, LineUnavailableException {
		start();                            //Esse m�todo � chamado para acionar a flag isPlay 
		tAux.interrupt();					
		tAux = new Thread(new Runnable() {
			public void run() {
				rawplay();                 //Esse m�todo que ser� chamado pela thread respons�vel por tocar a m�sica.
			}
		});
		tAux.start();
	}
	
	/** Inicia a SourceDataLine para ser executada. */
	private void start() {
		sdLinhaFile.start();
		isPlay = true;
	}

	/**
	 * Play same part of the music
	 */
	private void play(byte[] data) throws IOException {
		try {
			// Read a stream
			int length = aIOStream.read(data, 0, data.length);
			// Play the stream
			sdLinhaFile.write(data, 0, length);
		} catch (IOException e) {
			throw e;
		}
	}



	/**
	 * The engine of the player
	 */
	private void rawplay() {
		byte[] data = new byte[4096];
		try {
			while (isPlay){
				play(data);
			}
		} catch (Exception e) {
			System.out.println("Music end");
			isPlay = false;
			close();
			System.out.println(sCaminho);
		}
	}
	
	
	public boolean getIsPlay(){
		return isPlay;
	}

	/**
	 * Close all I/O
	 */
	public void close() {
		tAux.interrupt();
		sdLinhaFile.drain();
		sdLinhaFile.stop();
		sdLinhaFile.close();
		try {
			aIOStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** M�todo usado para parar a execu��o do arquivo mp3. Ele interrompe o estado da execu��o e permite a reprodu��o do mesmo ponto parado chamando o m�todo continuaExecucao. */
	public void stop() {
		tAux.interrupt();
		sdLinhaFile.stop();
		sdLinhaFile.drain();
		isPlay = false;
	}

	/**
	 * If the SourceDataLine is already in stop continue playing.
	 */
	public void continuaExecucao() {
		sdLinhaFile.start();
		isPlay = true;
		try {
			play();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get the SourceDataLine for Read and Write the music
	 * 
	 * @param audioFormat
	 *            The music as Stream
	 */
	private SourceDataLine getLine(AudioFormat audioFormat)	throws LineUnavailableException {
		SourceDataLine res = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class,
				audioFormat);
		res = (SourceDataLine) AudioSystem.getLine(info);
		res.open(audioFormat);
		return res;
	}
	



	
}

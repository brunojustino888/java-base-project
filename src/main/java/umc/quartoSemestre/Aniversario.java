package umc.quartoSemestre;
public class Aniversario extends CartaoWeb {

	public Aniversario(String d) {
		super.destinatario = d;
		showMessage();
		
		}	
			
		public void showMessage() {
			System.out.println("Feliz Anivers�rio "+ super.destinatario + " !");
		}

	}


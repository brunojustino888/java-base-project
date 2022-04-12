package umc.quartoSemestre;
public class Natal extends CartaoWeb {

	public Natal(String d) {
		super.destinatario = d;
		showMessage();
		
		}	
			
		public void showMessage() {
			System.out.println("Feliz Natal "+ super.destinatario + " !");
		}

	}


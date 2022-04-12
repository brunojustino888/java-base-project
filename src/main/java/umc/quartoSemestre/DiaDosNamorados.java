package umc.quartoSemestre;

public class DiaDosNamorados extends CartaoWeb {

	public DiaDosNamorados(String d) {
		super.destinatario = d;
		showMessage();
		
		}	
			
		public void showMessage() {
			System.out.println("Feliz dia dos Namorados!"+ super.destinatario);
		}

	}


	


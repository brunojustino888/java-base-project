package umc.primeirosemestre;

public class Galinha {

	public static int ovosDaGranja;
	public int ovos;

	
	public Galinha botar(){   //esse m�todo est� retornando o objeto galinha para a outra classe chamar um m�todo na mesma linha
	this.ovos++;
	Galinha.ovosDaGranja++;
	return this;
	}

	
	public static int media(int ngalinhas){
		return ovosDaGranja / ngalinhas;
		}
	
}

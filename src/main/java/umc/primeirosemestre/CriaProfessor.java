package umc.primeirosemestre;



public class CriaProfessor {


	public static void main(String[] args) {
		
		String horario = "22:40"; 
		
		Professores passos = new Professores();
		passos.nome = "Ricardo Passos";
		passos.apelido = "ZACARIAS";
		passos.idade = 89;
		passos.ensinar();
		
		if( (passos.apelido =="ZACARIAS") && (horario == "22:40") ) {
		passos.desmunhecar();
		}
		
		passos.dormir();
	}
}

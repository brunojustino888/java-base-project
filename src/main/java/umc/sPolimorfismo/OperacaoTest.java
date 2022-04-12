package umc.sPolimorfismo;

public class OperacaoTest {

	
	
	public static void calcule(OperacaoMatematica o, double x, double y ){
		System.out.println(o.calcular(x,y));
	}

	
	
	public static void main (String[] args) {
		
		calcule(new Soma(),8,8);
		calcule(new Multiplica(),8.8 ,8);
		
		
	}
	
	
	
}

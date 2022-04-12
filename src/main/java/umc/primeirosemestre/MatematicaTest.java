package umc.primeirosemestre;

public class MatematicaTest {

	public static void main(String[] args) {
		
		Matematica testeum = new Matematica();
		int ma = testeum.maior(8,2);
		System.out.println(ma);
		
		Matematica testedois = new Matematica();
		double so = testedois.soma(12,38);
		System.out.println(so);
		
		double gf = testedois.soma2(2.5,4.4,5.1,4,8,4,8,7,2,7,8,7);
		System.out.println(gf);
	}
	
}

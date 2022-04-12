package umc.primeirosemestre;
public class Encaixotar {

	public static void main(String[] args) {
	
		Integer x = new Integer(555);
		int a = x.intValue();
		a++;
		x = new Integer(a);
		System.out.println(x);
	
	}

}
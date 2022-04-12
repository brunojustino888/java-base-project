package umc.tiposGenericos;

public class Genericos {
	
	Object elemento;
	
	public void setElemento(Object elemento){
		this.elemento = elemento;
	}
	
	public Object getElemento(){
		return this.elemento;
	}
	
	public static void main(String args[]){
		
		Genericos g = new Genericos();
		g.setElemento("Lago Parano�");
		g.setElemento(123);
		String s = (String) g.getElemento();
		System.out.println(s);
		
		
		
	}
}

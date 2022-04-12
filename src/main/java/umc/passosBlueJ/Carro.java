package umc.passosBlueJ;


//motor,carro,officcina
public class Carro {
	
    private int iAno;
    private String sMarca,sModelo,sPlaca;
    private Motor oMotor;
    
    	public Carro() {
    	}
    
    public Carro(int pa,String pmc,String pmd, String ppl,Motor om){
        iAno    = pa;
        sMarca  = pmc;
        sModelo = pmd;
        sPlaca  = ppl;
        oMotor  = om;
    }
    
    public void imprimirCarro()
    {
        System.out.println("Ano:"+iAno+"\tMarca:"+sMarca+"\tModelo:"+sModelo+"\tPlaca:"+sPlaca);
        oMotor.imprimirMotor();

    }
    
}
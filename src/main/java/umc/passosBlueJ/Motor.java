package umc.passosBlueJ;

//motor, carro, oficina

public class Motor
{
    private int iCilindradas;
    private double dPotencia;
    private int iCilindros;
   
    public Motor() {}
    
    public Motor(int pc, double pp, int pcs)
    {
        iCilindradas = pc;
        dPotencia    = pp;
        iCilindros   = pcs;
    }
    
    public void imprimirMotor()
    {
        System.out.println("Cilindradas:"+iCilindradas+"\tPotencia:"+dPotencia+"\tCilindros:"+iCilindros);
    }
}
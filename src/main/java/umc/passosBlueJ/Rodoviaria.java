package umc.passosBlueJ;

public class Rodoviaria
{
    public static void main(String args[])
    {
        //Criar o Onibus
        Onibus oBus = new Onibus("SP","MG",890,24);
        
        for(int i=0;i<24;i++)
        {
            oBus.aViajante[i] = new Pasageiro("ZE"+i,30+i,2+i);
        }
        
        oBus.listaPassageiro();
        
       
    }
}

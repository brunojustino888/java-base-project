package umc.passosBlueJ;

public class Onibus
{
    String sOrigem, sDestino;
    int iNumero;
    Pasageiro aViajante[];
    
    public Onibus (String origem, String destino, int numero, int lotacao)
    {
        sOrigem = origem;
        sDestino = destino;
        iNumero = numero;
        aViajante = new Pasageiro[lotacao];
    }
 
    public void listaPassageiro()
    {
        System.out.println("ONIBUS:"+iNumero);
        System.out.println("ORIGEM:"+sOrigem+"\t"+"DESTINO:"+sDestino);
        for(int i=0; i<aViajante.length;i++)
        {
            System.out.println(aViajante[i].sNome+" Poltrona:"+aViajante[i].iPoltrona);
        }
    }
}

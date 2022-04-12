package umc.passosBlueJ;

//Exerc�cios 1 e 2
import javax.swing.JOptionPane;

public class Apolice {

    private String nome;
    private int idade;
    private double valor;
    
    public Apolice (String n, int i, double v){
     nome = n;
     idade = i;
     valor = v;
    }

    public void imprimir(){
        JOptionPane.showMessageDialog(null,"Nome = " + nome + "\nIdade = " + idade+"\n"+ "Valor = "+valor,"Prova do Mestre Passos",1 );
        }

    public void calcularPremio(){
     
        if((idade>=18) && (idade<=25)) {
        valor = valor * 1.20;
        }
        
        if((idade>25) && (idade<=36)) {
        valor = valor * 1.15;
        }
        
        if(idade>36)  {
        valor = valor * 1.10;
        }
        
    }
}
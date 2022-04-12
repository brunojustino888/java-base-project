package umc.primeirosemestre;
import javax.swing.JOptionPane;
import java.util.Random;

public class Dados {

public static void main (String[] args) {

String numero = JOptionPane.showInputDialog("Digite um n�mero de 1 a 6"); //Lendo o n�mero...

int variavel = Integer.parseInt(numero); //convertendo a string em n�mero...

JOptionPane.showMessageDialog(null, "O n�mero escolhido foi: " + variavel);

Random dado = new Random(); //criando o n�mero aleat�rio...
int gerado = dado.nextInt(6)+1; //0-5

JOptionPane.showMessageDialog(null, "O numero gerado pelo sistema foi: "+ gerado);

if(variavel==gerado){
JOptionPane.showMessageDialog(null,"ACERTOU");
} else{
JOptionPane.showMessageDialog(null,"ERROU");
}


}
}
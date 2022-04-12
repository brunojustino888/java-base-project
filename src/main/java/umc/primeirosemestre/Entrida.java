package umc.primeirosemestre;
import javax.swing.JOptionPane;

public class Entrida {

  public static void main (String[] args) {


   String nome = JOptionPane.showInputDialog("Digite o seu nome");
   System.out.println(nome);
   JOptionPane.showMessageDialog(null,"You be die " + nome + " !"+" "+(1+1));

}

}
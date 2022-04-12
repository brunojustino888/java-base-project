package umc.primeirosemestre;
import javax.swing.JOptionPane;
public class Caso {

public static void main (String[] args) {

char sexo = 'F';
 
 switch(sexo) {
 case 'M': System.out.println("Homem");
 case 'F': JOptionPane.showMessageDialog(null, "Mulher");
 }
}
}
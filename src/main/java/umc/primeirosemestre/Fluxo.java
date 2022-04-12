package umc.primeirosemestre;
import javax.swing.JOptionPane;
public class Fluxo {

public static void main (String[] args) {

boolean passou = true;
int idade = 11;

if(passou == true) {
 JOptionPane.showMessageDialog(null,"Contratado");
}

if (idade % 2 == 0){
JOptionPane.showMessageDialog(null,"Par");
}
else {
JOptionPane.showMessageDialog(null, "Impar");
}



}

}
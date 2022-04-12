package umc.primeirosemestre;
import javax.swing.JOptionPane;
public class IMC {

public static void main(String[] args) {

String peso = JOptionPane.showInputDialog("Qual o seu peso?");
String altu = JOptionPane.showInputDialog("Qual sua altura?");

double pesoEmQuilos = Double.parseDouble(peso);
double alturaEmMetros = Double.parseDouble(altu);
double imc = pesoEmQuilos / (alturaEmMetros*alturaEmMetros);

String msg = (imc >= 20 && imc <= 25) ? "Peso Ideal ": "Fora do Peso Ideal";

JOptionPane.showMessageDialog(null, msg);

}

}
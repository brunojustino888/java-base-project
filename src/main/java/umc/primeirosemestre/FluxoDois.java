package umc.primeirosemestre;
import javax.swing.JOptionPane;

public class FluxoDois {

public static void main(String[] args) {

String note = JOptionPane.showInputDialog("Digite a nota do aluno");
int nota = Integer.parseInt(note); 

if(nota<5) {
JOptionPane.showMessageDialog(null, "Aluno Reprovado");
} else {
JOptionPane.showMessageDialog(null, "Aluno Aprovado");
}


}

}


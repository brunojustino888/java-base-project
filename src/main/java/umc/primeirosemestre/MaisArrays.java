package umc.primeirosemestre;
import java.util.Random;
import javax.swing.JOptionPane;
public class MaisArrays {

public static void main(String[] args) {

String[] faces = {"A","1","2","3","4","5","6","7","8","9","10","J","Q","K"};
String[] nipes = {"Copas","Ouros","Espadas","Paus"};

Random ll = new Random();
int indiceFace = ll.nextInt(faces.length);
String face = faces[indiceFace];

String carta = face + " " + nipes[0];
System.out.println(carta);
JOptionPane.showMessageDialog(null,carta);

}
}
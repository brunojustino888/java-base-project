package umc.primeirosemestre;
import java.util.Arrays;
import javax.swing.JOptionPane;
public class ArraySimples{

public static void main (String[] args) {
 
 int[] impares = new int[5];
 impares[0] = 1;
 impares[1] = 3;
 impares[2] = 5;
 impares[3] = 7;
 impares[4] = 9;
 
 
 
 String[] paises = {"Brasil","R�ssia","Jap�o","Venezuela"};
 System.out.println(paises[2]);
 JOptionPane.showMessageDialog(null, paises[2]);
 
 System.out.println(Arrays.toString(paises));
 int posicao = Arrays.binarySearch(paises,"Venezuela");
 JOptionPane.showMessageDialog(null, posicao); 
 
 Arrays.sort(paises, 0 , paises.length);
 JOptionPane.showMessageDialog(null,Arrays.toString(paises));
 
 Double[] valores = {12.55,13.55,14.64,25.65};
 System.out.println(valores[2].doubleValue()); 
 
}
}
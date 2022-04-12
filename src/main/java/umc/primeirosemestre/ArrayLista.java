package umc.primeirosemestre;
import javax.swing.JOptionPane;
import java.util.ArrayList;
public class ArrayLista {

public static void main (String[] args){

ArrayList<String> cores = new ArrayList<String>();
cores.add("Branco");
cores.add(0,"Vermelho");
cores.add("Amarelo");
cores.add("Azul");


String s =  "Tamanho = "  + cores.size();

System.out.println(cores.toString());
JOptionPane.showMessageDialog(null,s + cores.indexOf("Branco") +" " + cores.get(3) + " " + cores.contains("Azul") /*retorna boolean*/);
cores.remove("Vermelho");




}

}
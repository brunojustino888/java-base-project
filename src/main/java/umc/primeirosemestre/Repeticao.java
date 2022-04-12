package umc.primeirosemestre;
public class Repeticao {

public static void main (String[] args) {
String texto= "";

for(int i=0; i<3; i++) {
System.out.println(i);
texto += i + ",";
}

System.out.println(texto);

}
}
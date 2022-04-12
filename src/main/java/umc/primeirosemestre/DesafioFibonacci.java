package umc.primeirosemestre;
public class DesafioFibonacci {

public static void main (String[] args) {

int anterior = 0;
int proximo = 1;
int i = 0;
System.out.println(anterior);



while(i<10) {

System.out.println(proximo);
proximo = proximo + anterior;
anterior = proximo - anterior;
i++;

}
}
}
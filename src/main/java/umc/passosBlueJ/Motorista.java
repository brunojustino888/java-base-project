package umc.passosBlueJ;

public class Motorista {

    String snome;
    int icarteira;
    char ccategoria;
    int ipontos;

   public void dirigir() {
 
        switch (ccategoria) {
            case 'A' : System.out.println("Dirigir Moto");
            break;
            case 'B' : System.out.println("Dirigir Automotivo");
            break;
            case 'C' : System.out.println("Dirigir Carga Leve");
            break;
            case 'D' : System.out.println("Dirigir Carga Pesada");
            break;
            case 'E' : System.out.println("Dirigir Carga Perigosa");
            break;
        }
    }
}
package umc.passosBlueJ;

import javax.swing.JOptionPane;


public class Exercicio {

    public static void main(String[] args) {
     
        String a = JOptionPane.showInputDialog("Digite um valor para A");
        String b = JOptionPane.showInputDialog("Digite um valor para B");
        String c = JOptionPane.showInputDialog("Digite um valor para C");
        
        int aa = Integer.parseInt(a);
        int bb = Integer.parseInt(b);
        int cc = Integer.parseInt(c);
               
        
        int ab = aa+bb;
        int ac = aa+cc;
        int cb = bb+cc;
        
        
        if(( ab > cc) && (ac > bb) && (cb > aa))       {
            System.out.println("� triangulo");
        }
        
        
        else{
         System.out.println("N�o � um triangulo");   
            }
            
            
   }
}

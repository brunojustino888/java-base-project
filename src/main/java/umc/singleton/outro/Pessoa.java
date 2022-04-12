package umc.singleton.outro;

/**
 * @author 12112100947 - 12112100836
 */

public class Pessoa {

    public static String nome;
    public static String cpf;
    public static Pessoa pessoa;
    
    private Pessoa(){
    }
    
    public static Pessoa getPessoa(){
        if(pessoa==null){
            pessoa = new Pessoa();
            return pessoa;
        }else{
            return pessoa;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
  
}
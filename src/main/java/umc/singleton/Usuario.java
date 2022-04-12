package umc.singleton;
	
/**
* @author 12112100836
* @author 12112100947
*/

/**
* Classe modelo criada para representar o conceito de Singleton em uma aplica��o.
*/
public class Usuario {  
   /**
   * Objetos da classe
   */	
   private String nome;
   private String login;
   private String senha;
   private static Usuario instanciaUser;
   
    /**
    * Construtor v�zio e privado para a classe n�o ser instanciada fora dela mesma
    */
    private Usuario(){
       
    }

	/**
	* @return Nome do Usu�rio
	*/
    public String getNome() {
        return nome;
    }

    /**
    * @param Nome � ser atru�do ao usu�rio.
    */
    public void setNome(String nome) {
        this.nome = nome;
    }
	/**
	* @return Senha do Usu�rio
	*/
    public String getSenha() {
        return senha;
    }

    /**
    * @param Senha � ser atru�da ao usu�rio.
    */
    public void setSenha(String senha) {
        this.senha = senha;
    }

	/**
	* @return Login do Usu�rio
	*/
    public String getLogin() {
        return login;
    }

    /**
    * @param Login � ser atru�do ao usu�rio.
    */
    public void setLogin(String nome) {
        this.nome = nome;
    }

    /**
     * @return A inst�ncia da classe.
     */
    public static Usuario getInstancia() {
        if (instanciaUser == null){
            instanciaUser = new Usuario();
        }
        return instanciaUser;
    }  
}
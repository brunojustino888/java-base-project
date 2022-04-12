package gidestock.model;

public class Usuario {
	
	private int id_user;
	private int id_tipo;
	private String nome;
	private String nascimento;
	private String cpf;
	private String rg;
	private String telefone;
	private String endereco;
	private String login;
	private String senha;
	private String obs_user;
		
 public Usuario(int id_user, int id_tipo,String nome,String nascimento,String cpf,String rg,String telefone,String endereco,String login,String senha,String obs_user){
		
		this.id_user = id_user;
		this.id_tipo = id_tipo;
		this.nome = nome;
		this.nascimento = nascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
		this.endereco = endereco;
		this.login = login;
		this.senha = senha;
		this.obs_user = obs_user;

}
	
		public int getId_user() {
			return id_user;
		}
		
		public void setId_user(int id_user) {
			this.id_user = id_user;
		}
		
		public int getId_tipo() {
			return id_tipo;
		}
		
		public void setId_tipo(byte id_tipo) {
			this.id_tipo = id_tipo;
		}
		
		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getNascimento() {
			return nascimento;
		}
		
		public void setNascimento(String nascimento) {
			this.nascimento = nascimento;
		}
		
		public String getCpf() {
			return cpf;
		}
		
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		
		public String getRg() {
			return rg;
		}
		
		public void setRg(String rg) {
			this.rg = rg;
		}
		
		public String getTelefone() {
			return telefone;
		}
		
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		
		public String getEndereco() {
			return endereco;
		}
		
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		
		public String getLogin() {
			return login;
		}
		
		public void setLogin(String login) {
			this.login = login;
		}
		
		public String getSenha() {
			return senha;
		}
		
		public void setSenha(String senha) {
			this.senha = senha;
		}
		
		public String getObs_user() {
			return obs_user;
		}
		
		public void setObs_user(String obs_user) {
			this.obs_user = obs_user;
		}
		
}
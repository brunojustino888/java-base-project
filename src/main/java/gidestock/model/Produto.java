package gidestock.model;

import gidestock.controller.ControllerConexaoDB;

public class Produto {
	
	private int id_produto;
	private String nome;
	private int quantidade;
	private double preco;
	private int estoque_min;
	private int estoque_max;
	private String descricao;
	
	public Produto(){}
	
	public Produto(int id, String nomeproduto, int qtd, double prec, int esto_min, int esto_max, String desc){
		id_produto = id;
		nome = nomeproduto;
		quantidade = qtd;
		preco = prec;
		estoque_min = esto_min;
		estoque_max = esto_max;
		descricao = desc;
	}
	
	public Produto(String nomeproduto, int qtd, double prec, int esto_min, String desc){
		nome = nomeproduto;
		quantidade = qtd;
		preco = prec;
		estoque_min = esto_min;
		descricao = desc;
	}
	
	public int getId_produto() {
		return id_produto;
	}
	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getEstoque_min() {
		return estoque_min;
	}
	public void setEstoque_min(int estoque_min) {
		this.estoque_min = estoque_min;
	}
	public int getEstoque_max() {
		return estoque_max;
	}
	public void setEstoque_max(int estoque_max) {
		this.estoque_max = estoque_max;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void cadastraProduto(){
		ControllerConexaoDB ccdb = new ControllerConexaoDB();
		ccdb.InsertProduto(nome, quantidade, String.valueOf(preco), estoque_min, descricao);
	}
}

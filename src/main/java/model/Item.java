package model;

public class Item {

	private Produto produto;
	private int quantidade;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(Produto produto, int quatidade) {
		this.produto = produto;
		this.quantidade = quatidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	

}

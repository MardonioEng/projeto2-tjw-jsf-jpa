package model;

public class ItemCarrinho {

	private Livro livro;
	private int quantidade;
	
	public ItemCarrinho() {
		// TODO Auto-generated constructor stub
	}
	
	public ItemCarrinho(Livro livro, int quatidade) {
		this.livro = livro;
		this.quantidade = quatidade;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	

}

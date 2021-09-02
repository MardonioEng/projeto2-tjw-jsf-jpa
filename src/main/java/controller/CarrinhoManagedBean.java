package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.ItemCarrinho;
import model.Livro;

@SessionScoped
@ManagedBean(name = "carrinhoManagedBean")
public class CarrinhoManagedBean {
	
	private List<ItemCarrinho> itens;
	
	public CarrinhoManagedBean() {
		this.itens = new ArrayList<ItemCarrinho>();
	}

	public List<ItemCarrinho> getItens() {
		return itens;
	}

	public void setItens(List<ItemCarrinho> itens) {
		this.itens = itens;
	}
	
	public String comprar(Livro livro) {
		int index = this.existe(livro);
		if (index == -1) {
			this.itens.add(new ItemCarrinho(livro, 1));
		} else {
			int quantity = this.itens.get(index).getQuantidade() + 1;
			this.itens.get(index).setQuantidade(quantity);
		}
		return "carrinho?faces-redirect=true";
	}
	
	private int existe(Livro livro) {
		for (int i = 0; i < this.itens.size(); i++) {
			if (this.itens.get(i).getLivro().getId() == livro.getId()) {
				return i;
			}
		}
		return -1;
	}
	
	public String delete(Livro livro) {
		int index = this.existe(livro);
		this.itens.remove(index);
		return "carrinho?faces-redirect=true";
	}

	public double total() {
		double s = 0;
		for(ItemCarrinho item : this.itens) {
			s += item.getLivro().getValor().doubleValue() * item.getQuantidade();
		}
		return s;
	}
	
	public String finalizarCompra() {
		return "confimacao_compra?faces-redirect=true";
	}
}

package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Item;
import model.Produto;

@SessionScoped
@ManagedBean(name = "carrinhoManagedBean")
public class CarrinhoManagedBean {
	
	private List<Item> itens;
	
	public CarrinhoManagedBean() {
		this.itens = new ArrayList<Item>();
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	public String comprar(Produto produto) {
		int index = this.existe(produto);
		if (index == -1) {
			this.itens.add(new Item(produto, 1));
		} else {
			int quantity = this.itens.get(index).getQuantidade() + 1;
			this.itens.get(index).setQuantidade(quantity);
		}
		return "carrinho?faces-redirect=true";
	}
	
	private int existe(Produto produto) {
		for (int i = 0; i < this.itens.size(); i++) {
			if (this.itens.get(i).getProduto().getId() == produto.getId()) {
				return i;
			}
		}
		return -1;
	}
	
	public String delete(Produto produto) {
		int index = this.existe(produto);
		this.itens.remove(index);
		return "carrinho?faces-redirect=true";
	}

	public double total() {
		double s = 0;
		for(Item item : this.itens) {
			s += item.getProduto().getValor().doubleValue() * item.getQuantidade();
		}
		return s;
	}
	
	public String finalizarCompra() {
		return "confimacao_compra?faces-redirect=true";
	}
}

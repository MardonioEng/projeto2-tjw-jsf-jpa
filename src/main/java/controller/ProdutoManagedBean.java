package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.ProdutoDoa;
import model.Produto;

@SessionScoped
@ManagedBean(name = "produtoManagedBean")
public class ProdutoManagedBean {

	private List<Produto> produtos;


	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public ProdutoManagedBean() {
		ProdutoDoa produtoDoa = new ProdutoDoa();
		this.produtos = produtoDoa.findAll();
	}

	public String index() {
		ProdutoDoa produtoDoa = new ProdutoDoa();
		this.produtos = produtoDoa.findAll();
		return "index?faces-redirect=true";
	}
	
}

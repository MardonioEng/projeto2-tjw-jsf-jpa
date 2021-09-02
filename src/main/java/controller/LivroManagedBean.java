package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.LivroDAO;
import model.Livro;

@SessionScoped
@ManagedBean(name = "livroManagedBean")
public class LivroManagedBean {

	private List<Livro> livros;


	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public LivroManagedBean() {
		LivroDAO livroDAO = new LivroDAO();
		this.livros = livroDAO.findAll();
	}

	public String index() {
		LivroDAO livroDAO = new LivroDAO();
		this.livros = livroDAO.findAll();
		return "index?faces-redirect=true";
	}
	
}

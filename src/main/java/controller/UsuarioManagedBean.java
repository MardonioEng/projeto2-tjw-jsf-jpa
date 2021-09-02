package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
@ManagedBean(name = "usuarioManagedBean")
public class UsuarioManagedBean {

	 private final static String USUARIO_NOME = "fulano";
	 private final static String SENHA = "1234";
	 
	 private String nomeUsuario;
	 private String senha;
	

	  public String getNomeUsuario() {
		return nomeUsuario;
	}


	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String validar() {

		  if(nomeUsuario == null || senha == null) {
			  FacesContext.getCurrentInstance().addMessage(
				         null,
				         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome ou senha não informado!",
				           "Erro no Login!"));
			  return null;
		  }else if(!nomeUsuario.equals(USUARIO_NOME) || !senha.equals(SENHA)) {
			  FacesContext.getCurrentInstance().addMessage(
				         null,
				         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
				           "Erro no Login!"));
			  return null;
		  }else {
			  return "index?faces-redirect=true";
		  }
	  }
}

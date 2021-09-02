package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
@ManagedBean(name = "usuarioManagedBean")
public class UsuarioManagedBean {

	private static String USUARIO_NOME = "mardonio";
	private static String SENHA = "mardonio";

	private String nomeUsuario;
	private String senha;

	public String validar() {

		if (!nomeUsuario.equals(USUARIO_NOME) || !senha.equals(SENHA)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));
			return null;
		} else {
			return "index?faces-redirect=true";
		}
	}

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
}

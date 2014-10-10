package br.com.fiap.am.session;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.am.bean.UsuarioBean;
import br.com.fiap.am.form.LoginForm;

@ManagedBean(name="loginSession")
@SessionScoped
public class LoginSession implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1286546900167006980L;

	private UsuarioBean usuario;
	private boolean logged;
	
	
	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}
}

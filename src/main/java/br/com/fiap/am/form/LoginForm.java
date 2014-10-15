package br.com.fiap.am.form;

import br.com.fiap.am.bean.UsuarioBean;

public class LoginForm {

	private UsuarioBean usuario;


	public LoginForm() {
		this.usuario = new UsuarioBean();
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}


}

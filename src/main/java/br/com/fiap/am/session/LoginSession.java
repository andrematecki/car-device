package br.com.fiap.am.session;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.am.bean.UsuarioBean;

@ManagedBean(name="loginSession")
@SessionScoped
public class LoginSession implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1286546900167006980L;
	private UsuarioBean usuario;

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

}

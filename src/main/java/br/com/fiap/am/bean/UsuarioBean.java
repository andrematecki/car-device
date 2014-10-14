package br.com.fiap.am.bean;

import java.util.HashMap;

import br.com.fiap.am.enums.UsuarioTipoEnum;
import br.com.fiap.am.sqlhelper.IDao;

public class UsuarioBean implements IDao{

	private int id;
	private String email;
	private String senha;
	private UsuarioTipoEnum tipo;

	public UsuarioBean() { }

	public UsuarioBean(String email, String senha, UsuarioTipoEnum tipo) {
		super();
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UsuarioTipoEnum getTipo() {
		return tipo;
	}
	public void setTipo(UsuarioTipoEnum tipo) {
		this.tipo = tipo;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public void bind(HashMap<String, Object> dados) {

	}
}

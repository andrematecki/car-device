package br.com.fiap.am.bean;

import java.util.HashMap;

import br.com.fiap.am.enums.UsuarioTipoEnum;
import br.com.fiap.am.sqlhelper.IDao;

public class UsuarioBean implements IDao{

	private int idUsuario;
	private String email;
	private String senha;
	private String repetirSenha;
	private UsuarioTipoEnum tipo;

	public UsuarioBean() { }

	public UsuarioBean(String email, String senha, UsuarioTipoEnum tipo) {
		super();
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
	public String getRepetirSenha() {
		return repetirSenha;
	}

	public void setRepetirSenha(String repetirSenha) {
		this.repetirSenha = repetirSenha;
	}

	@Override
	public void bind(HashMap<String, Object> dados) {
		idUsuario = dados.get("ID") != null ? Integer.parseInt(dados.get("ID").toString()) : 0;
		email = dados.get("EMAIL") != null ? dados.get("EMAIL").toString() : null;
		senha = dados.get("SENHA") != null ? dados.get("SENHA").toString() : null;
		tipo = dados.get("TIPO") != null ? getTipo(dados.get("TIPO").toString()) : null;

	}

	private UsuarioTipoEnum getTipo(String tipo) {
		for(UsuarioTipoEnum t : UsuarioTipoEnum.values()){
			if(t.getTipo().equals(tipo)){
				return t;
			}
		}
		return null;
	}


}

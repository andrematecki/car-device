package br.com.fiap.am.bean;

import java.util.HashMap;

import br.com.fiap.am.sqlhelper.IDao;

public class ContatoBean implements IDao {

	private String nome;
	private String email;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public void bind(HashMap<String, Object> dados) {
		nome = dados.get("NOME").toString();
		email = dados.get("EMAIL").toString();
	}

	
}

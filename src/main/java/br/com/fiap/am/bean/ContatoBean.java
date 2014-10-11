package br.com.fiap.am.bean;

import java.util.HashMap;

import br.com.fiap.am.sqlhelper.IDao;

public class ContatoBean implements IDao {

	private String nome;
	private String email;
	private String telefone;
	private String cia;
	private String titulo;
	private String mensagem;

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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCia() {
		return cia;
	}
	public void setCia(String cia) {
		this.cia = cia;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public void bind(HashMap<String, Object> dados) {
		nome = dados.get("NOME") != null ? dados.get("NOME").toString() : null;
		email = dados.get("EMAIL") != null ? dados.get("EMAIL").toString() : null;
		telefone = dados.get("TELEFONE") != null ? dados.get("TELEFONE").toString() : null;
		cia = dados.get("CIA") != null ? dados.get("CIA").toString() : null;
		titulo = dados.get("TITULO") != null ? dados.get("TITULO").toString() : null;
		mensagem = dados.get("MSG") != null ? dados.get("MSG").toString() : null;

	}


}

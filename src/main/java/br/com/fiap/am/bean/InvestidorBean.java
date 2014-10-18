package br.com.fiap.am.bean;

import java.util.HashMap;

import br.com.fiap.am.sqlhelper.IDao;

public class InvestidorBean extends UsuarioBean implements IDao {

	private int id;
	private String nome;
	private String sobrenome;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Override
	public void bind(HashMap<String, Object> dados) {
		super.bind(dados);
		id = dados.get("ID_INV") != null ? Integer.parseInt(dados.get("ID_INV").toString()) : 0;
		nome = dados.get("NOME") != null ? dados.get("NOME").toString() : null;
		sobrenome = dados.get("SOBRENOME") != null ? dados.get("SOBRENOME").toString() : null;
	}

}

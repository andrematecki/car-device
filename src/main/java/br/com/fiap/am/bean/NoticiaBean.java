package br.com.fiap.am.bean;

import java.util.HashMap;

import br.com.fiap.am.sqlhelper.IDao;

public class NoticiaBean implements IDao {

	private int id;
	private String titulo;
	private String noticia;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getNoticia() {
		return noticia;
	}
	public void setNoticia(String noticia) {
		this.noticia = noticia;
	}

	@Override
	public void bind(HashMap<String, Object> dados) {
		id = dados.get("ID") != null ? Integer.parseInt(dados.get("ID").toString()) : 0;
		titulo = dados.get("TITULO") != null ? dados.get("TITULO").toString() : null;
		noticia = dados.get("NOTICIA") != null ? dados.get("NOTICIA").toString() : null;
	}



}

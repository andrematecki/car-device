package br.com.fiap.am.form;

import java.util.ArrayList;

import br.com.fiap.am.bean.ContatoBean;

public class ContatoForm {
	private ArrayList<ContatoBean> contatos;
	private ContatoBean contato;

	public ArrayList<ContatoBean> getContatos() {
		return contatos;
	}
	public void setContatos(ArrayList<ContatoBean> contatos) {
		this.contatos = contatos;
	}
	public ContatoBean getContato() {
		return contato;
	}
	public void setContato(ContatoBean contato) {
		this.contato = contato;
	}
}

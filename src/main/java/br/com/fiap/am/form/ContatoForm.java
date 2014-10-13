package br.com.fiap.am.form;

import java.util.ArrayList;

import br.com.fiap.am.bean.ContatoBean;

public class ContatoForm {
	private ArrayList<ContatoBean> contatos;
	private ContatoBean contato;
	private ContatoBean contatoSelecionado;

	public void limpar(){
		contatos = null;
		contato.setNome(null);
		contato.setEmail(null);
		contato.setTelefone(null);
		contato.setCia(null);
		contato.setTitulo(null);
		contato.setMensagem(null);
	}

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

	public ContatoBean getContatoSelecionado() {
		return contatoSelecionado;
	}

	public void setContatoSelecionado(ContatoBean contatoSelecionado) {
		this.contatoSelecionado = contatoSelecionado;
	}
}

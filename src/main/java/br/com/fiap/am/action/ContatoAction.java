package br.com.fiap.am.action;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import br.com.fiap.am.bean.ContatoBean;
import br.com.fiap.am.dao.ContatoDAO;
import br.com.fiap.am.form.ContatoForm;

@ManagedBean(name="contatoAction")
public class ContatoAction {

	private ContatoForm form;
	
	public ContatoAction(){
		form = new ContatoForm();
	}

	public ContatoForm getForm() {
		return form;
	}

	public void setForm(ContatoForm form) {
		this.form = form;
	}
	
	public void salvarContato(){
		new ContatoDAO().insert(form);
		
		ArrayList<ContatoBean> lista = new ContatoDAO().list();
	}
	
	
}

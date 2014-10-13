package br.com.fiap.am.action;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.fiap.am.bean.ContatoBean;
import br.com.fiap.am.bean.UsuarioBean;
import br.com.fiap.am.dao.ContatoDAO;
import br.com.fiap.am.form.ContatoForm;
import br.com.fiap.am.session.LoginSession;

@ManagedBean(name="contatoAction")
public class ContatoAction {

	private ContatoForm form;
	@ManagedProperty(value="#{loginSession}")
	private LoginSession login;


	public ContatoAction(){
		form = new ContatoForm();
		form.setContato(new ContatoBean());
		form.setContatos(new ArrayList<ContatoBean>());
	}



	public void salvarContato(){
		new ContatoDAO().insert(form.getContato());
	}

	public void listarContatos(){
		form.setContatos(new ContatoDAO().list());
	}


	public void setLogin(LoginSession login) {
		this.login = login;
	}
	public ContatoForm getForm() {
		return form;
	}
	public void setForm(ContatoForm form) {
		this.form = form;
	}
}

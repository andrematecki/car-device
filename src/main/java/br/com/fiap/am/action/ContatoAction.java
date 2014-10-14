package br.com.fiap.am.action;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.am.bean.ContatoBean;
import br.com.fiap.am.bean.UsuarioBean;
import br.com.fiap.am.dao.ContatoDAO;
import br.com.fiap.am.form.ContatoForm;
import br.com.fiap.am.session.LoginSession;

@ManagedBean(name="contatoAction")
@ViewScoped
public class ContatoAction {

	private ContatoForm form;
	@ManagedProperty(value="#{loginSession}")
	private LoginSession login;


	public ContatoAction(){
		form = new ContatoForm();
	}

	public void salvarContato(){
		FacesContext context = FacesContext.getCurrentInstance();
        String titulo = "", msg = "";

		try {
			new ContatoDAO().insert(form.getContato());
			titulo = "Contato inserido com sucesso!";
			msg = "Obrigado pelo contato.";
			form.limpar();
		}
		catch(Exception e){
			titulo = "Erro ao fazer contato.";
			msg = e.getMessage();
		}

		context.addMessage(null, new FacesMessage(titulo, msg));
	}

	public void listarContatos(){
		if(!FacesContext.getCurrentInstance().isPostback()){
			form.setContatos(new ContatoDAO().list());
		}
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

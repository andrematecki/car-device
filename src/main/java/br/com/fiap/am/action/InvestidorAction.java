package br.com.fiap.am.action;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.am.bo.InvestidorBO;
import br.com.fiap.am.dao.ContatoDAO;
import br.com.fiap.am.form.InvestidorForm;

@ManagedBean
@ViewScoped
public class InvestidorAction {

	private InvestidorForm form;

	public InvestidorAction(){
		setForm(new InvestidorForm());
	}

	public void inserirInvestidor(){
		FacesContext context = FacesContext.getCurrentInstance();
        String titulo = "", msg = "";

		try {
			new InvestidorBO().insert(form.getInvestidor());
			titulo = "Investidor inserido com sucesso!";
			form.limpar();
		}
		catch(Exception e){
			titulo = "Erro ao inserir investidor";
			msg = e.getMessage();
		}

		context.addMessage(null, new FacesMessage(titulo, msg));
	}

	public InvestidorForm getForm() {
		return form;
	}

	public void setForm(InvestidorForm form) {
		this.form = form;
	}

}

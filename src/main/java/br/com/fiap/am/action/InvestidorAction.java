package br.com.fiap.am.action;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fiap.am.bo.InvestidorBO;
import br.com.fiap.am.form.InvestidorForm;

@ManagedBean
@ViewScoped
public class InvestidorAction {

	private InvestidorForm form;

	public InvestidorAction(){
		setForm(new InvestidorForm());
	}

	public void inserirInvestidor(){
		new InvestidorBO().insert(form.getInvestidor());
	}

	public InvestidorForm getForm() {
		return form;
	}

	public void setForm(InvestidorForm form) {
		this.form = form;
	}

}

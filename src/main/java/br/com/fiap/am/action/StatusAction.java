package br.com.fiap.am.action;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.am.bo.InvestidorBO;
import br.com.fiap.am.dao.StatusDAO;
import br.com.fiap.am.form.StatusForm;
import br.com.fiap.am.util.DateUtil;

@ManagedBean(name="statusAction")
@ViewScoped
public class StatusAction {

	private StatusForm form;

	public StatusAction(){
		setForm(new StatusForm());
	}


	public void inserirStatus(){
		FacesContext context = FacesContext.getCurrentInstance();
        String titulo = "", msg = "";

		try {
			form.getStatus().setData(DateUtil.getCalendar(form.getData()));
			new StatusDAO().insert(form.getStatus());
			titulo = "Status inserido com sucesso!";
			form.limpar();
		}
		catch(Exception e){
			titulo = "Erro ao inserir status";
			msg = e.getMessage();
		}

		context.addMessage(null, new FacesMessage(titulo, msg));
	}


	public StatusForm getForm() {
		return form;
	}
	public void setForm(StatusForm form) {
		this.form = form;
	}
}

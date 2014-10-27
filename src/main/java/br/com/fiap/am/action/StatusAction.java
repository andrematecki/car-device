package br.com.fiap.am.action;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.extensions.model.timeline.TimelineEvent;
import org.primefaces.extensions.model.timeline.TimelineModel;

import br.com.fiap.am.bean.StatusBean;
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

	public void listarStatus(){
		if(!FacesContext.getCurrentInstance().isPostback()){
			List<StatusBean> list = new StatusDAO().list();
			form.setModel(getModel(list));

		}
	}

	private TimelineModel getModel(List<StatusBean> list) {
		TimelineModel model = new TimelineModel();

		if(list != null){
			for(StatusBean s : list){
				model.add(new TimelineEvent(s.getTarget(), s.getData().getTime()));
			}
		}

		return model;
	}


	public StatusForm getForm() {
		return form;
	}
	public void setForm(StatusForm form) {
		this.form = form;
	}
}

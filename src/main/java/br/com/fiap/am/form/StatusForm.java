package br.com.fiap.am.form;

import java.util.Date;
import java.util.List;

import org.primefaces.extensions.model.timeline.TimelineModel;

import br.com.fiap.am.bean.StatusBean;

public class StatusForm {

	private StatusBean status;
	private Date data;
	private List<StatusBean> listaStatus;
	private TimelineModel model;

	public StatusForm(){
		status = new StatusBean();
	}

	public void limpar(){
		status = new StatusBean();
		setData(null);
	}

	public StatusBean getStatus() {
		return status;
	}
	public void setStatus(StatusBean status) {
		this.status = status;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public List<StatusBean> getListaStatus() {
		return listaStatus;
	}

	public void setListaStatus(List<StatusBean> listaStatus) {
		this.listaStatus = listaStatus;
	}
	public TimelineModel getModel() {
		return model;
	}
	public void setModel(TimelineModel model) {
		this.model = model;
	}
}

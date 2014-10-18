package br.com.fiap.am.form;

import java.util.Date;

import br.com.fiap.am.bean.StatusBean;

public class StatusForm {

	private StatusBean status;
	private Date data;

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
}

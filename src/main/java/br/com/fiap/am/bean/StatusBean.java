package br.com.fiap.am.bean;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import br.com.fiap.am.sqlhelper.IDao;
import br.com.fiap.am.util.DateUtil;

public class StatusBean implements IDao {

	private int id;
	private Calendar data;
	private String target;
	private String descricao;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Calendar getData() {
		return data;
	}
	public String getDataFormatada(){
		return DateUtil.format(data);
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	@Override
	public void bind(HashMap<String, Object> dados) {
		id = dados.get("ID") != null ? Integer.parseInt(dados.get("ID").toString()) : null;
		data = dados.get("DATA") != null ? DateUtil.getCalendar((Date)dados.get("DATA")) : null;
		target = dados.get("TARGET") != null ? dados.get("TARGET").toString() : null;
		setDescricao(dados.get("DESCRICAO") != null ? dados.get("DESCRICAO").toString() : null);

	}
}

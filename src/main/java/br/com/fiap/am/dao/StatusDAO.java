package br.com.fiap.am.dao;

import java.util.List;

import br.com.fiap.am.bean.StatusBean;
import br.com.fiap.am.sqlhelper.Parametro;
import br.com.fiap.am.sqlhelper.SqlHelper;

public class StatusDAO {

	private SqlHelper helper;

	public StatusDAO(){
		helper = new SqlHelper();
	}

	public int insert(StatusBean s){
		String cmd = "INSERT INTO AM_STATUS (DATA, TARGET, DESCRICAO) VALUES (TO_DATE(?, 'yyyy/mm/dd hh24:mi:ss'), ?, ?)";

		Parametro[] param = {
			new Parametro(1, s.getDataFormatada()),
			new Parametro(2, s.getTarget()),
			new Parametro(3, s.getDescricao())
		};

		return helper.executeUpdate(cmd, param);
	}

	public List<StatusBean> list(){
		String cmd = "SELECT ID, DATA, TARGET, DESCRICAO FROM AM_STATUS";
		return helper.executeCollection(cmd, StatusBean.class);
	}

}

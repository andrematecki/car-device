package br.com.fiap.am.dao;

import br.com.fiap.am.bean.InvestidorBean;
import br.com.fiap.am.sqlhelper.Parametro;
import br.com.fiap.am.sqlhelper.SqlHelper;

public class InvestidorDAO {

	private SqlHelper helper;

	public InvestidorDAO(){
		helper = new SqlHelper();
	}


	public int insert(InvestidorBean i){
		String cmd = "INSERT INTO AM_INVESTIDOR (NOME, SOBRENOME, ID_USUARIO) VALUES(?, ?, ?)";

		Parametro[] param = {
			new Parametro(1, i.getNome()),
			new Parametro(2, i.getSobrenome()),
			new Parametro(3, i.getIdUsuario())
		};

		return helper.executeUpdate(cmd, param);
	}
}

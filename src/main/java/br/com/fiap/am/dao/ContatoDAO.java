package br.com.fiap.am.dao;

import java.util.ArrayList;

import br.com.fiap.am.bean.ContatoBean;
import br.com.fiap.am.form.ContatoForm;
import br.com.fiap.am.sqlhelper.Parametro;
import br.com.fiap.am.sqlhelper.SqlHelper;

public class ContatoDAO {

	private SqlHelper helper;

	public ContatoDAO(){
		helper = new SqlHelper();
	}

	public int insert(ContatoBean c){
		String cmd = "INSERT INTO AM_CONTATO (NOME, EMAIL, TELEFONE, CIA, TITULO, MSG) VALUES (?, ?, ?, ?, ?, ?)";

		Parametro[] param = {
				new Parametro(1, c.getNome()),
				new Parametro(2, c.getEmail()),
				new Parametro(3, c.getTelefone()),
				new Parametro(4, c.getCia()),
				new Parametro(5, c.getTitulo()),
				new Parametro(6, c.getMensagem())
		};

		return helper.executeUpdate(cmd, param);
	}

	public ArrayList<ContatoBean> list(){
		String cmd = "SELECT NOME, EMAIL, TELEFONE, CIA, TITULO, MSG FROM AM_CONTATO";
		ArrayList<ContatoBean> list = helper.executeCollection(cmd, ContatoBean.class);
		return list;
	}

}

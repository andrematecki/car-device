package br.com.fiap.am.dao;

import java.util.ArrayList;

import br.com.fiap.am.bean.ContatoBean;
import br.com.fiap.am.sqlhelper.Parametro;
import br.com.fiap.am.sqlhelper.SqlHelper;
import br.com.fiap.form.ContatoForm;

public class ContatoDAO {
	
	private SqlHelper helper;
	
	public ContatoDAO(){
		helper = new SqlHelper();
	}
	
	public int insert(ContatoForm c){
		String cmd = "INSERT INTO AM_CONTATO (NOME, EMAIL) VALUES (?, ?)";
		
		Parametro[] param = {
				new Parametro(1, c.getNome()),
				new Parametro(2, c.getEmail())
		};
		
		return helper.executeUpdate(cmd, param);
		
	}
	
	public ArrayList<ContatoBean> list(){
		String cmd = "SELECT NOME, EMAIL FROM AM_CONTATO";
		ArrayList<ContatoBean> list = helper.executeCollection(cmd, ContatoBean.class);
		return list;
	}
	
}

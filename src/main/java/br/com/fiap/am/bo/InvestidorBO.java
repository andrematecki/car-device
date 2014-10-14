package br.com.fiap.am.bo;

import br.com.fiap.am.bean.InvestidorBean;
import br.com.fiap.am.dao.InvestidorDAO;
import br.com.fiap.am.dao.UsuarioDAO;

public class InvestidorBO {

	public void insert(InvestidorBean inv){
		UsuarioDAO uDao = new UsuarioDAO();
		uDao.insert(inv);
		inv.setIdUsuario(uDao.select(inv).getIdUsuario());

		InvestidorDAO iDao = new InvestidorDAO();
		iDao.insert(inv);
	}

}

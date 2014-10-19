package br.com.fiap.am.dao;

import java.util.List;

import br.com.fiap.am.bean.NoticiaBean;
import br.com.fiap.am.sqlhelper.Parametro;
import br.com.fiap.am.sqlhelper.SqlHelper;

public class NoticiaDAO {

	private SqlHelper helper;

	public NoticiaDAO(){
		helper = new SqlHelper();
	}

	public int insert(NoticiaBean n){
		String cmd = "INSERT INTO AM_NOTICIA(TITULO, NOTICIA) VALUES (?, ?)";

		Parametro[] param = {
			new Parametro(1, n.getTitulo()),
			new Parametro(2, n.getNoticia())
		};

		return helper.executeUpdate(cmd, param);
	}

	public List<NoticiaBean> list(){
		String cmd = "SELECT ID, TITULO, NOTICIA FROM AM_NOTICIA ORDER BY ID DESC";

		return helper.executeCollection(cmd, NoticiaBean.class);
	}
}

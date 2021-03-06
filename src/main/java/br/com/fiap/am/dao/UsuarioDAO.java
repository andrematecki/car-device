package br.com.fiap.am.dao;

import javax.swing.text.StyledEditorKit.BoldAction;

import br.com.fiap.am.bean.UsuarioBean;
import br.com.fiap.am.enums.UsuarioTipoEnum;
import br.com.fiap.am.sqlhelper.Parametro;
import br.com.fiap.am.sqlhelper.SqlHelper;

public class UsuarioDAO {
	private SqlHelper helper;

	public UsuarioDAO(){
		helper = new SqlHelper();
	}

	public int insert(UsuarioBean u){
		String cmd = "INSERT INTO AM_USUARIO(EMAIL, SENHA, TIPO) VALUES (?, ?, ?)";

		Parametro[] param = {
				new Parametro(1, u.getEmail()),
				new Parametro(2, u.getSenha()),
				new Parametro(3, UsuarioTipoEnum.INVESTIDOR.getTipo())
		};

		return helper.executeUpdate(cmd, param);
	}

	public UsuarioBean select(UsuarioBean u){
		String cmd = "SELECT ID, EMAIL, SENHA, TIPO FROM AM_USUARIO WHERE EMAIL = ? AND SENHA = ?";

		Parametro[] param = {
				new Parametro(1, u.getEmail()),
				new Parametro(2, u.getSenha())
		};

		return helper.executeObject(cmd, param, UsuarioBean.class);
	}

	public boolean usuarioExiste(String email){
		String cmd = "SELECT ID, EMAIL, SENHA, TIPO FROM AM_USUARIO WHERE EMAIL = ?";

		Parametro[] param = {
				new Parametro(1, email)
		};

		if(null == helper.executeObject(cmd, param, UsuarioBean.class)){
			return false;
		}
		return true;
	}
}

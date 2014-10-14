package br.com.fiap.am.form;

import br.com.fiap.am.bean.InvestidorBean;
import br.com.fiap.am.bean.UsuarioBean;

public class InvestidorForm {

	private UsuarioBean usuario;
	private InvestidorBean investidor;

	public InvestidorForm(){
		usuario = new UsuarioBean();
		investidor = new InvestidorBean();
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}
	public InvestidorBean getInvestidor() {
		return investidor;
	}
	public void setInvestidor(InvestidorBean investidor) {
		this.investidor = investidor;
	}

}

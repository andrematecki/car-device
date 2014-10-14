package br.com.fiap.am.form;

import br.com.fiap.am.bean.InvestidorBean;
import br.com.fiap.am.bean.UsuarioBean;

public class InvestidorForm {

	private InvestidorBean investidor;

	public InvestidorForm(){
		investidor = new InvestidorBean();
	}

	public InvestidorBean getInvestidor() {
		return investidor;
	}
	public void setInvestidor(InvestidorBean investidor) {
		this.investidor = investidor;
	}

}

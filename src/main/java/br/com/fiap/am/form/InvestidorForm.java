package br.com.fiap.am.form;

import java.util.List;

import br.com.fiap.am.bean.InvestidorBean;
import br.com.fiap.am.bean.UsuarioBean;

public class InvestidorForm {

	private InvestidorBean investidor;
	private List<InvestidorBean> investidores;

	public InvestidorForm(){
		investidor = new InvestidorBean();
	}

	public void limpar(){
		investidor = new InvestidorBean();
	}

	public InvestidorBean getInvestidor() {
		return investidor;
	}
	public void setInvestidor(InvestidorBean investidor) {
		this.investidor = investidor;
	}

	public List<InvestidorBean> getInvestidores() {
		return investidores;
	}

	public void setInvestidores(List<InvestidorBean> investidores) {
		this.investidores = investidores;
	}

}

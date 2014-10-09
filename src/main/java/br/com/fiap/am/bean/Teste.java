package br.com.fiap.am.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.am.sqlhelper.Parametro;
import br.com.fiap.am.sqlhelper.SqlHelper;
import br.com.fiap.am.sqlhelper.Usuario;

@ManagedBean(name="teste")
public class Teste {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	 public void buttonAction() throws InstantiationException, IllegalAccessException {
		 String cmd = "INSERT INTO COUNTRIES VALUES('TT', 'TESTE', 1)";
		 Parametro[] param = {
				 new Parametro(1, "TT"),
				 new Parametro(2, "TESTE"),
				 new Parametro(3, 1)
		 };

		 SqlHelper helper = new SqlHelper();



		 int ret = helper.executeUpdate(cmd, param);


	}

	    public void addMessage(String summary) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
}

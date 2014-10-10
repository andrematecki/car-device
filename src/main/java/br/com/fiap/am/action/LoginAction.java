package br.com.fiap.am.action;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.fiap.am.bean.UsuarioBean;
import br.com.fiap.am.form.LoginForm;
import br.com.fiap.am.session.LoginSession;

@ManagedBean(name = "loginAction")
public class LoginAction {

	private LoginForm form;
	
	@ManagedProperty(value="#{loginSession}")
	private LoginSession login;
	
	public LoginAction(){
		form = new LoginForm();
	}

	public String doLogin(){
		if(form.getLogin().equals("admin") && form.getSenha().equals("123")){
			UsuarioBean bean = new UsuarioBean();
			bean.setNome(form.getLogin());
			
			login.setLogged(true);
			login.setUsuario(bean);
			
			return "index";
		}
		return null;
	}
	
	public LoginForm getForm() {
		return form;
	}

	public void setForm(LoginForm form) {
		this.form = form;
	}

	public void setLogin(LoginSession login) {
		this.login = login;
	}
	
}

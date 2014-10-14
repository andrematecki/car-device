package br.com.fiap.am.action;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.FacesEvent;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.context.RequestContext;

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

	 public void login(FacesEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;

        if(form.getLogin() != null && form.getLogin().equals("admin") && form.getSenha() != null && form.getSenha().equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ben vindo ", form.getLogin());

            UsuarioBean bean = new UsuarioBean();
		//	bean.setNome(form.getLogin());

			login.setLogged(true);
			login.setUsuario(bean);

        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro no login", "Credenciais invalidas");
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    }

	public String logout() {
		login.setLogged(false);
		login.setUsuario(null);

		return "/index.xhtml?faces-redirect=true";
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

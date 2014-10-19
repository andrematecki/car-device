package br.com.fiap.am.action;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.am.dao.NoticiaDAO;
import br.com.fiap.am.form.NoticiaForm;

@ManagedBean(name="noticiaAction")
@ViewScoped
public class NoticiaAction {

	private NoticiaForm form;

	public NoticiaAction(){
		setForm(new NoticiaForm());
	}

	public void inserirNoticia(){
		FacesContext context = FacesContext.getCurrentInstance();
        String titulo = "", msg = "";

		try {
			new NoticiaDAO().insert(form.getNoticia());
			titulo = "Noticia inserida com sucesso!";
			form.limpar();
		}
		catch(Exception e){
			titulo = "Erro ao inserir noticia";
			msg = e.getMessage();
		}

		context.addMessage(null, new FacesMessage(titulo, msg));
	}

	public void listarNoticias(){
		if(!FacesContext.getCurrentInstance().isPostback()){
			form.setNoticias(new NoticiaDAO().list());
		}
	}

	public NoticiaForm getForm() {
		return form;
	}
	public void setForm(NoticiaForm form) {
		this.form = form;
	}
}

package br.com.fiap.am.form;

import java.util.List;

import br.com.fiap.am.bean.NoticiaBean;

public class NoticiaForm {

	private NoticiaBean noticia;
	private List<NoticiaBean> noticias;

	public NoticiaForm(){
		noticia = new NoticiaBean();
	}

	public void limpar(){
		noticia = new NoticiaBean();
	}

	public NoticiaBean getNoticia() {
		return noticia;
	}

	public void setNoticia(NoticiaBean noticia) {
		this.noticia = noticia;
	}

	public List<NoticiaBean> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<NoticiaBean> noticias) {
		this.noticias = noticias;
	}


}

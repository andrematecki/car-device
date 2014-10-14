package br.com.fiap.am.enums;

public enum UsuarioTipoEnum {

	ADMINISTRADOR("ADM"),
	INVESTIDOR("INV");

	private String tipo;

	private UsuarioTipoEnum(String tipo) {
		this.tipo = tipo;
	}

	public String getPreco(){
		return this.tipo;
	}
}

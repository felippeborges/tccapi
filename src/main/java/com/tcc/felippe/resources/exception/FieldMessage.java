package com.tcc.felippe.resources.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fieldName;
	private String messagem;

	public FieldMessage() {

	}

	public FieldMessage(String fieldName, String messagem) {
		super();
		this.fieldName = fieldName;
		this.messagem = messagem;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFildName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessagem() {
		return messagem;
	}

	public void setMessage(String messagem) {
		this.messagem = messagem;
	}

}

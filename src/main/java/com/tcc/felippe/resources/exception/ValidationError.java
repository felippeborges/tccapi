package com.tcc.felippe.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> lista = new ArrayList<>();
	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
		// TODO Auto-generated constructor stub
	}
	public List<FieldMessage> getLista() {
		return lista;
	}
	public void addError(String fildName, String messagem) {
		lista.add(new FieldMessage(fildName, messagem));
	}


}

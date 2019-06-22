package com.tcc.felippe.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tcc.felippe.domain.enums.TipoCliente;
import com.tcc.felippe.dto.ClienteNewDTO;
import com.tcc.felippe.resources.exception.FieldMessage;
import com.tcc.felippe.services.validation.util.validadorCPFouCNPJ;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
// inclua os testes aqui, inserindo erros na lista
		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod())
				&& !validadorCPFouCNPJ.isValidCPF(objDto.getCpfOUcnpj())) {
			list.add(new FieldMessage("cpfOUcnpj", "CPF Inválido"));
		}
		if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod())
				&& !validadorCPFouCNPJ.isValidCNPJ(objDto.getCpfOUcnpj())) {
			list.add(new FieldMessage("cpfOUcnpj", "CNPJ Inválido"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessagem()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}

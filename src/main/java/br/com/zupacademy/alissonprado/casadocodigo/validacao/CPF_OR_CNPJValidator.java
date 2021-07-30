package br.com.zupacademy.alissonprado.casadocodigo.validacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPF_OR_CNPJValidator implements ConstraintValidator<CPForCNPJ, Object> {

    @Override
    public void initialize(CPForCNPJ params) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

        String valueOnlyNumber = value.toString().replaceAll("\\p{Punct}", "");

        /**
         * Validação de CNPJ e CPF
         */
        if (valueOnlyNumber.matches("([0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2})") || validaCPF(valueOnlyNumber))
            return true;

        return false;
    }

    Boolean validaCPF(String cpf){

        if (cpf.equals("00000000000") ||
                cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999") ||
                (cpf.length() != 11))
            return false;

        if (!cpf.matches("([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}-[0-9]{2})|([0-9]{11})"))
            return false;

        return true;
    }
}

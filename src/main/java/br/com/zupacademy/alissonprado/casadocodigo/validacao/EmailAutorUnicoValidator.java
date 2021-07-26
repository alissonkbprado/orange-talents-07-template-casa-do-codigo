package br.com.zupacademy.alissonprado.casadocodigo.validacao;

import br.com.zupacademy.alissonprado.casadocodigo.repository.AutorRepository;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class EmailAutorUnicoValidator implements ConstraintValidator<EmailAutorUnico, String> {

    AutorRepository autorRepository;

    public EmailAutorUnicoValidator(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public void initialize(EmailAutorUnico constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if (autorRepository.existsByEmail(value))
            return false;

        return true;

    }
}

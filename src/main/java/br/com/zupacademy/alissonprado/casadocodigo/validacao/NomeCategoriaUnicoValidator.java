package br.com.zupacademy.alissonprado.casadocodigo.validacao;

import br.com.zupacademy.alissonprado.casadocodigo.repository.CategoriaRepository;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class NomeCategoriaUnicoValidator implements ConstraintValidator<NomeCategoriaUnico, String> {

    CategoriaRepository categoriaRepository;

    public NomeCategoriaUnicoValidator(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void initialize(NomeCategoriaUnico constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (categoriaRepository.existsByNome(value))
            return false;

        return true;
    }
}

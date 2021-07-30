package br.com.zupacademy.alissonprado.casadocodigo.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = CPF_OR_CNPJValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CPForCNPJ {

    String message() default ("O formato do campo documento (CPF ou CNPJ) está inválido.");

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

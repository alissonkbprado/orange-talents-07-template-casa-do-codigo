package br.com.zupacademy.alissonprado.casadocodigo.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = EmailAutorUnicoValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailAutorUnico {

    String message() default "O e-mail informado já está cadastrado.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

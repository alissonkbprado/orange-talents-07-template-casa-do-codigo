package br.com.zupacademy.alissonprado.casadocodigo.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = ExistIdValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistId {

    String message() default ("O id informado não está cadatrado. Deve ser informado um id já cadastrado no sistema");

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<?> domainClass();

}

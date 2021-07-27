package br.com.zupacademy.alissonprado.casadocodigo.validacao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistIdValidator implements ConstraintValidator<ExistId, Object> {

    private Class<?> klass;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ExistId params) {
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = manager.createQuery("SELECT 1 FROM " + klass.getSimpleName() + " WHERE id = :value");
        query.setParameter("value", Long.parseLong(value.toString()));

        List<?> list = query.getResultList();

        return !list.isEmpty();
    }
}

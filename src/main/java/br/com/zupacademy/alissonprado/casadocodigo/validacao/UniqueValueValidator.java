package br.com.zupacademy.alissonprado.casadocodigo.validacao;

import com.sun.xml.bind.v2.schemagen.episode.Klass;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private String domainAttribute;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(UniqueValue params) {
        domainAttribute = params.fieldName();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

        Query query = manager.createQuery("SELECT 1 FROM " + klass.getSimpleName() + " WHERE " + domainAttribute + "=:value");
        query.setParameter("value", value);

        List<?> list = query.getResultList();

        Assert.state(list.size() <= 1, "Foi encontrado mains de 1 " + klass.getName() + " com o atributo " + domainAttribute);

        return list.isEmpty();

    }
}
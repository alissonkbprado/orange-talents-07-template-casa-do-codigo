package br.com.zupacademy.alissonprado.casadocodigo.validacao;

import br.com.zupacademy.alissonprado.casadocodigo.model.Estado;
import br.com.zupacademy.alissonprado.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.alissonprado.casadocodigo.request.EstadoCadastroRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeNomeEstadoEPaisDuplicadoEstadoValidator implements Validator {

    private EstadoRepository estadoRepository;

    public ProibeNomeEstadoEPaisDuplicadoEstadoValidator(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return EstadoCadastroRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (errors.hasErrors()) {
            return;
        }

        EstadoCadastroRequest request = (EstadoCadastroRequest) target;

        if (request.getIdPais().matches("[0-9]*")) {
            errors.rejectValue("nome", null,
                    "Formato de id inválido.");
            return;
        }

        Estado estado = estadoRepository.findByNomeAndPais_Id(request.getNome(), Long.parseLong(request.getIdPais()));

        if (estado != null) {
            errors.rejectValue("nome", null,
                    "Já existe um Estado cadastrado com o País informado.");
            return;
        }

    }
}
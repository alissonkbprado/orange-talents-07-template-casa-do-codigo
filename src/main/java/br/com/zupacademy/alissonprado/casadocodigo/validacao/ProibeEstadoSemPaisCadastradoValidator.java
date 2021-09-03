package br.com.zupacademy.alissonprado.casadocodigo.validacao;

import br.com.zupacademy.alissonprado.casadocodigo.model.Estado;
import br.com.zupacademy.alissonprado.casadocodigo.model.Pais;
import br.com.zupacademy.alissonprado.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.alissonprado.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.alissonprado.casadocodigo.request.ClienteCadastroRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEstadoSemPaisCadastradoValidator implements Validator {

    private EstadoRepository estadoRepository;
    private PaisRepository paisRepository;

    public ProibeEstadoSemPaisCadastradoValidator(EstadoRepository estadoRepository, PaisRepository paisRepository) {
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {

        return ClienteCadastroRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (errors.hasErrors()) {
            return;
        }

        ClienteCadastroRequest request = (ClienteCadastroRequest) target;

        if(request.getIdEstado() == null|| request.getIdEstado().isBlank())
            return;

        if (!request.getIdEstado().matches("[0-9]*")) {
            errors.rejectValue("idEstado", null,
                    "Formato de id inválido.");
            return;
        }

        Optional<Estado> estadoOptional = estadoRepository.findById(Long.parseLong(request.getIdEstado()));

        if (estadoOptional.isEmpty()) {
            errors.rejectValue("idEstado", null,
                    "Não existe um Estado cadastrado com o idEstado informado.");
            return;
        }

        Estado estado = estadoOptional.get();

        Optional<Pais> pais = paisRepository.findById(Long.parseLong(request.getIdPais()));

        if(!estado.pertenceAPais(pais.get())) {
            errors.rejectValue("idEstado",null,"este estado não é o do país selecionado");
        }

//        Estado estado = estadoRepository.findByNomeAndPais_Id(estadoOptional.get().getNome(), Long.parseLong(request.getIdPais()));
//
//        if (estado == null) {
//            errors.rejectValue("idEstado", null,
//                    "O Estado preenchido não pertence ao País informado.");
//            return;
//        }

    }
}
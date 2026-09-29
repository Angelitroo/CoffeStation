package es.safareyes.coffestation.service;

import es.safareyes.coffestation.model.Alergeno;
import es.safareyes.coffestation.repository.AlergenoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class AlergenoService {

    @Autowired
    private AlergenoRepository alergenoRepository;

    public List<Alergeno> getAllAlergeno(){
        return alergenoRepository.findAll();
    }
}

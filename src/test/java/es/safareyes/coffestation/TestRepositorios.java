package es.safareyes.coffestation;

import es.safareyes.coffestation.model.Alergeno;
import es.safareyes.coffestation.repository.AlergenoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestRepositorios {

    @Autowired
    private AlergenoRepository alergenoRepository;

    @Test
    public void testTabla(){
        List<Alergeno> alergeno = alergenoRepository.findAll();
        alergeno.forEach(System.out::println);

    }
}

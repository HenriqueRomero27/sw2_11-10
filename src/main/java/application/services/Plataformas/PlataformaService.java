package application.services.Plataformas;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import application.model.Plataforma;
import application.record.Plataforma.PlataformaDTO;
import application.repository.PlataformaRepository;

@Service
public class PlataformaService {
    @Autowired
    private PlataformaRepository plataformaRepo;

    public PlataformaDTO getOne(long id) {
        Optional<Plataforma> resultado = plataformaRepo.findById(id);
        if(resultado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plataforma " + id + " não encontrada");
        }
        return new PlataformaDTO(plataformaRepo.findById(id).get());
    }
}

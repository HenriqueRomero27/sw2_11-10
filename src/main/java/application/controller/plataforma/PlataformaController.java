package application.controller.plataforma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Plataforma;
import application.record.Plataforma.PlataformaDTO;
import application.repository.PlataformaRepository;
import application.services.Plataformas.PlataformaService;

@RestController
@RequestMapping("/plataformas")
public class PlataformaController {
    @Autowired
    private PlataformaRepository plataformaRepo;
    private PlataformaService plataformaService;

    @PostMapping    
    public PlataformaDTO insert(@RequestBody PlataformaDTO plataforma) {
        Plataforma nova = plataformaRepo.save(new Plataforma(plataforma));
        return new PlataformaDTO(nova);
    }

    @GetMapping
    public Iterable<Plataforma> list() {
        return plataformaRepo.findAll();
    }
    
}

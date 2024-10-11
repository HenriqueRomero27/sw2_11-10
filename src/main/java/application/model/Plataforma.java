package application.model;

import application.record.Plataforma.PlataformaDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "plataformas")
@Getter
@Setter
public class Plataforma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String nome;

    public Plataforma(PlataformaDTO dados) {
        this.id = dados.id();
        this.nome = dados.nome();
    }
}

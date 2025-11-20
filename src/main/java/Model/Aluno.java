package Model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Aluno extends Usuario {

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @OneToOne(mappedBy = "aluno")
    private Tcc tcc;
}


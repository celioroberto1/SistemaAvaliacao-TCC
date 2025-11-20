package Model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Professor extends Usuario {

    @OneToMany(mappedBy = "orientador")
    private List<Tcc> tccsOrientados;

    @OneToMany(mappedBy = "avaliador")
    private List<Avaliacao> avaliacoes;

    @OneToMany(mappedBy = "coordenador")
    private List<Curso> cursosCoordenados;
}

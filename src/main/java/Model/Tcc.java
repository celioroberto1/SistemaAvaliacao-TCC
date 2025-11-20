package Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Tcc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String resumo;
    private String status;
    private LocalDate dataSubmissao;
    private LocalDate dataDefesa;

    @OneToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_orientador")
    private Orientador orientador;

    @OneToMany(mappedBy = "tcc")
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "tcc")
    private List<VersaoTcc> versoes;

    @OneToMany(mappedBy = "tcc")
    private List<Avaliacao> avaliacoes;
}

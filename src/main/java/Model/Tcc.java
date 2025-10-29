package Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    @OneToOne
    @JoinColumn(name = "id_banca")
    private Banca banca;

    @ManyToOne
    @JoinColumn(name = "fk_professor_id")
    private Professor orientador;

    @OneToMany(mappedBy = "tcc")
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "tcc")
    private List<VersaoTcc> versoes;

    // Getters e setters
}

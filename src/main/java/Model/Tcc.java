package Model;

import jakarta.persistence.*;
import lombok.*;

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

    // Aluno é um usuário
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Usuario aluno;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    // Orientador é um usuário com perfil PROFESSOR
    @ManyToOne
    @JoinColumn(name = "orientador_id")
    private Usuario orientador;

    // Pode haver várias bancas para um TCC
    @OneToMany(mappedBy = "tcc")
    private List<Banca> bancas;

    @OneToMany(mappedBy = "tcc")
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "tcc")
    private List<VersaoTcc> versoes;

    @OneToMany(mappedBy = "tcc")
    private List<Prazo> prazos;
}

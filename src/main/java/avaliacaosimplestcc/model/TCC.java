package avaliacaosimplestcc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tcc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TCC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String titulo;


    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Usuario aluno;


    @ManyToOne
    @JoinColumn(name = "orientador_id")
    private Usuario orientador;


    @ManyToOne
    @JoinColumn(name = "avaliador_id")
    private Usuario avaliador;


    @OneToOne
    @JoinColumn(name = "banca_id")
    private Banca banca;


    @OneToMany(mappedBy = "tcc")
    private List<Prazo> prazos;


    @OneToMany(mappedBy = "tcc")
    private List<VersaoTcc> versoes;


    @OneToMany(mappedBy = "tcc")
    private List<Feedback> feedbacks;
}
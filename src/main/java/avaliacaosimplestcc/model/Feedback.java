package avaliacaosimplestcc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "feedback")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String comentario;


    @ManyToOne
    @JoinColumn(name = "avaliador_id")
    private Usuario avaliador;


    @ManyToOne
    @JoinColumn(name = "tcc_id")
    private TCC tcc;
}
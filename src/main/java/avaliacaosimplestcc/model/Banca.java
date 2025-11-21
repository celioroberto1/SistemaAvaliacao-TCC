package avaliacaosimplestcc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "banca")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Banca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String descricao;


    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;


    @OneToMany(mappedBy = "banca")
    private List<BancaUsuario> usuarios;


    @OneToOne(mappedBy = "banca")
    private TCC tcc;
}

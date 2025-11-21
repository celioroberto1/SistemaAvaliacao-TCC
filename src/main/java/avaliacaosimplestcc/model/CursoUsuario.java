package avaliacaosimplestcc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "curso_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CursoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}

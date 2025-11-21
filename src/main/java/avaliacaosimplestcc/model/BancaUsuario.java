package avaliacaosimplestcc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "banca_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BancaUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "banca_id")
    private Banca banca;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
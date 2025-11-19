package Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome; 
    // Exemplo: "ALUNO", "PROFESSOR", "ORIENTADOR", "AVALIADOR", "COORDENADOR", "ADMIN"
}

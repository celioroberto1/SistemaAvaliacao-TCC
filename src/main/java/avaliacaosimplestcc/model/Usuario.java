package avaliacaosimplestcc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String nome;


    @Column(nullable = false, unique = true)
    private String email;


    @Column(nullable = false)
    private String senha;


    @OneToMany(mappedBy = "usuario")
    private List<UsuarioPerfil> perfis;


    @OneToMany(mappedBy = "usuario")
    private List<CursoUsuario> cursos;


    @OneToMany(mappedBy = "usuario")
    private List<BancaUsuario> bancas;


    @OneToMany(mappedBy = "aluno")
    private List<TCC> tccsComoAluno;


    @OneToMany(mappedBy = "orientador")
    private List<TCC> tccsComoOrientador;


    @OneToMany(mappedBy = "avaliador")
    private List<TCC> tccsComoAvaliador;
}

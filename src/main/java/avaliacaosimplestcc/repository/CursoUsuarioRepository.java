package avaliacaosimplestcc.repository;

import avaliacaosimplestcc.model.CursoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoUsuarioRepository extends JpaRepository<CursoUsuario, Long> {
}


package avaliacaosimplestcc.repository;
import avaliacaosimplestcc.model.BancaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancaUsuarioRepository extends JpaRepository<BancaUsuario, Long> {
}


package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
}

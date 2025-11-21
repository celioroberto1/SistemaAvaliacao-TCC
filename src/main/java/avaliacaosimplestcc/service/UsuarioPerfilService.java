package avaliacaosimplestcc.service;
import avaliacaosimplestcc.model.UsuarioPerfil;
import avaliacaosimplestcc.repository.UsuarioPerfilRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioPerfilService {

    private final UsuarioPerfilRepository repository;

    public UsuarioPerfilService(UsuarioPerfilRepository repository) {
        this.repository = repository;
    }

    public UsuarioPerfil salvar(UsuarioPerfil usuarioPerfil) {
        return repository.save(usuarioPerfil);
    }

    public List<UsuarioPerfil> listarTodos() {
        return repository.findAll();
    }

    public UsuarioPerfil buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relação UsuarioPerfil não encontrada!"));
    }

    public UsuarioPerfil atualizar(Long id, UsuarioPerfil atualizado) {
        UsuarioPerfil existente = buscarPorId(id);

        existente.setUsuario(atualizado.getUsuario());
        existente.setPerfil(atualizado.getPerfil());

        return repository.save(existente);
    }

    public void deletar(Long id) {
        UsuarioPerfil existente = buscarPorId(id);
        repository.delete(existente);
    }
}


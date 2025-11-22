package avaliacaosimplestcc.service;

import avaliacaosimplestcc.model.CursoUsuario;
import avaliacaosimplestcc.repository.CursoUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoUsuarioService {

    private final CursoUsuarioRepository repository;

    public CursoUsuarioService(CursoUsuarioRepository repository) {
        this.repository = repository;
    }

    // Salvar
    public CursoUsuario salvar(CursoUsuario entity) {
        return repository.save(entity);
    }

    // Listar todos
    public List<CursoUsuario> listarTodos() {
        return repository.findAll();
    }

    // Buscar por ID
    public CursoUsuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("CursoUsuario não encontrado com id " + id));
    }

    // Atualizar
    public CursoUsuario atualizar(Long id, CursoUsuario atualizado) {
        CursoUsuario existente = buscarPorId(id);
        existente.setCurso(atualizado.getCurso());
        existente.setUsuario(atualizado.getUsuario());
        return repository.save(existente);
    }

    // Deletar
    public void deletar(Long id) {
        CursoUsuario existente = buscarPorId(id);
        repository.delete(existente);
    }
}


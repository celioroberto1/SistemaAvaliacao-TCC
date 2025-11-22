package avaliacaosimplestcc.service;

import avaliacaosimplestcc.model.BancaUsuario;
import avaliacaosimplestcc.repository.BancaUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancaUsuarioService {

    private final BancaUsuarioRepository repository;

    public BancaUsuarioService(BancaUsuarioRepository repository) {
        this.repository = repository;
    }

    public BancaUsuario salvar(BancaUsuario entity) {
        return repository.save(entity);
    }

    public List<BancaUsuario> listarTodos() {
        return repository.findAll();
    }

    public BancaUsuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("BancaUsuario não encontrado com id: " + id));
    }

    public BancaUsuario atualizar(Long id, BancaUsuario entity) {
        BancaUsuario existente = buscarPorId(id);
        existente.setBanca(entity.getBanca());
        existente.setUsuario(entity.getUsuario());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

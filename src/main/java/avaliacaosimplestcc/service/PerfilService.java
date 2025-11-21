package avaliacaosimplestcc.service;

import avaliacaosimplestcc.model.Perfil;
import avaliacaosimplestcc.repository.PerfilRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    // Criar perfil
    public Perfil salvar(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    // Listar todos
    public List<Perfil> listarTodos() {
        return perfilRepository.findAll();
    }

    // Buscar por ID
    public Perfil buscarPorId(Long id) {
        return perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado!"));
    }

    // Atualizar
    public Perfil atualizar(Long id, Perfil perfilAtualizado) {
        Perfil perfil = buscarPorId(id);
        perfil.setNome(perfilAtualizado.getNome());
        return perfilRepository.save(perfil);
    }

    // Deletar
    public void deletar(Long id) {
        Perfil perfil = buscarPorId(id);
        perfilRepository.delete(perfil);
    }
}

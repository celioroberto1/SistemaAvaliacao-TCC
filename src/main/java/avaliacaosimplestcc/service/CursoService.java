package avaliacaosimplestcc.service;

import avaliacaosimplestcc.model.Curso;
import avaliacaosimplestcc.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public Curso salvar(Curso curso) {
        return repository.save(curso);
    }

    public List<Curso> listar() {
        return repository.findAll();
    }

    public Curso buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado!"));
    }

    public Curso atualizar(Long id, Curso dados) {
        Curso curso = buscarPorId(id);
        curso.setNome(dados.getNome());
        return repository.save(curso);
    }

    public void deletar(Long id) {
        Curso curso = buscarPorId(id);
        repository.delete(curso);
    }
}

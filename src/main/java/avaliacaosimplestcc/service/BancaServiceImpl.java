package avaliacaosimplestcc.service;
import avaliacaosimplestcc.model.Banca;
import avaliacaosimplestcc.repository.BancaRepository;
import avaliacaosimplestcc.service.BancaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancaServiceImpl implements BancaService {

    private final BancaRepository repository;

    public BancaServiceImpl(BancaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Banca salvar(Banca banca) {
        return repository.save(banca);
    }

    @Override
    public List<Banca> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Banca buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Banca não encontrada: " + id));
    }

    @Override
    public Banca atualizar(Long id, Banca banca) {
        Banca existente = buscarPorId(id);
        existente.setDescricao(banca.getDescricao());
        existente.setCurso(banca.getCurso());
        return repository.save(existente);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

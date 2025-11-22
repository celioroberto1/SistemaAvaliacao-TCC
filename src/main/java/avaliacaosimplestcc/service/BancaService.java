package avaliacaosimplestcc.service;

import avaliacaosimplestcc.model.Banca;

import java.util.List;

public interface BancaService {
    Banca salvar(Banca banca);
    List<Banca> listarTodos();
    Banca buscarPorId(Long id);
    Banca atualizar(Long id, Banca banca);
    void deletar(Long id);
}

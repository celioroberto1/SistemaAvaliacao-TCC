package avaliacaosimplestcc.service;

import avaliacaosimplestcc.model.Feedback;
import avaliacaosimplestcc.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    // Criar feedback
    public Feedback salvar(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    // Listar todos
    public List<Feedback> listarTodos() {
        return feedbackRepository.findAll();
    }

    // Buscar por ID
    public Feedback buscarPorId(Long id) {
        return feedbackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback não encontrado!"));
    }

    // Atualizar
    public Feedback atualizar(Long id, Feedback feedbackAtualizado) {
        Feedback feedback = buscarPorId(id);
        feedback.setComentario(feedbackAtualizado.getComentario());
        feedback.setAvaliador(feedbackAtualizado.getAvaliador());
        feedback.setTcc(feedbackAtualizado.getTcc());
        return feedbackRepository.save(feedback);
    }

    // Deletar
    public void deletar(Long id) {
        Feedback feedback = buscarPorId(id);
        feedbackRepository.delete(feedback);
    }
}

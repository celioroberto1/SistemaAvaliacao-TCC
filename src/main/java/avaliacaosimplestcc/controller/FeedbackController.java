package avaliacaosimplestcc.controller;

import avaliacaosimplestcc.DTO.FeedbackDTO;
import avaliacaosimplestcc.mapper.FeedbackMapper;
import avaliacaosimplestcc.model.Feedback;
import avaliacaosimplestcc.service.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    private final FeedbackService feedbackService;
    private final FeedbackMapper feedbackMapper;

    public FeedbackController(FeedbackService feedbackService, FeedbackMapper feedbackMapper) {
        this.feedbackService = feedbackService;
        this.feedbackMapper = feedbackMapper;
    }

    // POST - Criar Feedback
    @PostMapping
    public ResponseEntity<FeedbackDTO> criar(@RequestBody FeedbackDTO dto) {
        Feedback feedback = feedbackMapper.toEntity(dto);
        Feedback salvo = feedbackService.salvar(feedback);
        return ResponseEntity.ok(feedbackMapper.toDTO(salvo));
    }

    // GET - Listar todos
    @GetMapping
    public ResponseEntity<List<FeedbackDTO>> listar() {
        List<FeedbackDTO> lista = feedbackService.listarTodos()
                .stream()
                .map(feedbackMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    // GET - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<FeedbackDTO> buscarPorId(@PathVariable Long id) {
        Feedback feedback = feedbackService.buscarPorId(id);
        return ResponseEntity.ok(feedbackMapper.toDTO(feedback));
    }

    // PUT - Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<FeedbackDTO> atualizar(@PathVariable Long id, @RequestBody FeedbackDTO dto) {
        Feedback feedbackAtualizado = feedbackMapper.toEntity(dto);
        Feedback atualizado = feedbackService.atualizar(id, feedbackAtualizado);
        return ResponseEntity.ok(feedbackMapper.toDTO(atualizado));
    }

    // DELETE - Remover
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        feedbackService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

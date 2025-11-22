package avaliacaosimplestcc.controller;
import avaliacaosimplestcc.DTO.BancaDTO;
import avaliacaosimplestcc.mapper.BancaMapper;
import avaliacaosimplestcc.model.Banca;
import avaliacaosimplestcc.service.BancaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bancas")
public class BancaController {

    private final BancaService service;
    private final BancaMapper mapper;

    public BancaController(BancaService service, BancaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<BancaDTO> criar(@RequestBody BancaDTO dto) {
        Banca banca = mapper.toEntity(dto);
        Banca salvo = service.salvar(banca);
        return ResponseEntity.ok(mapper.toDTO(salvo));
    }

    @GetMapping
    public ResponseEntity<List<BancaDTO>> listar() {
        List<BancaDTO> lista = service.listarTodos()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BancaDTO> buscar(@PathVariable Long id) {
        Banca banca = service.buscarPorId(id);
        return ResponseEntity.ok(mapper.toDTO(banca));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BancaDTO> atualizar(@PathVariable Long id, @RequestBody BancaDTO dto) {
        Banca atualizado = service.atualizar(id, mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDTO(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}


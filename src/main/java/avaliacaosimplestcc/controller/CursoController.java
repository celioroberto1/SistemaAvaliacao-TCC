package avaliacaosimplestcc.controller;

import avaliacaosimplestcc.DTO.CursoDTO;
import avaliacaosimplestcc.mapper.CursoMapper;
import avaliacaosimplestcc.model.Curso;
import avaliacaosimplestcc.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService service;
    private final CursoMapper mapper;

    public CursoController(CursoService service, CursoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<CursoDTO> criar(@RequestBody CursoDTO dto) {
        Curso curso = mapper.toEntity(dto);
        Curso salvo = service.salvar(curso);
        return ResponseEntity.ok(mapper.toDTO(salvo));
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> listar() {
        List<CursoDTO> cursos = service.listar()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> buscar(@PathVariable Long id) {
        Curso curso = service.buscarPorId(id);
        return ResponseEntity.ok(mapper.toDTO(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> atualizar(@PathVariable Long id, @RequestBody CursoDTO dto) {
        Curso atualizado = service.atualizar(id, mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDTO(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

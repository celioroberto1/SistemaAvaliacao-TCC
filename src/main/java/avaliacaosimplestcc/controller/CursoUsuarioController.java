package avaliacaosimplestcc.controller;

import avaliacaosimplestcc.DTO.CursoUsuarioDTO;
import avaliacaosimplestcc.mapper.CursoUsuarioMapper;
import avaliacaosimplestcc.model.CursoUsuario;
import avaliacaosimplestcc.service.CursoUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/curso-usuarios")
public class CursoUsuarioController {

    private final CursoUsuarioService service;
    private final CursoUsuarioMapper mapper;

    public CursoUsuarioController(CursoUsuarioService service, CursoUsuarioMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    // POST - Criar CursoUsuario
    @PostMapping
    public ResponseEntity<CursoUsuarioDTO> criar(@RequestBody CursoUsuarioDTO dto) {
        CursoUsuario entity = mapper.toEntity(dto);
        CursoUsuario salvo = service.salvar(entity);
        return ResponseEntity.ok(mapper.toDTO(salvo));
    }

    // GET - Listar todos
    @GetMapping
    public ResponseEntity<List<CursoUsuarioDTO>> listar() {
        List<CursoUsuarioDTO> lista = service.listarTodos()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    // GET - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<CursoUsuarioDTO> buscarPorId(@PathVariable Long id) {
        CursoUsuario entity = service.buscarPorId(id);
        return ResponseEntity.ok(mapper.toDTO(entity));
    }

    // PUT - Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<CursoUsuarioDTO> atualizar(@PathVariable Long id, @RequestBody CursoUsuarioDTO dto) {
        CursoUsuario atualizado = mapper.toEntity(dto);
        CursoUsuario salvo = service.atualizar(id, atualizado);
        return ResponseEntity.ok(mapper.toDTO(salvo));
    }

    // DELETE - Remover
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}


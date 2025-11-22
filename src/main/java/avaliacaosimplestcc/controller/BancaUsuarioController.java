package avaliacaosimplestcc.controller;
import avaliacaosimplestcc.DTO.BancaUsuarioDTO;
import avaliacaosimplestcc.mapper.BancaUsuarioMapper;
import avaliacaosimplestcc.model.BancaUsuario;
import avaliacaosimplestcc.service.BancaUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/banca-usuarios")
public class BancaUsuarioController {

    private final BancaUsuarioService service;
    private final BancaUsuarioMapper mapper;

    public BancaUsuarioController(BancaUsuarioService service, BancaUsuarioMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<BancaUsuarioDTO> criar(@RequestBody BancaUsuarioDTO dto) {
        BancaUsuario entity = mapper.toEntity(dto);
        BancaUsuario salvo = service.salvar(entity);
        return ResponseEntity.ok(mapper.toDTO(salvo));
    }

    @GetMapping
    public ResponseEntity<List<BancaUsuarioDTO>> listar() {
        List<BancaUsuarioDTO> lista = service.listarTodos()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BancaUsuarioDTO> buscarPorId(@PathVariable Long id) {
        BancaUsuario entity = service.buscarPorId(id);
        return ResponseEntity.ok(mapper.toDTO(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BancaUsuarioDTO> atualizar(@PathVariable Long id, @RequestBody BancaUsuarioDTO dto) {
        BancaUsuario atualizado = mapper.toEntity(dto);
        BancaUsuario salvo = service.atualizar(id, atualizado);
        return ResponseEntity.ok(mapper.toDTO(salvo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

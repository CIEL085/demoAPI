import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService = new CategoriaService();

    // Criar uma nova categoria
    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaService.criarCategoria(categoriaDTO.getNome(), categoriaDTO.getDescricao());
        return ResponseEntity.ok(categoria);
    }

    // Listar todas as categorias
    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodas() {
        return ResponseEntity.ok(categoriaService.listarTodas());
    }

    // Buscar categoria por ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }

    // Atualizar categoria por ID
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoriaAtualizada = categoriaService.atualizarCategoria(id, categoriaDTO.getNome(), categoriaDTO.getDescricao());
        return ResponseEntity.ok(categoriaAtualizada);
    }

    // Deletar categoria por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}

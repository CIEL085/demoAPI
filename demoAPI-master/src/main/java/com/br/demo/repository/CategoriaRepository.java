import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriaRepository {
    private List<Categoria> categorias = new ArrayList<>();
    private Long proximoId = 1L;

    // Adicionar uma nova categoria
    public Categoria adicionarCategoria(Categoria categoria) {
        categoria.setId(proximoId++);
        categorias.add(categoria);
        return categoria;
    }

    // Buscar uma categoria por ID
    public Optional<Categoria> buscarPorId(Long id) {
        return categorias.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    // Listar todas as categorias
    public List<Categoria> listarTodas() {
        return new ArrayList<>(categorias);
    }

    // Atualizar uma categoria existente
    public boolean atualizarCategoria(Categoria categoriaAtualizada) {
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).getId().equals(categoriaAtualizada.getId())) {
                categorias.set(i, categoriaAtualizada);
                return true;
            }
        }
        return false;
    }

    // Remover uma categoria
    public boolean removerCategoria(Long id) {
        return categorias.removeIf(c -> c.getId().equals(id));
    }
}

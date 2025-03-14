import java.util.List;
import java.util.Optional;

public class CategoriaService {
    private CategoriaRepository categoriaRepository = new CategoriaRepository();

    public Categoria criarCategoria(String nome, String descricao) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome da categoria não pode ser nulo ou vazio.");
        }
        Categoria categoria = new Categoria(null, nome, descricao);
        return categoriaRepository.adicionarCategoria(categoria);
    }

    public Categoria buscarPorId(Long id) {
        Optional<Categoria> categoria = categoriaRepository.buscarPorId(id);
        return categoria.orElseThrow(() -> new RuntimeException("Categoria não encontrada para o ID: " + id));
    }

    public List<Categoria> listarTodas() {
        return categoriaRepository.listarTodas();
    }

    public Categoria atualizarCategoria(Long id, String nome, String descricao) {
        Categoria categoriaExistente = buscarPorId(id);
        categoriaExistente.setNome(nome);
        categoriaExistente.setDescricao(descricao);

        boolean atualizado = categoriaRepository.atualizarCategoria(categoriaExistente);
        if (!atualizado) {
            throw new RuntimeException("Erro ao atualizar categoria.");
        }
        return categoriaExistente;
    }

    public void deletarCategoria(Long id) {
        boolean removido = categoriaRepository.removerCategoria(id);
        if (!removido) {
            throw new RuntimeException("Erro ao remover categoria. ID não encontrado.");
        }
    }
}

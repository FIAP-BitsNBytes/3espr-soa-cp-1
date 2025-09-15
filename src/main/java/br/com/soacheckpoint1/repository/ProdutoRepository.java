package br.com.soacheckpoint1.repository;

import br.com.soacheckpoint1.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByCategoria(String categoria);
    List<Produto> findByAtivo(Boolean ativo);
}

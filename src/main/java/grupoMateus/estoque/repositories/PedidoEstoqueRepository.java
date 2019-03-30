package grupoMateus.estoque.repositories;

import grupoMateus.estoque.models.PedidoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoEstoqueRepository extends JpaRepository<PedidoEstoque, Long> {

}

package grupoMateus.estoque.repositories;

import grupoMateus.estoque.models.TipoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPedidoRepository extends JpaRepository<TipoPedido, Long> {

}

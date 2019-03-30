package grupoMateus.estoque.repositories;


import grupoMateus.estoque.models.ItemPedidoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoEstoqueRepository  extends JpaRepository<ItemPedidoEstoque, Long> {

}

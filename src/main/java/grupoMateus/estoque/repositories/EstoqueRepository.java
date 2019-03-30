package grupoMateus.estoque.repositories;

import grupoMateus.estoque.models.Estoque;
import grupoMateus.estoque.models.Filial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstoqueRepository  extends JpaRepository<Estoque, Long> {


}

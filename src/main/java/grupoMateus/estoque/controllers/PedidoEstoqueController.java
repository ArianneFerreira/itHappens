package grupoMateus.estoque.controllers;

import grupoMateus.estoque.models.PedidoEstoque;
import grupoMateus.estoque.repositories.PedidoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PedidoEstoqueController {

    @Autowired
    private PedidoEstoqueRepository pedidoEstoqueRepository;

    @RequestMapping(value = "/pedidos-estoques", method = RequestMethod.POST)
    public void salvar(@RequestBody PedidoEstoque pedidoEstoque){
        pedidoEstoqueRepository.save(pedidoEstoque);
    }

    @RequestMapping(value = "/pedidos-estoques")
    public Object buscar(){
        return pedidoEstoqueRepository.findAll();
    }

    @RequestMapping(value = "/pedidos-estoques/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable("id") long id){
        pedidoEstoqueRepository.deleteById(id);
    }


}

package grupoMateus.estoque.controllers;

import grupoMateus.estoque.models.ItemPedidoEstoque;
import grupoMateus.estoque.repositories.ItemPedidoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemPedidoEstoqueController {

    @Autowired
    private ItemPedidoEstoqueRepository itemPedidoEstoqueRepository;


    @RequestMapping(value = "/itens-pedidos-estoques", method = RequestMethod.POST)
    public void salvar(@RequestBody ItemPedidoEstoque itemPedidoEstoque){
        itemPedidoEstoqueRepository.save(itemPedidoEstoque);
    }

    @RequestMapping(value = "/itens-pedidos-estoques")
    public Object buscar(){
        return itemPedidoEstoqueRepository.findAll();
    }

    @RequestMapping(value = "/itens-pedidos-estoques/{id}", method = RequestMethod.PUT)
    public void atualizar(@PathVariable("id") Long id, @RequestBody ItemPedidoEstoque itemPedidoEstoque) throws Exception{

        ItemPedidoEstoque itemPedidoEstoque1 = itemPedidoEstoqueRepository.findById(id).get();

        if( itemPedidoEstoque1 == null){
            throw new Exception("/itens-pedidos-estoques não encontrado!");
        }

        itemPedidoEstoque1.setQuantidade(itemPedidoEstoque.getQuantidade());

        itemPedidoEstoqueRepository.save(itemPedidoEstoque1);
    }


    @RequestMapping(value = "/itens-pedidos-estoques/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable("id") Long id){
        itemPedidoEstoqueRepository.deleteById(id);
    }
}

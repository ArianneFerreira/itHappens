package grupoMateus.estoque.controllers;

import grupoMateus.estoque.models.TipoPedido;
import grupoMateus.estoque.repositories.TipoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TipoPedidoController {

    @Autowired
    private TipoPedidoRepository tipoPedidoRepository;

    @RequestMapping(value = "/tipos-pedidos", method = RequestMethod.POST)
    public void salvar(@RequestBody TipoPedido tipoPedido){
        tipoPedidoRepository.save(tipoPedido);
    }

    @RequestMapping(value = "/tipos-pedidos")
    public Object buscar(){
        return tipoPedidoRepository.findAll();
    }

    @RequestMapping(value = "/tipos-pedidos/{id}", method = RequestMethod.PUT)
    public void atualizar(@PathVariable("id") Long id, @RequestBody TipoPedido tipoPedido) throws Exception{
        TipoPedido tipoPedido1 = tipoPedidoRepository.findById(id).get();

        if(tipoPedido1 == null){
            throw new Exception("Tipo de Pedido não encontrado!");
        }

        tipoPedido1.setDescricao(tipoPedido.getDescricao());

        tipoPedidoRepository.save(tipoPedido);

    }

    @RequestMapping(value = "/tipos-pedidos/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable("id") Long id){
        tipoPedidoRepository.deleteById(id);
    }

}

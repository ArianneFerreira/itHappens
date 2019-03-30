package grupoMateus.estoque.controllers;


import grupoMateus.estoque.models.Produto;
import grupoMateus.estoque.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @RequestMapping(value = "/produtos", method = RequestMethod.POST)
    public void salvar(@RequestBody Produto produto){
        produtoRepository.save(produto);
    }

    @RequestMapping(value = "/produtos")
    public Object buscar(){
        return produtoRepository.findAll();
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.PUT)
    public void atualizar(@PathVariable("id") Long id, @RequestBody Produto produto) throws Exception{

        Produto produto1 = produtoRepository.findById(id).get();

        if( produto1 == null){
            throw new Exception("Produto não encontrado!");
        }

        produto1.setDescricao(produto.getDescricao());

        produtoRepository.save(produto1);
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable("id") Long id){
        produtoRepository.deleteById(id);
    }

}

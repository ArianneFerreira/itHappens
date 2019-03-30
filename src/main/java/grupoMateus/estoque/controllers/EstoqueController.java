package grupoMateus.estoque.controllers;

import grupoMateus.estoque.models.Estoque;
import grupoMateus.estoque.models.Filial;
import grupoMateus.estoque.models.Produto;
import grupoMateus.estoque.repositories.EstoqueRepository;
import grupoMateus.estoque.repositories.FilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private FilialRepository filialRepository;

    @RequestMapping(value = "/estoques", method = RequestMethod.POST)
    public void salvar(@RequestBody Estoque estoque){
        estoqueRepository.save(estoque);
    }

    @RequestMapping(value = "/estoques")
    public Object buscar(){
        return estoqueRepository.findAll();
    }


    @RequestMapping(value = "/estoques/{filial}")
    public Object findByFilial(@PathVariable("filial") Long idFilial) {
        Filial filial = this.filialRepository.findById(idFilial).get();
        List<Produto> produtosEstoque = this.estoqueRepository.findAllByFilial(filial)
                .stream() .map(Estoque::getProduto)
                .collect(Collectors.toList());
        return produtosEstoque;
    }



    @RequestMapping(value = "/estoques/greaterequalthen/{quantidade}")
    public Object findAllGreaterOrEqualThen(@PathVariable("quantidade") int quantidadeTotal) {
        List<Produto> produtosEstoque = this.estoqueRepository .findAllByQuantidadeTotalGreaterThanEqual(quantidadeTotal)
                .stream() .map(Estoque::getProduto) .collect(Collectors.toList());
        return produtosEstoque;
    }


   @RequestMapping(value = "/estoques/{id}", method = RequestMethod.PUT)
    public void atualizar(@PathVariable("id") Long id, @RequestBody Estoque estoque) throws Exception{

        Estoque estoque1 =  estoqueRepository.findById(id).get();

        if( estoque1 == null){
            throw new Exception("Estoque não encontrado!");
        }

        estoque1.setFilial(estoque.getFilial());
        estoque1.setProduto(estoque.getProduto());
        estoque1.setQuantidadeTotal(estoque1.getQuantidadeTotal());

        estoqueRepository.save(estoque1);

    }

    @RequestMapping(value = "/estoques/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable("id") Long id){
        estoqueRepository.deleteById(id);
    }

}

package grupoMateus.estoque.controllers;


import grupoMateus.estoque.models.Filial;
import grupoMateus.estoque.repositories.FilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FilialController {

    @Autowired
    private FilialRepository filialRepository;

    @RequestMapping(value = "/filiais", method = RequestMethod.POST)
    public void salvar(@RequestBody Filial filial){
        filialRepository.save(filial);
    }

    @RequestMapping(value = "/filiais")
    public Object buscar(){
        return filialRepository.findAll();
    }

    @RequestMapping(value = "/filiais/{id}", method = RequestMethod.PUT)
    public void atualizar(@PathVariable("id") Long id, @RequestBody Filial filial) throws  Exception{
        Filial filial1 = filialRepository.findById(id).get();

        if(filial1 == null){
            throw new Exception("Filial não encontrada!");
        }

        filial.setDescricao(filial.getDescricao());

        filialRepository.save(filial1);

    }


    @RequestMapping(value = "/filiais/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable("id") Long id){
        filialRepository.deleteById(id);

    }




}

package grupoMateus.estoque.controllers;


import grupoMateus.estoque.models.Filial;
import grupoMateus.estoque.repositories.FilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilialController {

    @Autowired
    private FilialRepository filialRepository;

    @RequestMapping(value = "/filiais")
    public void salvar(@RequestBody Filial filial){
        filialRepository.save(filial);
    }




}

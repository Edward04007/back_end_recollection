package com.recollection.back_end_recollection.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.recollection.back_end_recollection.Model.Model_API;
import com.recollection.back_end_recollection.Repository.Repository_Recollection;

@CrossOrigin(origins = {
    "http://localhost:3000/",
    "https://front-end-recollection.vercel.app"
} , maxAge = 3600)
@RestController
@RequestMapping(value = "/api")
public class Controller_API {
    
    @Autowired
    Repository_Recollection repository;

    @GetMapping("/questions")
    public List<Model_API> ShowAll(){

        return repository.findAll();
        /* Listar todos os atributos */

    }

    @GetMapping("/questions/{id}")
    public Model_API ShowOne(@PathVariable(value="id") long id){

        return repository.findById(id);
         /* Consultar um único atribuito */
    }

    @PostMapping("/save")
    public Model_API Create(@RequestBody Model_API model ) {

        return repository.save(model);
        /* Criar novo atributo */

    }

    @DeleteMapping("/delete")
    public void Delete(@RequestBody Model_API model) {

        repository.delete(model);
        /* Deleta um único atributo */
    }

    @PutMapping("/update")
    public Model_API Update(@RequestBody Model_API model) {

        return repository.save(model);
        /* Atualizar atributo */
    }

}

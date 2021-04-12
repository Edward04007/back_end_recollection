package com.recollection.back_end_recollection.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.recollection.back_end_recollection.Model.Model_API;
import com.recollection.back_end_recollection.Model.Model_API_Page;
import com.recollection.back_end_recollection.Repository.Repository_Recollection;
import com.recollection.back_end_recollection.Service.Service_API;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
@Api(value = "API REST Recollection")
public class Controller_API {
    
    @Autowired
    Repository_Recollection repository;

    private final Service_API service_API;

    public Controller_API(Service_API service_API) {
        this.service_API = service_API;
    }

    @GetMapping
    @ApiOperation(value = "Listar todos atributos")
    public ResponseEntity<Page<Model_API>> getModel_API(Model_API_Page model_API_Page){

        return new ResponseEntity<>(service_API.getModel_API(model_API_Page), HttpStatus.OK);

    }

    @PostMapping
    @ApiOperation(value = "Salvar atributo")
    public ResponseEntity<Model_API> addModelApi( @RequestBody Model_API model_API){

        return new ResponseEntity<>(service_API.addApi(model_API), HttpStatus.CREATED);
    } 

    @DeleteMapping("/delete")
    @ApiOperation(value = "Deletar atributo")
    public void Delete(@RequestBody Model_API model) {

        repository.delete(model);
        /* Deleta um único atributo */
    }

    @PutMapping("/update")
    @ApiOperation(value = "Atualizar atributo")
    public Model_API Update(@RequestBody Model_API model) {

        return repository.save(model);
        /* Atualizar atributo */
    }


}

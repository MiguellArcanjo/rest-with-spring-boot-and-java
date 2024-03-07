package br.com.erudio.restwithspringbootandjava.controllers;

import br.com.erudio.restwithspringbootandjava.data.vo.v1.PersonVO;
import br.com.erudio.restwithspringbootandjava.data.vo.v2.PersonVOV2;
import br.com.erudio.restwithspringbootandjava.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonService service;
//    private PersonService service = new PersonService();

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<PersonVO> findAll(){

        return service.findALl();
    }
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public PersonVO findById(@PathVariable(value = "id") Long id) throws Exception{

        return service.findById(id);
    }
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public PersonVO create(@RequestBody PersonVO person) throws Exception{

        return service.create(person);
    }

    @PostMapping(value = "/v2",produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public PersonVOV2 createV2(@RequestBody PersonVOV2 person) throws Exception{

        return service.createV2(person);
    }
    @PutMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public PersonVO update(@RequestBody PersonVO person) throws Exception{

        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

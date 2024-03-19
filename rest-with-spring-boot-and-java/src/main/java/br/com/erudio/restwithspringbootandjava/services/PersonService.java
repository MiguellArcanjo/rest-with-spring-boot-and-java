package br.com.erudio.restwithspringbootandjava.services;

import br.com.erudio.restwithspringbootandjava.controllers.PersonController;
import br.com.erudio.restwithspringbootandjava.data.vo.v1.PersonVO;
import br.com.erudio.restwithspringbootandjava.exceptions.RequiredObjectIsNullException;
import br.com.erudio.restwithspringbootandjava.exceptions.ResourceNotFoundException;
import br.com.erudio.restwithspringbootandjava.mapper.DozerMapper;
import br.com.erudio.restwithspringbootandjava.mapper.custom.PersonMapper;
import br.com.erudio.restwithspringbootandjava.model.Person;
import br.com.erudio.restwithspringbootandjava.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PagedResourcesAssembler<PersonVO> assembler;

    @Autowired
    PersonMapper mapper;

    public PagedModel<EntityModel<PersonVO>> findALl(Pageable pageable) {

        var personPage = repository.findAll(pageable);

        var personVosPage =  personPage.map(p -> DozerMapper.parseObject(p, PersonVO.class));

        personVosPage.map(p -> {
            try {
                return p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        Link link = linkTo(methodOn(PersonController.class).findAll(pageable.getPageNumber(), pageable.getPageSize(), "asc")).withSelfRel();
        return assembler.toModel(personVosPage, link);
    }

    public PersonVO findById(Long id) throws Exception {

        logger.info("Finding one person!");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        var vo = DozerMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;
    }

    public PersonVO create(PersonVO person) throws Exception {
        logger.info("Creating one person!");

        if (person == null) throw new RequiredObjectIsNullException();

        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

//
//    public PersonVOV2 createV2(PersonVOV2 person) {
//        logger.info("Creating one person with v2!");
//
//        var entity = mapper.convertVoToEntity(person);
//
//        var vo = mapper.convertEntityToVo(repository.save(entity));
//        return vo;
//    }

    public PersonVO update(PersonVO person) throws Exception {
        logger.info("Creating one person!");

        if (person == null) throw new RequiredObjectIsNullException();

        var entity = repository.findById(person.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }
    public void delete(Long id) {
        logger.info("Deleting one person!");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);
    }

    @Transactional
    public PersonVO disablePerson(Long id) throws Exception {

        logger.info("Disablind one person!");

        repository.disablePerson(id);

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        var vo = DozerMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;
    }


}

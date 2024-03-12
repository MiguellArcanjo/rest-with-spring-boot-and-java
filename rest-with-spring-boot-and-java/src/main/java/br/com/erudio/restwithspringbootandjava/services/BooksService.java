package br.com.erudio.restwithspringbootandjava.services;

import br.com.erudio.restwithspringbootandjava.controllers.BooksController;
import br.com.erudio.restwithspringbootandjava.data.vo.v1.BooksVO;
import br.com.erudio.restwithspringbootandjava.data.vo.v1.PersonVO;
import br.com.erudio.restwithspringbootandjava.exceptions.RequiredObjectIsNullException;
import br.com.erudio.restwithspringbootandjava.exceptions.ResourceNotFoundException;
import br.com.erudio.restwithspringbootandjava.mapper.DozerMapper;
import br.com.erudio.restwithspringbootandjava.mapper.custom.BooksMapper;
import br.com.erudio.restwithspringbootandjava.model.Books;
import br.com.erudio.restwithspringbootandjava.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BooksService {

    @Autowired
    private BooksRepository repository;

    public List<BooksVO> findALl() {
        var books = DozerMapper.parseListObjects(repository.findAll(), BooksVO.class);

        books.stream().forEach(b -> {
            try {
                b.add(linkTo(methodOn(BooksController.class).findById(b.getKey())).withSelfRel());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        return books;
    }

    public BooksVO findById(Long id) throws Exception {
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        var vo = DozerMapper.parseObject(entity, BooksVO.class);
        vo.add(linkTo(methodOn(BooksController.class).findById(id)).withSelfRel());
        return vo;
    }

    public BooksVO create(BooksVO book) throws Exception {
        if (book == null) throw new RequiredObjectIsNullException();

        var entity = DozerMapper.parseObject(book, Books.class);
        var vo = DozerMapper.parseObject(repository.save(entity), BooksVO.class);
        vo.add(linkTo(methodOn(BooksController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public BooksVO update(BooksVO book) throws Exception {
        if (book == null) throw new RequiredObjectIsNullException();

        var entity = repository.findById(book.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        entity.setTittle(book.getTittle());

        var vo = DozerMapper.parseObject(repository.save(entity), BooksVO.class);
        vo.add(linkTo(methodOn(BooksController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id) {
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        repository.delete(entity);
    }

}

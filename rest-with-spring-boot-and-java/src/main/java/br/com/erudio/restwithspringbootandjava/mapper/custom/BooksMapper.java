package br.com.erudio.restwithspringbootandjava.mapper.custom;

import br.com.erudio.restwithspringbootandjava.data.vo.v1.BooksVO;
import br.com.erudio.restwithspringbootandjava.model.Books;
import org.springframework.stereotype.Service;

@Service
public class BooksMapper {
    public BooksVO convertEntityToVo(Books books) {
        BooksVO vo = new BooksVO();
        vo.setKey(books.getId());
        vo.setAuthor(books.getAuthor());
        vo.setLaunchDate(books.getLaunchDate());
        vo.setPrice(books.getPrice());
        vo.setTittle(books.getTittle());
        return vo;
    }

    public Books convertVoToEntity(BooksVO books) {
        Books entity = new Books();
        entity.setId(books.getKey());
        entity.setAuthor(books.getAuthor());
        entity.setLaunchDate(books.getLaunchDate());
        entity.setPrice(books.getPrice());
        entity.setTittle(books.getTittle());
        return entity;
    }


}

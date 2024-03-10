package br.com.erudio.restwithspringbootandjava.mapper.custom;

import br.com.erudio.restwithspringbootandjava.data.vo.v1.BooksVO;
import br.com.erudio.restwithspringbootandjava.model.Books;
import org.springframework.stereotype.Service;

@Service
public class BooksMapper {
    public BooksVO convertEntityToVo(Books books) {
        BooksVO vo = new BooksVO();
        vo.setId(books.getId());
        vo.setAuthor(books.getAuthor());
        vo.setLauncherDate(books.getLauncherDate());
        vo.setPrice(books.getPrice());
        vo.setTittle(books.getTittle());
        return vo;
    }

    public Books convertVoToEntity(BooksVO books) {
        Books entity = new Books();
        entity.setId(books.getId());
        entity.setAuthor(books.getAuthor());
        entity.setLauncherDate(books.getLauncherDate());
        entity.setPrice(books.getPrice());
        entity.setTittle(books.getTittle());
        return entity;
    }


}

package br.com.erudio.restwithspringbootandjava.unittests.mapper.mocker;

import br.com.erudio.restwithspringbootandjava.data.vo.v1.BooksVO;
import br.com.erudio.restwithspringbootandjava.model.Books;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockBook {

    public Books mockEntity() {
        return mockEntity(0);
    }

    public BooksVO mockVO() {
        return mockVO(0);
    }

    public List<Books> mockEntityList() {
        List<Books> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BooksVO> mockVOList() {
        List<BooksVO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockVO(i));
        }
        return books;
    }


    public Books mockEntity(Integer number) {
        Books books = new Books();
        books.setAuthor("Author Test" + number);
        books.setLaunchDate(LocalDate.parse("2017-10-18"));
        books.setPrice(number);
        books.setTittle("Tittle Test" + number);
        return books;
    }

    public BooksVO mockVO(Integer number) {
        BooksVO books = new BooksVO();
        books.setAuthor("Author Test" + number);
        books.setLaunchDate(LocalDate.parse("2017-10-18"));
        books.setPrice(number);
        books.setTittle("Tittle Test" + number);
        return books;
    }

}

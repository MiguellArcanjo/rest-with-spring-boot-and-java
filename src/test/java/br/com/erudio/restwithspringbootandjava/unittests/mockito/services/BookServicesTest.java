package br.com.erudio.restwithspringbootandjava.unittests.mockito.services;

import br.com.erudio.restwithspringbootandjava.model.Books;
import br.com.erudio.restwithspringbootandjava.repositories.BooksRepository;
import br.com.erudio.restwithspringbootandjava.services.BooksService;
import br.com.erudio.restwithspringbootandjava.unittests.mapper.mocker.MockBook;
import br.com.erudio.restwithspringbootandjava.unittests.mapper.mocker.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class BookServicesTest {

    MockBook input;

    @InjectMocks
    private BooksService service;

    @Mock
    BooksRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception {
        input = new MockBook();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() throws Exception {
        Books entity = input.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = service.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
        assertEquals("Author Test1", result.getAuthor());
        assertEquals(LocalDate.parse("2017-10-18"), result.getLaunchDate());
        assertEquals(1, result.getPrice());
        assertEquals("Tittle Test1", result.getTittle());
    }

//    @Test
//    void testFindAll() {
//        List<Books> list = input.mockEntityList();
//
//        when(repository.findAll()).thenReturn(list);
//
//        var book = service.findALl();
//
//        assertNotNull(book);
//        assertEquals(14, book.size());
//
//        var bookOne = book.get(1);
//
//        assertNotNull(bookOne);
//        assertNotNull(bookOne.getKey());
//        assertNotNull(bookOne.getLinks());
//
//        assertTrue(bookOne.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
//        assertEquals("Author Test1", bookOne.getAuthor());
//        assertEquals(LocalDate.parse("2017-10-18"), bookOne.getLaunchDate());
//        assertEquals(1, bookOne.getPrice());
//        assertEquals("Tittle Test1", bookOne.getTittle());
//
//        var bookTwo = book.get(3);
//
//        assertNotNull(bookTwo);
//        assertNotNull(bookTwo.getKey());
//        assertNotNull(bookTwo.getLinks());
//
//        assertTrue(bookTwo.toString().contains("links: [</api/book/v1/3>;rel=\"self\"]"));
//        assertEquals("Author Test3", bookTwo.getAuthor());
//        assertEquals(LocalDate.parse("2017-10-18"), bookTwo.getLaunchDate());
//        assertEquals(3, bookTwo.getPrice());
//        assertEquals("Tittle Test3", bookTwo.getTittle());
//    }

}

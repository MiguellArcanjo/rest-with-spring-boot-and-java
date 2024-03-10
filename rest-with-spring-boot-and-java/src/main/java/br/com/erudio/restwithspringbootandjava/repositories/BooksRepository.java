package br.com.erudio.restwithspringbootandjava.repositories;

import br.com.erudio.restwithspringbootandjava.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
}

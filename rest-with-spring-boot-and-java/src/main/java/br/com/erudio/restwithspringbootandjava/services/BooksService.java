package br.com.erudio.restwithspringbootandjava.services;

import br.com.erudio.restwithspringbootandjava.data.vo.v1.BooksVO;
import br.com.erudio.restwithspringbootandjava.mapper.DozerMapper;
import br.com.erudio.restwithspringbootandjava.mapper.custom.BooksMapper;
import br.com.erudio.restwithspringbootandjava.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    @Autowired
    private BooksRepository repository;

    @Autowired
    private BooksMapper mapper;

    public List<BooksVO> findALl() {
        var books = DozerMapper.parseListObjects(repository.findAll(), BooksVO.class);

        books.stream().forEach(b -> {
            try {
                b.add(linkTo(me))
            }
        });

    }


}

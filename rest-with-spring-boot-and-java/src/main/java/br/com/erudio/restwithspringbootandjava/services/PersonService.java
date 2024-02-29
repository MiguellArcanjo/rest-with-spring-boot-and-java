package br.com.erudio.restwithspringbootandjava.services;

import br.com.erudio.restwithspringbootandjava.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {

        logger.info("Finding one person!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Miguel");
        person.setLastName("Arcanjo");
        person.setAddress("Taxilandia");
        person.setGender("Male");

        return person;
    }
}

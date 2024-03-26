package br.com.erudio.restwithspringbootandjava.mapper.custom;

import br.com.erudio.restwithspringbootandjava.data.vo.v1.PersonVO;
import br.com.erudio.restwithspringbootandjava.data.vo.v2.PersonVOV2;
import br.com.erudio.restwithspringbootandjava.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVO convertEntityToVo(Person person) {
        PersonVO vo = new PersonVO();
        vo.setKey(person.getId());
        vo.setAddress(person.getAddress());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());
        return vo;
    }
    public Person convertVoToEntity(PersonVO person) {
        Person entity = new Person();
        entity.setId(person.getKey());
        entity.setAddress(person.getAddress());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
//        vo.setBirthDay(new Date());
        entity.setGender(person.getGender());
        return entity;
    }

}

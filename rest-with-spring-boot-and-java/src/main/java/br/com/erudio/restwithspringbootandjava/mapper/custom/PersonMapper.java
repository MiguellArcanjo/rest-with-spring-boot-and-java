package br.com.erudio.restwithspringbootandjava.mapper.custom;

import br.com.erudio.restwithspringbootandjava.data.vo.v2.PersonVOV2;
import br.com.erudio.restwithspringbootandjava.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVo(Person person) {
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setBirthDay(new Date());
        vo.setGender(person.getGender());
        return vo;
    }
    public Person convertVoToEntity(PersonVOV2 person) {
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setAddress(person.getAddress());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
//        vo.setBirthDay(new Date());
        entity.setGender(person.getGender());
        return entity;
    }

}

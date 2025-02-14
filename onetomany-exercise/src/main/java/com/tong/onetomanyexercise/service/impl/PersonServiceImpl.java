package com.tong.onetomanyexercise.service.impl;

import com.tong.onetomanyexercise.dao.PersonRepository;
import com.tong.onetomanyexercise.entity.PersonEntity;
import com.tong.onetomanyexercise.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public void createPerson() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId("A123");
        personEntity.setName("逼1");
        personRepository.save(personEntity);
    }
}

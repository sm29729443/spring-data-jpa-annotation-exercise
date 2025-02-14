package com.tong.onetomanyexercise.controller;

import com.tong.onetomanyexercise.service.PersonService;
import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    /*
        測試當沒設定 @GeneratedValue(strategy = GenerationType.IDENTITY) 時
        插入一個具 id 的 entity 時與有設定 @GeneratedValue 的差別
    */
    @GetMapping("/createPerson")
    public String createPerson(){
        personService.createPerson();
        return "success";
    }
}

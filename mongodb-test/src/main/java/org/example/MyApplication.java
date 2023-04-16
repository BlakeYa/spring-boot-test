package org.example;

import org.example.springBootMonogo.Person;
import org.example.springBootMonogo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Autowired
    PersonRepository personRepository;

    @PostConstruct
    public void setDataToMongoDB(){
        personRepository.save(new Person("blake", 22));
    }

    @PostConstruct
    public void getDataFromMongoDB(){
        System.out.println(personRepository.findAll().toString());
    }

}

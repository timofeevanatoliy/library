package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.Person;

import java.util.List;

public interface PersonService {

    void save(Person person);

    void delete(Long id);

    void update(Long id, Person update);

    List<Book> getByBooksPersonId(Long id);

    Person findByOne(Long id);

    List<Person> findByAll();

}

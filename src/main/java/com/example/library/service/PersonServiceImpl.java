package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.Person;
import com.example.library.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonServiceImpl implements PersonService{
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public void save(Person person) {
        personRepository.save(person);


    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);

    }

    @Override
    public void update(Long id, Person update) {
      update.setId(id);
      personRepository.save(update);
    }

    @Override
    public List<Book> getByBooksPersonId(Long id) {
        return personRepository.findById(id).get().getBookList();
    }



    @Override
    public Person findByOne(Long id) {
        return personRepository.findById(id).get();
    }

    @Override
    public List<Person> findByAll() {
        return personRepository.findAll();
    }
}

package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.Person;

import java.util.List;

public interface BookService {


    void save(Book book);

    void delete(Long id);
    void update(Long id,Book book);

    Book findByOne(Long id);

    List<Book> findByAll();
}

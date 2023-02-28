package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.Person;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);

    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public void update(Long id, Book book) {
        book.setId(id);
        bookRepository.save(book);
    }


    @Override
    public Book findByOne(Long id) {

        return  bookRepository.findById(id).get();
    }

    @Override
    public List<Book> findByAll() {
        return bookRepository.findAll();
    }
}

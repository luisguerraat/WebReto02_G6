package com.grupog6.sbconmongodb.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupog6.sbconmongodb.Documents.Book;
import com.grupog6.sbconmongodb.MongoRepository.BookMongoRepository;

@Repository
public class BookRepository {
    @Autowired
    private BookMongoRepository bookMongoRepository;

    public List<Book> getAll() {
        return (List<Book>) bookMongoRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookMongoRepository.save(book);
    }

    public Book udpBook(Book book) {
        return bookMongoRepository.save(book);
    }

    public void delBook(String id) {
        bookMongoRepository.deleteById(id);
    }

    public Book getBookById(String id) {
        Optional<Book> myBook = bookMongoRepository.getBookById(id);
        Book bookrespuesta = new Book();

        if (myBook.isPresent()) {
            bookrespuesta = myBook.get();
        } else {
            bookrespuesta.setId(id);
            bookrespuesta.setName("No Encontrado");
        }
        return bookrespuesta;
    }

    public List<Book> getBooksByPages(Integer pages) {
        return (List<Book>) bookMongoRepository.getBooksByPages(pages);
    }

    public List<Book> getBooksByAuthor(String author) {
        return (List<Book>) bookMongoRepository.getBooksByAuthor(author);
    }

    public List<Book> findByAuthorAndCost(String author, Double cost) {
        return (List<Book>) bookMongoRepository.findByAuthorAndCost(author, cost);
    }
    
}

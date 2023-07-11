package com.grupog6.sbconmongodb.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.grupog6.sbconmongodb.Documents.Book;
import com.grupog6.sbconmongodb.Repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    public Book addBook(Book book) {
        return bookRepository.addBook(book);
    }
    
    public Book udpBook(Book book){
        Book myBook = bookRepository.getBookById(book.getId());

        if (myBook.getName().equals("No Encontrado") == false)
            return bookRepository.udpBook(book);
        else
            return book;
    }

    public void delBook(String id) {
        Book myBook = bookRepository.getBookById(id);

        if (myBook.getName().equals("No Encontrado") == false)
            bookRepository.delBook(id);
    }

    public Book getBookById(String id) {
        return bookRepository.getBookById(id);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.getBooksByAuthor(author);
    }

    public List<Book> findByAuthorAndCost(String author, Double cost) {
        return bookRepository.findByAuthorAndCost(author, cost);
    }
    
    public List<Book> getBooksByPages(Integer pages) {
        return bookRepository.getBooksByPages(pages);
    }



    
}

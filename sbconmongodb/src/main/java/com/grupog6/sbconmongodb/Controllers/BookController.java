package com.grupog6.sbconmongodb.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.grupog6.sbconmongodb.Documents.Book;
import com.grupog6.sbconmongodb.Services.BookService;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/pages/{pages}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooksByPages(@PathVariable Integer pages) {
        return bookService.getBooksByPages(pages);
    }

    @GetMapping("/author/{author}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookService.getBooksByAuthor(author);
    }


    @PostMapping("/new")
        @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/update")
        @ResponseStatus(HttpStatus.CREATED)
    public Book udpBook(@RequestBody Book book) {
        return bookService.udpBook(book);
    }

    @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delBook(@PathVariable String id) {
         bookService.delBook(id);
    }
    
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }



    
}

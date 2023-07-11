package com.grupog6.sbconmongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.grupog6.sbconmongodb.Documents.Book;
import com.grupog6.sbconmongodb.MongoRepository.BookMongoRepository;

@Component
public class SaveBooksRunner implements CommandLineRunner{

    @Autowired
    private BookMongoRepository bookMongoRepository;

    @Override
    public void run(String... args) throws Exception {

        bookMongoRepository.deleteAll();
        bookMongoRepository.saveAll(List.of(
                new Book("500", "Core Java", 200, "Kathy Sierra", 1065.65),
                new Book("501", "JSP and Servlets ", 350, "Kathy Sierra", 1749.65),
                new Book("502", "Sprint Action",   480, "craig Walls", 940.75),
                new Book("503", "ProA Angular", 260, "Freeman", 1949.25),
                new Book("509", " Java Design Patterns", 114, "Devendra Signh", 919.99)
        )
        );
        System.out.println("Cantidad de Libros " + bookMongoRepository.count());
        bookMongoRepository.findAll().forEach(System.out::println);

        System.out.println("findByAuthor " + bookMongoRepository.count());
        bookMongoRepository.findByAuthor("Kathy Sierra").forEach(System.out::println);

        System.out.println("getBooksByAuthor " + bookMongoRepository.count());
        bookMongoRepository.getBooksByAuthor("Kathy Sierra").forEach(System.out::println);

        System.out.println("findByAuthorAndCost " + bookMongoRepository.count());
        bookMongoRepository.findByAuthorAndCost("Kathy Sierra", 1065.65).forEach(System.out::println);
        
    }
    
}

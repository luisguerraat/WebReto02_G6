package com.grupog6.sbconmongodb.MongoRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.grupog6.sbconmongodb.Documents.Book;

public interface BookMongoRepository extends MongoRepository<Book, String> {
    
    @Query(" { id : ?0 } ")
    public Optional<Book> getBookById(String id);

    @Query ( "{ pages : { $lte : ?0} }  ")
    public List<Book> getBooksByPages(Integer pages);

    @Query( " { author : ?0 }")
    public List<Book> getBooksByAuthor(String author);
    

    public List<Book> findByAuthor(String author);

    public List<Book> findByAuthorAndCost(String author, Double cost);


}

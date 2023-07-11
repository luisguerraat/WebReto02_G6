package com.grupog6.sbconmongodb.MongoRepository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupog6.sbconmongodb.Documents.User;

public interface UserMongoRepository extends MongoRepository<User, Integer> {

     public Optional<User> findByEmail(String email);

     public Optional<User> findByEmailAndPassword(String email, String password);
    
}

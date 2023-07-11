package com.grupog6.sbconmongodb.MongoRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupog6.sbconmongodb.Documents.Gadget;

public interface GadgetMongoRepository extends MongoRepository<Gadget, Integer>{
    
}

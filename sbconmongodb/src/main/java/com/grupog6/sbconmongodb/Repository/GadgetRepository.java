package com.grupog6.sbconmongodb.Repository;

import org.springframework.stereotype.Repository;

import com.grupog6.sbconmongodb.Documents.Gadget;
import com.grupog6.sbconmongodb.MongoRepository.GadgetMongoRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Repository

public class GadgetRepository {
  @Autowired
    private GadgetMongoRepository gadgetMongoRepository;
    
    public List<Gadget> getAll() {
        return (List<Gadget>) gadgetMongoRepository.findAll();
    }

    public Gadget addGadget(Gadget gadget) {
        return gadgetMongoRepository.save(gadget);
    }

    public Gadget udpGadget(Gadget gadget) {
        return gadgetMongoRepository.save(gadget);
    }

    public void delGadget(Integer id) {
        gadgetMongoRepository.deleteById(id);
    }

    public Gadget getGadgetById(Integer id) {
        Optional<Gadget> myGadget = gadgetMongoRepository.findById(id);
        Gadget gadgetrespuesta = new Gadget();

        if (myGadget.isPresent()) {
            gadgetrespuesta = myGadget.get();
        } else {
            gadgetrespuesta.setId(id);
            gadgetrespuesta.setName("No Encontrado");
        }
        return gadgetrespuesta;
    }
  
}

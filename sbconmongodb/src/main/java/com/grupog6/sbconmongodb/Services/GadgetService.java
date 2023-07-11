package com.grupog6.sbconmongodb.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupog6.sbconmongodb.Documents.Gadget;
import com.grupog6.sbconmongodb.Repository.GadgetRepository;


@Service
public class GadgetService {
  @Autowired
    private GadgetRepository gadgetRepository;

    public List<Gadget> getAll() {
        return (List<Gadget>) gadgetRepository.getAll();
    }

    public Gadget addGadget(Gadget gadget) {
        return gadgetRepository.addGadget(gadget);
    }

    public Gadget udpGadget(Gadget gadget){
        Gadget myGadget = gadgetRepository.getGadgetById(gadget.getId());

        if (myGadget.getName().equals("No Encontrado") == false)
            return gadgetRepository.udpGadget(gadget);
        else
            return gadget;
    }

    public void delGadget(Integer id) {
        Gadget myGadget = gadgetRepository.getGadgetById(id);

        if (myGadget.getName().equals("No Encontrado") == false)
            gadgetRepository.delGadget(id);
    }

    public Gadget getGadgetById(Integer id) {
        return gadgetRepository.getGadgetById(id);
    }

}
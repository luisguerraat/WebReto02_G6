package com.grupog6.sbconmongodb.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupog6.sbconmongodb.Documents.Gadget;

import com.grupog6.sbconmongodb.Services.GadgetService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/gadget")
@CrossOrigin(origins = "*")
public class GadgetController {
    @Autowired
    private GadgetService gadgetService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Gadget> getAll() {
        return gadgetService.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget addGadget(@RequestBody Gadget gadget) {
        return gadgetService.addGadget(gadget);
    }
    
    @PutMapping("/update")
        @ResponseStatus(HttpStatus.CREATED)
    public Gadget udpGadget(@RequestBody Gadget gadget) {
        return gadgetService.udpGadget(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delGadget(@PathVariable Integer id) {
         gadgetService.delGadget(id);
    }
    
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Gadget getGadgetById(@PathVariable Integer id) {
        return gadgetService.getGadgetById(id);
    }
    
}

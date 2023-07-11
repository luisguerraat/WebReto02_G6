package com.grupog6.sbconmongodb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("")
@CrossOrigin(origins = "*")
public class VistaController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
    
}

package br.com.fiap.Filme.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FilmeController {

    @GetMapping
    public String oi(){
        return"oi";
    }
}

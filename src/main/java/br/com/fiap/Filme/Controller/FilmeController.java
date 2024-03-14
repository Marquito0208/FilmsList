package br.com.fiap.Filme.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.Filme.model.Filme;
import br.com.fiap.Filme.repository.FilmeListRepository;


@RestController
@RequestMapping("filmes")
public class FilmeController {



    
    @Autowired
    FilmeListRepository filmeListRepository;



    @GetMapping
    public List<Filme> index(){
        return filmeListRepository.findAll();
    }


    @PostMapping  
    @ResponseStatus(code = HttpStatus.CREATED)
    public Filme create(@RequestBody Filme filme){
        filmeListRepository.save(filme);
        return filme;
    }


    @GetMapping("{id}")
    public ResponseEntity<Filme> get(@PathVariable Long id) {
        
        return filmeListRepository
                    .findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }



    
    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {

        verificarSeExistefilme(id);

        filmeListRepository.deleteById(id);

        return ResponseEntity.noContent().build();

    }


 

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Filme filme){
     
        verificarSeExistefilme(id);

        filme.setId(id);
        filmeListRepository.save(filme);
        return ResponseEntity.ok(filme);
    }

    
     private void verificarSeExistefilme(Long id) {
            filmeListRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada" )
            );
    }

}

package br.com.fiap.Filme.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.Filme.model.Filme;

@RestController
@RequestMapping("filmes")
public class FilmeController {


    List<Filme> repository = new ArrayList<>();
    
    @GetMapping
    public List<Filme> index(){
        return repository;
    }

    @PostMapping  
    public ResponseEntity<Filme> create(@RequestBody Filme filme){
        repository.add(filme);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(filme);
    }


    
    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {

        var optionalFilme = buscarFilmePorId(id);

        if (optionalFilme.isEmpty())
            return ResponseEntity.notFound().build();

        repository.remove(optionalFilme.get());

        return ResponseEntity.noContent().build();

    }


    @GetMapping("{id}")
    public ResponseEntity<Filme> get(@PathVariable Long id) {
        
        var optionalFilme = buscarFilmePorId(id);

        if (optionalFilme.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(optionalFilme.get());
    }


    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Filme filme){
        
        var optionalFilme = buscarFilmePorId(id);

        if (optionalFilme.isEmpty())
            return ResponseEntity.notFound().build();

        var filmeEncontrado = optionalFilme.get();
        var filmeAtualizado = new Filme(id, filme.nome(), filme.url(), filme.descricao());
        repository.remove(filmeEncontrado);
        repository.add(filmeAtualizado);

        return ResponseEntity.ok().body(filmeAtualizado);
    }

    
    private Optional<Filme> buscarFilmePorId(Long id) {
        var optionalFilme = repository
                .stream()
                .filter(c -> c.id().equals(id))
                .findFirst();
        return optionalFilme;
    }

}

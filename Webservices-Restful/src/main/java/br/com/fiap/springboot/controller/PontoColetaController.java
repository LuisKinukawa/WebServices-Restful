package br.com.fiap.springboot.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.springboot.domain.Categoria;
import br.com.fiap.springboot.domain.PontosColeta;
import br.com.fiap.springboot.domain.Produto;
import br.com.fiap.springboot.repository.*;

@RestController 
@RequestMapping("/ponto") 
public class PontoColetaController { 

    @Autowired 
    private PontoColetaRepository pontoRepository; 

    @GetMapping
	public ResponseEntity<List<PontosColeta>> findAll() {
		List<PontosColeta> lista = pontoRepository.findAll();
		return ResponseEntity.ok(lista);
	}

    
    @GetMapping(path = {"/{codigo}"})
    public ResponseEntity findById(@PathVariable int codigo){
       return pontoRepository.findById(codigo)
               .map(record -> ResponseEntity.ok().body(record))
               .orElse(ResponseEntity.notFound().build());
    }
   /* @RequestMapping(value = "/categoria/{codigo}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> GetById(@PathVariable(value = "id") int id)
    {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isPresent())
            return new ResponseEntity<Categoria>(categoria.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }*/

    @PostMapping
    public PontosColeta create(@RequestBody PontosColeta ponto){
       return pontoRepository.save(ponto);
    }
    
    @PutMapping(value="/{codigo}")
    public ResponseEntity update(@PathVariable("codigo") int codigo,
                                          @RequestBody PontosColeta ponto) {
       return pontoRepository.findById(codigo)
               .map(record -> {
                   record.setCodigo(ponto.getCodigo());
                   record.setNome(ponto.getNome());
                   record.setEndereco(ponto.getEndereco());
                   record.setMaterial(ponto.getMaterial());
                   PontosColeta updated = pontoRepository.save(record);
                   return ResponseEntity.ok().body(updated);
               }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{codigo}")
    public void deletePonto(@PathVariable int codigo) {
    	pontoRepository.deleteById(codigo);
    }
    
    /*
    @DeleteMapping("/{codigo}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("codigo") int codigo) {
      try {
        categoriaRepository.deleteById(codigo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    
    
      
     /*
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Categoria> delete(@PathVariable("codigo") int codigo) {
    	categoriaRepository.deleteById(codigo);
        return ResponseEntity.noContent().build();
    }
    
    /*@DeleteMapping("/{codigo}")
    public ResponseEntity <Categoria> delete(@PathVariable("codigo") int codigo) {
       return categoriaRepository.findById(codigo)
               .map(record -> {
                   categoriaRepository.deleteById(codigo);
                   return ResponseEntity.ok().build();
               }).orElse(ResponseEntity.notFound().build());
    }
    */
    
    /*
    @RequestMapping(value = "/categoria", method = RequestMethod.POST)
    public Categoria Post(@Valid @RequestBody Categoria categoria)
    {
        return categoriaRepository.save(categoria);
    }

    @RequestMapping(value = "/categoria/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Categoria> Put(@PathVariable(value = "id") int id, @Valid @RequestBody Categoria newCategoria)
    {
        Optional<Categoria> oldCat = categoriaRepository.findById(id);
        if(oldCat.isPresent()){
            Categoria categoria = oldCat.get();
            categoria.setNome(newCategoria.getNome());
            categoriaRepository.save(categoria);
            return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/categoria/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id)
    {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isPresent()){
            categoriaRepository.delete(categoria.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    */

}


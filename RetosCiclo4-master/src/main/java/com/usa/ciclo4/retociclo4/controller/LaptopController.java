package com.usa.ciclo4.retociclo4.controller;

import com.usa.ciclo4.retociclo4.model.Laptop;
import com.usa.ciclo4.retociclo4.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/laptop")
@CrossOrigin("*")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;
       
    @GetMapping("/all")
    public List<Laptop> getAll() {
        return laptopService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Laptop> getLaptop(@PathVariable("id") int id) {
        return laptopService.getLaptop(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop save(@RequestBody Laptop laptop) {
        return laptopService.save(laptop);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop update(@RequestBody Laptop laptop) {
        return laptopService.update(laptop);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return laptopService.delete(id);
    }
    
    @GetMapping("/price/{price}")
    public List<Laptop> getByPrice(@PathVariable("price") double price){
        return laptopService.getByPrice(price);
    }

    @GetMapping("/description/{description}")
    public List<Laptop> getByDescriptionContains(@PathVariable("description") String description){
        return laptopService.getByDescriptionContains(description);
    }
}

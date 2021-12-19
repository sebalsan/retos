package com.usa.ciclo4.retociclo4.repository;

import com.usa.ciclo4.retociclo4.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import com.usa.ciclo4.retociclo4.repository.crudrepository.LaptopCrudRepository;

@Repository
public class LaptopRepository {
    @Autowired
    private LaptopCrudRepository laptopCrudRepository;

    public List<Laptop> getAll() {
        return laptopCrudRepository.findAll();
    }

    public Optional<Laptop> getLaptop(int id) {
        return laptopCrudRepository.findById(id);
    }
    
    public Laptop save(Laptop laptop) {
        return laptopCrudRepository.save(laptop);
    }

    public void update(Laptop laptop) {
        laptopCrudRepository.save(laptop);
    }

    public void delete(Laptop laptop) {
        laptopCrudRepository.delete(laptop);
    }
    
    public List<Laptop> getByPrice(double price){
        return laptopCrudRepository.findByPriceLessThanEqual(price);
    }

    public List<Laptop> getByDescriptionContains(String description){
        return laptopCrudRepository.findByDescriptionContainingIgnoreCase(description);
    }
}

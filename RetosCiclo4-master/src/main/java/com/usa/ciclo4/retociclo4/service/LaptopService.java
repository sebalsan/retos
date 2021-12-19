package com.usa.ciclo4.retociclo4.service;

import com.usa.ciclo4.retociclo4.model.Laptop;
import com.usa.ciclo4.retociclo4.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {
    @Autowired
    private LaptopRepository laptopRepository;

    public List<Laptop> getAll(){
        return laptopRepository.getAll();
    }

    public Optional<Laptop> getLaptop(int id) {
        return laptopRepository.getLaptop(id);
    }

    public Laptop save(Laptop laptop){
        if(laptop.getId() == null) {
            return laptop;
        }else{
            return laptopRepository.save(laptop);
        }
    }

    public Laptop update(Laptop laptop) {
        if (laptop.getId()!= null) {
            Optional<Laptop> e = laptopRepository.getLaptop(laptop.getId());
            if (!e.isEmpty()) {
                if (laptop.getBrand()!= null) {
                    e.get().setBrand(laptop.getBrand());
                }
                if (laptop.getModel() != null) {
                    e.get().setModel(laptop.getModel());
                }
                if (laptop.getProcesor() != null) {
                    e.get().setProcesor(laptop.getProcesor());
                }
                if (laptop.getOs() != null) {
                    e.get().setOs(laptop.getOs());
                }
                if (laptop.getDescription() != null) {
                    e.get().setDescription(laptop.getDescription());
                }
                if (laptop.getMemory() != null) {
                    e.get().setMemory(laptop.getMemory());
                }
                if (laptop.getHardDrive() != null) {
                    e.get().setHardDrive(laptop.getHardDrive());
                }
                if (laptop.getPrice() != 0.0) {
                    e.get().setPrice(laptop.getPrice());
                }
                if (laptop.getQuantity() != 0) {
                    e.get().setQuantity(laptop.getQuantity());
                }
                if (laptop.getPhotography() != null) {
                    e.get().setPhotography(laptop.getPhotography());
                }
                e.get().setAvailability(laptop.isAvailability());
                laptopRepository.update(e.get());
                return e.get();
            } else {
                return laptop;
            }
        } else {
            return laptop;
        }
    }

    public boolean delete(int id){
        return getLaptop(id).map(laptop -> {
            laptopRepository.delete(laptop);
            return true;
        }).orElse(false);
    }
    
    public List<Laptop> getByPrice(double price){
        return laptopRepository.getByPrice(price);
    }

    public List<Laptop> getByDescriptionContains(String description){
        return laptopRepository.getByDescriptionContains(description);
    }
}

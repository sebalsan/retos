package com.usa.ciclo4.retociclo4.repository.crudrepository;

import com.usa.ciclo4.retociclo4.model.Laptop;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LaptopCrudRepository extends MongoRepository<Laptop, Integer> {
    public List<Laptop> findByPriceLessThanEqual(double price);
    public List<Laptop> findByDescriptionContainingIgnoreCase(String description);
}

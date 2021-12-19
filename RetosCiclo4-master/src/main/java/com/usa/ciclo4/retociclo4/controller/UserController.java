package com.usa.ciclo4.retociclo4.controller;

import com.usa.ciclo4.retociclo4.model.User;
import com.usa.ciclo4.retociclo4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    /**
    *Instancia del Service de User
    */
    private UserService userService;
     
    @GetMapping("/all")
    /**
    *Metodo de consulta de todos los registros
    */
    public List<User> getAll() {
        return userService.getAll();
    }
    
    @GetMapping("/{id}")
    /**
    *Metodo de consulta registros por id
    */
    public Optional<User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    /**
    *Metodo que crea un nuevo registro
    */
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    /**
    *Metodo que actualiza un registro existente
    */
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    /**
    *Metodo que elimina un registro por id
    */
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }
    
    @GetMapping("/{email}/{password}")
    /**
    *Metodo que verifica registro existente por el dato email y password ingresado
    */
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }
    
    @GetMapping("/emailexist/{email}")
    /**
    *Metodo que verifica un email existente por el dato email ingresado
    */
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
    
    @GetMapping("/birthday/{month}")
    /**
    *Metodo que trae registros por el mes de cumpleaños
    */
    public List<User> getByMonthBirthDay(@PathVariable("month") String month){
        return userService.getByMonthBirthDay(month);
    }
}
package com.second.service_second_backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/add")
    public Cart addCart(@RequestBody Cart cart){
        return cartRepository.save(cart);
    }

    @GetMapping("/all")
    public List<Cart> getAllCart(){
        return cartRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        cartRepository.deleteById(id);
        return "Deleted";
    }

    @DeleteMapping("/all")
    public String deleteAllCart(){
        cartRepository.deleteAll();
        return "All Deleted";
    }


}

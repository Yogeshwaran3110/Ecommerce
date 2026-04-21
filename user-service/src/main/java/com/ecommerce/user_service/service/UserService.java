package com.ecommerce.user_service.service;

import com.ecommerce.user_service.entity.User;
import com.ecommerce.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> getAllUsers(){
        return repo.findAll();
    }

    public List<User> getAdults(){
        return repo.findAll().stream().
                filter(user -> user.getAge() >= 18).toList();
    }

    public User saveUser(User user){
        return repo.save(user);
    }
    public User getUserById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}

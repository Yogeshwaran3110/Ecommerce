package com.ecommerce.product_service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserClient {

    @Autowired
    RestTemplate restTemplate;

    public String getUser(Long userId){
        return restTemplate.getForObject( "http://localhost:8081/users/" + userId,String.class);
    }
}

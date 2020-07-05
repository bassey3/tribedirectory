package com.tribeapp.tribedirectory;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusinessRepo extends MongoRepository<Business, String>{

    public Business findByName (String businessName);
}

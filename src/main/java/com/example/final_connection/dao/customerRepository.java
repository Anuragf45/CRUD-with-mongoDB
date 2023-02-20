package com.example.final_connection.dao;

import com.example.final_connection.model.customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface customerRepository extends MongoRepository<customer,String> {
    Optional<customer> findById(String id);
}

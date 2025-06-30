package com.example.api_base.repositories;

import com.example.api_base.models.UserModel;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

    // public abstract ArrayList<UserModel> filterByPriority(Integer priority);
    
}

package com.example.api.repositories;

import com.example.api.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsername(String username);
   // User findByUsernameAndPassword(String username, String password);
   // User findBypassword(String password);



}

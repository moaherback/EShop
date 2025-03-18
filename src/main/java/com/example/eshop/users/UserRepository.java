package com.example.eshop.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
   public User getUserByUsernameAndPassword(String username, String password);
}

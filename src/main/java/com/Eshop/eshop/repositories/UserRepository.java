package com.Eshop.eshop.repositories;

import com.Eshop.eshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findAllByisActive(Boolean isActive);


    User findUserByEmailAndPhoneNumber(String userName,String phoneNumber);

    User findByEmail(String email);

    User findByName(String userName);
}

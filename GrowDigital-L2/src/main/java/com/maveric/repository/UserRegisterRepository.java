package com.maveric.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maveric.model.UserRegistration;

public interface UserRegisterRepository extends JpaRepository<UserRegistration, Integer>{

}

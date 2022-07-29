package com.maveric.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maveric.model.UserRegistration;

@Repository
public interface UserRegisterRepository extends JpaRepository<UserRegistration, Integer>{

	@Query("SELECT ud from user_register_login ud where customer_id=?1 and email=?2")
	List<UserRegistration> checkUserAvailable(int id,String email);
	
	@Query("SELECT userDet from user_register_login userDet where email=?1 and password=?2")
	UserRegistration getUser(String email,String password);

}

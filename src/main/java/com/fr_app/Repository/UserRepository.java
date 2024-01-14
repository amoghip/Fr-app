package com.fr_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fr_app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String emailId);

}
 
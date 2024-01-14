package com.fr_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fr_app.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}

package com.fr_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fr_app.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}

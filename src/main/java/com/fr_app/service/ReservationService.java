package com.fr_app.service;

import com.fr_app.dto.ReservationRequestdto;
import com.fr_app.entity.Reservation;

public interface ReservationService {

	Reservation bookFlight(ReservationRequestdto request);

}

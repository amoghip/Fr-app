package com.fr_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fr_app.dto.ReservationRequestdto;
import com.fr_app.entity.Reservation;
import com.fr_app.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/confirmReservation")
	public String confirmReservstion(ReservationRequestdto request,ModelMap modelMap) {//dto
		System.out.println(request.getFlightId());
		Reservation reservationId = reservationService.bookFlight(request);
		modelMap.addAttribute("reservationId", reservationId.getId());
		
		return "confirmReservation";
	}
}

package com.fr_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr_app.Repository.FlightRepository;
import com.fr_app.Repository.PassengerRepository;
import com.fr_app.Repository.ReservationRepository;
import com.fr_app.dto.ReservationRequestdto;
import com.fr_app.entity.Flight;
import com.fr_app.entity.Passenger;
import com.fr_app.entity.Reservation;
import com.fr_app.utility.EmailService;
import com.fr_app.utility.PdfGenerator;

@Service
public class ReservationServiceImpl implements ReservationService
{

	@Autowired
	private FlightRepository flightRepo;
	@Autowired
	private PassengerRepository passengerRepo;
	@Autowired
	private ReservationRepository reservationRepo;
	@Autowired
	private PdfGenerator pdfGenerator;
	@Autowired
	private EmailService emailservice;
	
	@Override
	public Reservation bookFlight(ReservationRequestdto request) {
		
		//save passenger obj
		Passenger passenger=new Passenger();
		passenger.setFirstName( request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail( request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
		
		//get flight obj from table
		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		
		//save the reservation
		Reservation reservation=new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		String filePath="F:\\javasts\\jan_code1\\flight_reservation_app\\tickets\\reservation"+reservation.getId()+".pdf";

		reservationRepo.save(reservation);
		pdfGenerator.generateItinerary(reservation, filePath);
		emailservice.sendItinerary(passenger.getEmail(), filePath);
		return reservation;
	}
}

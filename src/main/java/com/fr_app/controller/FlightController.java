package com.fr_app.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fr_app.Repository.FlightRepository;
import com.fr_app.entity.Flight;

@Controller
public class FlightController {
	@Autowired
	private FlightRepository flightRepo;
	
@RequestMapping("/findFlights")
	public String findingFlights(@RequestParam("from")String from,@RequestParam("to")String to,@RequestParam("departureDate")@DateTimeFormat(pattern = "MM-dd-yyyy")Date departureDate,ModelMap modelMap) {
	List<Flight> findFlight = flightRepo.findFlights(from,to,departureDate);
	modelMap.addAttribute("findFlight", findFlight);
	return "displayFlights";
	
}

@RequestMapping("/showCompleteReservation")
public String showCompleteReservation(@RequestParam("flightId")Long flightId,ModelMap modelMap ) {
	Optional<Flight> findById = flightRepo.findById(flightId);
	Flight flight = findById.get();
	modelMap.addAttribute("flight", flight);
	return "showReservation";
}


}

//package com.flight_reservation_app.Controller;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.flight_reservation_app.entity.Flight;
//import com.flight_reservation_app.repository.FlightRepository;
//
//@Controller
//public class FlightController {
//
//	@Autowired
//	private FlightRepository flightRepo;
//	
//	
//	
//	@RequestMapping("/findFlights")
//	public String findFlights(@RequestParam("from")String from,
//							  @RequestParam("to")String to,
//							  @RequestParam("departureDate")@DateTimeFormat(pattern = "MM-dd-yyyy")Date departureDate,
//							  ModelMap modelMap) 
//	{
//		List<Flight> findFlight = flightRepo.findFlights(from,to,departureDate);
//		modelMap.addAttribute("findFlight", findFlight);
//		return "displayFlights";
//	}
//	//capture all the data from findflight  jsp form ==@reqParam
//			//model attribute used when entity matches with form
//			//read the date as date format 
//			//search based on records
//	//modelmap :data transfer from jsp to controller 
//	//modelattribute used when both entity form has entity  create obj of entity fetch from form
//	
//	
//	@RequestMapping("/showCompleteReservation")
//	public String showCompleteReservation(@RequestParam("flightId")Long flightId,ModelMap modelMap ) {
//		Optional<Flight> findById = flightRepo.findById(flightId);
//		Flight flight = findById.get();
//		modelMap.addAttribute("flight", flight);
//		return "showReservation";
//	}
//	
//	
//
//	
//}

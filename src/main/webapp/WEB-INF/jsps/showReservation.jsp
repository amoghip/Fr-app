<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show Reservation</title>
</head>
<body>
<h2> flight details</h2>
<pre>
FlightNumber : ${flight.getFlightNumber()} <br>
OperatingAirlines : ${flight.getOperatingAirlines()} <br>
DepartureCity : ${flight.getDepartureCity()} <br>
ArrivalCity : ${flight.getArrivalCity()} <br>
DateOfDeparture : ${flight.getDateOfDeparture()} <br>
</pre>

<h2>enter passenger details</h2>
<h2>enter passenger details</h2>

<form action="confirmReservation" method="post">
<pre>
firstName<input type="text" name="firstName">
lastName<input type="text" name="lastName">
middleName<input type="text" name="middleName">
email<input type="text" name="email">
phone<input type="text" name="phone">
 <input type="hidden" name="id" value="${flight.id}">
name on the card<input type="text" name="nameOfTheCard">
cvv  <input type="text" name="cvv">
card Number<input type="text" name="cardNumber">
expiry date  <input type="text" name="expiryDate">
 <input type="submit" value="complete reservstion">


</pre>
</form>

</body>
</html>
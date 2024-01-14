<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>displayFlights</title>
</head>
<body>
<h2>flight search result </h2>
<h2>list of flights</h2>
<table border="1">
<tr> 
<th> airlines</th>
<th> departure city</th>
<th> arrival city</th>
<th> departure time</th>
<th> select flight</th>
</tr>

<c:forEach var="findFlight" items="${findFlight}">
<tr>
<td>${findFlight.operatingAirlines} </td>
<td>${findFlight.departureCity} </td>
<td>${findFlight.arrivalCity} </td>
 <td>${findFlight.estimatedDepartureTime} </td>
  <td> <a href="showCompleteReservation?flightId=${findFlight.id}"> select</a> </td>
 
 </tr>
</c:forEach>
</table>

</body>
</html>
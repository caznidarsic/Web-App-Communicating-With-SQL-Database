<%@ page import="java.time.LocalDateTime" %>
<%@ page import="myServlet.Reservation" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Reservation Query Tool</title>
<jsp:useBean id="quoteRequest" class="myServlet.QuoteRequest" scope="session" />
<script src="ValidateHikers.js">  </script>
<%LocalDateTime localDateTime = LocalDateTime.now();%>

<style>
  table {
    border: solid 1px #aaa999;
  }
  table tr th {
    border: solid 1px #aaa999;
  }
  table tr td {
    border: solid 1px #aaa999;
  }
  .center {
  text-align: center;
  border: 3px solid green;
}
</style>
</head>

<body>




<form method=POST>
<h1>Reservation Query Tool</h1>


<%if (quoteRequest.getDate() != null) { %>		
<input name="Date" id="dateSelector" type="date"
       value=<%=quoteRequest.getDate()%>>
<%} 
else { %>
<input name="Date" id="dateSelector" type="date">
<%} %>
       

<input type="SUBMIT" id="submitButton">

</form>


<%
if (quoteRequest.getOutputMessage() != "VALID") {
	out.write(quoteRequest.getOutputMessage());
}
%>

<br>
<br>

<%if (quoteRequest.getResList() != null) {%>
<table>
  <tr>
    <th>Starting Date</th>
    <th>Number of Days</th>
    <th>Location</th>
    <th>Guide First Name</th>
    <th>Guide Last Name</th>
    <th>Reservation First Name</th>
    <th>Reservation Last Name</th>
  </tr>

	<%for (Reservation res : quoteRequest.getResList()) { %>
	  <tr>
 		<td><%=res.getStartDay()%></td>
 		<td><%=res.getNumberOfDays()%></td>
 		<td><%=res.getLocation()%></td>
 		<td><%=res.getGuide_First()%></td>
 		<td><%=res.getGuide_Last()%></td>
 		<td><%=res.getReservation_First()%></td>
 		<td><%=res.getReservation_Last()%></td>
 	  </tr>
 	<%}%>

<%}%>

</table>


		
</body>
</html>
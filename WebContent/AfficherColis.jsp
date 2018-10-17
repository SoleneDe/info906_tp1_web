<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Info colis</title>
</head>
<body>
	<h1>Colis #${colis.id}</h1>
	<ul>
		<li>Weight: ${colis.weight}</li>
		<li>Price: ${colis.price}</li>
		<li>Origin: ${colis.origin}</li>
		<li>Destination: ${colis.destination}</li>
		<li>State: ${colis.state}</li>
		<li>Position: ${colis.position.latitude} / ${colis.position.longitude} / ${colis.position.place}</li>
	</ul>
	
	<a href="index.html">Revenir à l'accueil</a>
</body>
</html>
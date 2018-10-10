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
	<p>id: ${colis.id}</p>
	<p>weight: ${colis.weight}</p>
	<p>price: ${colis.price}</p>
	<p>origin: ${colis.origin}</p>
	<p>destination: ${colis.destination}</p>
</body>
</html>
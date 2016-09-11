<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>

<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Προβολή</title>
<%@ include file="/WEB-INF/views/scripts.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		$('#resultTable').DataTable();
	});
</script>

</head>
<body>
	<table id="resultTable" class="display" cellspacing="0" width="100%" style="overflow-x: auto">
		<thead>
			<tr>
				<th>id</th>
				<th>Αριθμός σειράς φιάλης</th>
				<th>Είδος</th>
				<th>Βάρος/Όγκος</th>
				<th>Έτος κατασκευής</th>
				<th>Κατασκευαστής</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${extinguisherList}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.bottlePartNumber}</td>
					<td>${item.contentItem}</td>
					<td>${item.contentWeightVolume}</td>
					<td>${item.yearBuild}</td>
					<td>${item.manufacture}</td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
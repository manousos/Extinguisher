<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/WEB-INF/views/scripts.jsp"%>

<title><spring:message code="title.edit.extinguisher" /></title>

</head>
<body>

	<form:form commandName="extinguisher">
		<fieldset>
			<table>
				<tr>
					<td><spring:message	code="label.extinguisherSN" /></td>
					<td><form:input path="bottlePartNumber" /></td>
					<td><input type="button" value="<spring:message	code="label.search" />" onclick="getExtinguisher();" /></td>
				</tr>
				<tr>
					<td><spring:message	code="label.contentItem" /></td>
					<td><form:input path="contentItem" /></td>
					<td><form:errors path="contentItem" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.contentWeightVolume"/></td>
					<td><form:input path="contentWeightVolume" /></td>
					<td><form:errors path="contentWeightVolume" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.yearBuild"/></td>
					<td><form:input path="yearBuild" /></td>
					<td><form:errors path="yearBuild" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.manufacture" /></td>
					<td><form:input path="manufacture" /></td>
					<td><form:errors path="manufacture" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.afm" /></td>
					<td><form:input path="afm" /></td>
					<td><form:errors path="afm" /></td>
				</tr>
			</table>
			<form:hidden path="id" />
			<form:hidden path="customer.id" />
			<form:hidden path="notification.id" />
			<form:hidden path="version" />
			<div>
				<input type="submit" value="<spring:message code="label.update" />" name="update" /> <input type="submit" value="<spring:message code="label.delete"/>" name="delete" onclick="alert('Είστε σίγουρος για την διαγραφή ;')"/>
			</div>
		</fieldset>
	</form:form>
	<script type="text/javascript">
	function getExtinguisher() {
	    $.support.cors = true;
	    $(document)
		    .ready(
			    function() {
				$
					.ajax(
						{
						    url : "http://localhost:8080/extinguisher/extinguisher/getBySn/"
							    + document
								    .getElementById("bottlePartNumber").value,
						    dataType : 'json'
						})
					.then(
						function(data) {
						    $("#contentItem").val(
							    data.contentItem);
						    $("#contentWeightVolume")
							    .val(
								    data.contentWeightVolume);
						    $("#yearBuild").val(
							    data.yearBuild);
						    $("#manufacture").val(
							    data.manufacture);
						    $("#afm").val(data.afm);
						    $("#id").val(data.id);
						    $("#version").val(
							    data.version);
						    $("#customer.id").val(
							    data.customer.id);
						    $("#notification.id").val(
							    data.notification.id);
						});
			    });
	}
    </script>
</body>
</html>

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Καταχώριση πυροσβεστήρα</title>
</head>
<body>
	<form:form method="post" commandName="extinguisher">
		<fieldset>
			<table>
				<tr>
					<td><spring:message code="label.extinguisherSN" /></td>
					<td><form:input path="bottlePartNumber" /></td>
					<td><form:errors path="bottlePartNumber" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.contentItem" /></td>
					<td><form:input path="contentItem" /></td>
					<td><form:errors path="contentItem" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.contentWeightVolume" /></td>
					<td><form:input path="contentWeightVolume" /></td>
					<td><form:errors path="contentWeightVolume" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.yearBuild" /></td>
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
			<input type="submit" value="<spring:message code="label.save"/>" />
		</fieldset>
	</form:form>
</body>
</html>

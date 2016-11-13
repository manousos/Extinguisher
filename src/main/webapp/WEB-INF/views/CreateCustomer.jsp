<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><spring:message code="title.customer.create" /></title>
</head>
<body>
	<form:form method="post" commandName="customer">
		<fieldset>
			<legend>
				<spring:message code="title.customer.table" />
			</legend>
			<table>
				<tr>
					<td><spring:message code="label.firstName" /></td>
					<td><form:input path="firstName" /></td>
					<td><form:errors path="firstName" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.lastName" /></td>
					<td><form:input path="lastName" /></td>
					<td><form:errors path="lastName" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.fatherName" /></td>
					<td><form:input path="fatherName" /></td>
					<td><form:errors path="fatherName" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.nickName" /></td>
					<td><form:input path="nickName" /></td>
					<td><form:errors path="nickName" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.identity" /></td>
					<td><form:input path="identity" /></td>
					<td><form:errors path="identity" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.companyTitle" /></td>
					<td><form:input path="companyTitle" /></td>
					<td><form:errors path="companyTitle" /></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend>
				<spring:message code="title.address.table" />
			</legend>
			<table>
				<tr>
					<td><spring:message code="label.address" /></td>
					<td><form:input path="address.address" /></td>
					<td><form:errors path="address.address" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.addrNum" /></td>
					<td><form:input path="address.addrNum" /></td>
					<td><form:errors path="address.addrNum" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.city" /></td>
					<td><form:input path="address.city" /></td>
					<td><form:errors path="address.city" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.postCode" /></td>
					<td><form:input path="address.postCode" /></td>
					<td><form:errors path="address.postCode" /></td>
				</tr>
			</table>
		</fieldset>
		<input type="submit" value="<spring:message code="label.save"/>" />
	</form:form>
</body>
</html>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.4/js/standalone/selectize.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.4/css/selectize.default.css"
	rel="stylesheet" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.4/css/selectize.css"
	rel="stylesheet" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.0/jquery-ui.min.js"></script>
<link
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.0/themes/smoothness/jquery-ui.css"
	rel="stylesheet" />
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
				<tr>
					<td><spring:message code="label.job" /></td>
					<td><form:select path="job.title" id="job">
							<form:option value="NONE" label="--Επιλέξτε--" />
							<form:options items="${jobList}" />
						</form:select></td>
					<td><form:errors path="job.title" /></td>
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
		
		<fieldset>
			<legend>
				<spring:message code="title.contact.table" />
			</legend>
			<table>
				<tr>
					<td><spring:message code="label.email" /></td>
					<td><form:input path="contacts[0].email" /></td>
					<td><form:errors path="contacts[0].email" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.phone" /></td>
					<td><form:input path="contacts[1].phone" /></td>
					<td><form:errors path="contacts[1].phone" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.cellPhone" /></td>
					<td><form:input path="contacts[2].cellPhone" /></td>
					<td><form:errors path="contacts[2].cellPhone" /></td>
				</tr>				
			</table>
		</fieldset>

		<input type="submit" value="<spring:message code="label.save"/>" />
	</form:form>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#job').selectize({
				create : true,
				sortField : 'text'
			});
		});
	</script>
</body>
</html>
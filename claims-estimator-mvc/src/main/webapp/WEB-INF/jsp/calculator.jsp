<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<form:form commandName="calculationModel">
	<fieldset>
		<legend><span>Integer Calculator</span></legend>
		<div>
			<form:input path="value1" size="2" />
			<form:errors path="value1" cssClass="errors" />
			<form:select path="operator" items="${operatorModel.operators}" />
			<form:input path="value2" size="2" />
			<form:errors path="value2" cssClass="errors" />
			<c:if test="${not empty result}"> = ${result}</c:if>
		</div>
		<br><input type="submit" value="Calculate" />
	</fieldset>
</form:form>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
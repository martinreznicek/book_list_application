<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<form:form method="post" commandName="book">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="author"><spring:message code="author.tabhead"/></form:label>
			<form:input path="author" type="text" class="form-control"
				required="required" />
			<form:errors path="author" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="title"><spring:message code="title.tabhead"/></form:label>
			<form:input path="title" type="text" class="form-control"
				required="required" />
			<form:errors path="title" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="year"><spring:message code="year.tabhead"/></form:label>
			<form:input path="year" type="number" value="2019" class="form-control"
				required="required" />
			<form:errors path="year" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="country"><spring:message code="country.tabhead"/></form:label>
			<form:input path="country" type="text" class="form-control"
				required="required" />
			<form:errors path="country" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="gender"><spring:message code="gender.tabhead"/></form:label>
			<form:input path="gender" type="text" class="form-control"
				required="required" />
			<form:errors path="gender" cssClass="text-warning" />
		</fieldset>
		<button type="submit" class="btn btn-success"><spring:message code="submit"/></button>
	</form:form>
</div>

<%@ include file="common/footer.jspf"%>

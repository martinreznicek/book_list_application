<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<!-- EL name is associated with param name form WelcomeController.java -->
	<spring:message code="welcome.message" /> ${name}.<br/>
	<a href="/list-books" class="badge badge-dark"><spring:message code="manage.message" /></a>
</div>

<%@ include file="common/footer.jspf"%>

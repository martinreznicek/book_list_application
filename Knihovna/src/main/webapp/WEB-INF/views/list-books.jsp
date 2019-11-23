<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<table class="table table-striped">
		<caption><spring:message code="book.caption"/></caption>
		<thead>
			<tr>
				<th><spring:message code="author.tabhead"/></th>
				<th><spring:message code="title.tabhead"/></th>
				<th><spring:message code="year.tabhead"/></th>
				<th><spring:message code="country.tabhead"/></th>
				<th><spring:message code="gender.tabhead"/></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${books}" var="book">
				<tr>
					<td>${book.author}</td>
					<td>${book.title}</td>
					<td>${book.year}</td>
					<td>${book.country}</td>
					<td>${book.gender}</td>
					<td><a type="button" class="btn btn-primary" href="/update-book?id=${book.id}"><spring:message code="edit.book"/></a>
						<a type="button" class="btn btn-warning" href="/delete-book?id=${book.id}"><spring:message code="delete.book"/></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a type="button" class="btn btn-success" href="/add-book"><spring:message code="add.book"/></a>
		<a type="button" class="btn btn-primary" href="/books"><spring:message code="export.book"/></a>
	</div>
</div>
<%@ include file="common/footer.jspf"%>
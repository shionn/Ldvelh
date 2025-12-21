<%@ page pageEncoding="UTF-8"%>
<%@ page import="shionn.ldvelh.db.dbo.AttributeType"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
<jsp:attribute name="content">

<h1>${game.fullname}</h1>
<spring:url value="/${game.id}" var="path"/>
<form:form method="POST" action="${url}">
	<c:forEach items="${game.model.attrs}" var="model">
		<c:choose>
			<c:when test="${model.type == AttributeType.stat or model.type == AttributeType.integer}">
				<label>${model.name}</label>
				<span>
					<button formaction="${path}/${model.id}/add">+</button>
					<button formaction="${path}/${model.id}/sub">-</button>
					<input type="text" name="${model.id}" value="${game.value(model)}">
				</span>
			</c:when>
			<c:when test="${model.type == AttributeType.text }">
				<label>${model.name}</label>
				<textarea name="${model.id}" rows="5">${game.value(model)}</textarea>
			</c:when>
			<c:otherwise>
				<label>${model.name}</label>
				TODO
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<input type="submit"/>
</form:form>


</jsp:attribute>
</t:template>
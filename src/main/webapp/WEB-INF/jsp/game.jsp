<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
<jsp:attribute name="content">

<h1>${game.fullname}</h1>

<form:form>
	<c:forEach items="${game.model.attrs}" var="model">
	<t:#{model.type}></t:#{model.type}>
<%-- 	<label>${model.name}</label> --%>
<%-- 	<c:choose> --%>
<%-- 		<c:when test="${model.type == 'stat'}"></c:when> --%>
<%-- 	</c:choose> --%>
	</c:forEach>
</form:form>


</jsp:attribute>
</t:template>
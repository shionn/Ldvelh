<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
<jsp:attribute name="content">

<h1>Livre Dont vous êtes le Héros</h1>

Partie en cours
<ul>
	<c:forEach items="${menu}" var="m">
		<li><a href="<spring:url value="/${m.id}"/>">${m.name} :: ${m.fullname}</a></li>
	</c:forEach>
</ul>


</jsp:attribute>
</t:template>
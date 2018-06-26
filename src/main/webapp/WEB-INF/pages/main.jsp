<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Hello,this is main page</h1>

<c:if test="${!empty errormsg}">
	<script type="text/javascript">
		alert('${errormsg}');
	</script>
</c:if>

<form:form action="/psall/saveform"  commandName="user" method="post">
	<form:label path="id">id:</form:label><form:input path="id" readonly="true"/> <br/>
	<form:label path="name">name:</form:label><form:input path="name"/> <br/>
	<form:label path="email">email:</form:label><form:input path="email"/> <br/>
	<form:label path="age">age:</form:label><form:input path="age"/> <br/>
	<input type="submit" value="Submit!"/>
</form:form>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: simonpirko
  Date: 1.03.22
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Title</title>
</head>
<body>

<s:form action="/user/reg" method="post" modelAttribute="newUser">

	<s:input path="name"  placeholder="Name"/>
	<s:errors path="name"/>

	<s:input path="password" placeholder="Password"/>
	<s:errors path="password"/>

	<s:button>Submit</s:button>

</s:form>


<%--<form action="/user/reg" method="post">--%>
<%--	<input type="text" name="name" placeholder="Name">--%>
<%--	<p>${name}</p>--%>
<%--	<input type="text" name="password" placeholder="Password">--%>
<%--	<p>${password}</p>--%>
<%--	<button>Submit</button>--%>
<%--</form>--%>
</body>
</html>

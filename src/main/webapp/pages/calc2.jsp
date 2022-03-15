<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 01.03.2022
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Calc</title>
</head>
<body>
<s:form action="/calc" method="post" modelAttribute="operation">
    <s:input path="value1" type="text" placeholder="Value1"/>
    <s:errors path="value1"/>
    <br>
    <s:select path="operation">
<%--        <option disabled selected>Choose operation</option>--%>
        <option value="sum">+</option>
        <option value="div">/</option>
        <option value="dif">-</option>
        <option value="mult">*</option>
    </s:select>
    <s:errors path="operation"/>
    <br>
    <s:input path="value2" placeholder="Value2"/>
    <s:errors path="value2"/>
    <br>
    <s:button>Submit</s:button>
     ${result}

</s:form>
</body>
</html>


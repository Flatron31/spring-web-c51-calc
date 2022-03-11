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
<%--<form action="/calc/" method="post">--%>
<%--    <input type="text" name="value1" placeholder="Value1">--%>
<%--    <select name="operation" required>--%>
<%--        <option disabled selected>Choose operation</option>--%>
<%--        <option value="sum">+</option>--%>
<%--        <option value="div">/</option>--%>
<%--        <option value="dif">-</option>--%>
<%--        <option value="mult">*</option>--%>
<%--    </select>--%>
<%--    <input type="text" name="value2" placeholder="value2">--%>
<%--    <button>Submit</button>--%>
<%--    <p>${result}</p>--%>
<%--</form>--%>

<s:form action="/calc" method="post" modelAttribute="operation">

    <s:input path="value1" type="text" placeholder="Value1"/>
    <s:errors path="value1"/>

    <s:select path="operation">
        <option disabled selected>Choose operation</option>
        <option value="sum">+</option>
        <option value="div">/</option>
        <option value="dif">-</option>
        <option value="mult">*</option>
    </s:select>
    <s:errors path="operation"/>

    <s:input path="value2" placeholder="Value2"/>
    <s:errors path="value2"/>

    <s:button>Submit</s:button>
    <td>${result}</td>

</s:form>


</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: fuzhongyu
  Date: 2017/4/16
  Time: 下午2:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>helloWorldForm</title>
</head>
<body>
     <form:form action="/helloWorld/form" modelAttribute="helloWorld">
         <form:input path="title"></form:input>
     </form:form>
</body>
</html>

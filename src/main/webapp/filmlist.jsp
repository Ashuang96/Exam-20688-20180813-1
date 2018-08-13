<%--
  Created by IntelliJ IDEA.
  User: Ashuang
  Date: 2018/8/13
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>

<head>
    <title>电影列表</title>
</head>
<body>
    <table bgcolor="aqua" border="1">
        <th>序号</th><th>标题</th><th>描述</th><th>语言</th>
        <c:forEach items="${list}" var="film">
        <tr>
            <td><c:out value="${film.film_id}"/></td>
            <td><c:out value="${film.title}"/></td>
            <td><c:out value="${film.description}"/></td>
            <td><c:out value="${film.language}"/></td>
            <td><button><a href="addFilm.jsp">新增</a></button></td>
            <td><button><a href="updateFilm.jsp?id=<c:out value='${film.film_id}'/>">修改</a></button></td>
            <td><button><a href="deleteServlet?id=<c:out value='${film.film_id}'/>">删除</a></button></td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>

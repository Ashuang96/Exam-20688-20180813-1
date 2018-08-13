<%@ page import="com.hand.bean.Film" %>
<%@ page import="com.hand.dao.FilmDao" %>
<%@ page import="com.hand.bean.Language" %>
<%@ page import="com.hand.dao.LanguageDao" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ashuang
  Date: 2018/8/13
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<%
    String id = request.getParameter("id");
    FilmDao filmDao = new FilmDao();
    Film film = filmDao.getFilm(id);
    LanguageDao dao = new LanguageDao();
    List<Language> list = dao.getLanguage();
%>
<body>
<form method="post" action="updateFilm?id=<%=id%>">
    <table>
        <tr>
            <td>标题</td>
            <td><input name="title" type="text" value="<%=film.getTitle()%>"></td>
        </tr>
    <tr>
        <td>描述</td>
        <td><textarea name="description" style="margin: 0px; width: 173px; height: 256px;"><%=film.getDescription()%></textarea>
        </td>
    </tr>
        <tr>
            <td>语言</td>

        <td><select name="language">
    <%
        for (Language l : list) {
    %>
            <option value="<%=l.getLanguage_id()%>"><%=l.getName()%></option>
    <%
        }
    %>
    </select>
        </td>
        </tr>
    </table>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>
</body>
</html>

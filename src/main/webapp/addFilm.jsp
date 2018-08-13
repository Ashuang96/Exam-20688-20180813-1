<%--
  Created by IntelliJ IDEA.
  User: Ashuang
  Date: 2018/8/13
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增</title>
</head>
<body>
    <form method="post" action="addFilm">
        <table>
            <tr><td>标题</td><td><input name="title" type="text"></td></tr>
        <tr><td>描述</td>
           <td><textarea name="description" style="height: 310px; margin: 0px; width: 174px;"></textarea></td>
        </tr>
        </table>
        语言<select name="language">
            <option name="language" value="1">English</option>
            <option name="language" value="2">Italian</option>
            <option name="language" value="3">Japanese</option>
            <option name="language" value="4">Mandarin</option>
            <option name="language" value="5">French</option>
            <option name="language" value="6">German</option>
            </select>
        <input type="submit" value="提交">
        <input type="reset" value="重置">
    </form>
</body>
</html>

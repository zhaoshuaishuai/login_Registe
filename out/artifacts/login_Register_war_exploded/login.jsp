<%--
  Created by IntelliJ IDEA.
  User: zss
  Date: 2015/7/15
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script language="JavaScript">
  function register(){

  }
</script>

<html>
  <head>
    <title>登录界面</title>
  </head>
  <body>
  <h1 align="center">请登录</h1>
  <br><br>
  <br><br>
  <%
    String msg= (String) request.getAttribute("msg");
  %>

<form method="post" action="<%=request.getContextPath()%>/loginCheckServlet?from=login">
  <table align="center" cellpadding="10" cellspacing="0" border="2">
    <tr>
      <td>userId:</td>
      <td>
        <input type="text" name="Id" size="18"/>
        <%
          if(msg==null) {
            out.print("");
          }else{
            %>
        <%=msg%>
        <%
          }

        %>
      </td>
    </tr>
    <tr>
      <td>password:</td>
      <td>
        <input type="password" name="password" size="18"/>
      </td>
    </tr>
    <tr>
      <td>
        <input type="submit" value="登录"/>
      </td>
      <td>
        <a href="<%=request.getContextPath()%>/register.jsp"><input type="button" value="新用户注册"></a>
      </td>
    </tr>
  </table>
</form>

  </body>
</html>

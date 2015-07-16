<%--
  Created by IntelliJ IDEA.
  User: zss
  Date: 2015/7/15
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<script language="JavaScript">
  var xmlHttp;
  var flag;
  function createXMLHttp(){
    if(window.XMLHttpRequest){
      xmlHttp=new XMLHttpRequest();
    }else{
      xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
  }
  function checkUserid(id){
    createXMLHttp();
    xmlHttp.open("POST","checkServlet?userId="+id);
    xmlHttp.onreadystatechange=checkUseridCallback;
    xmlHttp.send(null);
    document.getElementById("msg").innerHTML="正在验证";
  }
  function checkUseridCallback(){
    if(xmlHttp.readyState==4){
      if(xmlHttp.status==200){
        var text=xmlHttp.responseText;
        if(text=="true"){
          flag=false;
          document.getElementById("msg").innerHTML="用户ID重复，无法使用";
        }else{
          flag=true;
          document.getElementById("msg").innerHTML="此用户ID可以注册";
        }
      }
    }
  }
  function checkForm(){
    return flag;
  }
</script>
<h1 align="center">注册</h1>
<form  action="login.jsp" method="post">
  <table border="2" cellpadding="10" cellspacing="0" align="center">
    <tr>
      <td>用户ID：</td>
      <td>
        <input type="text" name="rUsetId" size="18" onblur="checkUserid(this.value)"/><span id="msg"></span>
      </td>
    </tr>
    <tr>
      <td>密码</td>
      <td>
        <input type="password" name="rnPassword"size="18"/>
      </td>
    </tr>
    <tr>
      <td>请再次输入密码</td>
      <td>
        <input type="password" name="rsPassword" size="18"/>
      </td>
    </tr>
    <tr>
      <td>用户名：</td>
      <td><input type="text" name="rUserName" size="18"/></td>
    </tr>
    <tr>
      <td>注册邮箱：</td>
      <td><input type="text" name="rUserEmail" size="18"></td>
    </tr>
    <tr>
      <td>注册生日：</td>
      <td>
        <input type="text" name="rBirthday" size="18"/>
      </td>
    </tr>
    <tr>
      <td>
        <input  type="submit" value="提交" align="center" onsubmit="return checkForm()"/>
      </td>
      <td><input type="reset" value="重置"/></td>
    </tr>
  </table>
</form>
</body>
</html>

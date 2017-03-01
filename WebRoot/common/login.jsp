<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>正在注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <table width="780" align="center" cellspacing="0"
	background="images/bodybg.jpg">
<tr>
<td >
<h3>请输入登录教务处的账号和密码</h3>
<div align="center">
<!-- 输出Action的错误提示 -->
<s:actionerror cssClass="error"/>
<s:form action="login">
	<s:textfield name="username" label="账号"/>
	<s:textfield name="password" label="密码" type="password"/>
	<s:textfield name="vercode" label="验证码"/>
	<s:submit value="登录"/>
</s:form>
验证码：<img name="d" src="auth.jpg">
</div>
</td>
</tr>
</table>
  </body>
</html>

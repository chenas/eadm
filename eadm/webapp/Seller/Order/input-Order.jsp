<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>输入商店信息</title>
<base target="_self">
<link rel="stylesheet" type="text/css" href="Seller/skin/css/base.css" />
<link rel="stylesheet" type="text/css" href="Seller/skin/css/main.css" />
<script src="JS/jquery-1.9.1.js"></script>
</head>
<body leftmargin="8" topmargin='8'>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px;margin-top:8px;">
  <tr>
    <td background="Seller/skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'><span>消息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td><font color="red" ><s:actionmessage/></font></td>
  </tr>
</table>
<form action="myshop/save-Seller" method="post">
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr bgcolor="#EEF4EA">
    <td colspan="2" background="Seller/skin/images/frame/wbg.gif" class='title'><span>输入商店信息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">商店编号：</td>
    <td width="85%" bgcolor="#FFFFFF"><input type="text" name="seller.storeid" value='<s:property value="#seller.storeid" />' size="50" /></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">商店账号：</td>
    <td width="85%" bgcolor="#FFFFFF"><input type="text" name="seller.name" value='<s:property value="#seller.name" />' size="50" /></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">登录密码：</td>
    <td width="85%" bgcolor="#FFFFFF"><input type="password" name="seller.password"  value='<s:property value="#seller.password" />' size="50" /></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">商店名称：</td>
    <td width="85%" bgcolor="#FFFFFF"><input type="text" name="seller.realname" value='<s:property value="#seller.realname" />'  size="50" /></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">商店电话：</td>
    <td width="85%" bgcolor="#FFFFFF"><input type="text" name="seller.phone" value='<s:property value="#seller.phone" />'  size="50" /></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">商店地址：</td>
    <td width="85%" bgcolor="#FFFFFF">
    <select name="seller.address"  >
    	<option value="北校区" >北校区</option>
    	<option value="南校区" >南校区</option>
    </select></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td colspan="2" bgcolor="#FFFFFF"><input type="submit" value="保   存" size="30" /></td>
  </tr>
</table>
</form>
</body>
</html>
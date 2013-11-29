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
<title>输入二级分类信息</title>
<base target="_self">
<link rel="stylesheet" type="text/css" href="Seller/skin/css/base.css" />
<link rel="stylesheet" type="text/css" href="Seller/skin/css/main.css" />
<script src="JS/jquery-1.9.1.js"></script>
<script src="JavaScript/category.js"></script>
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
<form action="myshop/save2-Product" method="post">
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr bgcolor="#EEF4EA">
    <td colspan="2" background="Seller/skin/images/frame/wbg.gif" class='title'><span>输入二级分类信息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">所属分类：</td>
    <td width="85%" bgcolor="#FFFFFF">
									<select id="cat1"  name="category.name" >
										<option value="0">...请选择...</option>
									</select></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">分类名称：</td>
    <td width="85%" bgcolor="#FFFFFF"><input type="text" name="categoryDetail.name" value='<s:property value="#categoryDetail.name" />' size="50" /></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">描述：</td>
    <td width="85%" bgcolor="#FFFFFF"><input type="text" name="categoryDetail.description" value='<s:property value="#categoryDetail.description" />' size="50" /></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td colspan="2" bgcolor="#FFFFFF"><input type="submit" value="保   存" size="30" /></td>
  </tr>
</table>
</form>
</body>
</html>
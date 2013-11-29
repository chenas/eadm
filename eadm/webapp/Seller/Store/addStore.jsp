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
<link rel="stylesheet" type="text/css" href="admin/skin/css/base.css" />
<link rel="stylesheet" type="text/css" href="admin/skin/css/main.css" />
<script src="JS/jquery-1.9.1.js" ></script>
<script src="JavaScript/validatecode.js"></script>
</head>
<body leftmargin="8" topmargin='8'>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px;margin-top:8px;">
  <tr>
    <td background="admin/skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'><span>消息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td><font color="red" ><s:actionmessage/><s:property value="#request.message" /></font></td>
  </tr>
</table>
<form action="seller/shop/submitAdd" method="post">
<input type="hidden" value="0" name="userShopModel.isEshop" >
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr bgcolor="#EEF4EA">
    <td colspan="2" background="admin/skin/images/frame/wbg.gif" class='title'><span>新增商店</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">用户名：</td>
    <td width="85%" bgcolor="#FFFFFF"><input type="text"  name="userShopModel.name"  size="50" maxlength="15"/></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">密码：</td>
    <td width="85%" bgcolor="#FFFFFF"><input type="password"  name="userShopModel.password"  size="50" /></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">编号：</td>
    <td width="85%" bgcolor="#FFFFFF"><input type="text"  name="userShopModel.storeId"  size="50" maxlength="5" /></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">名称：</td>
    <td width="85%" bgcolor="#FFFFFF"><input type="text"  name="userShopModel.storeName"  size="50" /></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">联系方式：</td>
    <td width="85%" bgcolor="#FFFFFF"><input type="text"  name="userShopModel.phone" size="50" maxlength="11" /></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">地址：</td>
    <td width="85%" bgcolor="#FFFFFF"><select name="userShopModel.address" ><option value="北校区">北校区</option><option value="南校区">南校区</option><option value="其他">其他</option></select></td>
  </tr>
<%--   <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">商店简介：</td>
    <td width="85%" bgcolor="#FFFFFF"><textarea rows="4" cols="50"  name="userShopModel.desc" ><s:property value="#session.seller.description" /></textarea></td>
  </tr> --%>
<!--   <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">验证码：</td>
    <td width="85%" bgcolor="#FFFFFF"><input type="text" name="securityCode" size="50" /></td>
  </tr> -->
<!--   <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">单击换验证码：</td>
    <td width="85%" bgcolor="#FFFFFF"><img src="Security/SecurityCodeImageAction" id="Verify"  style="cursor:hand;" alt="看不清，换一张"/></td>
  </tr> -->
  <tr bgcolor="#FFFFFF">
    <td colspan="2" bgcolor="#FFFFFF"><input type="submit" value="保   存" size="30" /></td>
  </tr>
</table>
</form>
</body>
</html>
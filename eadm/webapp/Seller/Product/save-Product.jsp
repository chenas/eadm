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
<title>输入商品信息</title>
<base target="_self">
<link rel="stylesheet" type="text/css" href="admin/skin/css/base.css" />
<link rel="stylesheet" type="text/css" href="admin/skin/css/main.css" />
<script src="JS/jquery-1.9.1.js"></script>
	<script src="JavaScript/showpicture.js"></script>
	<script src="JavaScript/category.js"></script>
</head>
<body leftmargin="8" topmargin='8'>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px;margin-top:8px;">
  <tr>
    <td background="admin/skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'><span>消息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td><font color="red" ><s:actionmessage/></font></td>
  </tr>
</table>
<form action="myshop/save-Product" method="post">
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr bgcolor="#EEF4EA">
    <td colspan="2" background="admin/skin/images/frame/wbg.gif" class='title'><span>输入商品信息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">分类</td>
    <td width="85%" bgcolor="#FFFFFF">
									<select id="cat1"  name="cat1" onchange="createCategory()">
										<option value="0">...请选择...</option>
									</select></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">具体类型</td>
    <td width="85%" bgcolor="#FFFFFF">
									<select id="cat2" name="cat2" >
										<option value="0">...请选择...</option>
									</select></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">编&nbsp;号</td>
    <td width="85%" bgcolor="#FFFFFF">
									<input size="40" type="text" name="productVo.productid" value="<s:property value="#product.productid" />"  >
									<input type="text" disabled  value="自己定义"/></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">名&nbsp;称</td>
    <td width="85%" bgcolor="#FFFFFF">
									<input size="40" type="text" name="productVo.name" value="<s:property value="#product.name" />" />
									<input type="text" disabled  value="请保持字数在50字以内"/></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">单&nbsp;价</td>
    <td width="85%" bgcolor="#FFFFFF">
									<input size="40" type="text" name="productVo.price" value="0" />
									<input type="text" disabled value="请填写数字"/></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">进&nbsp;价</td>
    <td width="85%" bgcolor="#FFFFFF">
									<input size="40" type="text" name="productVo.inprice" value="0" />
									<input type="text" disabled value="请填写数字"/></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">库存量</td>
    <td width="85%" bgcolor="#FFFFFF">
									<input size="40" type="text" name="productVo.kucunliang" value="0" />
									<input type="text" disabled value="只能填写正整数"/></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">促销状况</td>
    <td width="85%" bgcolor="#FFFFFF">
									<input type="radio" name="productVo.cuxiao" value="1" />
									是
									<input type="radio" name="productVo.cuxiao" value="0" checked/>
									否</td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">促销价格</td>
    <td width="85%" bgcolor="#FFFFFF">
									<input size="40" type="text" name="productVo.cuxiaojia" value="0" />
									<input type="text" disabled value="只能填写数字"/></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">上架状况</td>
    <td width="85%" bgcolor="#FFFFFF">
									<input type="radio" name="productVo.status" value="1" checked/>
									是
									<input type="radio" name="productVo.status" value="0" />
									否</td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">关键词</td>
    <td width="85%" bgcolor="#FFFFFF">
									<input size="40" type="text" name="productVo.keywords" value="<s:property value="#product.keywords" />" />
									<input type="text" disabled  value="多个关键词以逗号隔开，请保持字数在30字以内"/></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF">
									商&nbsp;品
									<br>描&nbsp;述</td>
    <td width="85%" bgcolor="#FFFFFF">
									<textarea name="productVo.descr" rows="3" cols="30"  ><s:property value="#product.description" />
									</textarea></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="15%" bgcolor="#FFFFFF"></td>
    <td width="85%" bgcolor="#FFFFFF"><img id="uploadPreview" style="width: 400px; height: 400px;"  alt="图片预览区域" src='<s:property value="#product.imageurl" />' />
	<input id="uploadImage" type="file" name="file"  size="50" onchange="loadImageFile();" class="file" />
    </td>
  </tr>
  
  
  <tr bgcolor="#FFFFFF">
    <td colspan="2" bgcolor="#FFFFFF">
    <input type="submit" value="保   存" size="30" /></td>
  </tr>
</table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<base href="<%=basePath%>">
<title>menu</title>
<link rel="stylesheet" href="Seller/skin/css/base.css" type="text/css" />
<link rel="stylesheet" href="Seller/skin/css/menu.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language='javascript'>var curopenItem = '1';</script>
<script language="javascript" type="text/javascript" src="Seller/skin/js/frame/menu.js"></script>
<base target="main" />
</head>
<body target="main">
<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
  <tr>
    <td style='padding-left:3px;padding-top:8px' valign="top">
	<!-- Item 1 Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items1_1")'><b>商品管理</b></dt>
        <dd style='display:block' class='sitem' id='items1_1'>
          <ul class='sitemu'>
            <li>
                <a href='seller/product/allProduct' target='main'>商品列表</a>
            </li>
            <li>
            	<!-- <a href='Seller/Product/save-Product.jsp' target='main'>添加商品</a>  -->
            </li>
            <li>
            	<a href='Seller/Product/upload-Product.jsp' target='main'>批量导入</a>
            </li>
          </ul>
        </dd>
      </dl>
      <!-- Item 1 End -->
	<!-- Item 2 Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items1_1")'><b>商品分类管理</b></dt>
        <dd style='display:block' class='sitem' id='items1_1'>
          <ul class='sitemu'>
            <li>
            	<!-- <a href='Seller/Product/list2-Product' target='main'>分类列表</a>  -->
            </li>
            <li>
            	<!-- <a href='Seller/Product/input2-Product.jsp' target='main'>添加二级分类</a>  -->
            </li>
          </ul>
        </dd>
      </dl>
      <!-- Item 2 End -->
      <!-- Item n Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items2_1")'><b>系统帮助</b></dt>
        <dd style='display:block' class='sitem' id='items2_1'>
          <ul class='sitemu'>
            <li><a href='http://www.usst.edu.cn' target='_blank'>上海理工大学</a></li>
            <li><a href='http://www.usst.edu.cn' target='_blank'>勤助中心</a></li>
          </ul>
        </dd>
      </dl>
      <!-- Item n End -->
	  </td>
  </tr>
</table>
</body>
</html>
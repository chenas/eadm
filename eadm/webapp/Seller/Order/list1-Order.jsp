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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>订单管理</title>
<link rel="stylesheet" type="text/css" href="Seller/skin/css/base.css">
<script src="JS/jquery-1.9.1.js"></script>
<script src="JavaScript/operations.js" ></script>
</head>
<body leftmargin="8" topmargin="8" >
<!--  快速转换位置按钮  -->
<div class="noprint">
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="Seller/skin/images/newlinebg3.gif">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td align="center">
    <input type='button' class="coolbg np" onClick="window.location.href=('../Seller/Product/save-Product.jsp');" value='添加商品' />
    <input type='button' class='coolbg np' onClick="window.location.href=('../Seller/Product/upload-Product.jsp');" value='批量导入商品' />
    <input type='button' class="coolbg np" onClick="window.location.href=('../Seller/Category/input2-Category.jsp');" value='添加分类' />
    <input type='button' class="coolbg np" onClick="JavaScript:alert(('敬请期待'));" value='敬请期待' />
    <input type='button' class="coolbg np" onClick="JavaScript:alert(('敬请期待'));" value='敬请期待' />
    <input type='button' class="coolbg np" onClick="JavaScript:alert(('敬请期待'));" value='敬请期待' />
    <input type='button' class="coolbg np" onClick="JavaScript:alert(('敬请期待'));" value='敬请期待' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>
</div>
  
<!--  内容列表   -->
<form name="list1form">

<div id="block">
<table id="tblout" width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="13" background="Seller/skin/images/tbg.gif">&nbsp;未发货订单列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<th width="4%">选择</th>
	<th width="10%">订单编号</th>
	<th width="25%">目的地</th>
	<th width="11%">下单时间</th>
	<th width="10%">收货人</th>
	<th width="10%">联系方式</th>
	<th width="10%">订单总价</th>
	<th width="10%">二维码</th>
	<!-- <th width="10%">操作</th> -->
</tr>
<s:if test="#request.pageList.map == null">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"  >
<td colspan="14"><font color="red">您暂还没订单</font></td>
</tr>
</s:if>
<s:else>
<s:iterator value="#request.pageList.map.keySet()" var="key">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><input name="checkbox" type="checkbox" id="checkid" value="<s:property value="#key.id" />" class="np"></td>
	<td><s:property value="#key.orderid" /></td>
	<td><s:property value="#key.finaladdr" /></td>
	<td><s:property value="#key.ordertime" /></td>
	<td><s:property value="#key.reciever" /></td>
	<td><s:property value="#key.phone" /></td>
	<td><s:property value="#key.totalpris" />元</td>
	<td rowspan="2"><img alt="二维码" src="<s:property value="#key.qrcode" />" width="150" height="40" ></td>
	<%-- <td><a id="edit" href='myshop/send-Order?id=<s:property value="#key.id" />' >发货</a></td> --%>
</tr>
<s:iterator value="#request.pageList.map.get(#key)" var="val">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td>&nbsp;</td>
	<td align="right"><a>订单详情</a></td>
	<td align="left">商品名称：<s:property value="#val.product.name" /></td>
	<td>数量：<s:property value="#val.count" /></td>
	<td>单价：<s:property value="#val.price" />元</td>
	<td>总：<s:property value="#val.itemprise" />元</td>
	<td>&nbsp;</td>
</tr>
</s:iterator>
</s:iterator>
</s:else>

<tr bgcolor="#FAFAF1">
<td height="28" colspan="13">
	&nbsp;
	<a href="javascript:" id="all" class="coolbg">全选</a>
	<a href="javascript:" id="noAll" class="coolbg">取消</a>
	<a href="javascript:" id="fanxuan" class="coolbg">&nbsp;反选&nbsp;</a>
	<a href='download/downexcel?fileName=downexcel' target="_blank" id="export" class="coolbg" >&nbsp;导出&nbsp;</a>
	<a href="javascript:" id="sendOrder" class="coolbg">&nbsp;发货&nbsp;</a>
	<a href="javascript:" id="refreshNew1" class="coolbg" >&nbsp;刷新&nbsp;</a>
	<input type=button value='打印' onClick="window.print();">
</td>
</tr>
<tr>
<td>

</td>
</tr>

</table>
</div>
</form>

<!--  搜索表单  -->
<form name='form3' action='' method='get'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='Seller/skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr >
          <td width='100%' align="left">注意：1、可以选择先导出订单到excel表格或者打印，再发货，否则无法导出或打印订单</td>
       </tr>
       <tr>
       	<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、点击导出时，会把所有的未发货订单全部导出，然后选择保存excel表格，可多次导出</td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
</body>
</html>
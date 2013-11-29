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
<script type="text/javascript">
var current = 0;
var totalPage = 0;
$(document).ready(function(){
	current = parseInt($("#current").text()); //当前页
	totalPage = parseInt($("#totalPage").text());
	//console.log(current);
	//上一页
	$("#pre").click(function(){
		if(parseInt(current) == 1) return;
		else if(parseInt(current) >1){
			current--;
			$("#current").text(current);
			window.location.href='seller/order/newOrder?orderMenuFilter.pageNo='+current;
			//document.pagelistfrm.submit();
		}
	});

	//下一页
	$("#next").click(function(){
		if(parseInt(current) == parseInt(totalPage)) return;
		else if(parseInt(current) < parseInt(totalPage)){
			current++;
			$("#current").text(current);
			window.location.href='seller/order/newOrder?orderMenuFilter.pageNo='+current;
			//document.pagelistfrm.submit();
		}
	});
});

</script>
</head>
<body leftmargin="8" topmargin="8" >

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="Seller/skin/images/newlinebg3.gif">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td align="center">
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
  
<!--  内容列表   -->
<form name="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="13" background="Seller/skin/images/tbg.gif">&nbsp;订单列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<th width="4%">选择</th>
	<th width="10%">编号</th>
	<th width="10%">登录名</th>
	<th width="16%">商店名称</th>
	<th width="30%">地址</th>
	<!-- <th width="10%">联系方式</th> -->
<!-- 	<th width="30%">目的地</th> -->
	<th width="10%">操作</th>
</tr>

<s:if test="#request.pageList.list == null">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"  >
<td colspan="14"><font color="red">您还没新订单</font></td>
</tr>
</s:if>
<s:else>
<s:iterator value="#request.pageList.list" var="key">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><input name="checkbox" type="checkbox" id="checkid" value='<s:property value="#key.id" />' class="np"></td>
	<td><s:property value="#key.storeId" /></td>
	<td><s:property value="#key.name" /></td>
	<td><s:property value="#key.storeName" /></td>
	<td><s:property value="#key.address" /></td>
	<%-- <td><s:property value="#key.phone" /></td> --%>
	<%-- <td><s:property value="#key.fianladdr" /></td> --%>
	<td><a id="edit" href='javascript:void(0)' >删除</a></td>
</tr>
</s:iterator>
</s:else>
<tr bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="javascript:" id="all" class="coolbg">全选</a>
	<a href="javascript:" id="noAll" class="coolbg">取消</a>
	<a href="javascript:" id="fanxuan" class="coolbg">&nbsp;反选&nbsp;</a>
	<!-- <a href="javascript:" id="comfirNew" class="coolbg">&nbsp;确认接收&nbsp;</a> -->
	<a href="javascript:" id="refreshNew0" class="coolbg" >&nbsp;刷新&nbsp;</a>
</td>
</tr>

<tr align="right" bgcolor="#EEF4EA">
			<td colspan="14" align="center">
        		<input id="pageNo" type="hidden" value='<s:property value="#request.pageList.pageNumber" />' />
				<a href="javascript:void(0);" id="pre">上一页</a>
				<a href="javascript:void(0);" id="current"><s:property value="#request.pageList.pageNumber" /></a>/
				<a href="javascript:void(0);" id="totalPage"><s:property value="#request.pageList.totalPage" /></a>
				<a href="javascript:void(0);" id="next">下一页</a>&nbsp;&nbsp;
			</td>
</tr>
</table>

</form>

<!--  提示栏 -->
<form name='form3' action='' method='get'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='Seller/skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='100%' align='center'>说明：确认接收之后，会员无法取消订单</td>
          
      </table>
    </td>
  </tr>
</table>
</form>
</body>
</html>
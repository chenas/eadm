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
  
<!--  内容列表   -->
<form name="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="13" background="Seller/skin/images/tbg.gif">&nbsp;已发货订单列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<th width="4%">选择</th>
	<th width="10%">订单编号</th>
	<th width="10%">订单状态</th>
	<th width="16%">下单时间</th>
	<th width="10%">订单总价</th>
	<th width="10%">联系方式</th>
	<th width="30%">目的地</th>
	<th width="10%">操作</th>
</tr>
<s:if test="#request.pageList.map == null">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"  >
<td colspan="14"><font color="red">您暂还没订单</font></td>
</tr>
</s:if>
<s:else>
<s:iterator value="#pageList.map.keySet()" var="key">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><input name="checkbox" type="checkbox" id="checkid" value="<s:property value="#key.id" />" class="np"></td>
	<td><s:property value="#key.orderid" /></td>
	<td>会员未确认</td>
	<td><s:property value="#key.ordertime" /></td>
	<td><s:property value="#key.totalpris" /></td>
	<td><s:property value="#key.phone" /></td>
	<td><s:property value="#key.finaladdr" /></td>
	<td><a id="edit" href='javascript:' >待定</a></td>
</tr>
<s:iterator value="#pageList.map.get(#key)" var="val">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td>&nbsp;</td>
	<td align="right"><a>订单详情</a></td>
	<td align="left">商品名称：<s:property value="#val.product.name" /></td>
	<td>数量：<s:property value="#val.count" /></td>
	<td>单价：<s:property value="#val.price" /></td>
	<td>总：<s:property value="#val.itemprise" /></td>
	<td><a id="edit" href='javascript:' >待定</a></td>
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
	<a href="javascript:" id="" class="coolbg">&nbsp;待定&nbsp;</a>
	<a href="javascript:" id="refreshNew2" class="coolbg" >&nbsp;刷新&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
			<td colspan="8" align="center">
        		<input id="pageNo" type="hidden" value='<s:property value="#request.pageList.pageNumber" />' />
				<s:if test = "#request.pageList.pageNumber>1" >
				<a href="myshop/list2-Order?pageNo=1">第一页</a>&nbsp;&nbsp;
				<a href="myshop/list2-Order?pageNo=${request.pageList.pageNumber-1}">上一页</a>
				</s:if>
				<s:else>
 				  已在第一页
				</s:else>
					<s:set name="number" value="#request.pageList.totalPage" />   <!-- 一共多少页 -->
    				<s:bean name="org.apache.struts2.util.Counter" id="counter">
       				<s:param name="first" value="1" />
        			<s:param name="last" value="%{#number}"  />
        			<s:iterator> 
             		  <s:if test="#request.pageList.pageNumber == <s:property />"><s:property /></s:if>
             		  <s:else><a href="myshop/list2-Order?pageNo=<s:property />"><s:property /></a></s:else>
             		  &nbsp;&nbsp;
     			   	</s:iterator>
      				</s:bean>
				<s:if test = "#request.pageList.pageNumber<#request.pageList.totalPage" >
				<a href="myshop/list2-Order?pageNo=${request.pageList.pageNumber+1}">下一页</a>&nbsp;&nbsp;
				<a href="myshop/list2-Order?pageNo=${request.pageList.totalPage }">末页</a>
				</s:if>
				<s:else>
   				末页
				</s:else>
			</td>
</tr>
</table>

</form>

<!--  搜索表单  -->
<form name='form3' action='' method='post'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='Seller/skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='cid' style='width:150'>
          <option value='0'>选择类型...</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='keyword' value='' style='width:150px' />
        </td>
        <td width='110'>
    		<select name='orderby' style='width:80px'>
            <option value='id'>排序...</option>
      	</select>
        </td>
        <td>
          <input name="imageField" onclick="javascript:alert('敬请期待');" type="image" src="Seller/skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
</body>
</html>
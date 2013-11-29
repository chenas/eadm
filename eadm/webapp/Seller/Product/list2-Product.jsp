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
<title>分类列表</title>
<link rel="stylesheet" type="text/css" href="Seller/skin/css/base.css">
<script src="JS/jquery-1.9.1.js"></script><%-- 
<script src="Seller/skin/js/frame/operations.js" ></script> --%>
</head>
<body leftmargin="8" topmargin="8" >

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="Seller/skin/images/newlinebg3.gif">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td align="left" width="5%">快捷方式</td>
  <td align="center" width="95%">
    <input type='button' class="coolbg np" onClick="window.location.href=('../Seller/Product/save-Product.jsp');" value='添加商品' />
    <input type='button' class='coolbg np' onClick="window.location.href=('../Seller/Product/upload-Product.jsp');" value='批量导入商品' />
    <input type='button' class="coolbg np" onClick="window.location.href=('../Seller/Product/input2-Product.jsp');" value='添加分类' />
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
	<td height="24" colspan="13" background="Seller/skin/images/tbg.gif">&nbsp;商品分类列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<th width="10%">分类编号</th>
	<th width="20%">分类名称</th>
	<th width="20%">描述</th>
	<th width="10%">添加二级分类</th>
	<!-- <th width="10%">操作</th> -->
</tr>
<s:iterator value="#pageList.map.keySet()" var="key">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><s:property value="#key.id" /></td>
	<td align="left" >&nbsp;&nbsp;<s:property value="#key.name" /></td>
	<td><s:property value="#key.description" /></td>
	<td align="left" ><a href='Seller/Product/save2-Product.jsp'>增加二级分类</a></td>
	<%-- <td><a id="edit" href='admin/input-Product?id=<s:property value="#key.id" />' >编辑</a> | <a id="del" href='admin/delete-Product?id=<s:property value="#key.id" />' >删除</a></td> --%>
</tr>
<s:iterator value="#pageList.map.get(#key)" var="val">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td></td>
	<td align="center">----<s:property value="#val.name" /></td>
	<td><s:property value="#val.description" /></td>
	<td align="left"><a></a></td>
	<%-- <td><a id="edit" href='admin/input2-Category?id=<s:property value="#val.id" />' >编辑</a> | <a id="del" href='admin/delete2-Category?id=<s:property value="#val.id" />' >删除</a></td> --%>
</tr>
</s:iterator>
</s:iterator>
<tr bgcolor="#FAFAF1">
</tr>
<tr align="right" bgcolor="#EEF4EA">
			<td colspan="7" align="center">
				<s:if test = "#request.pageList.pageNumber>1" >
				<a href="myshop/list2-Product?pageNo=1">第一页</a>&nbsp;&nbsp;
				<a href="myshop/list2-Product?pageNo=${request.pageList.pageNumber-1}">上一页</a>
				</s:if>
				<s:else>
 				  已在第一页
				</s:else>
					<s:set name="number" value="#request.pageList.totalPage" />   <!-- 一共多少页 -->
    				<s:bean name="org.apache.struts2.util.Counter" id="counter">
       				<s:param name="first" value="1" />
        			<s:param name="last" value="%{#number}"  />
        			<s:iterator>  
             		  <a href="myshop/list2-Product?pageNo=<s:property />"><s:property /></a>&nbsp;&nbsp;
     			   	</s:iterator>
      				</s:bean>
				<s:if test = "#request.pageList.pageNumber<#request.pageList.totalPage" >
				<a href="myshop/list2-Product?pageNo=${request.pageList.pageNumber+1}">下一页</a>&nbsp;&nbsp;
				<a href="myshop/list2-Product?pageNo=${request.pageList.totalPage }&status=0">末页</a>
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
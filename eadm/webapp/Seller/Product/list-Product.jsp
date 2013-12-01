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
<title>商品列表</title>
<link rel="stylesheet" type="text/css" href="Seller/skin/css/base.css">
<script src="JS/jquery-1.9.1.js"></script>
<script src="JavaScript/operations.js" ></script>
<script src="JavaScript/pagelist.js" ></script>
<script language="javascript">
</script>
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
    <input type='button' class="coolbg np" onClick="JavaScript:alert(('敬请期待'));" value='敬请期待' />
    <input type='button' class="coolbg np" onClick="JavaScript:alert(('敬请期待'));" value='敬请期待' />
    <input type='button' class="coolbg np" onClick="JavaScript:alert(('敬请期待'));" value='敬请期待' />
    <input type='button' class="coolbg np" onClick="JavaScript:alert(('敬请期待'));" value='敬请期待' />
 </td>
 </tr>
</table>
</td>
</tr>

</table><!--  搜索表单  -->
<form name='form3' action='' method='post'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='Seller/skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>筛选：</td>
          <td width='160'>
          <select name='cid' id="storeOpt" onchange="loadByStore()" style='width:150'>
          <option value='null'>选择商店...</option>
          </select>
        </td>
        <%-- <td width='160'>
    		<select name='' id="statusOpt" onchange="pageList()" style='width:150px'>
            <option value="null"  >是否上架...</option>
            <option value='1' >是</option>
            <option value='0' >否</option>
      	</select>
        </td>
        <td width='160'>
    		<select name='' id="onsaleOpt" onchange="pageList()" style='width:150px'>
            <option value="null" >是否促销...</option>
            <option value='1' >是</option>
            <option value='0' >否</option>
      	</select>
        </td> --%>
        <td><input id="queryStr" type="hidden" value='<s:property value="queryStr"/>'><s:property value="queryStr"/>
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
  
<!--  内容列表   -->
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="14" background="Seller/skin/images/tbg.gif">&nbsp;商品列表(<s:property value="#request.pageList.list.size()" />)&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="10%">商品编号</td>
	<td width="4%">选择</td>
	<td width="15%">商品名称</td>
	<td width="10%">虚拟分类</td>
	<td width="5%">销售价</td>
	<td width="5%">库存</td>
	<td width="5%">总销售量</td>
	<td width="5%">上架</td>
	<td width="5%">成本价</td>
	<td width="10%">上传时间</td>
	<td width="5%">点击次数</td>
	<td width="5%">促销</td>
	<td width="5%">促销价</td>
	<td width="10%">操作</td>
</tr>

<s:if test="#request.pageList.list==null || #request.pageList.list.size()<1">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"  >
<td colspan="14"><font color="red">没有商品</font></td>
</tr>
</s:if>
<s:else>
<s:iterator value="#request.pageList.list" var="l">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" id="<s:property value='#l.id' />" >
	<td><s:property value="#l.productid" /></td>
	<td><input name="choose" type="checkbox" id="checkid" value="<s:property value="#l.id" />" class="np"></td>
	<td align="left"><s:property value="#l.name" /></td>
	<td><s:property value="#l.keyword" /></td>
	<td><s:property value="#l.price" /></td>
	<td><s:property value="#l.remainNumber" /></td>
	<td><s:property value="#l.salenumber" /></td>
	<s:set name="isSale" value="#l.isSale"/>
	<td><s:if test="isSale==0">否</s:if><s:if test="isSale==1">是</s:if></td>
	<td><s:property value="#l.inprice" /></td>
	<td><s:property value="#l.createTime.substring(0,10)" /></td>
	<td><s:property value="#l.counter" /></td>
	<td><s:if test="#l.isOnsale==1">是</s:if><s:else>否</s:else></td>
	<td><s:property value="#l.onsalePrice" /></td>
	<td><a id="edit" href='javascript:' >编辑</a> | 
	<s:if test="isSale==0">
	<a id="<s:property value="#l.id" />1" href='javascript:' onclick="upOne('<s:property value="#l.id" />')" >上架</a></s:if>
	<s:if test="isSale==1">
	<a id="<s:property value="#l.id" />1" href='javascript:'  onclick="downOne('<s:property value="#l.id" />')" >下架</a></s:if>
	</td>
</tr>
</s:iterator>
</s:else>
<tr bgcolor="#FAFAF1">
<td height="28" colspan="14">
	&nbsp;
	<a href="javascript:" id="all" class="coolbg">全选</a>
	<a href="javascript:" id="noAll" class="coolbg">取消</a>
	<a href="javascript:" id="fanxuan" class="coolbg">&nbsp;反选&nbsp;</a>
	<a href="javascript:" id="upstatus" class="coolbg">&nbsp;上架&nbsp;</a>
	<a href="javascript:" id="downs" class="coolbg">&nbsp;下架&nbsp;</a>
	<a href="javascript:" id="refresh" class="coolbg" >&nbsp;刷新&nbsp;</a>
	<a href="javascript:" id="cuxiao" class="coolbg">&nbsp;促销&nbsp;</a>
	<a href="javascript:" id="yuanjia" class="coolbg">&nbsp;不促销&nbsp;</a>
	<a href="javascript:" id="delete" class="coolbg" >&nbsp;删除&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
			<td colspan="14" align="center">
        		<input id="pageNo" type="hidden" value='<s:property value="#request.pageList.pageNumber" />' />
				<a href="seller/product/allProduct?productInfoFilter.pageNo=1">第一页</a>&nbsp;&nbsp;
				<a href="javascript:void(0);" id="pre">上一页</a>
				<a href="javascript:void(0);" id="current"><s:property value="#request.pageList.pageNumber" /></a>/
				<a href="javascript:void(0);" id="totalPage"><s:property value="#request.pageList.totalPage" /></a>
				<a href="javascript:void(0);" id="next">下一页</a>&nbsp;&nbsp;
				<a href='seller/product/allProduct?productInfoFilter.pageNo=<s:property value="#request.pageList.totalPage" />'>末页</a>
			</td>
</tr>
</table>


<!--  搜索表单  -->
<form name='form4' >
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
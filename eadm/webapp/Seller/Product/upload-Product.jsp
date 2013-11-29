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
<title>main</title>
<base target="_self">
<link rel="stylesheet" type="text/css" href="Seller/skin/css/base.css" />
<link rel="stylesheet" type="text/css" href="Seller/skin/css/main.css" />
<script src="JS/jquery-1.9.1.js"></script>
<script src="JavaScript/operations.js" ></script>
<script src="JavaScript/pagelist.js" ></script>
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
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr>
    <td colspan="2" background="Seller/skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'>
    	<div style='float:left'><span>批量导入商品信息</span></div>
    	<div style='float:right;padding-right:10px;'></div>
   </td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="30" colspan="2" align="center" valign="bottom">
<form action="commonsys/excelContent" method="post" enctype="multipart/form-data">
    	<table width="100%" border="0" cellspacing="1" cellpadding="1">
        <tr>
          <td width="15%" height="31" align="center"><img src="Seller/skin/images/frame/qc.gif" width="90" height="30" /></td>
          <td width="85%" valign="bottom"><div class='icoitem'>
              <div class='txt'><u><label for="storeId" >选择所属商店：</label>
              </u></div>
          <select  id="storeOpt" name="storeId" style='width:150'>
          <option value='null'>选择商店...</option>
          </select>
            </div>
           </td>
           <td>
           </td>
        </tr>
        <tr>
           <td>
           </td>
        </tr>
        <tr>
          <td width="15%" height="31" align="center"><img src="Seller/skin/images/frame/qc.gif" width="90" height="30" /></td>
          <td width="85%" valign="bottom"><div class='icoitem'>
              <div class='txt'><u><label for="fileExcel" >excel文件：</label><input type="file" name="fileExcel" size="50" /></u></div>
              <div class='txt'><input class="submit_txt" name="submit_excel" type="submit" id="submit_excel" value="上传"  /></div>
            </div>
           </td>
           <td>
           </td>
        </tr>
        <tr>
        	<td >
        	</td>
        </tr>
      </table>
  </form>
      </td>
  </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr bgcolor="#EEF4EA">
    <td colspan="2" background="Seller/skin/images/frame/wbg.gif" class='title'><span>说明信息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
       <td >
         <div ><span >请注意</span></div>
      </td>
       <td >
         <div ><span >只能上传后缀名为xls的excel表格</span></div>
      </td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td>软件版本信息：</td>
    <td>usst_qinzhu_2013_04.26</td>
  </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC">
  <tr bgcolor="#EEF4EA">
    <td colspan="2" background="Seller/skin/images/frame/wbg.gif" class='title'><span>使用帮助</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="32">提示</td>
    <td><a href="http://www.usst.edu.cn" target="_blank"><u>http://www.usst.edu.cn</u></a></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="25%" height="32">更多：</td>
    <td width="75%"><a href="#" target="_blank"><u>http://www.usst.edu.cn</u></a></td>
  </tr>
</table>
</body>
</html>
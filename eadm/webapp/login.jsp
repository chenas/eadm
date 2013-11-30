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
<title>登录</title>
<style type="text/css">
#all {margin-left:auto; margin-right:auto; text-align: center;width: 540px;}
body {text-align:center;}
form{
    margin:0;
}
#main {background:url(Seller/skin/images/login_mid.gif); height:240px; text-align:center;}
#title {height:66px;margin-top: 120px;}
#login { margin-top: 0; width: 420px; margin-left: auto; margin-right:auto;}
#btm_left {background:url(Seller/skin/images/login_btm_left.gif) no-repeat; width:21px; float:left;}
#btm_mid {background:url(Seller/skin/images/login_btm_mid.gif); width:498px; float:left;}
#btm_right {background:url(Seller/skin/images/login_btm_right.gif) no-repeat; width:21px; float:left;}
</style>
<link rel="stylesheet" type="text/css" href="css/wrapstruts.css" />
<script src="JS/jquery-1.9.1.js" ></script>
<!-- begin of 验证码demo -->
<script type="text/javascript">
jQuery(function () {  
    //点击图片更换验证码
    jQuery("#Verify").click(function(){
    	jQuery(this).attr("src","commonsys/SecurityCodeImageAction.action?timestamp="+new Date().getTime());
    });
});
</script>
</head>
<body>
<div id="all">
    <div id="title"><img src="Seller/skin/images/login_title.gif" /></div>
    <div id="main">
    	<form action="commonsys/login" method="post" id="login_form" enctype="multipart/form-data">
        <table id="login">
        	<tr>
            	<td>账号</td>
                <td><input type="text" name="name" id="username" size="25" style="background:url(Seller/skin/images/username_bg.gif) left no-repeat #FFF; border:1px #ccc solid;height: 20px; font-family:Arial, Helvetica, sans-serif; font-size:14px; font-weight: 800; margin:0; padding-left: 24px;" /></td>
                <td><div class="errorAndmes"><s:fielderror><s:param>name</s:param></s:fielderror></div></td>
            </tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr>
            	<td>密码 </td>
                <td><input type="password" name="password" id="password" size="25" style="background:url(Seller/skin/images/password_bg.gif) left no-repeat #FFF; border: 1px #ccc solid; height: 20px; font-family:Arial, Helvetica, sans-serif; font-size:14px; font-weight: 800; margin:0; padding-left: 24px;" />
                	<input type="hidden" value="seller" name="status" />
                </td>
                <td><div class="errorAndmes"><s:fielderror><s:param>password</s:param></s:fielderror></div></td>
            </tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            
            <tr>
            	<td>验证</td>
                <td><input type="text" name="securityCode" onclick="this.value=''" value="单击图片可换验证码" style="background:url(Seller/skin/images/password_bg.gif) left no-repeat #FFF; border: 1px #ccc solid; height: 20px; font-family:Arial, Helvetica, sans-serif; font-size:14px; font-weight: 800; margin:0; padding-left: 24px;" />
                </td>
                <td><img src="commonsys/SecurityCodeImageAction.action" id="Verify"  style="cursor:hand;" alt="看不清，换一张"/></td>
            </tr>
            <tr><td></td>
            <td><div class="errorAndmes"><s:fielderror><s:param>securityCode</s:param></s:fielderror></div></td>
            </tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr>
            	<td></td>
            	<td >
            		<input type="submit" value="登   录"  />
                    <input type="reset" value="清  空" />
                </td>
            </tr>
        </table>
    </form>
    </div>
    <div id="btm">
        <div id="btm_left"></div>
        <div id="btm_mid"></div>
        <div id="btm_right"></div>
    </div>
</div>
</body>
</html>
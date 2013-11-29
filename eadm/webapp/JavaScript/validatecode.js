
$(function () {  
    //点击图片更换验证码
    $("#Verify").click(function(){
        $(this).attr("src","Security/SecurityCodeImageAction?timestamp="+new Date().getTime());
    });
});

/*
 * 用途：检查输入对象的值是否符合E-Mail格式 
 * 返回：如果通过验证返回true,否则返回false
 */
function isEmail() {
	var email = document.getElementById("email").value;
	var espan = document.getElementById("espan");
	var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/;
	if (email.length <= 0) {
		espan.innerHTML = "<font size='2' color='red'>请输入邮箱地址</font>";
		 document.getElementById("inputinfosubmit").onclick="alert('请输入邮箱地址')";
		return false;
	} 
	else if (!myReg.test(email.toString())) {
			espan.innerHTML = "<font size='2' color='red'>请检查邮箱地址</font>";
			 document.getElementById("inputinfosubmit").onclick="alert('请检查邮箱地址')";
			return false;
		}
	else{
		espan.innerHTML = "";
		 document.getElementById("inputinfosubmit").onclick="document.buyform.submit();";
		return true;
	}

}
/*
用途：检查输入字符串是否是数字
输入：
str：字符串
返回：
如果通过验证返回true,否则返回false
*/

function isNumber() 
{         
	var schoolid = document.getElementById("schoolid").value;
	var sidspan = document.getElementById("sidspan");
    var reg = /^\d+$/;
    if (!reg.test(schoolid)){
    	sidspan.innerHTML = "<font size='2' color='red'>请检查学号</font>";
		return false; 
    }
    else {
    	sidspan.innerHTML = "";
		return true; 
    }
}

/*
用途：检查输入手机号码是否正确
输入：
s：字符串
返回：
如果通过验证返回true,否则返回false
*/
function checkMobile(s) {
	var asubmit = document.getElementById("inputinfosubmit");
	var ponespan = document.getElementById("ponespan");
	var regu = /^[1][0-9][0-9]{9}$/;
	var rnum = /^\d{8}$/;
	//var re = new RegExp(regu);
	if (!rnum.test(s) &&(!regu.test(s))) {
	ponespan.innerHTML = "<font color='red' size='2'>请检查联系方式</font>";
	//asubmit.setAttribute("onclick","alert('请检查手机号码');");
	asubmit.setAttribute("onclick","javascript:alert('请检查联系方式');");
	return false;
	}
	else {
		ponespan.innerHTML = "";
		//asubmit.setAttribute("onclick","document.buyform.submit();");
		asubmit.setAttribute("onclick","javascript:document.buyform.submit();");
	return true;
	}
} 

window.onload=function ()
{
	var ls1=document.getElementById('details1');
	var ls2=document.getElementById('details2');
	var lsone=document.getElementById('lsone');
	var lstwo=document.getElementById('lstwo');
	var arrForm=document.getElementById('info').getElementsByTagName('input');
	var checkAll=document.getElementById('checkAll');
	var arrCheck=document.getElementById('order').getElementsByTagName('input');

	
	//个人信息与用户列表切换
	lsone.onclick=function ()
	{
		ls1.style.display='block';
		ls2.style.display='none';

	}
	lstwo.onclick=function ()
	{
		if(confirm("确认离开该页面？")==true)
		{
			ls1.style.display='none';
			ls2.style.display='block';
			for (i=0;i<arrForm.length-2;i++)
			{
				arrForm[i].value='';
			}
		}
	}
	//订单列表全选功能
	checkAll.onclick=function ()
	{
		for (i=0;i<arrCheck.length;i++)
		{
			if (arrCheck[i].checked==true)
			{
				arrCheck[i].checked=false;
			}
			else
			{
				arrCheck[i].checked=true;
			}
		}
	}
}
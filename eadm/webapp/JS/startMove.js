var timer=null;
var i=0;
var iNow=0;
window.onload=function ()
{
	var oDiv=document.getElementById('content');
	var aDiv=oDiv.getElementsByTagName('div');

	for(i=0;i<aDiv.length;i++)
	{
		aDiv[i].index=i;
		aDiv[i].onmouseover=function ()
		{
			for(i=0;i<aDiv.length;i++)
			{
				startMove(aDiv[i],'opacity', 20);
			}
			startMove(this, 'opacity', 100);
			oDiv.style.background='#eee';
		}
		aDiv[i].onmouseout=function ()
		{
			for(i=0;i<aDiv.length;i++)
			{
				startMove(aDiv[i], 'opacity', 100);
			}
			oDiv.style.background='#fff';
		}
	}
}
//获取当前样式，解决兼容性问题
function getStyle(obj,attr)
{
	if(obj.currentStyle)
	{
		return obj.currentStyle[attr];
	}
	else
	{
		return getComputedStyle(obj,false)[attr];
	}
}

function startMove(obj,attr,iTarget)
{
	clearInterval(obj.timer);
	obj.timer=setInterval(function ()
	{
		var iCur=0;
		if(attr=='opacity')
		{
			iCur=parseInt(parseFloat(getStyle(obj,attr))*100);
		}
		else
		{
			iCur=parseInt(getStyle(obj,attr));			
		}

		var iSpeed=(iTarget-iCur)/6;
		iSpeed=iSpeed>0?Math.ceil(iSpeed):Math.floor(iSpeed);

		if(iTarget==iCur)
		{
			clearInterval(obj.timer);
		}
		else
		{
			if(attr=='opacity')
			{
				obj.style.filter='alpha(opacity='+(iCur+iSpeed)+')';
				obj.style.opacity=(iCur+iSpeed)/100;
			}
			else
			{
				obj.style[attr]=iCur+iSpeed+'px';
			}
		}
	},30)
}
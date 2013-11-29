//按钮加减
	function calculate(sym){
				var str=document.getElementById('num').value;


				if(sym=='add'){
					document.getElementById('num').value=parseInt(str)+1;
				}
				else {
					document.getElementById('num').value=parseInt(str)-1;
					if(str==1){
						document.getElementById('num').value=1;
					}
				}
			}
//数值检查			
	function checkTxt()
	{
		var str=document.getElementById('num');

		if(isNaN(str.value))
		{
			str.value='1';
		}
		else if(parseInt(str.value)<1)
		{
			str.value='1';
		}

		return str.value=parseInt(str.value)
	}
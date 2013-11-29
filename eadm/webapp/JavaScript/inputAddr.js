//
$(document).ready(function(){

$("#north").click(function(){
	var sel = document.getElementById("area");
	sel.length = 0;
	$("#area").append("<option value=''>...请选择...</option>"+
			"<option value='办公楼'>办公楼</option>"+
			"<option value='一公寓北楼'>一公寓北楼</option>"+
			"<option value='一公寓南楼'>一公寓南楼</option>"+
			"<option value='二公寓一号楼'>二公寓一号楼</option>"+
			"<option value='二公寓二号楼'>二公寓二号楼</option>"+
			"<option value='二公寓三号楼'>二公寓三号楼</option>"+
			"<option value='三公寓一号楼'>三公寓一号楼</option>"+
			"<option value='三公寓二号楼'>三公寓二号楼</option>"+
			"<option value='三公寓三号楼'>三公寓三号楼</option>"+
			"<option value='四公寓一号楼'>四公寓一号楼</option>"+
			"<option value='四公寓二号楼'>四公寓二号楼</option>"+
			"<option value='四公寓三号楼'>四公寓三号楼</option>"+
			"<option value='四公寓四号楼'>四公寓四号楼</option>"+
			"<option value='三宿舍'>三宿舍</option>"+
			"<option value='四宿舍'>四宿舍</option>"+
			"<option value='五宿舍'>五宿舍</option>"+
			"<option value='六宿舍'>六宿舍</option>"+
			"<option value='七宿舍'>七宿舍</option>"+
			"<option value='八宿舍'>八宿舍</option>"+
			"<option value='九宿舍'>九宿舍</option>"+
			"<option value='十宿舍'>十宿舍</option>"+
			"<option value='十二宿舍'>十二宿舍</option>"+
			"<option value='第一教学楼'>第四教学楼</option>"+
			"<option value='第三教学楼'>第四教学楼</option>"+
			"<option value='第五教学楼'>第四教学楼</option>"
			);
});

$("#south").click(function(){
	var sel = document.getElementById("area");
	sel.length = 0;
	$("#area").append("<option value=''>...请选择...</option>"+
			"<option value='办公楼'>办公楼</option>"+
			"<option value='五公寓一号楼'>五公寓一号楼</option>"+
			"<option value='五公寓二号楼'>五公寓二号楼</option>"+
			"<option value='五公寓三号楼'>五公寓三号楼</option>"+
			"<option value='五公寓四号楼'>五公寓四号楼</option>"+
			"<option value='一宿舍'>一宿舍</option>"+
			"<option value='二宿舍'>二宿舍</option>"+
			"<option value='三宿舍'>三宿舍</option>"+
			"<option value='四宿舍'>四宿舍</option>"+
			"<option value='五宿舍'>五宿舍</option>"+
			"<option value='六宿舍'>六宿舍</option>"+
			"<option value='七宿舍'>七宿舍</option>"+
			"<option value='八宿舍'>八宿舍</option>"+
			"<option value='九宿舍'>九宿舍</option>"+
			"<option value='十宿舍'>十宿舍</option>"+
			"<option value='十一宿舍'>十一宿舍</option>"+
			"<option value='第四教学楼'>第四教学楼</option>"
	);
});
});


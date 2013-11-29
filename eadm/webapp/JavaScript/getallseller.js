//设定商店

$(document).ready(function(){
	$.ajax({
		url : 'jsonSeller.action',
		type : 'post',
		dataType : 'json',
		data : {},
		timeout:2000,
		success : 
			function (data) {
			var sellers = data.sellers;
			var s_root = document.getElementById('sellers');
			s_root.options.length = 0;
			$('#sellers').append("<option value=''>...请选择...</option>");
			for (var i = 0; i < sellers.length; i++) {
				var sellerName = sellers[i].realname;
				var lname = sellers[i].name;
				$('#sellers').append("<option value="+lname+">" + sellerName + "</option>");
			}
		}
	});
});
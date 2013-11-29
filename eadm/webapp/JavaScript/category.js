//
$(document).ready(
		function() {
			$.ajax({
				url : 'CreateCategoryAction!getCate1',
				type : 'post',
				dataType : 'json',
				data : {},
				success : function(data) {
					var cates1 = data.cates1;
					var s_root1 = document.getElementById('cat1');
					s_root1.options.length = 0;
					$('#cat1').append("<option value=''>...请选择...</option>");
					for ( var i = 0; i < cates1.length; i++) {
						var cate1Name = cates1[i].name;
						$('#cat1').append(
								"<option value=" + cate1Name + ">" + cate1Name
										+ "</option>");
					}
				},
				error : function(data) {
					alert(data.cates1[0].name);
				}
			});
		});

// 二级联动菜单
function createCategory() {

	var catName = $('#cat1').val();

	$.ajax({
		url : 'CreateCategoryAction.action',
		type : 'post',
		dataType : 'json',
		data : {
			cat1 : catName
		},
		success : function(data) {
			var cates2 = data.cates2;
			var s_root = document.getElementById('cat2');
			s_root.options.length = 0;
			$('#cat2').append("<option value=''>...请选择...</option>");
			for ( var i = 0; i < cates2.length; i++) {
				var cateName = cates2[i].name;
				$('#cat2').append(
						"<option value=" + cateName + ">" + cateName
								+ "</option>");
			}
		}
	});
}

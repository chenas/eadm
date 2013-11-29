//操作cookie,辅助实现猜你喜欢这一功能

$("document").ready(function(){

	var pids = ""; //存商品id序列
	var id = 0;
	//读取cookie
	$.each($.cookie(), function(name, value) {
		//判断是否为数字
		id = name;
		if($.isNumeric(id)){
			pids += value + " ";
		}
	});
	$.ajax({
		url : 'likeshow',
		type : 'post',
		dataType : 'json',
		data : { pids : pids },
		success : function(data) {
			var likeProduct = data.likeProduct;
			$("#recentProduct tr").each(function(){
				$(this).empty();
			});
			$.each(likeProduct, function(key, value){
				var pid = value.id;
				var price = value.price;
				var pname = value.name;
				var img = value.imageurl;
				$("#img").append("<td>"+
							"<a href='detailProduct?id="+pid+"' >" +
							"<img alt='努力加载中...' src='"+img+"' >" +
							"</a></td>" );
				$("#pname").append(
							"<th><a href='detailProduct?id="+pid+"' >" + pname +
							"</a></th>" );
				$("#price").append(
							"<th><a href='detailProduct?id="+pid+"' >"+"价格：" + price +
							"元</a></th>" );
			});
		},
		erorr : function(data){
			alert("error");
		}
	});
	
});


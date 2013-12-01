/*
 * 商品、订单的操作
 * */

$("document").ready(function() {
	var count=0; //被选中的计数器
	var pageNo = $("#pageNo").val(); //获得当前页
	var pids = ""; //id字符串
	var isdaochu = false; //在新订单中，在出货之前必须先导出，值为零表示出货事件不能被触发
	//全部选择
	$("#all").click(function() {
		$(":checkbox").each(function() {
			$(this).attr("checked", true);
		});
	});

	// 取消
	$("#noAll").click(function() {
		$(":checkbox").each(function() {
			$(this).attr("checked", false);
		});
	});
	// 反选
	$("#fanxuan").click(function() {
		$(":checkbox").each(function() {
			if($(this).attr("checked")=="checked"){
				$(this).attr("checked", false);
			}else{
				$(this).attr("checked", true);
			}
		});
	});

	// 删除选中的
	$("#delete").click(function() {

		$(":checkbox").each(function() {
			if ($(this).attr("checked")=="checked") {
				count++;
				var mcheck = $(this).val();
				pids += mcheck + ", ";
				$("#"+mcheck).remove();
			}
		}),
		$.post(
			 'seller/product/deleteMany',
			 { id : pids
			  // pageNo : pageNo
			 },
			function() {
					if(count != 0){
						alert("删除成功");
						count=0;
					}else{
						alert("没选中任何项");
					}
			});
	});
	
	// 批量上架
	$("#upstatus").click(function() {

		$(":checkbox").each(function() {
			if ($(this).attr("checked")=="checked") {
				count++;
				var mcheck = $(this).val();
				pids += mcheck + ", ";
				$(this).attr("checked", false);
			}
		}),
		$.post(
			 'seller/product/setManyUp',
			 { id : pids
			  // pageNo : pageNo
			 },
					function(){
						if(count != 0){
							alert("上架成功，赶紧刷新看看");
							count=0;
						}else{
							alert("没选中任何项");
						}
					}
				 );
			});
	
	// 批量下架
	$("#downs").click(function() {

		$(":checkbox").each(function() {
			if ($(this).attr("checked")=="checked") {
				count++;
				var mcheck = $(this).val();
				pids += mcheck + ", ";
				$(this).attr("checked", false);
			}
		}),
		$.post(
				'seller/product/setManyDown',
			 { id : pids
			  // pageNo : pageNo
			 },
					function(){
						if(count != 0){
							alert("下架成功，赶紧刷新看看");
							count=0;
						}else{
							alert("没选中任何项");
						}
					}
				 );
			});
	
	//刷新商品
	$("#refresh").click(function(){
		var storeName = "";
		storeName = $("#queryStr").val();
		if($.browser.msie) { 
			window.location.href="seller/product/allProduct?queryStr="+encodeURI(encodeURI(storeName)); 
		}else
			{
			$("#refresh").attr("href" ,"seller/product/allProduct?queryStr="+encodeURI(encodeURI(storeName)));
		}
	});
	
	//批量设置为不促销
	$("#yuanjia").click(function() {

		$(":checkbox").each(function() {
			if ($(this).attr("checked")=="checked") {
				count++;
				var mcheck = $(this).val();
				pids += mcheck + ", ";
				$(this).attr("checked", false);
			}
		}),
		$.post(
				 'seller/product/setManyUO',
			 { id : pids
			 },
					function(){
						if(count != 0){
							alert("设置成功，赶紧刷新看看");
							count=0;
						}else{
							alert("没选中任何项");
						}
					}
				 );
			});

	//批量促销
	$("#cuxiao").click(function() {

		$(":checkbox").each(function() {
			if ($(this).attr("checked")=="checked") {
				count++;
				var mcheck = $(this).val();
				pids += mcheck + ", ";
				$(this).attr("checked", false);
			}
		}),
		$.post(
			 'seller/product/setManyOnsale',
			 { id : pids
			 },
			function() {
					if(count != 0){
						alert("设置成功，赶紧刷新看看");
						count=0;
					}else{
						alert("没选中任何项");
					}});
	
	
	
	});
	
	//确认新订单
	/*$("#comfirNew").click(function(){
		$(":checkbox").each(function() {
			if ($(this).attr("checked")=="checked") {
				count++;
				var mcheck = $(this).val();
				pids += mcheck + " ";
				$(this).attr("checked", false);
			}
		}),
		$.post(
				 'myshop/comfir-Order',
				 { oids : pids,
				   pageNo : pageNo
				 },
				function() {
						if(count != 0){
							alert("确认成功，请刷新看看");
							count=0;
						}else{
							alert("没选中任何项");
						}});
	});	*/
	
	//导出excel
/*	$("#export").click(function(){
		isdaochu = true;
	});
	
	//发货sendOrder
	$("#sendOrder").click(function(){
		if(isdaochu){
			$(":checkbox").each(function() {
			if ($(this).attr("checked")=="checked") {
				count++;
				var mcheck = $(this).val();
				pids += mcheck + " ";
				$(this).attr("checked", false);
			}
		}),
		$.post(
				 'myshop/send-Order',
				 { oids : pids,
				   pageNo : pageNo
				 },
				function() {
						if(count != 0){
							alert("发货成功，请刷新看看");
							count=0;
							pids="";
						}else{
							alert("没选中任何项");
						}});
		}else{
			alert("请先导出excel，并尽快发货");
			return;
		}
		
	});	*/
	
	/*订单刷新*/
	$("#refreshNew0").click(function(){
		if($.browser.msie) { 
			window.location.href="myshop/list0-Order?pageNo="+pageNo; 
		}else
			{
			$("#refreshNew0").attr("href" ,"myshop/list0-Order?pageNo="+pageNo);
		}
	});
	$("#refreshNew1").click(function(){
		if($.browser.msie) { 
			window.location.href="myshop/list1-Order"; 
		}else
			{
			$("#refreshNew1").attr("href" ,"myshop/list1-Order");
		}
	});
	$("#refreshNew2").click(function(){
		if($.browser.msie) { 
			window.location.href="myshop/list2-Order?pageNo="+pageNo; 
		}else
			{
			$("#refreshNew2").attr("href" ,"myshop/list2-Order?pageNo="+pageNo);
		}
	});
	$("#refreshNew3").click(function(){
		if($.browser.msie) { 
			window.location.href="myshop/list3-Order?pageNo="+pageNo; 
		}else
			{
			$("#refreshNew3").attr("href" ,"myshop/list3-Order?pageNo="+pageNo);
		}
	});
	$("#refreshNewAll").click(function(){
		if($.browser.msie) { 
			window.location.href="myshop/listAll-Order?pageNo="+pageNo; 
		}else
			{
			$("#refreshNewAll").attr("href" ,"myshop/listAll-Order?pageNo="+pageNo);
		}
	});
	});	
	
	
//设定时间更新显示新订单情况
/*$(function(){
		var newOrder ="";
		newOrder = function() {
			$.ajax({
				cache:false,
				url : 'order/new-Order',
				type : 'post',
				dataType : 'json',
				data : {},
				success : function(data) {
					var sum = data.sum;
					if(data.seller == null){
						$('#msgorder').html("<a href='Seller/login.jsp' target='_top'>请登录</a>");
					}
					else if(sum == 0){
						$('#msgorder').html("您暂无新订单");
					}else{
						$('#msgorder').html("您有"+sum+"新订单，请前往查收确认！");
					}
				},
				error:function(data) {
					alert();}
			});
	        // setTimeout(newOrder, 2000); //2s定时刷新
		};
	     window.onload = newOrder;}
	     );
*/


//单个上架
function upOne(id){
	$.ajax({
		url : 'seller/product/setUp',
		type : 'post',
		dataType : 'json',
		data : {id: id},
		success:
			function(data){
			//console.log(data);
			$("#"+id+"1").text('下架');
		}
	});
}
//单个下架
function downOne(id){
	$.ajax({
		url : 'seller/product/setDown',
		type : 'post',
		dataType : 'json',
		data : {id: id},
		success:
			function(data){
			//console.log(data);
			$("#"+id+"1").text('上架');
		}
	});
}

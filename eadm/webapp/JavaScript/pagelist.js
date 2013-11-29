var current = 0;
var totalPage = 0;
$(document).ready(function(){
	 shopList();
	current = parseInt($("#current").text()); //当前页
	totalPage = parseInt($("#totalPage").text());
	//console.log(current);
	//上一页
	$("#pre").click(function(){
		if(parseInt(current) == 1) return;
		else if(parseInt(current) >1){
			current--;
			$("#current").text(current);
			var storeName = $("#queryStr").val();
			window.location.href='seller/product/allProduct?productInfoFilter.pageNo='+current+'&queryStr='+encodeURI(encodeURI(storeName));
			//document.pagelistfrm.submit();
		}
	});

	//下一页
	$("#next").click(function(){
		if(parseInt(current) == parseInt(totalPage)) return;
		else if(parseInt(current) < parseInt(totalPage)){
			current++;
			$("#current").text(current);
			var storeName = $("#queryStr").val();
			window.location.href='seller/product/allProduct?productInfoFilter.pageNo='+current+'&queryStr='+encodeURI(encodeURI(storeName));
			//document.pagelistfrm.submit();
		}
	});

	//调到第几页
	$("#forward").click(function(){
		if($("#tempageNo").val() > totalPage){
			return;
		}else{
			var storeName = $("#queryStr").val();
			window.location.href='seller/product/allProduct?productInfoFilter.pageNo='+$("#tempageNo").val()+'&queryStr='+encodeURI(encodeURI(storeName));
		}
	});
});

//加载商店商品列表
var loadByStore = function(){
	var selectStr = $("#storeOpt").val();
	var storeName = $("#storeOpt option:selected").text();
	if(selectStr === 0) return;
	var queryStr = " where a.shopId='"+selectStr+"'";
	window.location.href='seller/product/allProduct?productInfoFilter.pageNo=1&productInfoFilter.queryString='+queryStr+'&queryStr='+encodeURI(encodeURI(storeName));
};

var loadByStatus = function(){
	var selectStr = $("#statusOpt").val();
	if(selectStr === null) return;
	var queryStr = " where a.isSale='"+selectStr+"'";
	window.location.href='seller/product/allProduct?productInfoFilter.queryString='+queryStr;
};

var loadByOnsale = function(){
	var selectStr = $("#onsaleOpt").val();
	if(selectStr === null) return;
	var queryStr = " where a.isOnsale='"+selectStr+"'";
	window.location.href='seller/product/allProduct?productInfoFilter.queryString='+queryStr;
};

var pageList = function(){
	var selectedStr = $("#storeOpt").val() + ","+$("#statusOpt").val()+","+$("#onsaleOpt").val();
	console.log(selectedStr);
	window.location.href='seller/product/allProduct?queryString='+selectedStr;
};

//加载商店列表
 function shopList(){
	$.ajax({
		url : 'seller/shop/allShop',
		type : 'post',
		dataType : 'json',
		success :
			function(data){
			var shopLst = data.shopList;
			for(var i=0; i<shopLst.length; i++){
				$('#storeOpt').append('<option value='+shopLst[i].id+'>'+shopLst[i].storeName+'</option>');
			}
		}
	});
};

$(document).ready(function() {
	// 分类列表的单击事件
	$('.listName a').click(function() {
		$(this).parent().each(function() {
			var catName = $(this).text();
			if(catName == "服饰鞋帽" || catName == "礼品箱包" || catName == "礼品/纪念品" || catName == "办公用品" || catName == "图书/报刊/杂志" || catName == "食品" || catName == "饮料饮品" || catName == "电脑配件" || catName == "日用百货"){
				window.location.href='cate1Show?cat1='+encodeURI(encodeURI(catName));
			}
			else{
				window.location.href='cate2Show?cat2='+encodeURI(encodeURI(catName));
			}
		});
	});
});
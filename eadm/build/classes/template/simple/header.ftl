	<div id="header">
		<div>
			<h1><@s.text name="com.eshop.header" /></h1>
			<h5><a href="/eshop/shopping/cartList.action"  >&nbsp;我的购物车<span style="color:#f00"><@s.property value="#session.cartList.items.size()" /></span></a></h5>
			<h5>|</h5>
				<@s.if test="#session.loginUser != null">
					<h5><a href="/eshop/member/intoMyCenter.action"  id = "">&nbsp;您好！&nbsp;<@s.property value="#session.loginUser.name" />&nbsp;&nbsp;</a></h5>
				</@s.if>
				<@s.else>
			<h5><a href="/eshop/pages/login.jsp" id="login">登&nbsp;&nbsp;录&nbsp;</a></h5>
			<h5>|</h5>
			<h5><a href="pages/register.jsp" id="login">注&nbsp;&nbsp;册&nbsp;</a></h5>
			</@s.else>
		</div>
				<@s.if test="#session.loginUser != null">
					<div>
						<a href="pages/commonsys/logout.action" style="display:block;position:absolute;right:10px;top:0;width:50px;height:30px;color:#666;text-align:center">退出</a>
					</div>
				</@s.if>
	</div>
	<div id="nav">
		<div class="navBgColor"><!--底色布局块--></div>
		<div class="navBar">
			<div class="search">
				<form action="shopping/searchProduct.action" method="post" name="search">
				<input type="text" name="keyword" />	
				<span>
					<a href="javascript:void(0);"  onclick="document.search.submit();"  >搜&nbsp;索</a>
				</span>
				</form>
			</div>
			<h1></h1>
			<ul>
				<li>
					<a href="">首&nbsp;&nbsp;页</a>
				</li>
				<li>
					<a href="pages/activity.jsp">活&nbsp;&nbsp;动</a>
				</li>
				<li>
					<a href="shopping/allProduct.action">全部商品</a>
					<ul id="list">
						<li>
							<a href="javascript:void(0);">美味的食品</a>
						</li>
						<li>
							<a href="javascript:void(0);">好喝的饮品</a>
						</li>
						<li>
							<a href="javascript:void(0);">必备日用品</a>
						</li>
						<li>
							<a href="javascript:void(0);">土豪送的礼品</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="pages/aboutUs.jsp">关于我们</a>
				</li>
			</ul>
		</div>
	</div>
	
	
	
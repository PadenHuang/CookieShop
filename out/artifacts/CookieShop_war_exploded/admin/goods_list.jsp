<%--
  Created by IntelliJ IDEA.
  User: 19767
  Date: 2018/11/26
  Time: 16:03
  To change this template use File | Settings | File Templates.
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>首页</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/simpleCart.min.js"></script>
	<script type="text/javascript" src="layer/layer.js"></script>
	<script type="text/javascript" src="js/cart.js"></script>
</head>
<body>

<!--header-->
<jsp:include page="header.jsp">
	<jsp:param name="flag" value="2"></jsp:param>
</jsp:include>
<!--//header-->


<!--products-->
<div class="products">
	<div class="container">
		<h2><c:choose><c:when test="${empty t}">全部系列</c:when><c:otherwise>${t.name}</c:otherwise> </c:choose></h2>

		<div class="col-md-12 product-model-sec">

			<c:forEach items="${p.list}" var="g">
				<div class="product-grid">
					<a href="${pageContext.request.contextPath }/goods_detail?id=${g.id}">
						<div class="more-product"><span> </span></div>
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="${pageContext.request.contextPath }/${g.cover}" class="img-responsive" alt="${g.name}" width="240" height="240">
							<div class="b-wrapper">
								<h4 class="b-animate b-from-left  b-delay03">
									<button href="${pageContext.request.contextPath}/goods_detail?id=${g.id}">查看详情</button>
								</h4>
							</div>
						</div>
					</a>
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>${g.name}</h4>
							<span class="item_price">¥ ${g.price}</span>
							<input type="button" class="item_add items" value="加入购物车" onclick="buy(${g.id})">
							<div class="clearfix"> </div>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>

		<jsp:include page="/page.jsp">
			<jsp:param name="url" value="${pageContext.request.contextPath}/goods_list"></jsp:param>
			<jsp:param name="param" value="&typeid=${id}"></jsp:param>
		</jsp:include>
	</div>
</div>
</div>
<!--//products-->






<!--footer-->
<jsp:include page="/footer.jsp"></jsp:include>
<!--//footer-->


</body>
</html>
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
	<title>商品列表</title>
	<meta charset="utf-8"/>
	<link rel="stylesheet" href="css/bootstrap.css"/>
</head>
<body>
<div class="container-fluid">

	<jsp:include page="/admin/header.jsp"></jsp:include>

	<div class="text-right"><a class="btn btn-warning" href="${pageContext.request.contextPath}/admin/goods_add.jsp">添加商品</a></div>

	<br>

	<ul role="tablist" class="nav nav-tabs">
		<li <c:if test="${type==0 }">class="active"</c:if> role="presentation"><a href="${pageContext.request.contextPath}/admin/goods_list">全部商品</a></li>
		<li <c:if test="${type==1 }">class="active"</c:if> role="presentation"><a href="${pageContext.request.contextPath}/admin/goods_list?type=1">条幅推荐</a></li>
		<li <c:if test="${type==2 }">class="active"</c:if> role="presentation"><a href="${pageContext.request.contextPath}/admin/goods_list?type=2">热销推荐</a></li>
		<li <c:if test="${type==3 }">class="active"</c:if> role="presentation"><a href="${pageContext.request.contextPath}/admin/goods_list?type=3">新品推荐</a></li>
	</ul>





	<br>

	<table class="table table-bordered table-hover">

		<tr>
			<th width="5%">ID</th>
			<th width="10%">图片</th>
			<th width="10%">名称</th>
			<th width="20%">介绍</th>
			<th width="10%">价格</th>
			<th width="10%">类目</th>
			<th width="25%">操作</th>
		</tr>

		<c:forEach items="${p.list }" var="g">
			<tr>
				<td><p>${g.id }</p></td>
				<td><p><a href="${pageContext.request.contextPath}/goods_detail?id=${g.id}" target="_blank"><img src="${pageContext.request.contextPath}/${g.cover}" width="100px" height="100px"></a></p></td>
				<td><p><a href="${pageContext.request.contextPath}/goods_detail?id=${g.id}" target="_blank">${g.name}</a></p></td>
				<td><p>${g.intro}</p></td>
				<td><p>${g.price}</p></td>
				<td><p>${g.type.name}</p></td>
				<td>
					<p>
						<c:choose>
							<c:when test="${g.isScroll }">
								<a class="btn btn-info" href="${pageContext.request.contextPath}/admin/goods_recommend?id=${g.id }&method=remove&typeTarget=1&pageNumber=${p.pageNumber}&type=${type}">移出条幅</a>
							</c:when>
							<c:otherwise>
								<a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/goods_recommend?id=${g.id }&method=add&typeTarget=1&pageNumber=${p.pageNumber}&type=${type}">加入条幅</a>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${g.isHot }">
								<a class="btn btn-info" href="${pageContext.request.contextPath}/admin/goods_recommend?id=${g.id }&method=remove&typeTarget=2&pageNumber=${p.pageNumber}&type=${type}">移出热销</a>
							</c:when>
							<c:otherwise>
								<a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/goods_recommend?id=${g.id }&method=add&typeTarget=2&pageNumber=${p.pageNumber}&type=${type}">加入热销</a>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${g.isNew }">
								<a class="btn btn-info" href="${pageContext.request.contextPath}/admin/goods_recommend?id=${g.id }&method=remove&typeTarget=3&pageNumber=${p.pageNumber}&type=${type}">移出新品</a>
							</c:when>
							<c:otherwise>
								<a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/goods_recommend?id=${g.id }&method=add&typeTarget=3&pageNumber=${p.pageNumber}&type=${type}">加入新品</a>
							</c:otherwise>
						</c:choose>

					</p>
					<a class="btn btn-success" href="${pageContext.request.contextPath}/admin/goods_editshow?id=${g.id }& pageNumber=${p.pageNumber}&type=${type}">修改</a>
					<a class="btn btn-danger" href="${pageContext.request.contextPath}/admin/goods_delete?id=${g.id }&pageNumber=${p.pageNumber}&type=${type}">删除</a>
				</td>
			</tr>
		</c:forEach>


	</table>

	<br>
	<jsp:include page="/page.jsp">
		<jsp:param value="${pageContext.request.contextPath}/admin/goods_list" name="url"/>
		<jsp:param value="&type=${type }" name="param"/>
	</jsp:include>
	<br>
</div>
</body>
</html>
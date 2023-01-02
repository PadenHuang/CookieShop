<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/5/26/0026
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%--
   版本1：2020.5.26
         说明：没完整，两个jsp文件还没创建，存在一定问题

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/simpleCart.min.js"></script>
</head>
<body>

<!--header-->
<jsp:include page="/header.jsp">
    <jsp:param name="flag" value="10"></jsp:param>
</jsp:include>
<!--//header-->


<!--account-->
<div class="account">
    <div class="container">
        <div class="register">
            <c:if test="${!empty msg }">
                <div class="alert alert-danger">${msg }</div>
            </c:if>
            <%--将表单提交给servlet——UserRegisterServlet——使用绝对路径--%>
            <%--修改源码路径--%>
            <form action="${pageContext.request.contextPath}/user_rigister" method="post">
                <div class="register-top-grid">
                    <h3>注册新用户</h3>
                    <div class="input">
                        <span>用户名 <label style="color:red;">*</label></span>
                        <input type="text" name="username" placeholder="请输入用户名" required="required">
                    </div>
                    <div class="input">
                        <span>邮箱 <label style="color:red;">*</label></span>
                        <input type="text" name="email" placeholder="请输入邮箱" required="required">
                    </div>
                    <div class="input">
                        <span>密码 <label style="color:red;">*</label></span>
                        <input type="password" name="password" placeholder="请输入密码" required="required">
                    </div>
                    <div class="input">
                        <span>收货人<label></label></span>
                        <input type="text" name="name" placeholder="请输入收货">
                    </div>
                    <div class="input">
                        <span>收货电话<label></label></span>
                        <input type="text" name="phone" placeholder="请输入收货电话">
                    </div>
                    <div class="input">
                        <span>收货地址<label></label></span>
                        <input type="text" name="address" placeholder="请输入收货地址">
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <div class="register-but text-center">
                    <%--提交404——修改成绝对路径--%>
                    <input type="submit" value="提交">
                    <div class="clearfix"> </div>
                </div>
            </form>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!--//account-->






<!--footer-->
<jsp:include page="/footer.jsp"></jsp:include>
<!--//footer-->


</body>
</html>
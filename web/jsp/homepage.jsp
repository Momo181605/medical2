<%@ page import="cn.why.dao.MedicalDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.why.bean.Medical" %><%--
  Created by IntelliJ IDEA.
  User: Momo
  Date: 2020/12/27
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>.</title>
    <style>
    </style>
    <link rel="stylesheet" href="/medicalMS/bootstrap/css/bootstrap.css">
    <script src="/medicalMS/bootstrap/js/jquery.js"></script>
    <script src="/medicalMS/bootstrap/js/bootstrap.js"></script>

    <script type="text/javascript">
        function addServlet() {
            const name = document.getElementById("name").value;
            const price = document.getElementById("price").value;
            const number = document.getElementById("number").value;
            const status = document.getElementById("status").value;
            const describe = document.getElementById("describe").value;
            location="AddDrugServlet?drugname=" + name + "&price=" + price + "&number=" + number + "&status=" + status +"&describe=" + describe;return;
        }
    </script>

    <script>
        function myFunction(){
            var x;
            var r=confirm("您是否要注销账户?");
            if (r){
                location='/medicalMS/AccountCancellationServlet';
            } else {
                alert("取消");
            }

        }
    </script>

</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <span class="navbar-brand">欢迎您！ 用户：${sessionScope.username}</span>

        <div class="dropdown" style="display: inline">
            <button type="button" class="navbar-brand btn dropdown-toggle" id="dropdownMenu1"
                    data-toggle="dropdown">
                个人中心
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                <li role="presentation">
                    <a role="menuitem" tabindex="-1" href="/medicalMS/jsp/passwordchange.jsp">修改密码</a>
                </li>
                <li role="presentation">
                    <a onclick="return myFunction()" role="menuitem" tabindex="-1" href="#">注销账户</a>
                </li>
                <li role="presentation">
                    <a role="menuitem" tabindex="-1" href="/medicalMS/html/login.html">退出</a>
                </li>
            </ul>
        </div>


<%--        <ul class="nav navbar-nav">--%>
<%--            <li><a class="navbar-brand" href="/medicalMS/jsp/personalcenter.jsp">个人中心</a></li>--%>
<%--        </ul>--%>
    </div>
</nav>
<%--<div class="navbar navbar-fixed-top navbar-inverse" role="navigation">--%>
<%--    <div class="container">--%>
<%--        <div class="navbar-header">--%>
<%--            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">--%>
<%--                <span class="sr-only">Toggle navigation</span>--%>
<%--                <span class="icon-bar">aa</span>--%>
<%--                <span class="icon-bar">aa</span>--%>
<%--                <span class="icon-bar">aa</span>--%>
<%--            </button>--%>
<%--            <a class="navbar-brand" href="#">Project name</a>--%>
<%--        </div>--%>
<%--        <div class="collapse navbar-collapse">--%>
<%--            <ul class="nav navbar-nav">--%>
<%--                <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span> Home</a></li>--%>
<%--                <li><a href="#shop"><span class="glyphicon glyphicon-shopping-cart"></span> Shop</a></li>--%>
<%--                <li><a href="#support"><span class="glyphicon glyphicon-headphones"></span> Support</a></li>--%>
<%--            </ul>--%>
<%--        </div><!-- /.nav-collapse -->--%>
<%--    </div><!-- /.container -->--%>
<%--</div>--%>
<div>
<form action="/medicalMS/QueryServlet" method="post">
    <div class="input-group" style="display: flex;justify-content: center">
        <input type="text" class="form-control" name="drugname" placeholder="点击搜索" style="width: 40vw;">
        <button class="btn btn-info" type="submit">搜索</button>
    </div>
</form>
</div>
<div class="panel panel-info" style="margin-left: 10px;margin-right: 10px;">
<div class="panel-body">

<table class="table table-hover" border="1">
    <thead>
    <tr>
        <th>药品名</th>
        <th>单价</th>
        <th>数量</th>
        <th>上下架状态</th>
    </tr>
    </thead>
<%--    <%for(int i =0;i<4;i++){%>--%>
<%--    <tr>--%>
<%--        <%for(int j =0;j<4;j++){%>--%>
<%--        <td>111</td>--%>
<%--        <%}%>--%>
<%--    </tr>--%>
<%--    <%}%>--%>

   <c:if test="${not empty requestScope.medicals}">
    <c:forEach items="${requestScope.medicals}" var="medical">
<%--        <tr onclick="location='jsp/userdrugpage.jsp?name=${medical.name}'" style="cursor: pointer">--%>
    <tbody>
        <tr class="success" onclick="location='DrugServlet?name=${medical.name}'" style="cursor: pointer; color: ${medical.status.equals("上架")?"black":"red"}">
            <td>${medical.name}</td>
            <td>${medical.price}</td>
            <td>${medical.number}</td>
            <td>${medical.status}</td>
        </tr>
    </tbody>
    </c:forEach>
   </c:if>
</table>
</div>
</div>
<%if(request.getSession().getAttribute("usertype").equals("管理员")){%>
<!-- 按钮触发模态框 -->
<button style="display: flex;justify-content: center;"  class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    添加
</button>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="max-width: 600px;margin-top: 20vh;">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">
                    添加药品
                </h4>
            </div>

            <div class="modal-body" style="min-height: 300px;">

                <table class="table table-striped table-hover table-bordered" style="width: 300px;min-height: 300px;margin-left: 150px;">
                    <tr><td>药名  ：</td><td><input id="name" type="text" style="border-radius: 2px"></td></tr>
                    <tr><td>单价 ：</td><td><input id="price" type="text" style="border-radius: 2px"></td></tr>
                    <tr><td>数量：</td><td><input id="number" type="text" style="border-radius: 2px"></td></tr>
                    <tr><td>上下架状态：</td><td><input id="status" type="text" style="border-radius: 2px"></td></tr>
                    <tr><td>描述：</td><td><input id="describe" type="text" style="border-radius: 2px"></td></tr>
                </table>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" onclick="addServlet();">
                    确认
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<% } %>


<%--<form action="jsp/userdrugpage.jsp" method="post">--%>
<%--    <input type="text" name="name" value="75">--%>
<%--    <input type="submit" value="here">--%>
<%--</form>--%>

<%--    <%--%>

<%--        for(int i =0;i<medicals.size();i++){--%>
<%--    %>--%>
<%--       <tr>--%>
<%--           <td><%=medicals.get(i).getName()%></td>--%>
<%--           <td><%=medicals.get(i).getPrice()%></td>--%>
<%--           <td><%=medicals.get(i).getNumber()%></td>--%>
<%--           <td><%=medicals.get(i).getStatus()%></td>--%>
<%--       </tr>--%>
<%--            <%}%>--%>
<%--    <tr>--%>
<%--        <td></td>--%>
<%--        <td>row 1, cell 2</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>row 2, cell 1</td>--%>
<%--        <td>row 2, cell 2</td>--%>
<%--    </tr>--%>
<%--<input type="button">--%>


</body>
</html>

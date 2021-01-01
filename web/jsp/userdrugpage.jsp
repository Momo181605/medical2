<%--
  Created by IntelliJ IDEA.
  User: Momo
  Date: 2020/12/29
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/medicalMS/bootstrap/css/bootstrap.css">
    <script src="/medicalMS/bootstrap/js/jquery.js"></script>
    <script src="/medicalMS/bootstrap/js/bootstrap.js"></script>
    <script src="/medicalMS/js/ajax.js"></script>
</head>
<body>
<div class="panel panel-info" style="margin-left: 10px;margin-right: 10px;">
    <div class="panel-body">
        <table class="table table-hover" border="1">
            <thead>
    <tr>
        <th>药品名</th>
        <th>单价</th>
        <th>数量</th>
        <th>上下架状态</th>
        <th>详细描述</th>
        <th>操作</th>
    </tr>
            </thead>
            <tbody>
        <tr>
        <td>${requestScope.medical.name}</td>
        <td>${requestScope.medical.price}</td>
        <td>${requestScope.medical.number}</td>
        <td>${requestScope.medical.status}</td>
        <td>${requestScope.medical.describe}</td>
        <td onclick="location='PurchaseServlet?name=${requestScope.medical.name}'" style="cursor: pointer"><p>购买</p></td>
        </tr>
            </tbody>
    </table>
    </div>
</div>
    <button onclick="location='MedicalListServlet'" id="returnbutton" style="display: inline;"  class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
        首页
    </button>

</body>
</html>

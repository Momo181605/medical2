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
        <th>药品id</th>
        <th>药品名</th>
        <th>单价</th>
        <th>数量</th>
        <th>上下架状态</th>
        <th>详细描述</th>
    </tr>
        </thead>
        <tbody>
        <tr class="success" style="cursor: pointer; color: ${medical.status.equals("上架")?"black":"red"}">
        <td><input readonly="readonly" id="id" type="text" value="${requestScope.medical.id}"></td>
        <td><input id="name" type="text" value="${requestScope.medical.name}"></td>
        <td><input id="price" type="text" value="${requestScope.medical.price}"></td>
        <td><input id="number" type="text" value="${requestScope.medical.number}"></td>
        <td><input id="status" type="text" value="${requestScope.medical.status}"></td>
        <td><input id="describe" type="text" value="${requestScope.medical.describe}"></td>
        </tr>
        </tbody>
    </table> </div>
</div>
<%--<p id="modifybutton" style="cursor: pointer">修改</p>--%>
<%--<p onclick="location='DeleteDrugServlet?id=${requestScope.medical.id}'" id="deletebutton" style="cursor: pointer">删除</p>--%>
<%--<p onclick="location='MedicalListServlet'" id="returnbutton" style="cursor: pointer">首页</p>--%>

<button id="modifybutton" style="display: inline;"  class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    修改
</button>
<button onclick="location='DeleteDrugServlet?id=${requestScope.medical.id}'" id="deletebutton" style="display: inline;"  class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    删除
</button>
<button onclick="location='MedicalListServlet'" id="returnbutton" style="display: inline;"  class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    首页
</button>
</body>
</html>

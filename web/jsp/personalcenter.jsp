<%--
  Created by IntelliJ IDEA.
  User: Momo
  Date: 2020/12/29
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
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
<div><h1>个人中心</h1></div>
<div><a href="/medicalMS/jsp/passwordchange.jsp">修改密码</a></div>
<div><p onclick="return myFunction()" style="cursor: pointer ">注销账户</p></div>
</body>
</html>

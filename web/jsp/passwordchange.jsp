<%--
  Created by IntelliJ IDEA.
  User: Momo
  Date: 2020/12/29
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改密码页面</title>
    <link type="text/css" rel="stylesheet" href="../css/passwordchange.css"/>
    <script type="text/javascript">
        function validate() {
            var oldpassword = document.getElementById("oldpassword");
            var newpassword = document.getElementById("newpassword");
            var surenewpassword = document.getElementById("surenewpassword");

            if (oldpassword.value == "") {
                alert("密码不能为空！");
                oldpassword.focus();
                return false;
            }

            if(newpassword.value == ""){
                alert("密码不能为空！");
                newpassword.focus();
                return false;
            }

            if(surenewpassword.value == ""){
                alert("密码不能为空！");
                surenewpassword.focus();
                return false;
            }

            if(oldpassword.value.length<6 || oldpassword.value.length>12){
                alert("密码长度不符合要求，请输入6~12位密码");
                oldpassword.focus();
                return false;
            }

            if(newpassword.value.length<6 || newpassword.value.length>12){
                alert("密码不符合要求，请输入6~12位密码");
                newpassword.focus();
                return false;
            }

            if(surenewpassword.value.length<6 || surenewpassword.value.length>12){
                alert("密码不符合要求，请输入6~12位密码");
                surenewpassword.focus();
                return false;
            }

            return true;
        }
    </script>
</head>
<body>


<div class="top">
    <img src="../images/医疗产品信息管理系统logo.png" alt="">
</div>
<div class="mid">
    <img class="midimg" src="https://img.alicdn.com/tps/TB1ikSSKVXXXXaCXpXXXXXXXXXX-663-592.png" alt="">
    <div class="midformbox">
        <form class="midform" action="/medicalMS/PasswordChangeServlet" method="post" onsubmit="return validate();">

            <div><input class="textinput" style="z-index: 100000;" placeholder="旧密码"  type="password" name="oldapplicantPwd" id="oldpassword"></div>
            <div><input class="textinput" placeholder="新密码"  type="password" name="newapplicantPwd" id="newpassword"></div>
            <div><input class="textinput" placeholder="确认新密码"  type="password" name="surenewapplicantPwd" id="surenewpassword"></div>

            <div class="loginbuttonbox"><input class="loginbutton" type="submit" value="确认"></div>
            <a class="tipinfo" href="register.html">密码长度大于5位小于13位</a>
        </form>
    </div>
</div>

<div class="footer">

    <div class="footer_top">
        <p>
        <div>
            <ul>
                <li><a class="link" href="#">阿里巴巴集团</a></li>
                <li><a class="link" href="#">淘宝网</a></li>
                <li><a class="link" href="#">天猫</a></li>
                <li><a class="link" href="#">聚划算</a></li>
                <li><a class="link" href="#">全球速卖通</a></li>
                <li><a class="link" href="#">阿里巴巴国际交易市场</a></li>
                <li><a class="link" class="link" href="#">1688</a></li>
                <li><a class="link" href="#">阿里妈妈</a></li>
                <li><a class="link" href="#">飞猪</a></li>
                <li><a class="link" href="#">淘小铺</a></li>
                <li><a class="link" href="#">阿里云计算</a></li>
                <li><a class="link" href="#">AliOS</a></li>
                <li><a class="link" href="#">阿里通信</a></li>
                <li><a class="link" href="#">一淘</a></li>
                <li><a class="link" href="#">万网</a></li>
                <li><a class="link" class="link" href="#">高德</a></li>
                <li><a class="link" href="#">UC</a></li>
                <li><a class="link" href="#">友盟</a></li>
                <li><a class="link" href="#">阿里安全</a></li>

            </ul>
        </div>

        <div>
            <ul>
                <li><a class="link" href="#">阿里巴巴集团</a></li>
                <li><a class="link" href="#">淘宝网</a></li>
                <li><a class="link" href="#">天猫</a></li>
                <li><a class="link" href="#">聚划算</a></li>
                <li><a class="link" href="#">全球速卖通</a></li>
                <li><a class="link" href="#">阿里巴巴国际交易市场</a></li>
                <li><a class="link" class="link" href="#">1688</a></li>
                <li><a class="link" href="#">阿里妈妈</a></li>
                <li><a class="link" href="#">飞猪</a></li>
                <li><a class="link" href="#">淘小铺</a></li>
                <li><a class="link" href="#">阿里云计算</a></li>
                <li><a class="link" href="#">AliOS</a></li>
                <li><a class="link" href="#">阿里通信</a></li>
                <li><a class="link" href="#">一淘</a></li>
                <li><a class="link" href="#">万网</a></li>
                <li><a class="link" class="link" href="#">高德</a></li>
                <li><a class="link" href="#">UC</a></li>
                <li><a class="link" href="#">友盟</a></li>
                <li><a class="link" href="#">阿里安全</a></li>

            </ul>
        </div>
        </p>
    </div>

</div>

</div>

</body>
</html>

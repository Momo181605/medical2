function adddrugs(){

}

function oldregisterJudge() {
    //创建xhr对象,const不可修改
    const xhr = new XMLHttpRequest();
    if(xhr == null){
        alert("浏览器版本太低了");
        return ;
    }

    //账号
    const id = document.getElementById("userId");
    const url = "/medicalMS/AccountJudgeServlet?userid="+id.value;

    //get方式提交,服务地址，是否为异步处理
    xhr.open("get",url,true);
    //
    xhr.onreadystatechange = function () {
        if(xhr.readyState == 4 && xhr.status == 200){
            const msg = document.getElementById("msg");
            if(xhr.responseText == "1"){
                msg.style.color = "skyblue";
                msg.innerText = "用户名合法";
            }else{
                msg.style.color = "red";
                msg.innerText = "用户名不合法"
            }
        }
    };
    //如果是post请求，就得加请求头，发送的数据加在send里
    // xhr.setRequestHeader("Content-type","applicaation/x-www-form-urlencoded");
    // xhr.send("userid=" + id.value);

    //get请求send里为null
    xhr.send(null);
}

$(function () {
    $("#userId").keyup(function () {
        const name = $(this).val();
        $.get("/medicalMS/AccountJudgeServlet",{userid:name},function (data) {
            var myspan = $("#msg");
            if(data == "1"){
                myspan.css("color","skyblue");
                myspan.html("验证通过");
            }else{
                myspan.css("color","red");
                myspan.html("验证失败");
            }

        },"json");
    })
})

$(function () {
    $("#modifybutton").click(function() {
        const  id = $("#id").val();
        const name = $("#name").val();
        const price = $("#price").val();
        const number = $("#number").val();
        const status = $("#status").val();
        const describe = $("#describe").val();

        $.get("/medicalMS/ModifyServlet",{id:id,name:name,price:price,number:number,status:status,describe:describe},function (data) {
            if(data == "1"){
               alert("修改成功");
            }else{
                alert("修改失败");
            }

        },"json");
    })
})


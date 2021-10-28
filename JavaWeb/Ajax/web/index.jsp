<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <script src="js/jquery.min.js"></script>
    <script>
        /*var xhr ;
        function checkUserName(){
          // 获取输入框中的内容
          var usernameDOM = document.getElementById("username")
          var username = usernameDOM.value
          var usernameInfoDOM = document.getElementById("usernameInfo");
          if(null == username || username == ''){
            usernameInfoDOM.innerText = "用户名不能为空";
            return;
          }
          usernameInfoDOM.innerText = "";
          // 发送异步请求
          // 获取一个 XMLHttpRequest对象 ,对象可以帮助我们发送异步请求
          xhr = new XMLHttpRequest();
          // 使用xhr对象设置打开链接,设置请求方式和参数xhr.open("请求方式","请求的URL",是否使用异步方式);
          xhr.open("GET","usernameCheck?username=" + username, true);
          // 设置回调函数
          xhr.onreadystatechange = showReturnInfo;
          // 正式发送请求
          xhr.send(null);
        }
        function showReturnInfo(){
          if(xhr.readyState == 4 && xhr.status == 200){
            var returnInfo = xhr.responseText;
            var usernameInfoDOM =document.getElementById("usernameInfo");
            usernameInfoDOM.innerText = returnInfo;
          }
        }*/

        function checkUserName() {
            var username = $('#username').val()
            if (null == username || "" == username) {
                $('#usernameInfo').text('用户名不能为空')
                return
            }
            $.ajax({
                type: 'get',
                url: 'usernameCheck',
                data: {
                    username: username
                },
                success: function (msg) {
                    console.log(msg)
                    $('#usernameInfo').text(msg)
                }
            })
        }
    </script>
</head>
<body>
<form action="/usernameCheck">
    用户名:<input id="username" type="text" name="username" onblur="checkUserName()"><span id="usernameInfo"
                                                                                        style="color: red"></span><br/>
    密码:<input type="password" name="pwd"><br/>
    <input type="submit">
</form>
</body>
</html>

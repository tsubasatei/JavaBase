<%--
  Created by IntelliJ IDEA.
  User: XT
  Date: 2021/10/27
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        /*
        * JSON格式创建对象
        * {"属性名":"属性值","属性名":属性值 ... ... }
        * */
        var person = {"name": "zhangsan", "age": 10}
        alert(person.name)
        alert(person.age)
        var persons = [{"name": "zhangsan", "age": 10}, {"name": "lisi", "age": 10}, {"name": "wangwu", "age": 10}];
        for (var i = 0; i < persons.length; i++) {
            var person = persons[i];
            console.log(person.name)
            console.log(person.age)
        }
        console.log('-----------')
        var personStr = '{"name":"zhangsan", "age":10}';// 是一个字符串
        // 可以直接把上面这种格式的字符串直接转换成对象
        var p = JSON.parse(personStr);
        console.log(p.name)
        console.log(p.age)

        var xhr;

        function getData() {
            xhr = new XMLHttpRequest()
            xhr.open('GET', 'json', true)
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    var info = xhr.responseText;
                    console.info(info)
                    var users = JSON.parse(info)
                    for (var i = 0; i < users.length; i++) {
                        var user = users[i];
                        console.log(user.username)
                        console.log(user.pwd)
                        console.log(user.age)
                        console.log(user.gender)
                        console.log(user.birthday)
                    }
                }
            }
            xhr.send(null)
        }

        function testAjax() {
            $.ajax({
                type:'get',
                url:'json',
                data:{ // key=value&key=value  {"属性名":"属性值"}
                    username:"zhangsan",
                    pwd:"123"
                },
                dataType:'json', //以什么格式接收后端响应给我们的信息
                success: function (result) {
                    for (var i = 0; i < result.length; i++) {
                        var user = result[i];
                        console.log(user.username)
                        console.log(user.pwd)
                        console.log(user.age)
                        console.log(user.gender)
                        console.log(user.birthday)
                    }
                }
            })
        }
        function testLoad() {
            $("#d1").load('load', 'username=张三&pwd=123', function () {
                alert('load完成')
            })
            // $('#d1').load('loadPage.jsp #a')
        }

        function testAjax() {
            $.ajax(
                {
                    type:'get',
                    url:'ajax',
                    data:{
                        username:'李四',
                        pwd:'456'
                    },
                    success:function(result){
                        $.each(result, function (i, e) {
                            console.log(e)
                        })
                    },
                    dataType:'json'
                }
            )
            console.log('------------1-----------')
            $.get('ajax', 'username=王五&pwd=qwe', function (result) {
                $.each(result, function (i, e) {
                    console.log(e)
                })
            },'json')
            console.log('------------2-----------')
            $.getJSON('ajax', 'username=赵六&pwd=asd', function (result) {
                $.each(result, function (i, e) {
                    console.log(e)
                })
            })
            console.log('-------------3---------------')
            $.post('ajax', 'username=赵六&pwd=asd', function (result) {
                $.each(result, function (i, e) {
                    console.log(e)
                })
            },'json')
        }
    </script>
</head>
<body>
<button type="button" onclick="getData()">获取数据</button>
<button type="button" onclick="testAjax()">测试Ajax</button>
<hr/>
<div id="d1" style="width: 80%;height: 100px;border: 1px solid black"></div>
<input type="button" value="测试load" onclick="testLoad()">
<hr/>
<input type="button" value="测试ajax" onclick="testAjax()">
</body>
</html>

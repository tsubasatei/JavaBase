<%--
  Created by IntelliJ IDEA.
  User: XT
  Date: 2021/10/28
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            getArea(0, "#province")
        })
        function getArea(parentId, selector) {
            $.getJSON('area', {parentId:parentId}, function (result) {
                $(selector).html('<option>---请选择---</option>')
                $.each(result, function (i, e) {
                    $(selector).append('<option value="' + e.areaid + '">' + e.areaname + '</option>')
                })
            })
            if (selector == '#city') {
                $('#country').html('<option>---请选择---</option>')
            }
        }
    </script>
</head>
<body>
<div>
    省份：<select id="province" onchange="getArea(this.value, '#city')">
        <option>---请选择---</option>
    </select>
    城市：<select id="city" onchange="getArea(this.value, '#country')">
        <option>---请选择---</option>
    </select>
    区：<select id="country">
        <option>---请选择---</option>
    </select>
</div>
</body>
</html>

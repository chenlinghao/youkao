<%--
  Created by IntelliJ IDEA.
  User: 86185
  Date: 2020/8/7
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <link href="css/css.css" rel="stylesheet">
</head>
<body>
    <form action="add" method="post">
        会议编号：<input type="text" name="code"><br>
        会议名称：<input type="text" name="mname"><br>
        会议类型：<select name="type">

    </select><br>
        会议日期：<input type="date" name="start_time">
        ----<input type="date" name="end_time"><br>
        会议服务：<div id="dd">

    </div>
            <input type="submit" value="保存">
    </form>

</body>
    <script type="text/javascript">
       $.post(
            "listType",
           function (obj) {
               for(var i in obj){
                   $("[name = 'type']").append("<option value="+obj[i].tid+">"+obj[i].tname+"</option>");
               }
           }
       );
       $.post(
           "listServer",
           function (obj) {
               for(var i in obj){
                   $("#dd").append("<input type='checkbox' name='sid' value="+obj[i].sid+">"+obj[i].sname);
               }
           }
       );
    </script>
</html>

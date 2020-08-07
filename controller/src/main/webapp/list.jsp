<%--
  Created by IntelliJ IDEA.
  User: 86185
  Date: 2020/8/7
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <link href="css/css.css" rel="stylesheet">
</head>
<body>
    <form action="list" method="post">
        <input type="hidden" name="cpage">
        会议名称：<input type="text" name="mohu1" value="${map.mohu1}">
        会议类性：<select name = "mohu2">
                    <option value=""></option>
<%--                    <option value="2">java探讨</option>--%>
<%--                    <option value="3">web开发</option>--%>
    </select><br>
        创建时间：<input type="date" name="mohu3" value="${map.mohu3}">---
        <input type="date" name="mohu4" value="${map.mohu4}">
        <input type="submit" value="查询">
    </form>
    <table>
        <tr>
            <td>序号</td>
            <td>会议编号</td>
            <td>会议名称</td>
            <td>会议类型</td>
            <td>会议开始时间</td>
            <td>会议结束时间</td>
            <td>会议服务</td>
            <td>创建时间</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list}" var="l">
            <tr>
                <td>${l.mid}</td>
                <td>${l.code}</td>
                <td>${l.mname}</td>
                <td>${l.tname}</td>
                <td>${l.start_time}</td>
                <td>${l.end_time}</td>
                <td>${l.snames}</td>
                <td>${l.create_time}</td>
                <td>
                    <input type="button" onclick="xiu(${l.mid})" value="修改">
                    <input type="button" onclick="del(${l.mid})" value="删除">
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="11">
                <input type="button" onclick="add()" value="新增">
                <input type="button" onclick="fenye(${p.isIsFirstPage()?1:p.getPrePage()})" value="上一页">
                <c:forEach items="${p.navigatepageNums}" var="n">
                    <input type="button" onclick="fenye(${n})" value="${n}">
                </c:forEach>
                <input type="button" onclick="fenye(${p.isIsLastPage()?p.getPages():p.getNextPage()})" value="下一页">

            </td>
        </tr>
    </table>

</body>
    <script type="text/javascript">
        $.post(
            "listType",
            function (obj) {
                for(var i in obj){
                    $("[name = 'mohu2']").append("<option value="+obj[i].tid+">"+obj[i].tname+"</option>");
                }
            }
        );
        function fenye(cpage) {
            $("[name = 'cpage']").val(cpage);
            $("form").submit();
        }
        function add() {
            location = "toAdd";
        }
        function xiu(mid) {
            location = "toXiu?mid="+mid;
        }
        function del(mid) {
            location = "delete?mid="+mid;
        }

    </script>
</html>

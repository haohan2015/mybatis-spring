<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
    <title>字典信息</title>
    <script src="${path}/static/jquery.min.js"></script>
</head>
<body>
    <table>
        <tr>
            <th colspan="4">字典管理</th>
        </tr>
        <tr>
            <th>类别名</th>
            <th>字典名</th>
            <th>字典值</th>
            <th>操作 [<<a href="${path}/dict/add">新增</a>]</th>
        </tr>
        <c:forEach items="${dicts}" var="dict">
            <tr id="dict-${dict.id}">
                <td>${dict.code}</td>
                <td>${dict.name}</td>
                <td>${dict.value}</td>
                <td>
                    [<a href="${path}/dict/add?id=${dict.id}">编辑</a>]
                    [<a href="javascript:;" onclick="deleteById(${dict.id},'${dict.name}')">删除</a>]
                </td>
            </tr>
        </c:forEach>
    </table>
<script>
    function deleteById(id,label) {
        var r = confirm('确定要删除“'+label + "“吗？");
        if(r){
            $.ajax({
                url:'${path}/dict/delete',
                data:{
                    id:id
                },
                dataType:'json',
                type:'POST',
                success: function (data) {
                    if(data.success){
                        alert('11')
                        $('#dict-' + id).remove();
                    }else{
                        alert(data.msg);
                    }
                }
            })
        }
    }
</script>
</body>
</html>

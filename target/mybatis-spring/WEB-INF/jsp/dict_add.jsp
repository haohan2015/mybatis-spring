<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
    <title>字典维护</title>
    <script src="${path}/static/jquery.min.js"></script>
</head>
<body>
    <form action="${path}/dict/add" method="post">
        <input type="hidden" name="id" value="${model.id}">
        <table>
            <c:if test="${msg != null}">
                <tr>
                    <th colspan="2" style="color: red;max-width: 400px;">${msg}</th>
                </tr>
            </c:if>
            <tr>
                <th colspan="2">字典维护</th>
            </tr>
            <tr>
                <th>类别名</th>
                <th><input type="text" name="code" value="${model.code}"></th>
            </tr>
            <tr>
                <th>字典名</th>
                <th><input type="text" name="name" value="${model.name}"></th>
            </tr>
            <tr>
                <th>字典值</th>
                <th><input type="text" name="value" value="${model.value}"></th>
            </tr>
            <tr>
                <th colspan="2">
                    <input type="submit" value="保存">
                    <input type="button" onclick="backToList()" value="取消">
                </th>
            </tr>
        </table>
    </form>
<script>
    function backToList() {
        location.href='${path}/dicts';
    }
</script>
</body>
</html>

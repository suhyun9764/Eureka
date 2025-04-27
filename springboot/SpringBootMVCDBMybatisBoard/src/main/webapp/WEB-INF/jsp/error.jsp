<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>error</title>
</head>
<body>
<h1>Error page</h1>
<p> 요청하신 서비스에 문제가 발생했습니다.</p>
<p> 요청하신 서비스 : ${requestURI}</p>
<p> 발생된 오류 : ${exception}</p>
</body>
</html>
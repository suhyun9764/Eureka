<%@ page import="java.util.List, com.bookmanager_springmvc.controller.BookDto" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>간단한 도서 목록</title>
    <style>
        table { width: 80%; border-collapse: collapse; margin: 20px auto; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        tr:nth-child(even) { background-color: #f9f9f9; }
    </style>
</head>
<body>
<h1 style="text-align: center;">도서 목록</h1>

<table>
    <tr>
        <th>ID</th>
        <th>제목</th>
        <th>저자</th>
        <th>출판사</th>
        <th>가격</th>
    </tr>
    <%
        List<BookDto> bookList = (List<BookDto>) request.getAttribute("bookList");
        if (bookList != null) {
            for (BookDto book : bookList) {
    %>
    <tr>
        <td><%= book.getBookId() %></td>
        <td><%= book.getBookName() %></td>
        <td><%= book.getAuthor() %></td>
        <td><%= book.getPublisher() %></td>
        <td><%= String.format("%,d원", book.getPrice()) %></td>
    </tr>
    <%
            }
        }
    %>
</table>

<div style="text-align: center; margin-top: 20px;">
    <a href="/book/add" style="padding: 8px 16px; background: #4CAF50; color: white; text-decoration: none;">도서 추가</a>
</div>
</body>
</html>
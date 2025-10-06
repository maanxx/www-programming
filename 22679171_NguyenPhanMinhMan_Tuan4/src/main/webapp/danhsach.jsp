<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>IUH BOOKSTORE - San pham</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body { background: #f9f9f9; font-family: Arial, sans-serif; }
        .header-bar {
            background: #b3a074;
            background-image: url('${pageContext.request.contextPath}/images/background.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            padding: 0;
            margin-bottom: 0;
        }
        .navbar-nav .nav-link {
            color: #fff;
            font-weight: bold;
            padding: 18px 22px;
        }
        .navbar-nav .nav-link:hover {
            background: #a18a5b !important;
            border-radius: 4px;
        }
        .sidebar {
            background: #fff;
            border: 1px solid #ccc;
            border-radius: 6px;
            padding: 18px 16px;
            margin-top: 18px;
            min-width: 240px;
            max-width: 320px;
        }
        .sidebar-title {
            font-size: 18px;
            font-weight: bold;
            color: #444;
        }
        .sidebar-link {
            font-size: 15px;
            color: black;
            text-decoration: underline;
        }
        .search-box {
            border: 1px solid #aaa;
            border-radius: 4px;
            width: 100%;
            padding: 5px 10px;
        }
        .main-content-flex {
            display: flex;
            flex-direction: row;
            align-items: flex-start;
            width: 100vw;
            max-width: 100vw;
        }
        .sidebar-wrap {
            flex: 0 0 280px;
            max-width: 320px;
            min-width: 220px;
            margin-left: 20px;
        }
        .book-list-area {
            flex: 1 1 0;
            padding: 16px 32px 0 32px;
            min-width: 0;
        }
        .book-list {
            display: flex;
            flex-wrap: wrap;
            gap: 22px;
            justify-content: flex-start;
        }
        .book-card {
            background: #fff;
            border: 1px solid #aaa;
            border-radius: 7px;
            padding: 13px 12px 10px 12px;
            min-width: 190px;
            max-width: 210px;
            margin-bottom: 18px;
            box-shadow: 0 1px 3px rgba(0,0,0,0.02);
            text-align: center;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .book-card img {
            width: 110px;
            height: 160px;
            object-fit: cover;
            border: 1px solid #ccc;
            margin-bottom: 9px;
            background: #eee;
        }
        .book-title {
            font-size: 15px;
            font-weight: bold;
            margin-bottom: 4px;
        }
        .book-meta {
            font-size: 13px;
            margin-bottom: 1px;
        }
        .book-link {
            font-size: 13px;
            color: #1976d2; text-decoration: underline;
            margin-bottom: 3px;
        }
        .book-link:hover { color: #0d395f; }
        .btn-add-cart {
            font-size: 13px;
            padding: 3px 14px;
            margin-top: 2px;
        }
        @media (max-width: 1100px) {
            .main-content-flex { flex-direction: column; }
            .sidebar-wrap { max-width: 100vw; min-width: 0; }
            .book-list-area { padding: 0 4vw; }
        }
        @media (max-width: 700px) {
            .book-list-area { padding: 0 2vw; }
            .book-list { justify-content: center; }
            .sidebar { margin: 0 auto 16px auto; }
        }
    </style>
</head>
<body>
<!-- Header & Menu -->
<div class="header-bar">
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#" style="color:#fff;font-family:serif;font-weight:bold;letter-spacing:2px;">
                IUH BOOKSTORE
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="#">HOME</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">EXAMPLES</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">SERVICES</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">PRODUCTS</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">CONTACT</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<!-- Main content - full screen with sidebar and book list -->
<div class="main-content-flex">
    <div class="sidebar-wrap">
        <div class="sidebar">
            <div style="border-width: 1px; padding: 10px; background: #e1dbc8; border-radius: 2px">
                <div class="sidebar-title">ABOUT US</div>
                <div style="font-size:12px; color:#444; margin-bottom:18px;">
                    About us information will be here...
                    <a href="#" class="sidebar-link">Read More »</a>
                </div>
            </div>
            <div class="sidebar-title" style="margin-top:14px;">SEARCH SITE</div>
            <form method="get" action="books">
                <input type="text" class="search-box" name="q" placeholder="Nhập mã sách hoặc tên sách..." value="${param.q != null ? param.q : ''}"/>
                <button type="submit" class="btn btn-primary btn-sm" style="margin-top: 6px;">Tìm kiếm</button>
            </form>
        </div>
    </div>
    <div class="book-list-area">
        <div class="book-list">
            <c:forEach var="b" items="${books}">
                <div class="book-card">
                    <div class="book-title">${b.title} - Tác giả: ${b.author}</div>
                    <img src="${pageContext.request.contextPath}/images/${b.image}" alt="${b.title}"/>
                    <div class="book-meta">Price: <fmt:formatNumber value="${b.price}" type="number" maxFractionDigits="0"/></div>
                    <div class="book-meta">Quantity: ${b.quantity}</div>
                    <a class="book-link" href="book?id=${b.id}">Product details</a>
                    <form action="${pageContext.request.contextPath}/cart" method="post" style="margin:0;">
                        <input type="hidden" name="id" value="${b.id}"/>
                        <input type="hidden" name="action" value="add"/>
                        <input type="hidden" name="quantity" value="1"/>
                        <button type="submit" class="btn btn-primary btn-add-cart">Add to cart</button>
                    </form>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 메인페이지</title>
</head>
<body>

    <h3>header</h3>
    <p><a href="mainPage(logout).html"><button>로그아웃</button></a>
        <a href="myPage.html"><button>마이페이지</button></a>
        <a href="cartPage.html"><button>장바구니</button></a>
        <a href="<c:url value='/admin'/>">관리자 페이지</a>
    </p>
    <input type="text" placeholder="search">
    <br>
    <br>
    <button><a href="goodsListPage.html">상의</a></button>
    <button><a href="goodsListPage.html">상의</a></button>
    <button><a href="goodsListPage.html">상의</a></button>
    <button><a href="goodsListPage.html">상의</a></button>
    <button><a href="goodsListPage.html">상의</a></button>
    <br>

    <tr>
        <a href="goodsDetailPage.html"><img src="http://placehold.it/600x300" width="600" , height="300"> </a>
        <br>
        <iframe width="560" height="315" src="https://www.youtube.com/embed/55Tu-jXQAHY" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

    </tr>
    <footer>footer</footer>
</body></html>
























</body>
</html>
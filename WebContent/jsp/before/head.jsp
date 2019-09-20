<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>Insert title here</title>
<link href="css/before/daohang.css" rel="stylesheet" type="text/css" />
</head>
<body>
            <div class="topbar">
                <div class="container">
                    <div class="topbar-nav">
                        <a href="before?id=0">首页</a><span>|</span>

                    </div>
                    <div class="topbar-cart">
                        <a href="cart/selectCart">购物车</a>
                    </div>

                    <div class="topbar-info">
                        <c:if test="${bruser!=null}"><a>欢迎 ${bruser.username }</a></c:if>
                        <c:if test="${bruser==null}"><a href="toLogin">登录</a></c:if>
                        <a href="toRegister">注册</a>
                        <a href="userCenter">用户中心</a>
                        <c:if test="${bruser!= null}">
                           <a href="user/exit">退出</a>
                        </c:if>
                    </div>



                </div>
            </div>

            <div class="header">
                <div class="container">
                    <div class="header-logo">
                        <a herf="#"></a>
                    </div>
                    <div class="header-nav">
                        <ul class="nav-list">
                            <li class="nav-category">
                                <a herf="#">全部商品分类</a>
                            </li>

                            <c:forEach items="${goodsType}" var="g">
                                <li class="nav-item">
                                <a href="before?id=${g.id }"> ${g.typename }</a>
                                </li>
                            </c:forEach>
                        </ul>

                    </div>
                    <div class="header-search">
                        <form action="search" class="search-form">
                            <input type="search" name="keyword" placeholder="请输入搜索关键词"  class="search-text" >
                            <input type="submit"  value="搜索" class="search-btn">
                        </form>
                    </div>
                </div>
            </div>
</body>
</html>
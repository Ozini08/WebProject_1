<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC >
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Start Simple Web</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/clean-blog.css" rel="stylesheet">
    <link href="css/board.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link
            href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
            rel="stylesheet" type="text/css">
    <link
            href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
            rel='stylesheet' type='text/css'>
    <link
            href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
            rel='stylesheet' type='text/css'>

</head>
<body>

<jsp:include page="header.jsp"></jsp:include>


<!-- Set your background image for this header on the line below. -->
<header class="intro-header"
        style="background-image: url('/img/about-bg.jpg'); height: 200px">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <div class="site-heading"
                     style="margin-top: 10px; padding-top: 35px; padding-bottom: 35px">
                    <h2>SAMPLE</h2>
                    <span class="subheading">MY PAGE</span>
                </div>
            </div>
        </div>
    </div>
</header>
<div class="col-md-12">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <div class="list-group col-md-12">
            <a class="list-group-item list-group-item-warning">스크랩한 게시글</a>
            <a class="list-group-item">
            <div class="list-group">
                <c:forEach var="lis" varStatus="cnt" items="${list}">
<%--                    <a>${lis.scrabno}</a>--%>
                    <%--                    <a href="/BoardInfo.do?cmd=BoardInfo&boardno=${lis.boardno}" class="list-group-item">--%>
                    <a href="/hit.do?cmd=hit&boardno=${lis.boardno}&job=info" class="list-group-item">

                        <div class="board-title">
                            <span class="board-category">${lis.category}</span>
                                ${lis.title}
<%--                            <button class="pull-right" style="margin-top: 10px" onclick="return confirmDelete();">삭제--%>
<%--                            </button>--%>
                            <td><a class="pull-right" href="${pageContext.request.contextPath}/ScrabDel.do?cmd=ScrabDel&scrabno=${lis.scrabno}" class="pull-right">삭제</a></td>
<%--                            <button href="/ScrabDel.do?cmd=ScrabDel&scrabno=${lis.scrabno}" class="pull-right" style="margin-top: 10px">삭제</button>--%>
                        </div>
                        <div class="board-meta"
                             style="font-weight: 400; font-size: 1.2rem; color: #404040">
                            <p>
                                <i class="glyphicon glyphicon-user"></i> ${lis.writer} <i
                                    class="glyphicon glyphicon-comment"></i> ${lis.comments} <i
                                    class="glyphicon glyphicon-ok"></i> ${lis.hit} <i
                                    class="glyphicon glyphicon-time"></i> ${lis.writedate}
                            </p>
                        </div>
                    </a>
                </c:forEach>
            </div>
            <%--            <c:forEach var="lis" varStatus="cnt" items="${list}">--%>
            <%--                <div>--%>
            <%--                    <div class="board-title">--%>
            <%--                        <span class="board-category">${lis.category}</span>--%>
            <%--                            ${lis.title}--%>
            <%--                        <button class="pull-right" style="margin-top: 10px" onclick="return confirmDelete();">삭제--%>
            <%--                        </button>--%>
            <%--                    </div>--%>
            <%--                    <div class="board-meta"--%>
            <%--                         style="font-weight: 400; font-size: 1.2rem; color: #404040">--%>
            <%--                        <p>--%>
            <%--                            <i class="glyphicon glyphicon-user"></i> ${lis.writer} <i--%>
            <%--                                class="glyphicon glyphicon-comment"></i> ${lis.comments} <i--%>
            <%--                                class="glyphicon glyphicon-ok"></i> ${lis.hit} <i--%>
            <%--                                class="glyphicon glyphicon-time"></i> ${lis.writedate}--%>
            <%--                        </p>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </c:forEach>--%>
        </a>
        </div>
    </div>
</div>
<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <ul class="list-inline text-center">
                    <li><a href="#"> <span class="fa-stack fa-lg"> <i
                            class="fa fa-circle fa-stack-2x"></i> <i
                            class="fa fa-envelope-o fa-stack-1x fa-inverse"></i>
							</span>
                    </a></li>
                    <li><a href="#"> <span class="fa-stack fa-lg"> <i
                            class="fa fa-circle fa-stack-2x"></i> <i
                            class="fa fa-home fa-stack-1x fa-inverse"></i>
							</span>
                    </a></li>
                    <li><a href="#"> <span class="fa-stack fa-lg"> <i
                            class="fa fa-circle fa-stack-2x"></i> <i
                            class="fa fa-github fa-stack-1x fa-inverse"></i>
							</span>
                    </a></li>
                </ul>
                <p class="copyright text-muted">Copyright &copy;2016 SIST. All
                    rights reserved | code by milib</p>
            </div>
        </div>
    </div>
</footer>

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="js/clean-blog.min.js"></script>

</body>

</html>

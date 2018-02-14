<%--
  Created by IntelliJ IDEA.
  User: sw
  Date: 2018-02-13
  Time: 오후 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <jsp:include page="/WEB-INF/template/script.jsp" ></jsp:include>


    <%--/importing custom css--%>
        <%--<c:url var="cssUrl" value="/public/postForm.css"></c:url>--%>
        <c:url value="/resources/css/list.css" var="cssUrl"></c:url>
        <link href="${cssUrl}" rel="stylesheet">
    <%--importing custom css/--%>

    <title>Journal List</title>
</head>
<body>

<div class="container">
    <jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>

    <div class="jumbotron p-3 p-md-5 text-white rounded bg-dark">
        <div class="col-md-6 px-0">
            <h1 class="display-4">Title of Intro</h1>
            <p class="lead my-3">Blog Introduction</p>
            <p class="lead mb-0"><a href="#" class="text-white font-weight-bold">Continue reading...</a></p>
        </div>
    </div>
</div>
<main role="main" class="container">
    <div class="row">
        <div class="col-12 blog-main">

            <div class="card">
                <div class="card-header journal-list-header"><h2 >Journals</h2></div>
                <div class="card-body journal-list-body">
                    <div class="row col-12 journal-columns" >
                        <c:forEach items="${journalList}" var="journal">
                            <div class="col-4 journal-column">
                                <p class="alert" ><h3>${journal.title}</h3></p>
                                ${journal.content}
                                <c:url value="/journal/${journal.id}" var="journalUrl"></c:url>
                                <a class="btn btn-default journal-btn" href="/journal/${journalUrl}" >Details <:</a>
                            </div>
                        </c:forEach>
                    </div>
                </div>

                <nav class="blog-pagination journal-pagination" >
                    <a class="btn btn-outline-primary" href="#">Previous</a>
                    <a class="btn btn-outline-secondary disabled" href="#">Next</a>
                </nav>


            </div>
        </div><!-- /.blog-main -->
    </div><!-- /.row -->
</main><!-- /.container -->

<jsp:include page="/WEB-INF/template/footer.jsp" />

</body>
</html>

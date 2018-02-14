<%--
  Created by IntelliJ IDEA.
  User: sw
  Date: 2018-02-12
  Time: 오후 8:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <jsp:include page="/WEB-INF/template/script.jsp" ></jsp:include>
    <%--<c:url var="cssUrl" value="/public/postForm.css"></c:url>--%>
    <c:url value="/resources/css/postForm.css" var="cssUrl"></c:url>

    <link href="${cssUrl}" rel="stylesheet">
    <title>Home</title>
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
                <div class="card-header post-header" >
                    <p class="card-title post-title" >Posting Journal</p>
                </div>
                <div class="card-body">
                    <form:form cssClass="form-group" modelAttribute="newJournal">
                        <div class="form-group row offset-1">
                            <label class="col-0.5 label-wrapper"><i class="fas fa-bolt"></i>&nbsp;Title :> </label>
                            <form:input type="text"
                                   name="title"
                                   cssClass="form-control col-7"
                                   placeholder="Enter title..."
                                   path="title"
                            ></form:input>
                        </div>

                        <div class="from-group">
                            <label class="label-wrapper"><i class="fab fa-adn"></i>&nbsp; Textarea</label>
                            <form:textarea rows="15"
                                      name="content"
                                      cssClass="form-control"
                                      placeholder="type journal.."
                                      path="content"
                            ></form:textarea>
                        </div>

                        <div class="form-group btn-group-wrapper" style="">
                            <button type="submit" class="btn btn-default">Submit</button>
                            <button type="submit" class="btn btn-danger">Go back</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div><!-- /.blog-main -->

    </div><!-- /.row -->

</main><!-- /.container -->

<jsp:include page="/WEB-INF/template/footer.jsp" />

</body>
</html>

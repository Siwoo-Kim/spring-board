<%--
  Created by IntelliJ IDEA.
  User: sw
  Date: 2018-02-11
  Time: 오후 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--common css--%>
<c:url value="/public/common.css" var="commonResourceUrl"></c:url>
<%--jquery lib--%>
<c:url value="/webjars/jquery/jquery.js" var="jqueryUrl"></c:url>
<%--bootstrap --%>
<c:url value="/webjars/bootstrap/css/bootstrap.css" var="bootstrapCssUrl"></c:url>
<c:url value="/webjars/bootstrap/js/bootstrap.js" var="bootstrapJsUrl"></c:url>
<c:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" var="popperJsUrl"></c:url>

<link rel="stylesheet" href="${commonResourceUrl}" >
<link rel="stylesheet" href="${bootstrapCssUrl}" >

<script src="${jqueryUrl}" ></script> <%-- popper.js --%>
<script src="${popperJsUrl}" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="${bootstrapJsUrl}"></script>
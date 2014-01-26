
<?xml version="1.0" encoding="utf-8" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Results</title>
        <jsp:include page="header.jsp"/>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/newstyle.css" type="text/css" />
    </head>
    <body>
        <div class="navbar navbar-inverse">
            <div class="navbar-inner">



            </div>
        </div>
            <div class="container">
                <div class="row">
                    <div class="span2">
                        <jsp:include page="sidepanel_left.jsp"/>
                    </div>

                    <div class="span10">
                        <h1>Showing Results For: <c:out value="${key}"/></h1>
                        <div class="well">
                            <c:forEach var="searchresults" items="${searchresults}">
                                <table class="table">
                                    <tbody>
                                        <tr>
                                            <td rowspan="3">
                                                <img src="<%=request.getContextPath()%>/dbresources/images/<c:out value ="${searchresults.id}"/>" width="100" height="100"> 
                                            </td>
                                            <td>Name</td>
                                            <td><c:out value ="${searchresults.name}"/></td>
                                        </tr>
                                        <tr>
                                            <td>ID</td>
                                            <td><c:out value ="${searchresults.id}"/></td>
                                        </tr>
                                        <tr colspan="3">
                                            <td></td>
                                            <td>
                                                <a href="<%=request.getContextPath()%>/viewprofile/<c:out value ="${searchresults.id}"/>" class="btn btn-primary pull-right">View Profile</a> 
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>

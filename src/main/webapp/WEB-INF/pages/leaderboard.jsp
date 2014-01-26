
<?xml version="1.0" encoding="utf-8" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leader Board</title>
        <jsp:include page="header.jsp"/>
    </head>

    <body>
        <div class="navbar navbar-inverse">
            <div class="navbar-inner">
            </div>
        </div>

        <div class="span2" style="padding-left: 40px;">
            <jsp:include page="sidepanel_left.jsp" />

        </div>
        <div class="span9">
            <h1>Leader Board</h1>
            <!--<for each loop to display here>-->
            <div class="well">
                
                <c:forEach var="e" items="${e}">
                    <table class="table">

                        <br>
                        <tbody>
                            <tr>
                                <td rowspan="4">
                                    <img src="<%=request.getContextPath()%>/dbresources/images/<c:out value ="${e.id}"/>" width="100" height="100"> 
                                </td>
                                <td>Name</td>
                                <td><c:out value ="${e.name}"/></td>
                            </tr>
                            <tr>
                                <td>ID</td>
                                <td><c:out value ="${e.id}"/></td>
                            </tr>
                            <tr>
                                <td>Rating</td>
                                <td><c:out value ="${e.rating}"/></td>
                            </tr>
                            <tr colspan="3">
                                <td></td>
                                <td>
                                    <a href="<%=request.getContextPath()%>/viewprofile/<c:out value ="${e.id}"/>" class="btn btn-primary pull-right"/>View Profile</a> 
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </c:forEach>

                
                <c:forEach var="m" items="${m}">
                    <table class="table">

                        <br>
                        <tbody>
                            <tr>
                                <td rowspan="4">
                                    <img src="<%=request.getContextPath()%>/dbresources/images/<c:out value ="${m.id}"/>" width="100" height="100"> 
                                </td>
                                <td>Name</td>
                                <td><c:out value ="${m.name}"/></td>
                            </tr>
                            <tr>
                                <td>ID</td>
                                <td><c:out value ="${m.id}"/></td>
                            </tr>
                            <tr>
                                <td>Rating</td>
                                <td><c:out value ="${m.rating}"/></td>
                            </tr>
                            <tr colspan="3">
                                <td></td>
                                <td>
                                    <a href="<%=request.getContextPath()%>/viewprofile/<c:out value ="${m.id}"/>" class="btn btn-primary pull-right"/> View Profile</a> 
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </c:forEach>
            </div>
        </div>

</html>

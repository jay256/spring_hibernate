
<?xml version="1.0" encoding="utf-8" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>History</title>
        <jsp:include page="header.jsp"/>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/newstyle.css" type="text/css" />
    </head>
    <body>
        <div class="row">
            <div class="span9">

                <c:forEach var="nomination" items="${allapprovals}">
                    <table class="table">

                        <tbody>

                            <tr>
                                <td rowspan="3">
                                    <h4>Nominated by </h4><br>
                                    <img src="<%=request.getContextPath()%>/dbresources/images/<c:out value="${nomination.mid}"/>" width="60"> 
                                </td>
                            </tr>
                            <tr >
                                <td rowspan="1">Scheme</td>
                                <td><c:out value="${nomination.aname}"/></td>
                            </tr>

                            <tr>
                                <td rowspan="1">Date</td>
                                <td><c:out value="${nomination.time}"/></td>
                            </tr>


                        </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>

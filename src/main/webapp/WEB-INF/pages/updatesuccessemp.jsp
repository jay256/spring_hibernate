<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

        <title>Admin page</title>
        <!-- Stylesheets -->
         <jsp:include page="header.jsp"/>
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/images/icons/btlogonew_favicon.ico" />

        <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet'>


            <!-- Optimize for mobile devices -->
            <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
            <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
            <title>admin_empadd_success</title>
            <meta name="viewport" content="width=device-width, initial-scale=1">
                <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
                    <link rel="stylesheet" href="https://app.divshot.com/css/bootstrap.css">
                        <link rel="stylesheet" href="https://app.divshot.com/css/bootstrap-responsive.css">
                            <link rel="stylesheet" href="https://djyhxgczejc94.cloudfront.net/builds/80037b02082b29f5f9cea127cab2a4ba4365ec67.css">
                                <script src="https://app.divshot.com/js/jquery.min.js"></script>
                                <script src="https://app.divshot.com/js/bootstrap.min.js"></script>

                                </head>
                                <body>
                                    <div class="navbar navbar-fixed-top navbar-inverse">
                                        <div class="navbar-inner">
                                            <div class="container">
                                                <a class="brand" href="#">Logged in as Admin</a>
                                                <div class="navbar-content">
                                                    <ul class="nav pull-right ">
                                                        <li>
                                                            <a href="<%=request.getContextPath()%>/admin/employeedb">Go Back</a> 
                                                        </li>
                                                        <li>
                                                            <a href="<c:url value="/j_spring_security_logout" />">Log Out</a> 
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="container">
                                        <div class="hero-unit hidden-phone">
                                            <h3>Successfully added employee
                                                <c:out value="${empid}"/>!
                                            </h3>
                                            <p>Select the manager</p>
                                        </div>
                                        <div class="span6">
                                            <form method="POST" name="selectedManagers" action="<%=request.getContextPath()%>/admin/updatesuccessemp/<c:out value="${empid}"/>">
                                                <c:forEach var="managerslist" items="${mngrslist}">
                                                    <c:set var="status" value="${managerslist.value}"/>
                                                    <table class="table">
                                                        <tbody>
                                                            <tr>
                                                                <td rowspan="4">
                                                                    <label class="checkbox" for="checkbox">
                                                                        <input type="checkbox" value="<c:out value="${managerslist.key.id}"/>" id="checkbox" <c:if test="${status==true}">checked</c:if> name="mngrs"> </label>
                                                                    <img src="<%=request.getContextPath()%>/dbresources/images/<c:out value="${managerslist.key.id}"/>" width="100" height="100"> 
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>Name</td>
                                                                <td><c:out value="${managerslist.key.name}"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td>ID</td>
                                                                <td><c:out value="${managerslist.key.id}"/></td>
                                                            </tr>

                                                        </tbody>
                                                    </table>
                                                </c:forEach>
                                                <input type="submit" value="Submit"></input>
                                                <c:if test="${success == true}">                 
                                                    <b>Successful.</b>  </c:if> 
                                            </form>
                                        </div>
                                    </div>


                                </body>
                                </html>

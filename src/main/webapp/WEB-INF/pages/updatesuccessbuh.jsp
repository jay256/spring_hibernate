
<?xml version="1.0" encoding="utf-8" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<html>

    <head>
        <title>Admin Page</title>
        <jsp:include page="header.jsp"/>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/newstyle.css" type="text/css" />
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
        </br></br></br>
        <div class="container">
            <div class="well">
                <h3>BUSINESS UNIT HEAD
                    <c:out value="${empid}"/>
                </h3>
                <p>Select Managers</p>
            </div>
                <div class="span6 offset3" >
            <form method="POST" name="selectedManagers" action="<%=request.getContextPath()%>/admin/updatesuccessbuh/<c:out value="${empid}"/>">  
                <c:forEach var="managerslist" items="${mngrslist}">
                    <table class="table">  
                        <tbody><tr>  
                                <td rowspan="5">  

                                    <label class="checkbox" for="checkbox">
                                        <input type="checkbox" value="<c:out value="${managerslist.key.id}"/>" id="checkbox" name="mngrs"> </label>
                                    <img src="<%=request.getContextPath()%>/dbresources/images/<c:out value="${managerslist.key.id}"/>" width="50" height="50"> 


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
                            
                            <tr>
                                
                                <td>BUH Name</td>
                                <td><c:out value="${managerslist.value.name}"/></td>
                            </tr>
                            <tr>
                                <td>BUH ID</td>
                                <td><c:out value="${managerslist.value.id}"/></td>
                            </tr>


                        </tbody></table>   </c:forEach></div>
                
                        <input type="submit" value="Submit">  
                   
            </form>

    </body>
</html>
<?xml version="1.0" encoding="utf-8" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<html>

    <head>
        <title>manager</title>
        <jsp:include page="header.jsp"/>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/newstyle.css" type="text/css" />
        <script type="text/javascript">
            $(function() {
                $.localise('ui-multiselect', {/*language: 'en',*/path: '<%=request.getContextPath()%>/js/locale/'});
                $(".multiselect").multiselect();
                $('#switcher').themeswitcher();
            });
        </script>
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
                                            <h3>MANAGER
                                                <c:out value="${empid}"/>
                                            </h3>
                                            <p>Select BUH</p>
                                        </div>
<div class="span6 offset3" >
        <form method="POST" name="selectedBUHandEmp" action="<%=request.getContextPath()%>/admin/updatesuccessmngr/<c:out value="${empid}"/>/<c:out value="${radio}"/>/<c:out value="${emptable}"/>">  
            <c:set var="radio" value="${radio}"/>
            <c:set var="emptable" value="${emptable}"/>
            <c:if test="${radio==true}">                                    

                
                                    <c:forEach var="buhlist" items="${buhlist}">
                                        <c:set var="status" value="${buhlist.value}"/>
                                        <table class="table">
                                            <tr>
                                                <td rowspan="3">
                                        <input type="radio" name="buhs" value="<c:out value="${buhlist.key.id}"/>" <c:if test="${status==true}">checked</c:if> />
                                   <img src="<%=request.getContextPath()%>/dbresources/images/<c:out value="${buhlist.key.id}"/>" width="50" height="50"/>       
                                                </td>
                                   <tr>
                                   <td>Name</td>
                                   <td><c:out value="${buhlist.key.name}"/></td>
                                            </tr>
                                            <tr><td>Id</td>
                                   <td><c:out value="${buhlist.key.id}"/></td>
                                            </tr>
                                        </table>
                                    </c:forEach>
                                
                            

                        <c:if test="${success == true}">                 
                            <b>Successful.</b>  </c:if>            
                         
                </c:if>

            <c:if test="${radio==false}"><input type ="hidden" value ="0" name ="buhs" /> </c:if> 

            <c:if test="${emptable==true}">
                <div class="container">
                    <div class="row">

                        <div class="span7">




                            <select id="users" class="multiselect" multiple="multiple" name="users">
                                <c:forEach items="${allemps}" var="user">
                                    <c:set var="status1" value="${user.value}"/>
                                    <option value=${user.key.id} <c:if test="${status1==true}">selected</c:if> > NAME:${user.key.name}, ID:${user.key.id} </option>
                                </c:forEach>
                            </select>

                        </c:if>  
                        <br/>


                        <input type="submit" value="ADD"/>

                        </form>
                        <script type="text/javascript"
                                src="http://jqueryui.com/themeroller/themeswitchertool/">
                        </script>
                        <div id="switcher"></div>  
                    </div>
                </div>

            </div>

    </body>
</html>
<?xml version="1.0" encoding="utf-8" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
        <title>UserProfile</title>
        <jsp:include page="header.jsp" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/newstyle.css" type="text/css" />
        <script>
            function OpenModal() {
                $("#divModal").dialog({
                    autoOpen: false, modal: true, width: 'auto', height: 'auto'
                            , buttons: {"Cancel": function() {
                            $(this).dialog("close");
                        }}
                }).dialog('open');
                return false;
            }

        </script>

    </head>
    <body>
        <div class="navbar navbar-inverse">
            <div class="navbar-inner">
            </div>                         
        </div>
        <div class="page-header"/>
        <div class="container">
            <div class="row">
                <div class="span2">
                    <jsp:include page="sidepanel_left.jsp"/>
                </div>
                <div class="span9">
                    <div class="well" id="wellid">
                        <div class="table">
                            <br>

                                <img src="<%=request.getContextPath()%>/dbresources/images/<c:out value="${emp_id}"/>" class="img-rounded" height="100" width="100" style="margin-left: 40px"/>


                                <div class="span4 pull-right" style="margin-right: 40px">
                                    <br>
                                        <font size="5" color="#00297A"><b><c:out value="${aname}"/><b></font>
                                                    <br>
                                                        <font size="3" color="#6B6B6B"><b><c:out value="${role}"/></b></font>
                                                        <br>
                                                            <font size="2" color="#00000"><c:out value="${dob}"/></font>
                                                            <br><br>
                                                                    <c:set var="emp_role" value="${role}"/>
                                                                    <c:if test="${emp_role == 'EMP' or emp_role == 'MNGR'}">
                                                                        <font size="2" color="#6B6B6B"><c:out value="${rating}"/></font>

                                                                        <c:forEach begin="1" end="${fullstar}">
                                                                            <img src="<%=request.getContextPath()%>/resources/images/RatingStars/Star.png" height="30" width="30">

                                                                            </c:forEach>
                                                                            <c:set var="fullstar" value="${fullstar}"/>
                                                                            <c:if test="${fullstar != 5}">
                                                                                <img src="<%=request.getContextPath()%>/resources/images/RatingStars/<c:out value="${decimalstar}"/>.png" height="30" width="30">  
                                                                                </c:if>
                                                                            </c:if>
                                                                            </div>

                                                                            </div>
                                                                            </div>
                                                                            <jsp:include page="viewpanel.jsp"/>
                                                                            </div>
                                                                            </div>
                                                                            </div>
                                                                            <div class="span1 pull-right">
                                                                            </div>
                                                                              

                                                                            </body>
                                                                            </html>
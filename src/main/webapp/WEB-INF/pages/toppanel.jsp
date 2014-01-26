
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<div class="navbar navbar-inverse">
    <div class="navbar-inner">
        <div class="navbar-content pull-right">

            <ul class="nav">
                <li>
                    <c:set var="role" value="${role}"/>
                    <c:if test="${role=='CEO' or role=='MNGR' or role=='BUH'}">
                        <div class="btn-group">
                            <button class="btn btn-inverse dropdown-toggle" data-toggle="dropdown">View
                                <span class="caret"></span> 
                            </button>
                            <ul class="dropdown-menu">
                                <c:if test="${role=='MNGR'}">
                                    <li>
                                        <a href="<%=request.getContextPath()%>/manager/managerpage">Nominate</a> 
                                    </li>
                                </c:if> 
                                <c:if test="${role=='BUH'}">
                                    <li>
                                        <a href="<%=request.getContextPath()%>/buh/buhpage">Approve</a> 
                                    </li>
                                    <li>
                                        <a href="<%=request.getContextPath()%>/buh/managernomination">Reward Manager</a> 
                                    </li>
                                </c:if>
                                <c:if test="${role=='CEO'}">
                                    <li>
                                        <a href="<%=request.getContextPath()%>/ceo/rewardall">Reward Anyone</a> 
                                    </li>
                                </c:if>
                            </ul>
                        </div>
                    </c:if>
                </li>
                <li class="v-sep">
                    <a href="#">Logged in as <strong><c:url value="${role}" /></strong></a> 
                </li>
                <li>
                    <a href="<c:url value="/j_spring_security_logout" />">Log Out</a> 
                </li>
            </ul>
        </div>
    </div>
</div>

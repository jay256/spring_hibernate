
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<div class="well" id="wellid">  
    <div class="table">
        <br>
        <img src="<%=request.getContextPath()%>/dbresources/images/<c:out value="${emp_id}"/>" class="img-rounded" height="160" width="160" style="margin-left:30px;border:4px solid; border-color:#595466  #A2A0A8 #A2A0A8 #595466">

        <div class="span4 pull-right">

            <font size="5" color="#00297A"><b><c:out value="${aname}"/><b></font>
                    <br>
                    <font size="3" color="#6B6B6B"><b><c:out value="${role}"/></b></font>
                    <br>
                    <font size="2" color="#00000"><c:out value="${phone}"/></font>
                    <br><br><br>

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
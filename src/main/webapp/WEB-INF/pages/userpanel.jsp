
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<div class="well">
    <p></p>
    <div>
        <br>
        <ul class="nav nav-tabs">
            <li class="active">
                <a href="userpage">Comments</a> 
            </li>
            <c:set var="role" value="${role}"/>
            <c:if test="${role=='BUH' or role=='MNGR' or role=='EMP'}">
            <li>
                <a href="#" onclick="javascript:OpenModal();">History</a> 
                <div style="display:none;" id="divModal">
                    <iframe id="myIframe" src="userhistory" width="600" height="550"></iframe>
                </div>
            </li>
            <div class="btn-group">
                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                    New 
                    <span class="caret"></span><span class="badge"><c:out value="${listsize}"/></span>
                </a>
                <ul class="dropdown-menu">
                    <c:forEach var="list" items="${approvedNomination}">
                        <li>
                            <form method="post" action="<%=request.getContextPath()%>/notification" id="myForm">
                                <input type="hidden" name="mid" value="<c:out value="${list.mid}"/>">
                                <input type="hidden" name="aname" value="<c:out value="${list.aname}"/>">
                                <input type="hidden" name="nid" value="<c:out value="${list.nid}"/>">
                                <input type="submit" value="You have been approved under <c:out value="${list.aname}"/>" class="btn-link">                                    
                            
                            </form>
                        </li>
                    </c:forEach>

                </ul>
            </div>
            </c:if>
        </ul>
    </div>
    <jsp:include page="usercomment.jsp"/>
</div>

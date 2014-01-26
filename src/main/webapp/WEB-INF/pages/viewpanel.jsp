
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<div class="well">
    <p></p>
    <div>
        <ul class="nav nav-tabs">
            <li class="active">
                <a href="#">Comments</a> 
            </li>
            <li>
                <a href="#" onclick="javascript:OpenModal();">History</a> 
                <div style="display:none;" id="divModal">
                    <iframe id="myIframe" src="<%=request.getContextPath()%>/viewprofile/history/<c:out value="${emp_id}"/>" width="600" height="550"></iframe>
                </div>
            </li>
        </ul>
    </div>
    <div>
        <h3>Comment on <c:out value="${aname}"/>
            <form action="viewercomment" method="POST">
                <input type="text" autofocus="true" maxlength="150" name="comment"/>
                <input type="hidden" name="commenton" value="<c:out value="${emp_id}"/>">
                <input type="Submit" value="Comment"/>
            </form>
    </div>  
              <br><br><br>
    <jsp:include page="comment.jsp"/>
</div>



<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<div style="overflow: scroll;height: 500px">
    <c:forEach var="comment" items="${comments}">
        <div>
            <table>
                <tr>
                    <a class="commentor" href="<%=request.getContextPath()%>/viewprofile/<c:out value="${comment.commented_by}"/>"><img src="<%=request.getContextPath()%>/dbresources/images/<c:out value="${comment.commented_by}"/>" style="float:left;" height="50" width="50"></a>
                    <textarea class="" readonly="true" cursor="text"><c:out value="${comment.comment}"/></textarea>
                    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size="1"><c:out value="${comment.time}"/></font>
                    <form action ="deletecomment" method="POST">
                        <input type="hidden" value="${comment.cid}" name="cid">
                        <input type="submit" value="Delete">
                    </form>
                </tr>
            </table>
        </div><br><br>
    </c:forEach>
</div>

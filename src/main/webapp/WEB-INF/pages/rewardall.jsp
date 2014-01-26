
<?xml version="1.0" encoding="utf-8" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
        <jsp:include page="toppanel.jsp"/>
        <div class="container">
            <div class="row">
                <div class="span2">
                    <jsp:include page="sidepanel_left.jsp" />  
                </div>
                <div class="span7">

                    <jsp:include page="employeeinfo.jsp" /> 
                    <h2> Reward any Employee </h2>
                    <form action="selectedusers" method ="GET" >
                        <select name="awardscheme">
                            <c:forEach var="awardScheme" items="${awardschemes}">
                                <option value="${awardScheme.awardName}">${awardScheme.awardName}</option>
                            </c:forEach>
                        </select>
                        <h2>ALL BUSINESS UNIT HEADS</h2>
                        <select id="users" class="multiselect" multiple="multiple" name="users">
                            <c:forEach items="${allusers}" var="user">       
                                <c:if test="${user.emp_role=='BUH'}">
                                    <option value=${user.id} > NAME:${user.name}, ID:${user.id} </option>
                                </c:if>
                            </c:forEach>
                        </select>

                        <h2>ALL MANAGERS</h2>
                        <select id="users" class="multiselect" multiple="multiple" name="users">
                            <c:forEach items="${allusers}" var="user">
                                <c:if test="${user.emp_role=='MNGR'}">
                                    <option value=${user.id} > NAME:${user.name}, ID:${user.id} </option>
                                </c:if>
                            </c:forEach>
                        </select>


                        <h3>ALL EMPLOYEES</h3>
                        <select id="users" class="multiselect" multiple="multiple" name="users">
                            <c:forEach items="${allusers}" var="user">
                                <c:if test="${user.emp_role == 'EMP'}">
                                    <option value=${user.id} > NAME:${user.name}, ID:${user.id} </option>
                                </c:if>
                            </c:forEach>
                        </select>

                        <br/>
                        <input type ="hidden" value ="${emp_id}" name ="ceoid" />
                        <input type="submit" value="Reward"/>
                    </form>
                    <script type="text/javascript"
                            src="http://jqueryui.com/themeroller/themeswitchertool/">
                    </script>
                    <div id="switcher"></div>   
                </div>
                <div class="span3">
                    <jsp:include page="sidepanel.jsp"/>
                </div>

            </div>
        </div>      
    </body>
</html>

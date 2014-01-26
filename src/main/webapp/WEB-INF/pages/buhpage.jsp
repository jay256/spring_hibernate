<?xml version="1.0" encoding="utf-8" ?>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
        <title>BUH</title>
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
                    <form action="approveduser" method ="GET" >
                        <c:forEach var="man_nom" items="${man_nom}">
                            <h3> MANAGER NAME : ${man_nom.key.name}</h3>
                            <select id="nomination" class="multiselect" multiple="multiple" name="nominations">
                                <c:forEach items="${man_nom.value}" var="nomination">
                                    <option value=${nomination.nid} > EMPLOYEE: ${nomination.eid}, AWARD: ${nomination.aname}</option>
                                </c:forEach>
                            </select>
                            <br/>
                        </c:forEach>
                        <br/>
                        <input type ="hidden" value ="${emp_id}" name ="buhid" />
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


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
            function formSubmit(){
                $("#myForm").submit();
            }
        </script>
    </head>
    <body>
        <jsp:include page="toppanel.jsp"/>
        <div class="container">
            <div class="header">
                <img src="<%=request.getContextPath()%>/resources/images/btlogo.png" height="50" width="50"/>
                <form action="search" method="GET" path="name" id="search-form" style ="float:right" class="fr">
                    <fieldset>
                        <input type="text" name="name1" id="search-keyword"  class="round button dark ic-search image-right" placeholder="Search..." />
                        <input type="hidden" value="SUBMIT" />
                    </fieldset>
                </form>
            </div>
            <div class="row">
                <div class="span2">
                    <jsp:include page="sidepanel_left.jsp" />  
                </div>
                <div class="span7">
                    <jsp:include page="employeeinfo.jsp"/>                    
                    <jsp:include page="userpanel.jsp"/>
                </div>
                <div class="span3">
                    <jsp:include page="sidepanel.jsp"/>
                </div>
            </div>
        </div>      
    </body>
</html>
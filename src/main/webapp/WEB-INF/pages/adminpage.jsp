
<?xml version="1.0" encoding="utf-8" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Admin page</title>
        <!-- Stylesheets -->
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/images/icons/btlogonew_favicon.ico" />

        <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet'>
            <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">

                <!-- Optimize for mobile devices -->
                <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

                <!-- jQuery & JS files -->
                <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
                <script src="<%=request.getContextPath()%>/resources/js/script.js"></script> 

                <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
                <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.1/jquery-ui.min.js"></script>

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



                <style>
                    .error{
                        color :red;
                    }
                </style>
<!--<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet" media="screen">-->
                </head>
                <body>
                    <!-- TOP BAR -->
                    <div id="top-bar">
                        <div class="page-full-width cf">
                            <ul id="nav" class="fl">
                                <li>
                                    <a class="round button dark menu-logoff image-left" href="<c:url value="/j_spring_security_logout" />">Log out</a>
                                </li>
                            </ul>
                            <!-- end nav -->
                        </div>
                        <!-- end full-width -->
                    </div>
                    <!-- end top-bar -->
                    <!-- HEADER -->
                    <div id="header-with-tabs">
                        <div class="page-full-width cf">
                            <a href="#" id="company-branding-small" class="fr"><img src="<%=request.getContextPath()%>/resources/images/bluetree.png" alt="Blue Hosting" id="logo"/></a>
                            <br></br>
                            <br></br>
                            <ul id="tabs" class="fr">
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/adminpage" class="active-tab dashboard-tab">Schemes</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/employeedb">Emp Master</a>
                                </li>
                            </ul>
                            <!-- end tabs -->
                        </div>
                        <!-- end full-width -->
                    </div>
                    <!-- end header -->
                    <div id="content">
                        <div class="page-full-width cf">
                            <div class="content-module">
                                <div class="content-module-heading cf">
                                    <h3 class="fl">Full width page</h3>
                                    <span class="fr expand-collapse-text"></span>
                                    <span class="fr expand-collapse-text initial-expand"></span>
                                    <form action="<%=request.getContextPath()%>/admin/addnewscheme" method="POST" id="NewScheme-form" >
                                        <fieldset id="employee_db">
                                            <div class="stripe-separator"><!--  --></div>
                                            <label for="scheme_name" class="alt-label" >Scheme Name<input type="text" name="scheme_name" id="name" style="float: right" class="round default-width-input " autofocus /></label>
                                            <label for="scheme_des" class="alt-label" >Scheme Description<input type="text" name="scheme_des" id="dob" style="float: right" class="round default-width-input " autofocus /></label>
                                            <label for="value" class="alt-label">Value<input type="text" name="value" id="phonenum" style="float: right"  class="round default-width-input" autofocus /></label>
                                            Credits <select name="credits" style="float: right">
                                                <c:forEach var="credits" items="0,1,2,3,4,5,6,7,8,9">
                                                    <option  value ="${credits}">${credits}</options>
                                                    </c:forEach>
                                            </select></br></br>    
                                            <c:if test="${error == true}">                 
                                                <b class="error">The scheme already exists.</b>              
                                            </c:if>
                                            <c:if test="${errorph == true}">                 
                                                <b class="error" float="left">invalid input for price.</b>   
                                            </c:if>
                                            <button class="round button blue text-upper small-button" style="float: right " type="submit">Add</button><br>
                                                <div class="stripe-separator"><!--  --></div>
                                        </fieldset> 
                                    </form>
                                </div> <!-- end content-module-heading -->
                                <div class="content-module-main">
                                    <form action="<%=request.getContextPath()%>/admin/searchadminscheme" method="POST" path="name" id="search-form" style ="float:right" class="fr">
                                        <fieldset>
                                            <input type="text" name="name1" id="search-keyword"  class="round button dark ic-search image-right" placeholder="Search..." />
                                            <input type="hidden" value="SUBMIT" />
                                        </fieldset>
                                    </form>
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>Scheme Name</th>
                                                <th>Scheme Description</th>
                                                <th>Scheme Value</th>
                                                <th>Credits</th>
                                                <th>Actions</th>
                                            </tr>
                                        </thead>
                                        <tbody>          
                                            <c:forEach var="allschemes" items="${allschemes}">

                                                <tr>
                                                    <td><c:out value ="${allschemes.awardName}"/></td>
                                                    <td><c:out value ="${allschemes.description}"/></td>
                                                    <td><c:out value ="${allschemes.price}"/></td>
                                                    <td><c:out value ="${allschemes.credits}"/></td>
                                                    <td>
                                                        <li>
                                                            <form action="<%=request.getContextPath()%>/admin/updateschemepage/<c:out value ="${allschemes.awardName}"/>">
                                                               <input type="submit" value="" class="table-actions-button ic-table-edit" />   
                                                        </form>
                                                        </li>
                                                        <a href="<%=request.getContextPath()%>/admin/deletescheme/<c:out value ="${allschemes.awardName}"/>" class="table-actions-button ic-table-delete" method="GET"></a>
                                                    </td>
                                                </tr>
                                            </c:forEach>  
                                        </tbody>            
                                    </table>
                                    <div class="stripe-separator"><!--  --></div>
                                </div> <!-- end content-module-main -->
                            </div> <!-- end content-module -->
                        </div> <!-- end full-width -->
                    </div> <!-- end content -->
                </body>
                </html>
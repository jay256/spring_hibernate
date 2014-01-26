<?xml version="1.0" encoding="utf-8" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <title></title>

        <!-- Stylesheets -->
        <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet'>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/images/icons/btlogonew_favicon.ico" />

        <!-- Optimize for mobile devices -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

        <!-- jQuery & JS files -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/script.js"></script>  
        <style>
            .error{
                color :red;
            }
        </style>
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


        <!-- HEADER -->
        <div id="header-with-tabs">

            <div class="page-full-width cf">
                <a href="#" id="company-branding-small" class="fr"><img src="<%=request.getContextPath()%>/resources/images/bluetree.png" alt="Blue Hosting"id="logo"/></a>
                <br></br>
                <br></br>
                <ul id="tabs" class="fr">
                    <li>
                        <a href="<%=request.getContextPath()%>/admin/adminpage" >Schemes</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/admin/employeedb" class="active-tab dashboard-tab"> Emp Master</a>
                    </li>

                </ul>



                <!-- Change this image to your own company's logo -->
                <!-- The logo will automatically be resized to 30px height. -->


            </div> <!-- end full-width -->	

        </div> <!-- end header -->



        <!-- MAIN CONTENT -->
        <div id="content">

            <div class="page-full-width cf">

                <div class="content-module">

                    <div class="content-module-heading cf">

                        <h3 class="fl">Full width page</h3>
                        <span class="fr expand-collapse-text"></span>
                        <span class="fr expand-collapse-text initial-expand"></span>

                        <form action="<%=request.getContextPath()%>/admin/addnewemp" method="POST" id="NewEmployee-form" >
                            <fieldset id="employee_db">
                                <div class="stripe-separator"><!--  --></div>

                                <label for="name1" class="alt-label" >Name<input type="text" name="name1" id="name" style="float: right" class="round default-width-input " autofocus /></label><c:if test="${error == true}">                 
                                    <b class="error">Invalid characters in the name.</b>              
                                </c:if>

                                <label for="dob1" class="alt-label" >DOB(YYYY-MM-DD)<input type="text" name="dob1" id="dob" style="float: right" class="round default-width-input " autofocus /></label><c:if test="${errordob == true}">                 
                                    <b class="error">please check the date format.</b>              
                                </c:if>

                                <label for="doj1" class="alt-label" >DOJ(YYYY-MM-DD)<input type="text" name="doj1" id="doj" style="float: right" class="round default-width-input " autofocus /></label><c:if test="${errordoj == true}">                 
                                    <b class="error">please check the date format.</b>              
                                </c:if>   

                                <label for="phonenum1" class="alt-label">Phone Number <input type="text" name="phonenum1" id="phonenum" style="float: right"  class="round default-width-input" autofocus /></label><c:if test="${errorph == true}">                 
                                    <b class="error">Invalid Phonenumber.</b>              
                                </c:if>
                                </br>

                                <!--                                <label for="role1" class="alt-label">Role<input type="text" name="role1" id="role" style="float: right"  class="round default-width-input " autofocus /></label>-->

                                Employee Role <select name="role1" style="float: right">
                                    <c:forEach var="Employee_Role" items="EMPLOYEE,MANAGER,BUSINESS UNIT HEAD">
                                        <option  value ="${Employee_Role}">${Employee_Role}</options>
                                        </c:forEach>
                                </select></br>
                                </br>

                                <button class="round button blue text-upper small-button" style="float: right " type="submit">Add</button><br>
                                <div class="stripe-separator"><!--  --></div>
                            </fieldset> 
                        </form>



                    </div> <!-- end content-module-heading -->


                    <div class="content-module-main">

                        <form action="<%=request.getContextPath()%>/admin/searchadmin" method="GET" path="name" id="search-form" style ="float:right" class="fr">
                            <fieldset>
                                <input type="text" name="name1" id="search-keyword"  class="round button dark ic-search image-right" placeholder="Search..." />
                                <input type="hidden" value="SUBMIT" />
                            </fieldset>
                        </form>
                        <table>
                            <thead>
                                <tr>

                                    <th>Employee Id</th>
                                    <th>Name</th>
                                    <th>Role</th>

                                    <th>Editing Options</th>
                                    <th>Editing Options</th>

                                    <th>Editing Options</th>
                                </tr>

                            </thead>

                            <tfoot>

                                <tr>

                                    <td colspan="7" class="table-footer">
                                    </td>

                                </tr>

                            </tfoot>

                            <tbody>
                                <c:forEach var="searchresults" items="${searchresults}">
                                    <tr>

                                        <td><c:out value ="${searchresults.id}"/></td>
                                        <td><c:out value ="${searchresults.name}"/></td>
                                        <!--                                    <td><a href="#">username@gmail.com</a></td>-->
                                        <td><c:out value ="${searchresults.emp_role}"/></td>
                                        <c:set var="role" value="${searchresults.emp_role}"/>
                                        <td> <c:if test="${role=='EMP'}">
                                                <a href="<%=request.getContextPath()%>/admin/editmngrabv/<c:out value ="${searchresults.id}"/>">Change Managers</a> 
                                            </c:if>
                                            <c:if test="${role=='MNGR'}">
                                                <a href="<%=request.getContextPath()%>/admin/editbuhabv/<c:out value ="${searchresults.id}"/>">Change BUH </a> 
                                            </c:if>
                                            <c:if test="${role=='BUH'}">
                                                <a href="<%=request.getContextPath()%>/admin/editmngrunder/<c:out value ="${searchresults.id}"/>">Change Managers</a> 
                                            </c:if></td>
                                        <td> <c:if test="${role=='EMP'}">
                                                <a href="<%=request.getContextPath()%>/admin/promotetomanager/<c:out value ="${searchresults.id}"/>">Promote To Manager</a> 
                                            </c:if>
                                            <c:if test="${role=='MNGR'}">
                                                <a href="<%=request.getContextPath()%>/admin/editempunder/<c:out value ="${searchresults.id}"/>">Change Employees </a> 
                                            </c:if>
                                        </td>
                                        <td> <c:if test="${role=='EMP'}">
                                                <a href="<%=request.getContextPath()%>/admin/promoteemptobuh/<c:out value ="${searchresults.id}"/>">Promote to BUH</a> 
                                            </c:if>
                                            <c:if test="${role=='MNGR'}">
                                                <a href="<%=request.getContextPath()%>/admin/promotemngrtobuh/<c:out value ="${searchresults.id}"/>">Promote to BUH</a> 
                                            </c:if>
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
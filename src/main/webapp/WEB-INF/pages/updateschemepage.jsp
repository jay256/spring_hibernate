<?xml version="1.0" encoding="utf-8" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
    <head>

        <title>Reward Scheme</title>
        <meta charset="utf-8">


        <!-- Stylesheets -->
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/images/icons/btlogonew_favicon.ico" />

        <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet'>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">

        <link rel="stylesheet/less" href="<%=request.getContextPath()%>/resources/less/bootstrap.less">
        <script src="<%=request.getContextPath()%>/resources/js/less.js"></script> <!--bootstrap-->

        <!-- Optimize for mobile devices -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

        <!-- jQuery & JS files -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/script.js"></script>


        <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet" media="screen">

    </head>
    <body> 
        <!-- TOP BAR -->
                    <div id="top-bar">
                        <div class="page-full-width cf">
                            <ul id="nav" class="fl">
                                <li>
                                    <a class="round button dark" href="<%=request.getContextPath()%>/admin/adminpage">Go Back</a>
                                </li>
                            </ul>
                            <!-- end nav -->
                        </div>
                        <!-- end full-width -->
                    </div>
                    <!-- end top-bar -->
        <div id="update_scheme">
            <div class="page-full-width cf">
                <!--                                                                <button id="close" class="close" data-dismiss="modal" aria-hidden="true">×</button>-->
                <div class="well well-large">
                    <h2> Update Scheme </h2>
                </div>
            </div>
        </div>
        <form action="<%=request.getContextPath()%>/admin/updatescheme/<c:out value ="${thisaward}"/>"  method="GET" id="NewScheme-form" >
            <div class="content-module-reward cf">
                <fieldset id="employee_db">
                    <label><b> Scheme Name: </b><b><c:out value="${thisaward}"/></b></label><br><br></br>
                    <table>
                        <tr>
                            <td>
                                <label for="scheme_des"  >Scheme Description </label>
                            </td> 
                            <td>
                                <input type="text" name="scheme_des" style="float: right"  class="round default-width-input" autofocus />
                            </td>
                        </tr>
                        <tr>
                            <td><label for="value" >Value</label></td>
                            <td><input type="text" name="value"  style="float: right"  class="round default-width-input" autofocus /></td>
                        </tr>
                        <tr>
                            <td>
                                <label>Credits </label>
                            </td>
                            <td>
                                <select name="credits" style="float: right">
                                    <c:forEach var="credits" items="0,1,2,3,4,5,6,7,8,9">
                                        <option  value ="${credits}">${credits}</options>
                                        </c:forEach>
                                </select>
                            </td>
                        </tr>
                        
                        
                    </table>
                      <input type="submit" value="Submit"> 
</form>
                    </br>    

                    <c:if test="${errorph == true}">                 
                        <b class="error" float="left">invalid input for price.</b>   
                    </c:if>
                    <c:if test="${errorp == true}">                 
                        <b>Updated Succesfully.</b>   
                    </c:if>
                </fieldset>

            </div>

        </div>
</body>
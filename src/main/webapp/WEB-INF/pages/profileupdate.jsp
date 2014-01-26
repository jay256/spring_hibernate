
<?xml version="1.0" encoding="utf-8" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
        <title>Edit Profile</title>
        <jsp:include page="header.jsp" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css"/>
        <style>
            .error{
                color :red;
            }
        </style>
    </head>
    <body>
        <div class="navbar navbar-inverse">
            <div class="navbar-inner">



            </div>
        </div>
        <div class="page-header"/>
        <div class="container">

            <div class="span2">
                <jsp:include page="sidepanel_left.jsp"/>
            </div>
            <div class="span3">
                <font size="6" color="#3f4551">Picture</font>
                <form action="picture" method="POST" enctype="multipart/form-data"
                      id="pform" class="fr">
                    <fieldset>
                        <label for="new_picture"></label>
                        <input type="file" name="name1" id="new_picture"/>
                        </br>
                        <input type="submit" value="Change Picture" class="btn btn-label"/> 
                    </fieldset>
                    <c:if test="${errorpicture == true}">                 
                        <b class="error">Invalid file extension or no file selected</b>              
                    </c:if> 
                </form>
            </div>
            <div class="span3">
                <font size="6" color="#3f4551">Phone</font>
                <form action="phonenumber" method="POST" id="pform" class="fr">
                    <fieldset>
                        <label for="new_phonenumber"><font size="2">Enter new number</font></label>  
                        <input type="text" name="namep" id="new_phonenumber"
                               size="10" maxlength="40"/>
                        <p>
                            <input type="submit" value="Change Number" class="btn btn-label"/> 
                        </p>
                    </fieldset>
                    <c:if test="${errorphone == true}">                 
                        <b class="error">Invalid phone no.</b>              
                    </c:if> 
                </form>  
            </div>
            <div class="span3">
                <font size="6" color="#3f4551">Password</font>
                <form action="password" method="POST" id="pform" class="fr">
                    <fieldset>
                        <p>
                            <label for="password1"><font size="2">Old password</font></label>
                            <input type="password" name="oldpassword" id="p1" size="30"
                                   maxlength="40"/> 
                        </p>
                        <p>
                            <label for="password"><font size="2">New Password</font></label>
                            <input type="password" name="newpassword" id="p" size="30"
                                   maxlength="40"/> <br>

                        </p>
                        <p>
                            <label for="password"><font size="2">Confirm Password</font></label>
                            <input type="password" name="confirmpassword" id="p" size="30"
                                   maxlength="40"/> <br>

                        </p>
                        <p>
                            <input type="submit" value="Change Password" class="btn btn-label"/> 
                        </p>
                    </fieldset>
                    <c:if test="${errorpassword == true}">                 
                        <b class="error">Old password not correct or passwords don't match.</b>              
                    </c:if> 
                </form>
            </div>
        </div>
    </body>
</html>
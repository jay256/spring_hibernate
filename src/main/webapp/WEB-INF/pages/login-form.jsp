
<?xml version="1.0" encoding="utf-8" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
    <head>
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
        <meta http-equiv="Pragma" content="no-cache" />
        <meta http-equiv="Expires" content="0" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>BlueTree-LogIn</title>

        <!-- Stylesheets -->
         <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/images/icons/btlogonew_favicon.ico" />

        <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet'>
            <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
                <link rel="stylesheet/less" href="<%=request.getContextPath()%>/resources/less/bootstrap.less">
                    <script src="<%=request.getContextPath()%>/resources/js/less.js"></script>
                    <!--bootstrap-->
                    <style>
                        .error{
                            color :red;
                        }
                    </style>
                    </head>      
                    <body style="padding-left: 100px; padding-right: 100px;">          
                        <div id="header">           
                            <div class="page-full-width cf">              
                                <div id="login-intro" class="fl">                 
                                    <h1><b>Login</b></h1>              
                                </div>              
                                <a href="#" id="company-branding" class="fr"><img src="<%=request.getContextPath()%>/resources/images/bluetree.png"  alt="Blue Hosting"></img></a>         
                            </div> <!-- end full-width -->	     
                        </div> <!-- end header --> 
                        <div id="content"  > 
                            <fieldset > 
                                <div style="float:left">
                                    <div id="home"class="fr">
                                        <img src="<%=request.getContextPath()%>/resources/images/btlogo.png" height="250" width="250"/>
                                    </div>
                                    <div class="fl" style="text-align: justify;">
                                        <br>
                                        <p >
                                            In a competitive business climate,<br>
                                            more business owners are looking at improvements<br>
                                            in quality while reducing costs. Meanwhile,<br> 
                                            a strong economy has resulted in a tight job <br>
                                            market. So while small businesses need to get <br>
                                            more from their employees, their employees are <br>
                                            looking for more out of them. Employee reward <br>
                                            and recognition programs are one method of <br>
                                            motivating employees to change work habits and <br>
                                            key behaviors to benefit a small business. <br>
                                         </p>
                                                                            </div>

                                                                            </div>


                                                                            <div style="float:right" >    
                                                                                <form method="post" action="<c:url value='j_spring_security_check'/>" id="login-form">           

                                                                                    <p>               
                                                                                        <label for="login-username" >Username</label>                            
                                                                                        <input type="text" name="j_username" id="j_username" size="30" maxlength="40"  />              
                                                                                    </p>                
                                                                                    <p>                       
                                                                                        <label for="login-password">Password</label>                         
                                                                                        <input type="password" name="j_password" id="j_password" size="30" maxlength="32" />            
                                                                                    </p>                       
                                                                                    <p><input type="submit" value="Login" class="button round blue image-right ic-right-arrow"/></p>      
                                                                                     
                                                                                </form>
                                                                            </div>
                                                                            </fieldset>             

                                                                            </div>  

                                                                            <p>                  
                                                                                <c:if test="${error == true}">                 
                                                                                    <b class="error">Invalid login or password.</b>              
                                                                                </c:if>             
                                                                            </p> 
                                                                            <div id="footer">
                                                                                <jsp:include page="footer.jsp"/>
                                                                            </div>

                                                                            </body>          
                                                                            </html>
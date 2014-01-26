
<%@page import="java.util.List"%>
<%@page import="com.sprsec.model.Coupon"%>
<?xml version="1.0" encoding="utf-8" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Reward Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
        <link rel="stylesheet" href="https://app.divshot.com/css/bootstrap.css">
        <link rel="stylesheet" href="https://app.divshot.com/css/bootstrap-responsive.css">
        <script src="https://app.divshot.com/js/jquery.min.js"></script>
        <script src="https://app.divshot.com/js/bootstrap.min.js"></script>
        <script>
            function printpage()
            {
                window.print();
            }
        </script>
        <script type = "text/javascript" >
            window.onload = function() {
                fixBrokenImages('<%=request.getContextPath()%>/resources/images/employee1_pic.png');
            }
            fixBrokenImages = function(url) {
                var img = document.getElementsByTagName('img');
                var i = 0, l = img.length;
                for (; i < l; i++) {
                    var t = img[i];
                    if (t.naturalWidth === 0) {
                        //this image is broken
                        t.src = url;
                    }
                }
            }
        </script>
    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="span12">
                    <div class="well well-large">
                        <h2>Congratulations!</h2>
                    </div>
                    <div class="well">
                        <h4>Approver</h4>
                        <div>
                            <br>
                            <table class="table">
                                <tbody>
                                    <tr>
                                        <td rowspan="3">
                                            <img src="<%=request.getContextPath()%>/dbresources/images/<c:out value="${approver.id}"/>" height="100" width="100"> 
                                        </td>
                                        <td>Name</td>
                                        <td>
                                            <b><c:out value="${approver.name}"/></b> 
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>ID</td>
                                        <td>
                                            <b><c:out value="${approver.id}"/></b> 
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="row">
                        <div class="span12">
                            <div class="well">
                                <h3>Gift Coupon</h3>
                                <table class="table">
                                    <tbody>
                                        <tr>
                                            <td>Scheme</td>
                                            <td>
                                                <b>${aname}</b> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Coupons</td>
                                            <td>

                                                <c:forEach var="couponno" items="${couponno}">

                                                    <b><c:out value="${couponno.coupon_no}"/></b><br>
                                                </c:forEach>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td>
                                                <form action ="<%=request.getContextPath()%>/notification/accepted" method="GET">
                                                    <input name="nid" type="hidden" value="<c:out value="${nid}"/>">
                                                    <input type="submit" value="Accept" class="btn btn-primary pull-right" onclick="printpage()"> 
                                                </form>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>                       
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
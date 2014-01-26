

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="well" style="overflow: scroll;height: 240px">
    <h4>Recent Rewards</h4>



    <table class="table">

        <tbody>
            <c:forEach var="recentawards" items="${recentawards}">

                <tr>
                    <td rowspan="3">
                        <img src="<%=request.getContextPath()%>/dbresources/images/<c:out value="${recentawards.value.eid}"/>" > 
                    </td>
                </tr>
                <tr >
                    <td rowspan="1">Name</td>
                    <td><c:out value="${recentawards.key.name}"/></td>
                </tr>
              
                <tr>
                    <td rowspan="1">Scheme</td>
                    <td><c:out value="${recentawards.value.aname}"/></td>
                </tr>
                
                
            </c:forEach>

        </tbody>
    </table>
</div>


<div class="well" style="overflow: scroll;height: 240px">
    <h4>Birthdays and Events</h4>

    <table class="table">
        <tbody>
            <c:forEach var="recentbdays" items="${recentbdays}">

                <tr>
                    <td rowspan="3">
                        <img src="<%=request.getContextPath()%>/dbresources/images/<c:out value="${recentbdays.id}"/>"> 
                    </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><c:out value="${recentbdays.name}"/></td>
                </tr>
                <tr>
                    <td>DOB</td>
                    <td><c:out value="${recentbdays.dob}"/></td>
                </tr>
            </c:forEach>

        </tbody>
    </table>

</div>



</tbody>
</table>
</div>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<%@include file="../section/head.jsp" %>
<body>
<%@include file="../section/inAppHeader.jsp" %>

<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <%@include file="../section/sideMenu.jsp" %>

        <div class="m-4 p-3 width-medium">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <div class="row border-bottom border-3 p-1 m-1">
                    <div class="col noPadding">
                        <h3 class="color-header text-uppercase">PLANS:</h3>
                    </div>
                    <div class="col d-flex justify-content-end mb-2 noPadding">
                        <a href="/user/plan/add" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Add+</a>
                    </div>
                </div>

                <div class="schedules-content">
                    <table class="table border-bottom">
                        <thead>
                        <tr class="d-flex">
                            <th class="col-1">ID</th>
                            <th class="col-2">NAME</th>
                            <th class="col-7">DESCRIPTION</th>
                            <th class="col-2 center">ACTIONS</th>
                        </tr>
                        </thead>
                        <tbody class="text-color-lighter">
                        <c:forEach items="${plan}" var="plan">
                            <tr class="d-flex">
                                <td class="col-1">${plan.id}</td>
                                <td class="col-2">${plan.name}</td>
                                <td class="col-7">
                                        ${plan.description}
                                </td>
                                <td class="col-2 d-flex align-items-center justify-content-center flex-wrap"><a href="/user/plan/delete/${plan.id}"
                                                                                                                class="btn btn-danger rounded-0 text-light m-1">Delete</a>
                                    <a href="/user/plan/details/${plan.id}" class="btn btn-info rounded-0 text-light m-1">Details</a>
                                    <a href="/user/plan/edit/${plan.id}" class="btn btn-warning rounded-0 text-light m-1">Edit</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<%@include file="../section/script.jsp" %>
</body>
</html>
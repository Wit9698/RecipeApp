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

        <div class="m-4 p-4 width-medium">
            <div class="dashboard-header m-4">
                <div class="dashboard-menu">
                    <div class="menu-item border-dashed">
                        <a href="/user/recipe/add">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">add recipe</span>
                        </a>
                    </div>
                    <div class="menu-item border-dashed">
                        <a href="/app/plan/add">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">add plan</span>
                        </a>
                    </div>

                </div>

                <div class="dashboard-alerts">
                    <div class="alert-item alert-info">
                        <i class="fas icon-circle fa-info-circle"></i>
                        <span class="font-weight-bold">Number of recipes: ${count}</span>
                    </div>
                    <div class="alert-item alert-light">
                        <i class="far icon-calendar fa-calendar-alt"></i>
                        <span class="font-weight-bold">Number of plans:</span>
                    </div>
                </div>
            </div>
            <div class="m-4 p-4 border-dashed">
                <h2 class="dashboard-content-title">
                    <span>Recently added plan:</span>
                </h2>


                    <table class="table">
                        <thead>
                        <tr class="d-flex">
                            <th class="col-2"></th>
                            <th class="col-8"></th>
                            <th class="col-2"></th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>

            </div>
        </div>
    </div>
</section>

<%@include file="../section/script.jsp" %>
</body>
</html>
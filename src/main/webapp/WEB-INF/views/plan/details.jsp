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
        <div class="m-4 p-3 width-medium ">
            <div class="dashboard-content border-dashed p-3 m-4">
                <div class="row border-bottom border-3 p-1 m-1">
                    <div class="col noPadding">
                        <h3 class="color-header text-uppercase">PLAN DETAILS</h3>
                    </div>
                    <div class="col d-flex justify-content-end mb-2 noPadding">
                        <a href="/user/plan/list" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Back</a>
                    </div>
                </div>
                <thead class="schedules-content">
                <div class="schedules-content-header">
                    <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    Plan name
                                </span>
                        <div class="col-sm-10">
                            <p class="schedules-text">${plan.name}</p>
                        </div>
                    </div>
                    <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    Plan description
                                </span>
                        <div class="col-sm-10">
                            <p class="schedules-text">
                                ${plan.description}
                            </p>
                        </div>
                    </div>
                </div>
                <div style="text-align: center; color: red; font-weight: bolder; font-size: 18px">

                </div>
                <table class="table">
                    Recipes:
                        <thead>
                        <c:forEach items="${plan.recipes}" var="recipe">
                        <tr class="d-flex">
                            <td>${recipe.name}</td>
                            </c:forEach>
                        </tr>
                        </thead>
                </table>
            </div>
        </div>
    </div>
    </div>
</section>
<%@include file="../section/script.jsp" %>
</body>
</html>
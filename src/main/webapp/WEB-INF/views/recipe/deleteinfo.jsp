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

            <div class="m-4 p-4 border-dashed">
                <h2 class="dashboard-content-title">
                    <span>You cannot delete this recipe because it belong to some plan</span>
                </h2>
                <table class="table">
                    <thead>
                    <div class="col d-flex justify-content-end mb-2"><a href="javascript:history.back()" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Back</a></div>
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
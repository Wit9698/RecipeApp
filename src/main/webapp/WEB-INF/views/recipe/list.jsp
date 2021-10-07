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
                    <div class="col noPadding"><h3 class="color-header text-uppercase">Recipe list</h3></div>
                    <div class="col noPadding d-flex justify-content-end mb-2"><a href="/user/recipe/add"
                                                                                  class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Add +</a></div>
                </div>
                <table class="table border-bottom schedules-content">
                    <thead>
                    <tr class="d-flex text-color-darker">
                        <th scope="col" class="col-1">ID</th>
                        <th scope="col" class="col-2">NAME</th>
                        <th scope="col" class="col-7">DESCRIPTION</th>
                        <th scope="col" class="col-2 center">ACTION</th>
                    </tr>
                    </thead>
                    <tbody class="text-color-lighter">
                    <c:forEach var="recipe" items="${recipes}">
                        <tr class="d-flex">
                            <th scope="row" class="col-1">${recipe.id}</th>
                            <td class="col-2">
                                    ${recipe.name}
                            </td>
                            <td class="col-7">${recipe.description}
                            </td>
                            <td class="col-2 d-flex align-items-center justify-content-center flex-wrap">
                                <a href="/user/recipe/delete/${recipe.id}" class="btn btn-danger rounded-0 text-light m-1">Delete</a>
                                <a href="/user/recipe/details/${recipe.id}"
                                   class="btn btn-info rounded-0 text-light m-1">Details</a>
                                <a href="/user/recipe/edit/${recipe.id}" class="btn btn-warning rounded-0 text-light m-1">Edit</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>

<%@include file="../section/script.jsp" %>
</body>
</html>
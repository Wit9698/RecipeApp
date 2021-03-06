<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<%@include file="../section/head.jsp" %>

<body class="recipes-section">
<%@include file="../section/header.jsp" %>
<section class="mr-4 ml-4">
    <div class="row pt-4 pb-2">
        <i class="fas fa-users icon-users"></i>
        <h1></h1>
        <hr>
        <div class="orange-line w-100"></div>
    </div>
</section>

<section class="width-medium text-color-darker">
    <div class="pb-2">
        <div class="border-dashed view-height w-100">
            <div class="mt-4 ml-4 mr-4">
                <div class="row border-bottom border-3">
                    <div class="col"><h3 class="color-header text-uppercase">Recipe details</h3></div>
                    <div class="col d-flex justify-content-end mb-2"><a href="/recipes" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Back</a></div>
                </div>

                <table class="table borderless">
                    <tbody>
                    <tr class="d-flex">
                        <th scope="row" class="col-2">Recipe name</th>
                        <td class="col-7">
                            ${recipe.name}
                        </td>
                    </tr>
                    <tr class="d-flex">
                        <th scope="row" class="col-2">Recipe description</th>
                        <td class="col-7">${recipe.description}</td>
                    </tr>
                    <tr class="d-flex">
                        <th scope="row" class="col-2">Preparation(min)</th>
                        <td class="col-7">
                            ${recipe.preparationTime}
                        </td>
                    </tr>
                    </tbody>
                </table>

                <div class="row d-flex">
                    <div class="col-5 border-bottom border-3"><h3 class="text-uppercase">Preparation</h3></div>
                    <div class="col-2"></div>
                    <div class="col-5 border-bottom border-3"><h3 class="text-uppercase">Ingredients</h3></div>
                </div>
                <div class="row d-flex">
                    <div class="col-5 p-4">
                        <p>${recipe.preparation}</p>
                    </div>
                    <div class="col-2"></div>
                    <ul class="col-5 p-4 list-unstyled">
                        ${recipe.ingredients}
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>

<%@include file="../section/footer.jsp" %>
<%@include file="../section/script.jsp" %>
</body>
</html>
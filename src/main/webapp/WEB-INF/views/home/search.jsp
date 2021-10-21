<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<%@include file="../section/head.jsp" %>

<body class="recipes-section">
<%@include file="../section/header.jsp" %>

<section>
    <div class="row padding-small">
        <i class="fas fa-users icon-users"></i>
        <h1>Recipes added by our users</h1>
        <hr>
        <div class="orange-line w-100"></div>
    </div>
</section>

<section class="mr-4 ml-4">
    <div style="color: red"><c:if test="${notFound != null}">${notFound}</c:if></div>
    <p/>

        <a href="/recipes" class="btn btn-color">All recipes</a>
        <p/>
    <table class="table">
        <thead>
        <tr class="d-flex text-color-darker">
            <th scope="col" class="col-1">ID</th>
            <th scope="col" class="col-5">NAME</th>
            <th scope="col" class="col-5">DESCRIPTION</th>
            <th scope="col" class="col-1">ACTIONS</th>
        </tr>
        </thead>

        <tbody class="text-color-lighter">
            <tr class="d-flex">

                <th scope="row" class="col-1">${recipe.id}</th>
                <td class="col-5">
                        ${recipe.name}
                </td>
                <td class="col-5">${recipe.description}</td>
                <td class="col-1"><a href="/recipes/details/${recipe.id}"
                                     class="btn btn-info rounded-0 text-light">Details</a></td>
            </tr>
        </tbody>

    </table>
</section>

<%@include file="../section/script.jsp" %>
</body>
</html>
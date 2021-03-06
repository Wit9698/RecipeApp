<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul class="nav flex-column long-bg">
    <li class="nav-item">
        <a class="nav-link" href="/user/dashboard">
            <span>Desktop</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/user/recipe/list">
            <span>Recipes</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/user/plan/list">
            <span>Plans</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/user/edit">
            <span>Edit your data</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li >
        <a class="nav-link">
        <form action="<c:url value="/logout"/>" method="post">
            <input class="btn-color" type="submit" value="Logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        </a>
    </li>
</ul>

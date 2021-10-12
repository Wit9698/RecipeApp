<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<%@include file="../section/head.jsp" %>
<body>
<%@include file="../section/inAppHeader.jsp" %>

<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <%@include file="../section/sideMenu.jsp" %>
        <div class="m-4 p-3 width-medium text-color-darker">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <form:form  modelAttribute="recipe" method="post" >
                    <div class="mt-4 ml-4 mr-4">
                        <div class="row border-bottom border-3">
                            <div class="col"><h3 class="color-header text-uppercase">Edit recipe</h3></div>
                            <div class="col d-flex justify-content-end mb-2">
                                <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Save
                                </button>
                            </div>
                        </div>

                        <table class="table borderless">
                            <tbody>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Name</th>
                                <td class="col-7">
                                    <form:input id="name" type="text" name="name" path="name" /><br>
                                    <form:errors path="name"/>
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Description</th>
                                <td class="col-7"> <form:textarea id="description" type="textera" name="description" path="description" /><br>
                                    <form:errors path="description"/>
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Preparation time(min)</th>
                                <td class="col-3">
                                    <form:hidden id="createdTime"  name="createdTime" path="createdTime" />
                                    <form:input id="preparationTime" type="number" name="preparationTime" path="preparationTime" /><br>
                                    <form:errors path="preparationTime"/>
                                </td>
                            </tr>
                            </tbody>
                        </table>

                        <div class="row d-flex">
                            <div class="col-5 border-bottom border-3"><h3 class="text-uppercase">Preparation</h3></div>
                            <div class="col-2"></div>
                            <div class="col-5 border-bottom border-3"><h3 class="text-uppercase">Ingregients</h3></div>
                        </div>
                        <div class="row d-flex">
                            <div class="col-5 p-4">
                                <form:textarea id="preparation"  name="preparation" path="preparation" /><br>
                                <form:errors path="preparation"/>
                            </div>
                            <div class="col-2"></div>

                            <div class="col-5 p-4">
                                <form:textarea id="ingredients"  name="ingredients" path="ingredients" /><br>
                                <form:errors path="ingredients"/>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

<%@include file="../section/script.jsp" %>
</body>
</html>
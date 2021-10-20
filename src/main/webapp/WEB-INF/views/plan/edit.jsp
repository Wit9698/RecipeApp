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

        <div class="m-4 p-3 width-medium">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <div class="row border-bottom border-3 p-1 m-1">
                    <div class="col noPadding">
                        <h3 class="color-header text-uppercase">EDIT PLAN</h3>
                    </div>
                    <form:form  modelAttribute="plan" method="post" >
                    <div class="col d-flex justify-content-end mb-2 noPadding">
                        <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Save</button>
                    </div>
                </div>
                <form:hidden id="createdTime"  name="createdTime" path="createdTime" />
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
                    </tr>
                    <tr class="d-flex">
                        <th scope="row" class="col-2">Recipes</th>
                        <td class="col-7"> <form:select  path="recipes" items="${recipes}" itemLabel="name"  itemValue="id" multiple="true"/>
                            <form:errors path="recipes"/>
                        </td>
                    </tr>
                    </tbody>
                </table>

                </form:form>
            </div>

        </div>
    </div>
    </div>
</section>

<%@include file="../section/script.jsp" %>
</body>
</html>

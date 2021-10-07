<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<%@include file="../section/head.jsp" %>
<body>
<%@include file="../section/inAppHeader.jsp" %>

<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-25">
                <!-- fix action, method -->
                <!-- add name attribute for all inputs -->
                <form:form action="edit" modelAttribute="user" method="post" >
                    <h1 class="text-color-darker">Edit data:</h1>
                    <form:hidden id="id"  name="id" path="id"/>
                    <div class="form-group">
                        First name: <form:input id="firstName" type="text" name="firstName" path="firstName"  class="input-material"/>
                    </div>
                    <div class="form-group">
                        Last name: <form:input id="lastName" type="text" name="lastName" path="lastName"/>
                    </div>

                    <div class="form-group">
                        Email: <form:input id="email" type="text" name="email" path="email"/>
                    </div>
                      <form:hidden id="username"  name="username" path="username" />
                    <div>
                     Password: <form:password id="password"  name="password" path="password"/>
                    </div>
                    <br>
                    <button class="btn btn-color rounded-0" type="submit">Edit</button>
                </form:form>
            </div>
        </div>
    </div>
</section>

<%@include file="../section/script.jsp" %>
</body>
</html>
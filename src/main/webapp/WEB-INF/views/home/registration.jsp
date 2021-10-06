<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<%@include file="../section/head.jsp" %>

<body>

<%@include file="../section/header.jsp" %>
<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-25">
                <!-- fix action, method -->
                <!-- add name attribute for all inputs -->
                <form:form action="registration" modelAttribute="user" method="post" >
                    <h1 class="text-color-darker">Register</h1>
                    <div class="form-group">
                        <form:input id="firstName" type="text" name="firstName" path="firstName" placeholder="Name"   data-msg="Please enter your name" class="input-material"/>
                    </div>
                    <div class="form-group">
                        <form:input id="lastName" type="text" name="lastName" path="lastName" placeholder="Surname" data-msg="Please enter your surname"/>
                    </div>
                    <div class="form-group">
                        <form:input id="username" type="text" name="username" path="username"  placeholder="Username"  data-msg="Please enter username" />
                    </div>
                    <div class="form-group">
                        <form:input id="email" type="text" name="email" path="email"  placeholder="Email"  data-msg="Please enter a valid email address" />
                    </div>
                    <div class="form-group">
                        <form:input id="password" type="password" name="password" path="password"  placeholder="Password"  data-msg="Please enter your password"/>
                    </div>
                    <button class="btn btn-color rounded-0" type="submit">Zarejestruj</button>

                </form:form><small>Already have an account? </small><a href="login" class="signup">Log in</a>
            </div>
        </div>
    </div>
</section>

<%@include file="../section/script.jsp" %>
</body>
</html>
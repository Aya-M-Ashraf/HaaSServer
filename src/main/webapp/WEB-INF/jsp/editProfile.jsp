<%-- 
    Document   : editProfile
    Created on : Jun 6, 2016, 1:10:27 PM
    Author     : Hossam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <body >
        <div class="content-wrapper">
            <div class="register-box">

                <div class="login-logo">
                    <span class="logo-lg"><b>HaaS </b>App.</span>
                    <div class=" image">
                        <img src="resources/dist/img/HaaS.jpg" class="img-circle" alt="User Image">
                    </div>
                </div><!-- /.login-logo -->

                <div class="register-box-body">
                    <b><p class="login-box-msg">Edit Your Profile</p></b>
                    <form:form method="POST" action="updateUser.htm" modelAttribute="user">

                        <div class="form-group has-feedback">
                            <form:input path="firstName" cssClass="form-control" value="${sessionScope.loggedUser.firstName}" />
                            <form:errors  path="firstName" cssStyle="color:red" />
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        </div>

                        <div class="form-group has-feedback">
                            <form:input path="lastName" cssClass="form-control" value="${sessionScope.loggedUser.lastName}"/>
                            <form:errors  path="lastName" cssStyle="color:red" />
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        </div>

                        <div class="form-group has-feedback">
                            <form:password path="password" cssClass="form-control" value="${sessionScope.loggedUser.password}"/>
                            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        </div>

                        <div class="form-group has-feedback">
                            <form:input path="phone" cssClass="form-control" value="${sessionScope.loggedUser.phone}"/>
                            <form:errors  path="phone" cssStyle="color:red" />
                            <span class="glyphicon glyphicon-phone form-control-feedback"></span>
                        </div>

                        <div class="row">
                            <div class="col-xs-4">
                                <button type="submit" class="btn btn-primary btn-block btn-flat">Submit</button>
                            </div><!-- /.col -->
                        </div>

                    </form:form>
                </div><!-- /.form-box -->
            </div><!-- /.register-box -->

        </div>
    </body>
</html>


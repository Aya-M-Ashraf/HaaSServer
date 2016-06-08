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
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Edit Profile Page</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
        <link rel="stylesheet" href="resources/plugins/iCheck/square/blue.css">
    </head>

    <body class="hold-transition register-page">
        <div class="register-box">
            
            <div class="login-logo">
                <span class="logo-lg"><b>HaaS </b>App.</span>
            </div><!-- /.login-logo -->
            
            <div class="register-box-body">
                <b><p class="login-box-msg">Edit Your Profile</p></b>
                <form:form method="POST" action="updateUser.htm" modelAttribute="user">

                    <div class="form-group has-feedback">
                        <form:input path="firstName" cssClass="form-control" value="${sessionScope.loggedUser.firstName}" />
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                    </div>

                    <div class="form-group has-feedback">
                        <form:input path="lastName" cssClass="form-control" value="${sessionScope.loggedUser.lastName}"/>
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                    </div>
                        
                    <div class="form-group has-feedback">
                        <form:password path="password" cssClass="form-control" value="${sessionScope.loggedUser.password}"/>
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                        
                    <div class="form-group has-feedback">
                        <form:input path="phone" cssClass="form-control" value="${sessionScope.loggedUser.phone}"/>
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

        <script src="resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
        <script src="resources/plugins/iCheck/icheck.min.js"></script>
    </body>
</html>


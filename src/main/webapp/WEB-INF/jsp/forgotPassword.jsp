<%-- 
    Document   : login
    Created on : Jun 2, 2016, 10:38:37 PM
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
        <title> Forgot Password </title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.5 -->
        <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="resources/plugins/iCheck/square/blue.css">


    </head>

    <body class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">
                <span class="logo-lg"><b>HaaS </b>App.</span>
                <div class=" image">
                    <img src="resources/dist/img/HaaS.jpg" class="img-circle" alt="User Image">
                </div>
            </div><!-- /.login-logo -->
            <div class="login-box-body">
                <b><p class="login-box-msg">Forgot your password ? No problem.</p></b>
                <br>
                <span style="color:red" >${message}</span>

                <form:form method="POST" action="retrievingPassword.htm" modelAttribute="user">

                    <div class="form-group has-feedback">
                        <form:input path="email" cssClass="form-control"   placeholder= "Enter Your Email" />
                        <div style="color:red"><form:errors path="email" /></div>
                        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                    </div>

                    <div class="form-group has-feedback">
                        <form:input path="phone" cssClass="form-control"   placeholder= "Enter Your Mobile Number" />
                         <span style="color:red"><form:errors path="phone" /></span>
                        <span class="glyphicon glyphicon-phone form-control-feedback"></span>
                    </div>


                    <br>
                    <div class="row">
                        <div class="col-xs-4">
                            <button type="submit" class="btn btn-primary btn-flat">Retrieve Password</button>
                        </div><!-- /.col -->
                    </div>
                </form:form>
                   <br>
                <b><a href="register.htm" class="text-center">Register a new membership</a></b>
                <br>
                <b><a href="login.htm" class="text-center">or Login</a></b> 


            </div><!-- /.login-box-body -->
        </div><!-- /.login-box -->

    </body>
</html>

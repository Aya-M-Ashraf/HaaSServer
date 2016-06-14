<%-- 
    Document   : register
    Created on : May 23, 2016, 2:00:08 PM
    Author     : Aya M. Ashraf
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
        <title>Registration Page</title>
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
                <div class=" image">
                    <img src="resources/dist/img/HaaS.jpg" class="img-circle" alt="User Image">
                </div>
            </div><!-- /.login-logo -->
            <div class="register-box-body">
                <b><p class="login-box-msg">Register a new membership</p></b>

                <center> <div style="color:red">${message}</div> </center>

                <form:form method="POST" action="addUser.htm" modelAttribute="user">
                    <div class="form-group has-feedback">
                        <form:input path="firstName" cssClass="form-control" placeholder= "Enter Your First Name" />
                        <form:errors  path="firstName" cssStyle="color:red" />
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                    </div>

                    <div class="form-group has-feedback">
                        <form:input path="lastName" cssClass="form-control" placeholder= "Enter Your Last Name" />
                        <form:errors  path="lastName" cssStyle="color:red" />
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                    </div>

                    <div class="form-group has-feedback">
                        <form:input path="email" cssClass="form-control" placeholder= "Enter Your E-mail Address" />
                        <form:errors  path="email" cssStyle="color:red" />
                        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                    </div>

                    <div class="form-group has-feedback">
                        <form:input path="phone" cssClass="form-control"  placeholder= "Enter Your Phone Number" />
                        <form:errors  path="phone" cssStyle="color:red" />
                        <span class="glyphicon glyphicon-phone form-control-feedback"></span>
                    </div>

                    <div class="form-group has-feedback">
                        <form:password path="password" cssClass="form-control" placeholder= "Enter Your Password" />
                        <form:errors  path="password" cssStyle="color:red" />
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <form:select path="gender" cssClass="form-control" >
                            <form:option value="0" label="Male"/>
                            <form:option value="1" label="Female"/>
                        </form:select>
                    </div>
                    <div class="form-group has-feedback">
                        <form:select path="country" cssClass="form-control" >
                            <form:option value="Cairo" label="Cairo"/>
                            <form:option value="Giza" label="Giza"/>
                            <form:option value="Alex" label="Alex"/>
                            <form:option value="Mansoura" label="Mansoura"/>
                            <form:option value="Suez" label="Suez"/>
                        </form:select>
                        <form:errors  path="country" cssStyle="color:red" />
                        <span class="glyphicon glyphicon-map-marker form-control-feedback"></span>
                    </div>
                    <br>
                    <br>

                    <div class="row">
                        <div class="col-xs-4">
                            <button type="submit" class="btn btn-primary btn-block btn-flat">Register</button>
                        </div><!-- /.col -->
                    </div>
                </form:form>
                <br>
                <b><a href="login.htm" class="text-center">I already have a membership</a></b>
            </div><!-- /.form-box -->
        </div><!-- /.register-box -->

        <script src="resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
        <script src="resources/plugins/iCheck/icheck.min.js"></script>
        <script>
            $(function () {
                $('input').iCheck({
                    checkboxClass: 'icheckbox_square-blue',
                    radioClass: 'iradio_square-blue',
                    increaseArea: '20%' // optional
                });
            });
        </script>
    </body>
</html>

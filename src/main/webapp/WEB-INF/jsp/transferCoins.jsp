<%-- 
    Document   : profile
    Created on : May 22, 2016, 12:31:52 PM
    Author     : Aya M. Ashraf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html> 
    <body>

        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Transfer Coins</h1>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="box box-body">
                    <div class="box-header">
                        <h3 class="box-title">Transfer Coins Operation</h3>
                    </div>
                    <form:form method="POST" action="submitTransfer.htm" modelAttribute="transferringOperation" >
                        <div class="box-body">
                            <div class="form-group">
                                <label>Coins Type</label>
                                <div class="input-group">
                                    <div class="input-group-addon"><i class="fa fa-money"></i></div>
                                        <form:select path="coinsType" cssClass="form-control">
                                            <form:option value="silver" label="Silver Coins"/>
                                            <form:option value="golden" label="Golden Coins"/>
                                        </form:select>
                                </div><!-- /.input group -->

                                <label>Coins Type</label>
                                <div class="input-group">
                                    <div class="input-group-addon"><i class="fa fa-money"></i></div>
                                        <form:input  path="coinsCount" cssClass="form-control" />
                                    <b><form:errors path="coinsCount" /></b>
                                </div><!-- /.input group -->

                                <div class="input-group">
                                    <form:input type="hidden" path="senderMail" cssClass="form-control" value="Aya@yahoo.com"/>
                                    <form:errors  path="senderMail"  />
                                </div><!-- /.input group -->

                                <label>To:</label>
                                <div class="input-group">
                                    <div class="input-group-addon"><i class="fa fa-envelope"></i></div>
                                        <form:input  path="receiverMail" cssClass="form-control" />
                                        <form:errors  path="receiverMail"  />
                                </div><!-- /.input group -->

                                <button type="submit" class="btn btn-primary btn-block btn-default">Transfer</button>
                            </div><!-- /.form group --> 
                        </div><!-- /.box-body -->  
                    </form:form>
                </div><!-- /.box -->   
            </section><!-- /.content -->
        </div><!-- /.content-wrapper -->
    </body>

</html>

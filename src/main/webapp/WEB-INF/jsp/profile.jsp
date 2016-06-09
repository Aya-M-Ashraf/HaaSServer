<%-- 
    Document   : profile
    Created on : May 22, 2016, 12:31:52 PM
    Author     : Aya M. Ashraf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html> 
    <body>

        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>${sessionScope.loggedUser.firstName} ${sessionScope.loggedUser.lastName}'s Profile</h1>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-md-3">

                        <!-- Profile Image -->
                        <div class="box box-primary">
                            <div class="box-body box-profile">
                                <img class="profile-user-img img-responsive img-circle" src="resources/dist/img/user4-128x128.jpg" alt="User profile picture">
                                <h3 class="profile-username text-center"> ${user.firstName} ${user.lastName}</h3>
                                <p class="text-muted text-center">${user.email}</p>

                                <ul class="list-group list-group-unbordered">
                                    <li class="list-group-item">
                                        <b>Golden Coins</b> <a class="pull-right">${sessionScope.loggedUser.goldenCoins} </a>
                                    </li>
                                    <li class="list-group-item">
                                        <b>Silver Coins</b> <a class="pull-right">${sessionScope.loggedUser.silverCoins} </a>
                                    </li>
                                </ul>
                            </div><!-- /.box-body -->
                        </div><!-- /.box -->

                    </div><!-- /.col -->
                    <div class="col-md-9">

                        <!-- About Me Box -->
                        <div class="box box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title">About Me</h3>
                            </div><!-- /.box-header -->
                            <div class="box-body">

                                <strong><i class="fa fa-map-marker margin-r-5"></i> Location</strong>
                                <p class="text-muted">Malibu, California</p>

                                <hr>

                                <strong><i class="fa fa-phone margin-r-5"></i>Phone</strong>
                                <p class="text-muted"> ${sessionScope.loggedUser.phone}</p>

                                <hr>

                            </div><!-- /.box-body -->
                        </div><!-- /.box -->


                        <div class="nav-tabs-custom">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#timeline" data-toggle="tab">Timeline</a></li>
                                <li><a href="#activity" data-toggle="tab">Registered Devices</a></li>
                            </ul>

                            <div class="tab-content">

                                <div class="tab-pane" id="activity">

                                    <div class="box-body table-responsive no-padding">
                                        <table class="table table-hover">
                                            <tr>
                                                <th>ID</th>
                                                <th>Serial Number</th>
                                                <th>Start Using Date</th>
                                                <th>End Using Date</th>
                                                <th>Status</th>
                                            </tr>
                                            <c:forEach var="obj" items="${devicesList}">
                                                <tr>
                                                    <td>${obj.device.deviceId}</td>
                                                    <td>${obj.device.serialNumber}</td>
                                                    <td>${obj.userUsesDevicePK.startUsingTimestamp}</td>
                                                    <td>${obj.endUsingTimestamp}</td>
                                                    <td><span class="label label-success">Working</span></td>
                                                </tr>
                                            </c:forEach>

                                        </table>
                                    </div><!-- /.box-body -->


                                </div> <!-- /.tab-pane -->

                                <div class="active tab-pane" id="timeline">
                                    <!-- The timeline -->
                                    <ul class="timeline timeline-inverse">
                                        <c:forEach var="innerList" items="${asGuestList}">
                                            <c:forEach var="obj" items="${innerList}">
                                                <c:out value="${obj.device.deviceId}"></c:out>
                                                    <!--  timeline time label--> 
                                                    <li class="time-label">
                                                        <span class="bg-green-gradient">
                                                        ${obj.deviceOldSessionDevicesPK.startTimestamp}
                                                    </span>
                                                </li>
                                                <!-- /.timeline-label -->

                                                <li>
                                                    <i class="fa fa-anchor bg-gray"></i>
                                                    <div class="timeline-item">
                                                        <span class="time"><i class="fa fa-clock-o"></i> 27 mins ago</span>
                                                        <h3 class="timeline-header"><a>You Joined a Hosted network</a> </h3>
                                                        <div class="timeline-body">
                                                            Session Total Consumed MegaBytes is  <b>${obj.consumedMb}</b>  mega bytes.
                                                        </div>
                                                    </div>
                                                </li>
                                                <!-- END timeline item -->

                                            </c:forEach>
                                        </c:forEach>

                                        <c:forEach var="innerList" items="${asHostList}">
                                            <c:forEach var="obj" items="${innerList}">
                                                <c:out value="${obj.device.deviceId}"></c:out>

                                                    <!--  timeline time label--> 
                                                    <li class="time-label">
                                                        <span class="bg-blue-gradient">
                                                        ${obj.deviceOldSessionDevicesPK.startTimestamp}
                                                    </span>
                                                </li>
                                                <!-- /.timeline-label -->

                                                <li>
                                                    <i class="fa fa-anchor bg-yellow"></i>
                                                    <div class="timeline-item">
                                                        <span class="time"><i class="fa fa-clock-o"></i> 27 mins ago</span>
                                                        <h3 class="timeline-header"><a>You Started a Hosted network</a> </h3>
                                                        <div class="timeline-body">
                                                            Session Total Consumed MegaBytes is  <b>${obj.consumedMb}</b>  mega bytes.
                                                        </div>
                                                    </div>
                                                </li>
                                                <!-- END timeline item -->

                                            </c:forEach>
                                        </c:forEach>
                                        <li>
                                            <i class="fa fa-clock-o bg-gray"></i>
                                        </li>
                                    </ul>
                                </div> <!-- /.tab-pane --> 

                            </div> <!-- /.tab-content -->
                        </div> <!-- /.nav-tabs-custom -->
                    </div><!-- /.col -->
                </div><!-- /.row -->

            </section><!-- /.content -->

        </div><!-- /.content-wrapper -->

    </body>
</html>

<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
        <link rel="stylesheet" href="resources/dist/css/skins/_all-skins.min.css">
        <link rel="stylesheet" href="resources/plugins/iCheck/flat/blue.css">
        <link rel="stylesheet" href="resources/plugins/morris/morris.css">
        <link rel="stylesheet" href="resources/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
        <link rel="stylesheet" href="resources/plugins/datepicker/datepicker3.css">
        <link rel="stylesheet" href="resources/plugins/daterangepicker/daterangepicker-bs3.css">
        <link rel="stylesheet" href="resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

        <!--        <script src="resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
                <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
                <script src="resources/plugins/morris/morris.min.js"></script>
                <script src="resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
                <script>$.widget.bridge('uibutton', $.ui.button);</script>-->

        <script src="resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
        <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
        <script>$.widget.bridge('uibutton', $.ui.button);</script>
        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        <script src="resources/plugins/morris/morris.min.js"></script>
        <script src="resources/plugins/knob/jquery.knob.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
        <script src="resources/plugins/daterangepicker/daterangepicker.js"></script>
        <script src="resources/plugins/datepicker/bootstrap-datepicker.js"></script>
        <script src="resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
        <script src="resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
        <script src="resources/plugins/fastclick/fastclick.min.js"></script>
        <script src="resources/dist/js/app.min.js"></script>
        <!--<script src="resources/dist/js/pages/dashboard.js"></script>-->
        <!--<script src="resources/dist/js/demo.js"></script>-->
        <!--<script src="resources/dist/js/pages/dashboard2.js"></script>-->
        <script src="resources/plugins/chartjs/Chart.min.js"></script>
        <script src="resources/plugins/sparkline/jquery.sparkline.min.js"></script>
        <script src="resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
        <script src="resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>

    </head>

    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    Statistics
                    <small>year 2016</small>
                </h1>
            </section>

            <!-- Main content -->
            <section class="content">
                <!-- Info boxes -->
                <div class="row">
                    <div class="col-lg-3 col-xs-6">
                        <!-- small box -->
                        <div class="small-box bg-aqua">
                            <div class="inner">
                                <h3>${reportBean.devicesCount}</h3>
                                <p>Registered Devices</p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-bag"></i>
                            </div>
                        </div>
                    </div><!-- ./col -->
                    <div class="col-lg-3 col-xs-6">
                        <!-- small box -->
                        <div class="small-box bg-green">
                            <div class="inner">
                                <h3>${reportBean.connectionsCount}</h3>
                                <p>Total Connections</p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-stats-bars"></i>
                            </div>
                        </div>
                    </div><!-- ./col -->
                    <div class="col-lg-3 col-xs-6">
                        <!-- small box -->
                        <div class="small-box bg-yellow">
                            <div class="inner">
                                <h3>${reportBean.usersCount}</h3>
                                <p>User Registrations</p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-person-add"></i>
                            </div>
                        </div>
                    </div><!-- ./col -->
                    <div class="col-lg-3 col-xs-6">
                        <!-- small box -->
                        <div class="small-box bg-red">
                            <div class="inner">
                                <h3>${reportBean.totalMegaBytes}</h3>
                                <p>Total Shared Mega Bytes</p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-ios-cloud-download-outline"></i>
                            </div>
                        </div>
                    </div><!-- ./col -->
                </div><!-- /.row -->

                <div class="row">
                    <section class="content">

                        <div class="row">
                            <div class="col-md-6">

                                <!-- DONUT CHART -->
                                <div class="box box-danger">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Gender Chart</h3>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                            <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                        </div>
                                    </div>
                                    <div class="box-body chart-responsive">
                                        <div class="chart" id="gender-chart" style="height: 300px; position: relative;"></div>
                                    </div><!-- /.box-body -->
                                </div><!-- /.box -->

                            </div><!-- /.col (LEFT) -->
                            <div class="col-md-6">

                                <!-- BAR CHART -->
                                <div class="box box-success">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Users Locations Chart</h3>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                            <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                        </div>
                                    </div>
                                    <div class="box-body chart-responsive">
                                        <div class="chart" id="bar-chart" style="height: 300px;"></div>
                                    </div><!-- /.box-body -->
                                </div><!-- /.box -->

                            </div><!-- /.col (RIGHT) -->
                        </div><!-- /.row -->

                    </section><!-- /.content -->

                </div><!-- /.row -->


            </section><!-- /.content -->
        </div><!-- /.content-wrapper -->

        <script>
            $(function () {
                "use strict";
                //DONUT CHART
                var donut = new Morris.Donut({
                    element: 'gender-chart',
                    resize: true,
                    colors: ["#f56954", "#3c8dbc"],
                    data: [
                        {label: "Female Users", value: ${reportBean.femaleUsersCount}},
                        {label: "Male Users", value: ${reportBean.maleUsersCount}}
                    ],
                    hideHover: 'auto'
                });

                //BAR CHART
                var bar = new Morris.Bar({
                    element: 'bar-chart',
                    resize: true,
                    data: [
                        {y: 'Giza', a:${reportBean.gizaDist}},
                        {y: 'Cairo', a: ${reportBean.cairoDist}},
                        {y: 'Alex', a: ${reportBean.alexDist}},
                        {y: 'Suez', a: ${reportBean.suezDist}},
                        {y: 'Mansoura', a: ${reportBean.mansouraDist}}
                    ],
                    barColors: ['#02a15a'],
                    xkey: 'y',
                    ykeys: ['a'],
                    labels: ['Users'],
                    hideHover: 'auto'
                });
            });

        </script>

    </body>
</html>

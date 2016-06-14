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

        <script src="resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
        <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        <script src="resources/plugins/morris/morris.min.js"></script>
        
    </head>

    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    Dashboard
                    <small>Version 2.0</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Dashboard</li>
                </ol>
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
                                <!-- AREA CHART -->
                                <div class="box box-primary">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Area Chart</h3>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                            <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                        </div>
                                    </div>
                                    <div class="box-body chart-responsive">
                                        <div class="chart" id="revenue-chart" style="height: 300px;"></div>
                                    </div><!-- /.box-body -->
                                </div><!-- /.box -->

                                <!-- DONUT CHART -->
                                <div class="box box-danger">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Donut Chart</h3>
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
                                <!-- LINE CHART -->
                                <div class="box box-info">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Line Chart</h3>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                            <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                        </div>
                                    </div>
                                    <div class="box-body chart-responsive">
                                        <div class="chart" id="line-chart" style="height: 300px;"></div>
                                    </div><!-- /.box-body -->
                                </div><!-- /.box -->

                                <!-- BAR CHART -->
                                <div class="box box-success">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Bar Chart</h3>
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
                alert("inside function");
                "use strict";

                // AREA CHART
                var area = new Morris.Area({
                    element: 'revenue-chart',
                    resize: true,
                    data: [
                        {y: '2011 Q1', item1: 2666, item2: 2666},
                        {y: '2011 Q2', item1: 2778, item2: 2294},
                        {y: '2011 Q3', item1: 4912, item2: 1969},
                        {y: '2011 Q4', item1: 3767, item2: 3597},
                        {y: '2012 Q1', item1: 6810, item2: 1914},
                        {y: '2012 Q2', item1: 5670, item2: 4293},
                        {y: '2012 Q3', item1: 4820, item2: 3795},
                        {y: '2012 Q4', item1: 15073, item2: 5967},
                        {y: '2013 Q1', item1: 10687, item2: 4460},
                        {y: '2013 Q2', item1: 8432, item2: 5713}
                    ],
                    xkey: 'y',
                    ykeys: ['item1', 'item2'],
                    labels: ['Item 1', 'Item 2'],
                    lineColors: ['#a0d0e0', '#3c8dbc'],
                    hideHover: 'auto'
                });

                // LINE CHART
                var line = new Morris.Line({
                    element: 'line-chart',
                    resize: true,
                    data: [
                        {y: '2011 Q1', item1: 2666},
                        {y: '2011 Q2', item1: 2778},
                        {y: '2011 Q3', item1: 4912},
                        {y: '2011 Q4', item1: 3767},
                        {y: '2012 Q1', item1: 6810},
                        {y: '2012 Q2', item1: 5670},
                        {y: '2012 Q3', item1: 4820},
                        {y: '2012 Q4', item1: 15073},
                        {y: '2013 Q1', item1: 10687},
                        {y: '2013 Q2', item1: 8432}
                    ],
                    xkey: 'y',
                    ykeys: ['item1'],
                    labels: ['Item 1'],
                    lineColors: ['#3c8dbc'],
                    hideHover: 'auto'
                });

                //DONUT CHART
                var donut = new Morris.Donut({
                    element: 'gender-chart',
                    resize: true,
                    colors: ["#f56954","#3c8dbc"],
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
                        {y: '2006', a: 100, b: 90},
                        {y: '2007', a: 75, b: 65},
                        {y: '2008', a: 50, b: 40},
                        {y: '2009', a: 75, b: 65},
                        {y: '2010', a: 50, b: 40},
                        {y: '2011', a: 75, b: 65},
                        {y: '2012', a: 100, b: 90}
                    ],
                    barColors: ['#00a65a', '#f56954'],
                    xkey: 'y',
                    ykeys: ['a', 'b'],
                    labels: ['CPU', 'DISK'],
                    hideHover: 'auto'
                });
            });

        </script>

    </body>
</html>

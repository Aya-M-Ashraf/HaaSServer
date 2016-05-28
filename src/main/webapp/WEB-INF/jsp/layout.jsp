<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  

<html>  
    <head>  
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
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
        
        <title><tiles:insertAttribute name="title" ignore="true" /></title>  
    </head> 
    
    <body class="hold-transition skin-blue sidebar-mini">  
        <div class="wrapper">
            <tiles:insertAttribute name="header" />
            <tiles:insertAttribute name="leftMenu" />
            <tiles:insertAttribute name="rightMenu" />
            <tiles:insertAttribute name="body" />
            <tiles:insertAttribute name="footer" />
        </div>    
        
        
        <script src="resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
        <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
        <script>$.widget.bridge('uibutton', $.ui.button);</script>
        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        <script src="resources/plugins/morris/morris.min.js"></script>
        <script src="resources/plugins/sparkline/jquery.sparkline.min.js"></script>
        <script src="resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
        <script src="resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
        <script src="resources/plugins/knob/jquery.knob.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
        <script src="resources/plugins/daterangepicker/daterangepicker.js"></script>
        <script src="resources/plugins/datepicker/bootstrap-datepicker.js"></script>
        <script src="resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
        <script src="resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
        <script src="resources/plugins/fastclick/fastclick.min.js"></script>
        <script src="resources/dist/js/app.min.js"></script>
        <script src="resources/dist/js/pages/dashboard.js"></script>
        <script src="resources/dist/js/demo.js"></script>
    </body>  
</html>  
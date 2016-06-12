<%-- 
    Document   : menu
    Created on : May 22, 2016, 12:35:24 PM
    Author     : Aya M. Ashraf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="image">
                    <img src="resources/dist/img/HaaS.jpg" class="img-circle" alt="User Image">
                </div>
            </div>
          
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li class="header">MAIN NAVIGATION</li>


                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-edit"></i> <span>Profile</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="profile.htm"><i class="fa fa-circle-o"></i> View Profile</a></li>
                        <li><a href="editProfile.htm"><i class="fa fa-circle-o"></i> Edit Profile</a></li>
                    </ul>
                </li>

                <li class="treeview">
                    <a href="transferCoins.htm">
                        <i class="fa fa-dollar"></i> <span>Transfer Coins </span>
                    </a>
                </li>

            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

</html>

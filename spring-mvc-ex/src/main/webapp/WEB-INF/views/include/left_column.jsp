<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>

<body class="hold-transition skin-blue sidebar-mini">
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- Sidebar user panel (optional) -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="../dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>홍현우</p>
          <!-- Status -->
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>

      <!-- search form (Optional) -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
          <span class="input-group-btn">
              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
              </button>
            </span>
        </div>
      </form>
      <!-- /.search form -->

      <!-- 왼쪽 사이드 메뉴 -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">메뉴</li>
        
        <li class="treeview">
        	<a href="#"><i class ="fa fa-edit"></i> <span>게시판(기본)</span>
        		<span class="pull-right-container">
					<i class="fa fa-angle-left pull-right"></i>
				</span>        		
        	</a>
        	<ul class="treeview-menu">
        		<li class="active"><a href="${path}/article/write"><i class="fa fa-pencil"></i> <span>게시글 쓰기</span></a></li>
        		<li><a href="${path}/article/list"><i class="fa fa-list"></i> <span>게시글 목록</span></a></li>
			</ul> 
		</li>	
		
		<li class="treeview">
        	<a href="#"><i class ="fa fa-edit"></i> <span>게시판(페이징)</span>
        		<span class="pull-right-container">
					<i class="fa fa-angle-left pull-right"></i>
				</span>        		
        	</a>
        	<ul class="treeview-menu">
        		<li class="active"><a href="${path}/article/paging/write"><i class="fa fa-pencil"></i> <span>게시글 쓰기</span></a></li>
        		<li><a href="${path}/article/paging/list"><i class="fa fa-list"></i> <span>게시글 목록</span></a></li>
			</ul> 
		</li>	
		
		<li class="treeview">
        	<a href="#"><i class ="fa fa-edit"></i> <span>게시판(페이징+검색)</span>
        		<span class="pull-right-container">
					<i class="fa fa-angle-left pull-right"></i>
				</span>        		
        	</a>
        	<ul class="treeview-menu">
        		<li class="active"><a href="${path}/article/paging/search/write"><i class="fa fa-pencil"></i> <span>게시글 쓰기</span></a></li>
        		<li><a href="${path}/article/paging/search/list"><i class="fa fa-list"></i> <span>게시글 목록</span></a></li>
			</ul> 
		</li>	
		
      </ul>
      
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>
</body>
</html>
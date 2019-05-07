<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<html>
<%@ include file="../include/head.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#writeBtn").click(function(){ 
			location.replace('/article/write');
		});

	
	});
</script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		
		<!-- main header -->
		<%@ include file="../include/main_header.jsp" %>
		
		<!-- left area -->
		<%@ include file="../include/left_column.jsp" %>
		
		
		<div class="content-wrapper">
    	<!-- Content Header (Page header) -->
		    <section class="content-header">
		      <h1>
		        Page Header
		        <small>Optional description</small>
		      </h1>
		      <ol class="breadcrumb">
		        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
		        <li class="active">Here</li>
		      </ol>
		    </section>
		
		    <!-- Main content -->
		    <section class="content container-fluid">
				<h3><i class="fa fa-warning text-red"></i>${excetion.getMessage()}</h3>
		      	<ul>
		      		<c:forEach items="${exception.getStackTrace()}" var="stack">
		      			<li>${stack.toString()}</li>
					</c:forEach>		      			
		      	</ul>
		
		    </section>
		    <!-- /.content -->
		</div>
		
		<!-- footer area -->
		<%@ include file="../include/main_footer.jsp" %>
		
	</div>
	
	<%@ include file="../include/plugin_js.jsp" %>
</body>
</html>
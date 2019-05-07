<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<script src="/js/jquery/jquery-1.11.2.min.js"></script>
<html>
<jsp:include page="/WEB-INF/views/include/head.jsp" />

<script type="text/javascript">
	$(document).ready(function(){
		
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$(".btn-primary").on("click", function(){
			self.location = "/article/list"
		});
		
	});
</script>


<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		
		<!-- main header -->
		<%@ include file="/WEB-INF/views/include/main_header.jsp" %>
		
		<!-- left area -->
		<%@ include file="/WEB-INF/views/include/left_column.jsp" %>
		
		
		<div class="content-wrapper">

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
				
				<div class="col-lg-12">
					<form role="form" id="writeForm" method="post" action="${path}/article/write">
						<div class="box box-primary">
							<div class="box-header with-border">
								<h3 class="box-title">게시글 작성</h3>
							</div>
							<div class="box-body">
								<div class="form-group">
									<label for="title">제목</label>
									<input class="form-control" id="title" name="title" placeholder="제목을 입력해주세요">
								</div>
								<div class="form-group">
									<label for="content">내용</label>
									<textarea class="form-control" id="content" name="content" rows="30"
									       placeholder="제목을 입력해주세요" style="resize: none;"></textarea>
								</div>
								<div class="form-group">
									<label for="writer">작성자</label>
									<input class="form-control" id="writer" name="writer">
								</div>
							</div>
							<div class="box-footer">
								<button type="button" class="btn btn-primary"><i class="fa fa-list"></i>목록</button>
								<div class="pull-right">
									<button type="reset" class="btn btn-warning"><i class="fa fa-reply"></i>초기화</button>
									<button type="submit" class="btn btn-success"><i class="fa fa-save"></i>저장</button>
								</div>
							</div>							
						</div>					
					</form>
				</div>
				
		    </section>
		    <!-- /.content -->
		</div>
		
		<!-- footer area -->
		<%@ include file="/WEB-INF/views/include/main_footer.jsp" %>
		
	</div>
	
	<%@ include file="/WEB-INF/views/include/plugin_js.jsp" %>
</body>
</html>
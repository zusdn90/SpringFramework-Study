<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<%@ include file="../../include/head.jsp" %>
<script src="/js/jquery/jquery-1.11.2.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		
		$("#writeBtn").click(function(){ 
			location.replace('/article/write');
		});
		
		
		/**
		 * 게시글 등록, 수정, 삭제 요청이 컨트롤러에서 처리가 되고, redirect되면서
		 * redirectAttributes.addFlashAttribute()를 통해 저장된 데이터를 가지고
		 * 요청이 정상적으로 처리되었는지 알려주기 위해 작성
		 */
		var result = "${msg}";

		if(result == "regSucces"){
			alert("게시글 등록이 완료되었습니다.")
		}else if(result == "modSucces"){
			alert("게시글 수정이 완료되었습니다.")
		}else if(result == "delSucces"){
			alert("게시글 삭제가 완료되었습니다.")
		}
	
	});
</script>
<body class="hold-transition skin-blue sidebar-mini layout-boxed">
	<div class="wrapper">
		
		<!-- main header -->
		<%@ include file="../../include/main_header.jsp" %>
		
		<!-- left area -->
		<%@ include file="../../include/left_column.jsp" %>
		
		
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
				<div class="col-lg-12">
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">게시글 목록</h3>
						</div>
						<div class="box-body">
							<table class="table table-bordered">
								<tbody>
								<tr>
									<th style="width : 30px">#</th>
									<th>제목</th>
									<th style="width : 100px">작성자</th>
									<th style="width : 150px">조회시간</th>
									<th style="width : 60px">조회</th>
								</tr>
								<c:forEach items="${articles}" var="article">
								<tr>
									<td>${article.articleNo}</td>
									<td><a href="${path}/article/read?articleNo=${article.articleNo}">${article.title}</a></td>
									<td>${article.writer}</td>
									<td><fmt:formatDate value="${article.regDate}" pattern="yyyy-MM-dd a HH:mm"/></td>
									<td><span class="badge bg-red">${article.viewCnt}</span></td>
								</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="box-footer">
							<div class="pull-right">
								<button type="button" class="btn btn-success btn-flat" id="writeBtn">
									<i class="fa fa-pencil">글쓰기</i> 
								</button>
							</div>
						</div>
					</div>
				</div>
		      
		
		    </section>
		    <!-- /.content -->
		</div>
		
		<!-- footer area -->
		<%@ include file="../../include/main_footer.jsp" %>
		
	</div>
	
	<%@ include file="../../include/plugin_js.jsp" %>
</body>
</html>
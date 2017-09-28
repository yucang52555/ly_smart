<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%  
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);   
%>

<link rel="stylesheet" href="${_staticPath}/assets/css/jquery-ui.custom.css" />
<link rel="stylesheet" href="${_staticPath}/assets/css/jquery.gritter.css" />
<link rel="stylesheet" href="${_staticPath}/assets/css/select2.css" />
<link rel="stylesheet" href="${_staticPath}/assets/css/datepicker.css" />
<link rel="stylesheet" href="${_staticPath}/assets/css/bootstrap-editable.css" />

<title>个人中心-${_systemName}</title>

<!-- ajax layout which only needs content area -->
<div class="page-header">
	<h1>
		个人中心
	</h1>
</div><!-- /.page-header -->

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<div>
			<div id="user-profile-3" class="user-profile row">
				<div class="col-sm-offset-1 col-sm-10">

					<div class="space"></div>
					
					<form id="_editForm" class="form-horizontal"
						validate="true">
						<div class="tabbable">
							<ul class="nav nav-tabs padding-16">
								<li class="active">
									<a data-toggle="tab" href="#edit-basic">
										<i class="green ace-icon fa fa-pencil-square-o bigger-125"></i>
										基本信息
									</a>
								</li>
								<!-- 
								<li>
									<a data-toggle="tab" href="#edit-password">
										<i class="blue ace-icon fa fa-key bigger-125"></i>
										修改密码
									</a>
								</li>
								 -->
							</ul>
	
							<div class="tab-content profile-edit-tab-content">
								<div id="edit-basic" class="tab-pane in active">
									<h4 class="header blue bolder smaller">注册信息</h4>
	
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-email">登录名</label>
	
										<div class="col-sm-9">
											<label class="control-label"><b>${user.account}</b></label>
										</div>
									</div>
	
									<div class="space-4"></div>
	
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-website">注册时间</label>
	
										<div class="col-sm-9">
											<label class="control-label"><b><fmt:formatDate  value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></b></label>
										</div>
									</div>
	
									<div class="space"></div>
									<h4 class="header blue bolder smaller">登录信息</h4>
	
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-facebook">最后登录IP</label>
	
										<div class="col-sm-9">
											<label class="control-label"><b>${user.lastLoginIp}</b></label>
										</div>
									</div>
	
									<div class="space-4"></div>
	
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-twitter">登录总次数</label>
	
										<div class="col-sm-9">
											<label class="control-label"><b>${user.loginCount}</b></label>
										</div>
									</div>
	
									<div class="space-4"></div>
	
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-gplus">最后登录时间</label>
	
										<div class="col-sm-9">
											<label class="control-label"><b><fmt:formatDate  value="${user.lastLoginTime}" pattern="yyyy-MM-dd HH:mm:ss" /></b></label>
										</div>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div><!-- /.span -->
			</div><!-- /.user-profile -->
		</div>

		<!-- PAGE CONTENT ENDS -->
	</div><!-- /.col -->
</div><!-- /.row -->

<!--[if lte IE 8]>
  <script src="${_staticPath}/assets/js/excanvas.js"></script>
<![endif]-->
<script type="text/javascript">
	var scripts = [null,
		// UI
		"${_staticPath}/assets/js/jquery-ui.custom.js?v=" + Math.random(),
		// Form提交Json转换
		"${_staticPath}/custom/jquery.form.min.js?v=" + Math.random(),
		// 验证
		"${_staticPath}/custom/jquery.validate-2.0.min.js?v=" + Math.random(),
		// 验证定制
		"${_staticPath}/custom/jquery.validate-2.0.custom.min.js?v=" + Math.random(),
		"${_staticPath}/assets/js/jquery.gritter.js?v=" + Math.random(),
		"${_staticPath}/custom/assets/jquery.gritter.custom.js?v=" + Math.random(),
		null];
	$('.page-content-area').ace_ajax('loadScripts', scripts, function() {
		jQuery(function($) {
			
		});
	});
</script>
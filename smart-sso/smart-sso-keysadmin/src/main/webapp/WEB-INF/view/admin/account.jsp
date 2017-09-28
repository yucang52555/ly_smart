<%@ page language="java" pageEncoding="utf-8"%>

<jsp:include page="../common/common.jsp">
	<jsp:param name="title" value="应用"/>
</jsp:include>

<div class="page-header">
	<h1>
		用户列表
	</h1>
</div>

<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<div class="col-xs-12">
				<div class="widget-box">
					<div class="widget-header widget-header-small">
						<h5 class="widget-title lighter">搜索栏</h5>
					</div>

					<div class="widget-body">
						<div class="widget-main">
							<form id="_form" class="form-inline">
								<label>
									<label class="control-label" for="form-field-1"> 名称： </label>
									<input name="name" type="text" class="form-data input-medium search-data">
								</label>
								<!-- 
								<button id="_search" type="button" class="btn btn-info btn-sm">
									<i class="ace-icon fa fa-search bigger-110"></i>搜索
								</button>
								 -->
							</form>
						</div>
					</div>
				</div>

				<div>
					<div class="dataTables_wrapper form-inline no-footer">
						<table id="_table" class="table table-striped table-bordered table-hover dataTable no-footer">
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$('.page-content-area').ace_ajax('loadScripts', scripts, function() {
		jQuery(function($) {
			// 列表
    		var $table = $("#_table").table({
    			url : "${_path}/account/user/list",
    			formId : "_form",
				tools : [
					{text : '新增', clazz : 'btn-info', icon : 'fa fa-plus-circle blue', permission : '/account/user/edit', handler : function(){
						$.aceRedirect("${_path}/account/user/edit");
					}},
					{text : '禁用', clazz : 'btn-warning', icon : 'fa fa-lock orange', permission : '/account/user/enable', handler : function(){
						$table.ajaxEnable({url : "${_path}/account/user/enable"}, false);
					}},
					{text : '启用', clazz : 'btn-success', icon : 'fa fa-unlock green', permission : '/account/user/enable', handler : function(){
						$table.ajaxEnable({url : "${_path}/account/user/enable"}, true);
					}},
					{text : '删除', clazz : 'btn-danger', icon : 'fa fa-trash-o red', permission : '/account/user/delete', handler : function(){
						$table.ajaxDelete({
							confirm : "删除用户会影响相关账号密钥，确认要删除?", 
							url : "${_path}/account/user/delete"
						});
					}}
				],
				columns : [
			        {field:'id', hide : true},
			        {field:'isEnable', hide : true},
			        {field:'wechatNickname', title:'微信昵称', align:'left'},
			        {field:'wechatOpenId', title:'openId', align:'left', mobileHide : true},
			        {field:'createTime', title:'创建时间', mobileHide : true},
			        {field:'updateTime', title:'更新时间', mobileHide : true}
				],
				operate : [
					{text : '修改', clazz : 'blue', icon : 'fa fa-pencil', permission : '/account/user/edit', handler : function(d, i){
						$.aceRedirect("${_path}/account/user/edit?id=" + d.id);
					}},
					{text : '禁用', clazz : 'orange', icon : 'fa fa-lock', permission : '/account/user/enable', 
						handler : function(){
							$table.ajaxEnable({url : "${_path}/account/user/enable"}, false);
						},
						show : function(d){
							return d.isEnable;
						}
					},
					{text : '启用', clazz : 'green', icon : 'fa fa-unlock', permission : '/account/user/enable', 
						handler : function(){
							$table.ajaxEnable({url : "${_path}/account/user/enable"}, true);
						},
						show : function(d){
							return !d.isEnable;
						}
					},
					{text : '删除', clazz : 'red', icon : 'fa fa-trash-o', permission : '/account/user/delete', handler : function(d, i){
						$table.ajaxDelete({
							confirm : "删除用户会影响相关账号密钥，确认要删除?", 
							url : "${_path}/account/user/delete"
						});
					}}
				],
				after : function(){
					// 权限处理
					$.permission();
				}
			});
			
			/**
    		// 搜索
			$("#_search").click(function () {
           		$table.search();
           	});
           	
           	// 回车绑定
			$(".form-data").bind('keypress',function(event){
                if(event.keyCode == "13"){
                	event.preventDefault();
                	$table.search();
                }
            });
			*/
			
    		//搜索
			$(".search-data").keyup(function () { 
				$table.search();
			});
		});
	});
</script>

<%@ page language="java" pageEncoding="utf-8"%>

<jsp:include page="../common/common.jsp">
	<jsp:param name="title" value="产品"/>
</jsp:include>

<div class="page-header">
	<h1>
		产品列表
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
    			url : "${_path}/admin/product/list",
    			formId : "_form",
				tools : [
					{text : '新增', clazz : 'btn-info', icon : 'fa fa-plus-circle blue', permission : '/admin/product/edit', handler : function(){
						$.aceRedirect("${_path}/admin/product/edit");
					}},
					{text : '删除', clazz : 'btn-danger', icon : 'fa fa-trash-o red', permission : '/admin/product/delete', handler : function(){
						$table.ajaxDelete({
							confirm : "确认要删除产品吗?", 
							url : "${_path}/admin/product/delete"
						});
					}}
				],
				columns : [
			        {field:'id', hide : true},
			        {field:'productName', title:'产品名称', align:'left'},
			        {field:'productCode', title:'产品编码', align:'left'},
			        {field:'productStatus', title:'产品状态', align:'left'},
			        /* {field:'isEnableStr', title:'是否启用', replace : function (d){
				        if(d.isEnable)
				        	return "<span class='label label-sm label-success'>" + d.isEnableStr + 	"</span>";
			        	else
			        		return "<span class='label label-sm label-warning'>" + d.isEnableStr + "</span>";
			        }}, */
			        {field:'productType', title:'产品类型', align:'left'},
			        {field:'sort', title:'排序', mobileHide : true},
			        {field:'salesPrice', title:'销售价格', align:'left', mobileHide : true},
			        {field:'purchasePrice', title:'进货价格', align:'left', mobileHide : true},
			        {field:'homePage', title:'主页链接', align:'left', mobileHide : true},
			        {field:'productDesc', title:'产品描述', align:'left', mobileHide : true},
			        {field:'createTime', title:'创建时间', mobileHide : true}
				],
				operate : [
					{text : '修改', clazz : 'blue', icon : 'fa fa-pencil', permission : '/admin/product/edit', handler : function(d, i){
						$.aceRedirect("${_path}/admin/product/edit?id=" + d.id);
					}},
					{text : '删除', clazz : 'red', icon : 'fa fa-trash-o', permission : '/admin/product/delete', handler : function(d, i){
						$table.ajaxDelete({
							confirm : "删除应用会影响关联的管理员、角色、权限，确认要删除?", 
							url : "${_path}/admin/app/delete"
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

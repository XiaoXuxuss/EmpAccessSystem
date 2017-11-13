$(function(){
	 $("#wu-tabs").tabs({
		 onAdd:function(title,index){
			//alert(title+"/"+index)
			var tabs = $("#wu-tabs").tabs('tabs');
			for(var i=0;i<tabs.length;i++){
				if(i!=index){
					$("#wu-tabs").tabs('close',i)
				}
			}
		 }
	 })
});


$(function(){
	$('.wu-side-tree a').bind("click",function(){
		var title = $(this).text();
		var url = $(this).attr('data-link');
		var iconCls = $(this).attr('data-icon');
		var iframe = $(this).attr('iframe')==1?true:false;
		addTab(title,url,iconCls,iframe);
	});	
})

/**
* Name 载入树形菜单 
*/
/*$('#wu-side-tree').tree({
	url:'temp/menu.php',
	cache:false,
	onClick:function(node){
		var url = node.attributes['url'];
		if(url==null || url == ""){
			return false;
		}
		else{
			addTab(node.text, url, '', node.attributes['iframe']);
		}
	}
});*/

/**
* Name 选项卡初始化
*/
$('#wu-tabs').tabs({
	tools:[{
		iconCls:'icon-reload',
		border:false,
		handler:function(){
			$('#wu-datagrid').datagrid('reload');
		}
	}]
});
	
/**
* Name 添加菜单选项
* Param title 名称
* Param href 链接
* Param iconCls 图标样式
* Param iframe 链接跳转方式（true为iframe，false为href）
*/	
function addTab(title, href, iconCls, iframe){
	var tabPanel = $('#wu-tabs');
	if(!tabPanel.tabs('exists',title)){
		var content = '<iframe scrolling="auto" frameborder="0"  src="'+ href +'" style="width:100%;height:100%;"></iframe>';
		if(iframe){
			tabPanel.tabs('add',{
				title:title,
				content:content,
				iconCls:iconCls,
				fit:true,
				cls:'pd3',
				closable:true
			});
		}
		else{
			tabPanel.tabs('add',{
				title:title,
				href:href,
				iconCls:iconCls,
				fit:true,
				cls:'pd3',
				closable:true
			});
		}
	}
	else
	{
		tabPanel.tabs('select',title);
	}
}
/**
* Name 移除菜单选项
*/
function removeTab(){
	var tabPanel = $('#wu-tabs');
	var tab = tabPanel.tabs('getSelected');
	if (tab){
		var index = tabPanel.tabs('getTabIndex', tab);
		tabPanel.tabs('close', index);
	}
}
$(function(){
	$('#search-ptypeID-input').combobox({
		onSelect: function(record){
			$.post(
				'loadProduct.action',
				getFormJson($('#wu-form-1')),
				function(data){
					$('#search-proName-input').combobox('clear')
					$('#search-proName-input').combobox('loadData',data)
				},
				'json'
			);
		}
	});
	$('#search-vender-input').combobox({
		onSelect: function(record){
			$.post(
				'loadProduct.action',
				getFormJson($('#wu-form-1')),
				function(data){
					$('#search-proName-input').combobox('clear')
					$('#search-proName-input').combobox('loadData',data)
				},
				'json'
			);
		}
	});
	$('#search-presc-input').combobox({
		onSelect: function(record){
			$.post(
				'loadProduct.action',
				getFormJson($('#wu-form-1')),
				function(data){
					$('#search-proName-input').combobox('clear')
					$('#search-proName-input').combobox('loadData',data)
				},
				'json'
			);
		}
	});
})
$(function(){
	if($('#span-roleid').text()!='')
		if($('#span-roleid').text()!='1'){
			$("#menu-main").accordion('remove','系统管理');
		}
});


function getFormJson(form) {
	var o = {};
	var a = $(form).serializeArray();
	$.each(a, function () {
		if (o[this.name] !== undefined) {
			if (!o[this.name].push) {
				o[this.name] = [o[this.name]];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
}









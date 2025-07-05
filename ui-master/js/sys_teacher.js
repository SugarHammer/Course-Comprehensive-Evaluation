$(function(){
	layui.use('table', function(){
	    var table = layui.table;
	    table.render({
	        elem: '#test'
	        ,url:'http://127.0.0.1:8080/teacher/findAll'
	        ,cols: [[
	            {field:'teacherid', width:100, title: 'ID', sort: true}
	            ,{field:'teacherno', width:80, title: '教师编号'}
	            ,{field:'teachername', width:80, title: '姓名', sort: true}
	            /* ,{field:'is_delete', width:80, title: '是否删除'} */
	           
	        ]]
	        ,page:false
	    });
	});
	
	
	$("#teacherSave").click(function(){
		
	
		 /* var teacherid=$("#teacherid").val(); */
		var teacherno=$("#teecherno").val();
		
		var teachername=$("#theachername").val();
		var is_delete=$("#teacherDelete").val();
		
		 var data ={
				"teacherno":teacherno,"teachername":teachername,"isDelete":is_delete
			}
		$.ajax({
			  type:"post",
			dateType:"json",
			contentType: "application/json;charset=utf-8",
			url:"http://127.0.0.1:8080/teacher/save",
			data:JSON.stringify(data),
			success:function(msg){
				alert(msg.data);
			
				var teacherno=$("#teecherno").val("");
				
				var teachername=$("#theachername").val("");
				var is_delete=$("#teacherDelete").val("");
			},
			error:function(){
				alert("添加老师失败");
			}
		})
		
	})
	
	
		
	$("#close").click(function(){
		
			layui.use('table', function(){
		    var table = layui.table;
		    table.render({
		        elem: '#test'
		        ,url:'http://127.0.0.1:8080/teacher/findAll'
		        ,cols: [[
		            {field:'teacherid', width:100, title: 'ID', sort: true}
		            ,{field:'teacherno', width:80, title: '教师编号'}
		            ,{field:'teachername', width:80, title: '姓名', sort: true}
		            /* ,{field:'is_delete', width:80, title: '是否删除'} */
		           
		        ]]
		        ,page:true
		    });
		});
		
	})
})
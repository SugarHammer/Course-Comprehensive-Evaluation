$(function(){
	/* $.ajax({
		type:"post",
		 url:"http://127.0.0.1:8080/student/findAll",
		   dataType: 'json',
		   contentType: "application/json;charset=utf-8",
		   success:function(msg){
			   if(msg.code==200){
				   alert("学生")
				   
				   
			   }
			   
		   }
		
	}) */
	/* 
	 layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#test'
            ,url:'http://127.0.0.1:8080/student/findAll'
            ,cols: [[
                {field:'studentid', width:100, title: 'ID', sort: true}
                ,{field:'studentno', width:80, title: '学号'}
                ,{field:'studentname', width:80, title: '姓名', sort: true}
                ,{field:'clazzid', width:80, title: '班级'}
               
            ]]
            ,page:true
        });
    }); */
	
	
	
	 /* layui.use('table', function(){
	    var table = layui.table;
	    table.render({
	        elem: '#teacher'
	        ,url:'http://127.0.0.1:8080/student/findAll'
	        ,cols: [[
	            {field:'studentid', width:100, title: 'ID', sort: true}
	            ,{field:'studentno', width:80, title: '学号'}
	            ,{field:'studentname', width:80, title: '姓名', sort: true}
	            ,{field:'clazzid', width:80, title: '班级'}
	            ,{field:'sign', title: '签名', minWidth: 150}
	            ,{field:'experience', width:80, title: '积分', sort: true}
	            ,{field:'score', width:80, title: '评分', sort: true}
	            ,{field:'classify', width:80, title: '职业'}
	            ,{field:'wealth', width:135, title: '财富', sort: true}
	        ]]
	        ,page:false
	    });
	}); */
	
	
	$("#studentSave").click(function(){
		var studentno=$("#studentno").val();
		var studentname=$("#studentname").val();
		
		/* var clazzid=$("#studentclass").val(); */
		var isDelete=$("#studentdelete").val();
		var data={
			'studentno':studentno,
			'studentname':studentname,
			
			'isDelete':isDelete
		};
		
		
		$.ajax({
			  type:"post",
			dateType:"json",
			contentType: "application/json;charset=utf-8",
			url:"http://127.0.0.1:8080/student/save",
			data:JSON.stringify(data),
			success:function(msg){
				alert("添加成功");
				 $("#studentno").val("");
				$("#studentname").val("");
				$("#studentdelete").val("");
			},
			error:function(){
				/* $("#studentno").val()="";
				$("#studentname").val()="";
				$("#studentdelete").val()=""; */
				alert("添加失败");
			}
		});
	}) 
	
	$("#studentSave1").click(function(){
		var studentno=$("#studentno1").val();
		var studentname=$("#studentname1").val();
		/* alert(studentno+studentname) */
		/* var clazzid=$("#studentclass").val(); */
		var isDelete=$("#studentdelete1").val();
		var data={
			'teacherno':studentno,
			'teachername':studentname,
			
			'isDelete':isDelete
		};
		$.ajax({
			  type:"post",
			dateType:"json",
			contentType: "application/json;charset=utf-8",
			url:"http://127.0.0.1:8080/teacher/save",
			data:JSON.stringify(data),
			success:function(msg){
				alert("添加成功");
				 $("#studentno1").val("");
				$("#studentname1").val("");
				$("#studentdelete1").val("");
			},
			error:function(){
				 $("#studentno1").val()="";
				$("#studentname1").val()="";
				$("#studentdelete1").val()=""; 
				alert("添加失败");
			}
		});
	}) 
	
	
})
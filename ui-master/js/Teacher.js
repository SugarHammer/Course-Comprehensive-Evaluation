$(function(){
	
var newscript = document.createElement('script');
newscript.setAttribute('type','text/javascript');
newscript.setAttribute('src','js/Global.js');
var head = document.getElementsByTagName('head')[0];
head.appendChild(newscript);


 	 var id=window.globalConfig.id;
	 var token=window.globalConfig.token;
 	 var ids2="";
	
/* alert(request.QueryString("name")); */
	if(window.localStorage["token"]!=null&&window.localStorage["token"]!=""){
		$.ajax({
			beforeSend: function(request) {
		         request.setRequestHeader("token", token);
		    },
			  type:"get",
			   url:"http://127.0.0.1:8080/user/index",
			   
			  contentType:  "application/x-www-form-urlencoded;charset=utf-8",
			   
			 data: {'id':id},
			 success:function(msg){
				 $(".tname").html(msg.data.teachername);
				console.log(msg.data.teachername);
					 if($("#demoAdmin").attr("src")==""||$("#demoAdmin").attr("src")==null){
							 $("#demoAdmin").attr("src","teacherIndex.html"+"?userid="+id+"&&userid2"+msg.data.teacherid+"&&token="+token);
				    ids2=msg.data.teacherid;
				} 
			 },
			 error:function(){
				 console.log("错误")
			 }
		})
		
	}
	
	$(".ta").click(function(){
		
		var _link=$(this).attr('_link');
	     /* alert(_link); */
		$("#demoAdmin").attr("src",_link+"?userid="+id+"&&userid2="+ids2+"&&token="+token);
	})
})
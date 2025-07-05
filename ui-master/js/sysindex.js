$(function(){
	

	
	var newscript = document.createElement('script');
	newscript.setAttribute('type','text/javascript');
	newscript.setAttribute('src','js/Global.js');
	var head = document.getElementsByTagName('head')[0];
	head.appendChild(newscript);
	
	
	 	 var id=window.globalConfig.id;
 	 

	$.ajax({
		  type:"get",
		   url:"http://127.0.0.1:8080/user/index",
		   
		  contentType:  "application/x-www-form-urlencoded;charset=utf-8",
		   
		 data: {'id':id},
		 success:function(msg){
			 $(".sname").html(msg.data);
			console.log(msg.data.teachername);
			
		 },
		 error:function(){
			 console.log("错误")
		 }
	})
	
	$(".sa").click(function(){
		
		var _link=$(this).attr('_link');
		$(this).attr('href',_link+"?userid="+id);
	})
})
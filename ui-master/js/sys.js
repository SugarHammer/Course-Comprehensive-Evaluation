$(function(){
	
/* var request = { 
QueryString : function(val) { 
var uri = window.location.search; 
var re = new RegExp("" +val+ "\=([^\&\?]*)", "ig"); 
return ((uri.match(re))?(uri.match(re)[0].substr(val.length+1)):null); 
}
};
   var id=request.QueryString("userid");
   
 	console.log(typeof(id)); */
	
	var newscript = document.createElement('script');
	newscript.setAttribute('type','text/javascript');
	newscript.setAttribute('src','js/Global.js');
	var head = document.getElementsByTagName('head')[0];
	head.appendChild(newscript);
	
	
	 	 var id=window.globalConfig.id;
 	 
/* alert(request.QueryString("name")); */
if(window.localStorage["token"]!=null&&window.localStorage["token"]!=""){
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
	
	
	 /* var src=$("#demoAdmin").attr("src"); */
	
		 if($("#demoAdmin").attr("src")==""||$("#demoAdmin").attr("src")==null){
			 $("#demoAdmin").attr("src","sysindex.html"+"?userid="+id);
		 } 
	 
	  $(".sa").click(function(){
	 	
	 	var _link=$(this).attr('_link');
		alert(_link);
	 	$("#demoAdmin").attr("src",_link+"?userid="+id);
	 })
	
}

	
})
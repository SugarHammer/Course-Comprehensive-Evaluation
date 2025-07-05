$(function(){
	var ids=""
	var ids2=""
	var ids3=""
		if(ids==""){
			var request = { 
			QueryString : function(val) { 
			var uri = window.location.search; 
			var re = new RegExp("" +val+ "\=([^\&\?]*)", "ig"); 
			return ((uri.match(re))?(uri.match(re)[0].substr(val.length+1)):null); 
			}
			};
			ids=request.QueryString("userid");
			ids2=request.QueryString("userid2");
			ids3=request.QueryString("userid3");
			token=request.QueryString("token")
			
		}
		   
		   
			   
		    
		   window.globalConfig={'id':ids,'id2':ids2,'ids3':ids3,'token':token}
		console.log("df全局globle"+token); 
	
	
})
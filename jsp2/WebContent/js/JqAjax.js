var JqAjax = function(p_url,p_param,p_type,p_d_type){
		var callback;
		this.changeFunc = function(func){
			callback = func;
		}
		var ajaxParam = { 
     				type     : p_type ? p_type 		: "POST"
 	    	    ,   url      : p_url ? p_url 		: "list.board"
 	    	    ,   dataType : p_d_type ? p_d_type 	:"json" 
 	    	    ,   beforeSend: function(xhr) {
 	    	        xhr.setRequestHeader("Content-Type", "application/json");
 	    	    }
 	    	    ,   data     : p_param
 	    	    ,   success : function(result){
 	    	    	if(callback){
 	    	    		callback(result);
 	    	    	}else{
 	    	    		//TODO : 공통처리 필요
 	    	    		alert("아직 정의된 공통 처리 함수가 없습니다.");
 	    	    		return;
 	    	    	}
 				}
 				,   error : function(xhr, status, e) {
 						alert(xhr.responseText);
 				}
 				,   complete : function(e) {
 				}
		}
		this.send = function(){
			$.ajax(ajaxParam);
		}
	}
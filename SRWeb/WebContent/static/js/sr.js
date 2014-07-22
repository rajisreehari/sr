function vote(id, rate){
	try{
		var voteData = "id=" + id + "&rate=" + rate;
	    $.ajax({
	        type: 'GET',
	        contentType: 'text/plain',
	        url: 'http://localhost:8080/SRWeb/vote',
	        dataType: "text",
	        data: voteData,
	        success: 'Success',
	        error: 'Error'
	    });
	}catch(err){}
}

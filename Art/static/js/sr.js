function handleData(data) {
}

function vote(id, rate, ctx){
	var voteData = "id=" + id + "&rate=" + rate;
	try{
	    $.ajax({
	        type: 'GET',
	        contentType: 'text/plain',
	        url: ctx + '/vote',
	        dataType: "text",
	        data: voteData,
	        success: handleData,
	        error: 'Error'
	    });
	}catch(err){}
}
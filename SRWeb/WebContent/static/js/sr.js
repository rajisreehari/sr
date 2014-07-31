function handleData(data) {
	document.getElementById("rate_" + currentId).innerHTML = data;
}

function vote(id, rate){
	var voteData = "id=" + id + "&rate=" + rate;
	try{
	    $.ajax({
	        type: 'GET',
	        contentType: 'text/plain',
	        url: '/w/vote',
	        dataType: "text",
	        data: voteData,
	        success: handleData,
	        error: 'Error'
	    });
	}catch(err){}
}

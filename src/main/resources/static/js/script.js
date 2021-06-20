$(document).ready(function(){

	var input_filter = $("#dataTable_filter input.form-control");

	input_filter.on("focus", function(){
		$("tfoot tr th").hide();
	});

	input_filter.on("blur", function(){
		$("tfoot tr th").show();
	});

});




	

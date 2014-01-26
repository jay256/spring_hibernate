$(function()	{
	$("#add-employee-btn").click(function() {
		$("#selected-emps").empty();			//clear the contents
		$('.check-box input[type="checkbox"]').each(function()	{
			if($(this).is(':checked'))	{
				$("#selected-emps").append(
						$(this).parent().parent().html()
				);
				$("#selected-emps label:last").remove();		// remove the checkbox
			}
		});
	});
});
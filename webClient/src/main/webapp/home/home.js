/*********************************************************************
 *                                                                   *
 *                      javascripts Utils Home                       *
 *                                                                   *
 ********************************************************************/


function addValidationNewUserForm() {
	
	$('#newUserForm').submit(
			function() {
				var msg = "";
				var dateFormat = $('#dateFromat').html();
				
				/* Requiered validation */
				msg += isRequeired('#newUserForm_userName','#errorUserName',count);
				msg += isRequeired('#newUserForm_userNick','#errorUserNick',count);
				msg += isRequeired('#newUserForm_userEmail','#errorUserEmail',count);
				msg += isRequeired('#newUserForm_userPassword','#errorUserPassword',count);
				var count = $(msg).length; 
				
				if (count > 0){
					if (count > 1){
						msg = $('#validatorErrors').html() + "<br/> <ul>" + msg + "</ul>";
					} else {
						msg = $('#oneValidatorError').html() + "<br/> <ul>" + msg + "</ul>";
					}
					
				}
				
				/** Format validation */
				msg += isDateFormat('#newUserForm_userBirthDate', '#errorUserBirthDate', '#validatorFormatDate', dateFormat );
				msg += isEmailFormat('#newUserForm_userEmail', '#errorUserEmail','#validatorFormatEmail');
				
				if (msg != ""){
					validationError(msg);
					return false;
				}
				
				ajaxSubmit($('#newUserForm'), 
				          function(html){
					        if ($("<div>").html(html).find("#messageError").length == 0){
					         	$("#templatemo_content_bot").html(html)
					        } else {
					        	validationError(html)
					        }
				          }		
				);
				
				return false;
			}
	);
	
	
	$('#loginUserForm').submit(
			function() {
				var msg = "";
				var dateFormat = $('#dateFromat').html();
				
				/* Requiered validation */
				msg += isRequeired('#loginUserForm_userName','#errorUserName',count);
				msg += isRequeired('#loginUserForm_userPassword','#errorUserPassword',count);
				var count = $(msg).length; 
				
				if (count > 0){
					if (count > 1){
						msg = $('#validatorErrors').html() + "<br/> <ul>" + msg + "</ul>";
					} else {
						msg = $('#oneValidatorError').html() + "<br/> <ul>" + msg + "</ul>";
					}
					
				}
							
				if (msg != ""){
					validationError(msg);
					return false;
				}
				
				ajaxSubmit($('#loginUserForm'), 
				          function(html){
					        if ($("<div>").html(html).find("#messageError").length == 0){
					        	document.write(html);
					        	$("#logout").button().click(function () {
									document.location.href = '$logoutURL';
								});
					        } else {
					        	validationError(html);
					        }
				          }		
				);
				
				return false;
			}
	);
	
	var dateFormat = $('#dateFromat').html();
	var datePickerSetting= {'defaultDate': -6480, 'dateFormat':dateFormat };
	$("#newUserForm_userBirthDate").datepicker(datePickerSetting);

}
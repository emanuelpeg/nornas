/*********************************************************************
 *                                                                   *
 *                           javascripts Utils                       *
 *                                                                   *
 ********************************************************************/

function validationError(msg) {
	
	$("<div title='Error'> " +
			"<img src='../csss/images/Button_Close-01.png' alt='Error' class='icon_big' />" +
			" <div class='error_div'> "+
			msg +" </div> </div>").dialog({ 
		modal:true,
		buttons: {
			"Ok": function() {
				  		$(this).dialog('close');
	              }
		},
		show: "blind",
		hide: "explode",
		resizable: false
	});
	
}

function warning(msg) {
	
	$("<div title='Warning'> " +
			"<img src='../csss/images/Button_Warning-01.png' alt='Error' class='icon_big' />" +
			" <div class='error_div'> "+
			msg +" </div> </div>").dialog({ 
		modal:true,
		buttons: {
			"Ok": function() {
				  		$(this).dialog('close');
	              }
		},
		show: "blind",
		hide: "explode",
		resizable: false
	});
	
}

function getData(form) {
	var data = form.serialize();
	data +=  "&" + form.find("*[type=submit]").attr("name") + "=" + form.find("*[type=submit]").val();
	return data;
}

function ajaxSubmit(form, successFunction, errorFunction) {
	$.ajax({ url: form.attr("action"),
			type: form.attr("method"),
			data: getData(form),
			success: successFunction,
			error: errorFunction });
}

var dtCh= "/";
var minYear=1900;
var maxYear=2100;

function isInteger(s){
	var i;
    for (i = 0; i < s.length; i++){   
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}

function stripCharsInBag(s, bag){
	var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++){   
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function daysInFebruary (year){
	// February has 29 days in any year evenly divisible by four,
    // EXCEPT for centurial years which are not also divisible by 400.
    return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}

function DaysArray(n) {
	for (var i = 1; i <= n; i++) {
		this[i] = 31
		if (i==4 || i==6 || i==9 || i==11) {this[i] = 30}
		if (i==2) {this[i] = 29}
   } 
   return this
}

function isDate(dtStr){
	var daysInMonth = DaysArray(12)
	var pos1=dtStr.indexOf(dtCh)
	var pos2=dtStr.indexOf(dtCh,pos1+1)
	var strMonth=dtStr.substring(0,pos1)
	var strDay=dtStr.substring(pos1+1,pos2)
	var strYear=dtStr.substring(pos2+1)
	strYr=strYear
	if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
	if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
	for (var i = 1; i <= 3; i++) {
		if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
	}
	month=parseInt(strMonth)
	day=parseInt(strDay)
	year=parseInt(strYr)
	if (pos1==-1 || pos2==-1){
		return false
	}
	if (strMonth.length<1 || month<1 || month>12){
		return false
	}
	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
		return false
	}
	if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
		return false
	}
	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
		return false
	}
return true
}


function isEmail(str) {

		var at="@"
		var dot="."
		var lat=str.indexOf(at)
		var lstr=str.length
		var ldot=str.indexOf(dot)
		if (str.indexOf(at)==-1){
		   return false
		}

		if (str.indexOf(at)==-1 || str.indexOf(at)==0 || str.indexOf(at)==lstr){
		   return false
		}

		if (str.indexOf(dot)==-1 || str.indexOf(dot)==0 || str.indexOf(dot)==lstr){
		    return false
		}

		 if (str.indexOf(at,(lat+1))!=-1){
		    return false
		 }

		 if (str.substring(lat-1,lat)==dot || str.substring(lat+1,lat+2)==dot){
		    return false
		 }

		 if (str.indexOf(dot,(lat+2))==-1){
		    return false
		 }
		
		 if (str.indexOf(" ")!=-1){
		    return false
		 }

 		 return true					
}


function isRequeired(id, idMsgError, count) {
	if ($(id).val() == "") {
		return "<li>" + $(idMsgError).html() + "</li>";
	}
	return "";
}


function isDateFormat(id, idMsgError, idValidatorMsgError, dateFormat) {
	if ($(id).val() != "") {
		if (!isDate($(id).val())) {
			return $(idMsgError).html() + $(idValidatorMsgError).html() + ' (' + dateFormat + ') <br/>';
		}
	}
	return "";
}

function isEmailFormat(id, idMsgError, idValidatorMsgError) {
	if ($(id).val() != "") {
		if (!isEmail($(id).val())) {
			return $(idMsgError).html() + $(idValidatorMsgError).html();
		}
	}
	return "";
}


/******************************************************************
VALIDATOR
******************************************************************/
var Validate = {
	init: function(value, nodeName){
	    this.scrollTopVal = value;
	    
	    if(typeof (nodeName) == 'undefined'){
	    	nodeName = "errMsgList";
	    }
		this.resetList(nodeName);
		if($('form1:messages1') != null){
			$('form1:messages1').style.display = 'none';
		}
	},
	messages: [],
	divNames: [],
	scrollTopVal: 0,
	field: function(fieldId, fieldName, divName){
		if ($(fieldId).value == "") {
			this.addMsg('&raquo; The ' + fieldName + ' field cannot be empty');
			this.addErrorCssToDiv(divName);
		} 
	},
	andOrFields: function(data1, data2, msg){
		if ($(data1.field).value == "" && $(data2.field).value == "") {
			this.addMsg('&raquo; ' + msg);	
			this.addErrorCssToDiv(data1.divName);
			this.addErrorCssToDiv(data2.divName);
		} 
	},
	dateFields: function(field1, field2, field3, fieldName, divName){
		if ($(field1).value == "" ||$(field2).value == "" || $(field3).value == "") {
			this.addMsg('&raquo; All of the ' + fieldName +  ' fields must be entered');
			this.addErrorCssToDiv(divName);
		} else if (isNaN($(field1).value) || isNaN($(field2).value) || isNaN($(field3).value)) {
			this.addMsg('&raquo; All of the ' + fieldName + ' fields must be numeric');
			this.addErrorCssToDiv(divName);
		}
		
	},
	/* Validates that a group of checkboxes has at least one item checked. It takes two required  args.  The id of the container that wraps the checkboxes, and the message to display if none of them are checked.  */
	chkBoxGrp: function(containerId, msg){
		var grpContainer = $(containerId);
		var elementsInputs = grpContainer.getElementsByTagName("input");
		var flag = true;
		for (var i = 0; i < elementsInputs.length; i++){
			var obj = elementsInputs[i];
			if(obj.checked == true){
				flag = false;
				break;
			}
		}
		
		if(flag) {
			this.addMsg(msg);
		}
		
	},
	fieldsAndMatch: function(fieldOne, fieldTwo, noMatchMsg, minLenghtCheck){
		var field1Flag = false;
		var field2Flag = false;
		if ($(fieldOne.name).value == "") {
			this.addMsg('&raquo; The ' + fieldOne.msg + ' field cannot be empty');
			this.addErrorCssToDiv(fieldOne.divName);
			field1Flag = true; }
		if ($(fieldTwo.name).value == "") {
			this.addMsg('&raquo; The ' + fieldTwo.msg + ' field cannot be empty');
			this.addErrorCssToDiv(fieldTwo.divName);
			field2Flag = true; }
		
		if(field1Flag == false  && field2Flag == false){
			if($(fieldOne.name).value !== $(fieldTwo.name).value){
				this.addMsg('&raquo; ' + noMatchMsg);
				this.addErrorCssToDiv(fieldOne.divName);
				this.addErrorCssToDiv(fieldTwo.divName);
			} else if (minLenghtCheck.flag == true){
				if($(fieldOne.name).value.length < minLenghtCheck.value){
					this.addMsg('&raquo; ' + "Your " + fieldOne.msg + " must be at least " + minLenghtCheck.value + " characters long.");
					this.addErrorCssToDiv(fieldOne.divName);
					this.addErrorCssToDiv(fieldTwo.divName);
				}
			}
		}  
	},
	fieldAndMinLenght: function(field, minLenght){
		
		if ($(field.name).value == "") {
			this.addMsg('&raquo; The ' + field.msg + ' field cannot be empty');
			this.addErrorCssToDiv(field.divName);
		} else if ($(field.name).value.length < minLenght.minChars){
			this.addMsg('&raquo; ' + "Your " + field.msg + " must be at least " + minLenght.minChars + " characters long.");
			this.addErrorCssToDiv(field.divName);
			this.addErrorCssToDiv(field.divName);
		}
	},
	addMsg: function (_msg){	
		var error = {};
		error.message = _msg;
		this.messages.push(error);
	},
	addErrorCssToDiv: function(_div){
		$(_div).className += ' form-error';
		var divs = {};
		divs.name = _div;
		this.divNames.push(divs);
	},
	resetList: function (ulNodeName){
		if(this.messages.length > 0){
			
			if($('error-title') != null){
				$('error-title').style.display = 'none';
			}
			
			this.messages = [];
			var ullist = document.getElementById(ulNodeName);
			var lis = ullist.getElementsByTagName("li");
			var list_size = ullist.getElementsByTagName("li").length;
			for ( var i = list_size; i > 0; --i ){
			   var li = lis[i-1];
			   ullist.removeChild(li);
			}  

			dojo.forEach(this.divNames, function(div, i){
			  $(div.name).className = 'field-row input-field-row';
			});
		
		}
   
	},
	computeErrors: function (param){
			
		if(this.messages.length > 0){
			if($('error-title') != null){
				$('error-title').style.display = 'block';
			}
			
			var ulNodeName = '';
			if(typeof (param) == 'undefined'){
				ulNodeName = 'errMsgList';
			} else {
				ulNodeName = param;
			}
			
			this.createErrorNodes(ulNodeName);
			
			if(this.scrollTopVal != null){
				document.body.scrollTop = document.documentElement.scrollTop = this.scrollTopVal;
			}
			
			return false;
		} else {
			return true;
		}
	
	}, 
	createErrorNodes: function(obj){
		dojo.forEach(this.messages, function(item, i){
		    var new_element = document.createElement('li');
			new_element.innerHTML = item.message;
			$(obj).appendChild(new_element);
		});
	}

};



/***********************************************************
********** PAGE MANAGER
***********************************************************/
var producerNumber;
var produceSubNumber;
var producerName;
var urlProductCode='';
var PageMgr = {
	originalUserEmail : $('txtEmailAddress').value,
	init : function (){
		try {
			//get params from url
			var urlParams = dojo.queryToObject(window.location.search.substring(1));
			Utils.showMessageBox(CONSTANTS.PROCESSING_REQ);
			
			/**Go get the data for both modes  **/
			//1. for book of business
			var userType = $('txtUserType').value;
			console.log("userType ::::: "+userType);
			
			if(userType=='CHBEMP'){
				//if chubb employee...unhide search widget
				dojo.toggleClass('cb-emp-search', 'active');
				dojo.toggleClass('cb-emp-pas-search', 'active');
			} else {
				BookOfBusManager.getData(false);
			}

			//2. get data for 'Contacts by Products' values for Products and Branches dropdowns
			ContactsByProdMgr.getProducsAndBranches(urlParams.product);

			/*** url param options:
				product = {product-selected}
			 ***/
			//if a product param is passed
			if(urlParams.pc !== undefined && urlParams.pc !== ''){
				//process for contacts by book of business
				urlProductCode=urlParams.pc;
				dojo.toggleClass('contact-for-product-mod', 'active');
			}

			//OTHER PROCESS
			//initialize tooltip
			var isMobile = false;
			if ( Modernizr.mq('(max-width: 767px)') ) { //mobile
				isMobile = true;
			}
			if(isMobile){
				dojo.create("div", { id: "mobile-tooltip", className: "mobile-tooltip", innerHTML: "<span id='tool-tip-msg'></span>" + close_button }, dojo.body());
			}
			
			var tooltip_msg = "Please change the email address if you would prefer your details to be sent to another email address.</br>You will also have the option to update the email address in your profile.";
			dojo.query('#account_icon').forEach(function(node){
				console.log(node);
				if(isMobile){
					dojo.connect(node, 'onclick', function() {
						$('tool-tip-msg').innerHTML = tooltip_msg;
						dojo.toggleClass('mobile-tooltip', 'active');
					});
				} else {
					var bobTooltip = new Opentip(node, { style: "chubbStyle", showOn: "mouseover", hideTrigger: "trigger"});
					bobTooltip.setContent(tooltip_msg);
				}
			});
			
			var branch_tooltip_msg = "<div>For contacts in the USB-Underwriting Service Branch, select one of the following branch codes:</div><ul><li>SIMS NBS USB</li><li>SIM PAC ALLNCE</li><li>SIM PAC ALN NT</li><li>CSI SIMS SRC</li></ul><div>For contacts in the EUC-Eastern Underwriting Center, select one of the following branch codes:</div><ul><li>ESTRN UWC CE</li><li>ESTRN UWC X CE</li></ul><div>For contacts in the WUC-Western Underwriting Center, select one of the following branch codes:</div><ul><li>WSTRN UWC X CE</li><li>WSTRN UWC CE</li></ul>";
			dojo.query('#select_branch_tip_icon').forEach(function(node){
				console.log(node);
				if(isMobile){
					dojo.connect(node, 'onclick', function() {
						$('tool-tip-msg').innerHTML = branch_tooltip_msg;
						dojo.toggleClass('mobile-tooltip', 'active');
					});
				} else {
					var bobTooltip = new Opentip(node, { style: "chubbStyle", showOn: "mouseover", hideTrigger: "trigger"});
					bobTooltip.setContent(branch_tooltip_msg);
				}
			});



		} catch (e){
			console.log(e);
		}
	},
	toggleMods : function(mod){
		if(mod === 'bob-mod'){
			dojo.toggleClass('contact-book-of-business-mod', 'active');
			dojo.removeClass('contact-for-product-mod', 'active');
		} else {
			dojo.removeClass('contact-book-of-business-mod', 'active');
			dojo.toggleClass('contact-for-product-mod', 'active');
		}
	},
	unhide : function(area) {
		dojo.addClass(area, 'active');
	},
	checkEmailChange : function(obj){
		if(obj){
			if(obj.value !== this.originalUserEmail){
				dojo.addClass("update-profile-query", "active");
			} else {
				dojo.removeClass("update-profile-query", "active");
			}
		}
	},
	processProducerSelection:function(producerNum,produceSubNum,index){
		resetBOB();
		var cellObj = document.getElementById("producersTable"+index).rows[0].cells;
		
		producerName=cellObj[1].innerHTML;
		
		var producerAndSubProducerNum=cellObj[2].innerHTML;
		var res = producerAndSubProducerNum.split("-");
		producerNum=res[0];
		produceSubNum=res[1];
			    
		producerNumber =producerNum.toString();
		produceSubNumber=produceSubNum.toString();
		
		//console.log("selected radio :: producerNum and produceSubNum ::::: "+producerNumber+" ::::: "+produceSubNumber+" ::::: "+producerName);
	}
};
/***********************************************************
********** CONTACTS BY BOOK OF BUSINESS SECTION MANAGER
***********************************************************/
var BookOfBusManager = {
	processEmpSearch : function(){
		var prodNumber = $('txtProducerNumber').value;
		var subProdNumber = $('txtSubProdNumber').value;
		var errorMsg="";
		var reg = /^\d+$/;
		 alert('processEmpSearch search........');
		//process validation here
		//console.log('Prod#: ' + prodNumber + ' Sub-Prod No: ' + subProdNumber);
		
		//Additional code has to be added here to call the getData method passing prod and sub prod numbers.
		if(prodNumber!=='' && prodNumber!== undefined ){
			if(!reg.test(prodNumber)){
				errorMsg="The producer number you entered is invalid. Please check the number and try again.";
			}
		}
		
		if(subProdNumber!=='' && subProdNumber!== undefined ){
			if(!reg.test(subProdNumber)){
				if(errorMsg!=''){
					errorMsg="The producer and subproducer number you entered is invalid. Please check the number and try again.";
				}else{
					errorMsg="The subproducer number you entered is invalid. Please check the number and try again.";
				}
			}
		}
		
		if(prodNumber!=='' && prodNumber!== undefined ){

			if(errorMsg!=''){
				dojo.byId("errorBox").innerHTML=errorMsg;
				return;
			}else{
				Utils.showMessageBox(CONSTANTS.PROCESSING_REQ);
				this.getData(true);
			}
		}else{
			console.log("The producer Number field cannot be empty.");
			dojo.byId("errorBox").innerHTML = "Please enter producer number.<BR>"+errorMsg;
		}
	},
	getData : function (cbEmp){
		var params = {};
		//reset selected produces and email message in every search 
		resetBOB();
		
		if(cbEmp){
			dojo.byId("errorBox").innerHTML="";
			var prodNumber = $('txtProducerNumber').value;
			var subProdNumber = $('txtSubProdNumber').value;
			
			params.producerNumber=prodNumber;
			params.producerSubNumber=subProdNumber;
			
			//console.log('params  Prod#: ' + params.producerNumber + ' Sub-Prod No: ' + params.producerSubNumber);
		}
		
		dojo.xhrPost({
			url: "jaxrs/commercial/producers",
			preventCache : true,
			headers: { "Content-Type": "application/json; charset=utf-8"},
			postData: dojo.toJson(params),
			handleAs: "json",
			load: function(data) {
				var _producerList = data.producerList;
				var _result=data.result;
				
				if(_result.statusCode=='E'){
					//dojo.byId("errorBox").innerHTML = _result.statusMessage;
					dojo.byId("errorBox").innerHTML = "Failed to retrieve the producers list based on search.";
				}else{
					if(_producerList.length > 0){
						new CBgrid (_producerList, producerGridMapper, "producers-grid");
					}
				}
				
				if(cbEmp){
					dojo.addClass("cb-emp-search", "active");
				}else{
					dojo.addClass("non-chubb-emp-msg", "active");
				}
				dojo.addClass('book-of-bus-data', 'active');
				
				var emailAddress = data.emailAddress;
				if(emailAddress != null && emailAddress != undefined){
					$('txtEmailAddress').value = emailAddress;
				}
				
				Utils.hideMessageBox();
			},
			error : function (error){
				Utils.hideMessageBox();
				console.log(error);
				//$('lc-ajax-loader').innerHTML = "We're sorry, but an error has occurred.";
			}
		});
	}
	
};


/***********************************************
 * *********************************PAS search 
 */
var BookOfBusManager1 = {
		processPASSearch : function(){
			var paasNumber = $('txtPasNumber').value;
			/*var subPaasNumber = $('txtSubPasNumber').value;*/
			var errorMsg="";
			var reg = /^\d+$/;
			var pasvalidation = /^[a-zA-Z0-9]|\d+$/;
			//process validation here
			//console.log('Prod#: ' + prodNumber + ' Sub-Prod No: ' + subProdNumber);
			
			//Additional code has to be added here to call the getData method passing prod and sub prod numbers.
			if(paasNumber!=='' && paasNumber!== undefined ){
				if(!pasvalidation.test(paasNumber)){
					errorMsg="The producer number you entered is invalid. Please check the number and try again.";
				}
			}
			
			/*if(subPaasNumber!=='' && subPaasNumber!== undefined ){
				if(!reg.test(subPaasNumber)){
					if(errorMsg!=''){
						errorMsg="The pas you entered is invalid. Please check the number and try again.";
					}else{
						errorMsg="The subpas number you entered is invalid. Please check the number and try again.";
					}
				}
			}*/
			
			if(paasNumber!=='' && paasNumber!== undefined ){

				if(errorMsg!=''){
					dojo.byId("errorBox").innerHTML=errorMsg;
					return;
				}else{
					Utils.showMessageBox(CONSTANTS.PROCESSING_REQ);
					this.getData(true);
				}
			}else{
				console.log("The pas Number field cannot be empty.");
				dojo.byId("errorBox").innerHTML = "Please enter pas number.<BR>"+errorMsg;
			}
		},
		getData : function (cbEmp){
			var params = {};
			//reset selected produces and email message in every search 
			resetBOB();
			
			if(cbEmp){
				dojo.byId("errorBox").innerHTML="";
				var paasNumber = $('txtPasNumber').value;
				/*var subPaasNumber = $('txtSubPasNumber').value;*/
				
				params.pasNumber=paasNumber;
				/*params.pasSubNumber=subPaasNumber;*/
				
				//console.log('params  Prod#: ' + params.producerNumber + ' Sub-Prod No: ' + params.producerSubNumber);
			}
			
			dojo.xhrPost({
				url: "jaxrs/commercial/pas",
				preventCache : true,
				headers: { "Content-Type": "application/json; charset=utf-8"},
				postData: dojo.toJson(params),
				handleAs: "json",
				load: function(data) {
					var _producerList = data.producerList;
					var _result=data.result;
					
					if(_result.statusCode=='E'){
						//dojo.byId("errorBox").innerHTML = _result.statusMessage;
						dojo.byId("errorBox").innerHTML = "Failed to retrieve the producers list based on search.";
					}else{
						if(_producerList.length > 0){
							alert('::::::::'+_producerList.length);
							new CBgrid (_producerList, pasGridMapper, "pas-grid");
						}
					}
					
					if(cbEmp){
						dojo.addClass("cb-emp-pas-search", "active");
					}else{
						dojo.addClass("non-chubb-emp-msg", "active");
					}
					alert('----end------------>');
					dojo.addClass('book-of-bus-PAS-data', 'active');
					
					var emailAddress = data.emailAddress;
					if(emailAddress != null && emailAddress != undefined){
						$('txtEmailAddress').value = emailAddress;
					}
					
					Utils.hideMessageBox();
				},
				error : function (error){
					Utils.hideMessageBox();
					console.log(error);
					//$('lc-ajax-loader').innerHTML = "We're sorry, but an error has occurred.";
				}
			});
		}
		
	};
/*******************************************************************
 * PAS search End
 ************************************************/
/***********************************************************
********** CONTACTS BY PRODUCTS SECTION MANAGER
***********************************************************/
var ContactsByProdMgr = {
		getProducsAndBranches : function (product){
			console.log('getting products and branches from rest service');
			//IF URL CONTAINTS A PRODUCT, UPDATE THE VALUE OF THE APPROPRIATE DROPDOWN
			var _displayProduct;
			if(product!= null){
				_displayProduct = product;
				console.log(product);
			}
			else{
				_displayProduct = "Select a Product";
				console.log('no product was passed in the url');
			}

			//Make REST calls to get the Products and Branches.
			//if a product is passed..default the dropdown to that value
			//populate product list
			dojo.xhrGet({
				url: "jaxrs/commercial/products",
				preventCache : true,
				headers: { "Content-Type": "application/json; charset=utf-8"},
				handleAs: "json",
				load: function(data) {
					var _productList = data.productList;
					var _result=data.result;

					if(_result.statusCode=='E'){
						//dojo.byId("errorBox").innerHTML = _result.statusMessage;
						dojo.byId("errorBox").innerHTML = "Failed to load the products.";
					}

					dojo.place( 
							"<option value="+ "/" /"" + ">" + _displayProduct
							+ "</option>", "select-product");

					if (_productList != null){
						dojo.forEach(_productList, function(obj, i){
							dojo.place( 
									"<option id=\"" + obj.productCode + "\" value=\""
									+ obj.productCode + "\">" + obj.productName
									+ "</option>", "select-product");
						});
						if(urlProductCode!=''){
							document.getElementById("select-product").value=urlProductCode;
						}
					}
				},
				error : function (error){
					console.log(error);
					//$('lc-ajax-loader').innerHTML = "We're sorry, but an error has occurred.";
				}
			});
			//populate branch list
			dojo.xhrGet({
				url: "jaxrs/commercial/branches",
				preventCache : true,
				headers: { "Content-Type": "application/json; charset=utf-8"},
				//postData: dojo.toJson(params),
				handleAs: "json",
				load: function(data) {
					var _branchListList = data.branchList;
					var _result=data.result;

					if(_result.statusCode=='E'){
						//dojo.byId("errorBox").innerHTML = _result.statusMessage;
						dojo.byId("errorBox").innerHTML = "Failed to load the branchs.";
					}

					dojo.place( 
							"<option value="+ "/" /"" + ">" + "Select a Branch"
							+ "</option>", "select-branch");

					if (_branchListList != null){
						dojo.forEach(_branchListList, function(obj, i){

							dojo.place( 
									"<option id=\"" + obj.branchCode + "\" value=\""
									+ obj.branchCode + "\">" + obj.branchName
									+ "</option>", "select-branch");
						});
					}
					Utils.hideMessageBox();
				},
				error : function (error){
					console.log(error);
					//$('lc-ajax-loader').innerHTML = "We're sorry, but an error has occurred.";
				}
			});
		},
		branchNameSelected : null,
		productNameSelected : null,
		setProductName : function (productName){
			this.productNameSelected = productName;
		},
		setBranchName : function (branchName){
			this.branchNameSelected = branchName;
		},
		getContacts : function(){
			//console.log('getting contacts data');
				
			//reset section state to original in case there's a new search
			dojo.removeClass('products-contacts-message-container', 'active');
			dojo.removeClass('products-contacts-results', 'active');
			
			dojo.byId("errorBox").innerHTML="";
			var selectedProduct = $('select-product').value;
			var selectedBranch = $('select-branch').value;
			
			//Analytics
			try{
				//for analytics
				var param = "ev=Contact by Product Search&productName=" + encodeURIComponent(this.productNameSelected) + "&branchName=" + encodeURIComponent(this.branchNameSelected);
				console.log(param);  
				ntptEventTag(param);
			}catch(e){
				console.log(e);
			}
			
			//process validation
			var params = {};
			if(selectedBranch!=="NaN"){
				params.branchCode = selectedBranch;
			}else{
				dojo.byId("errorBox").innerHTML = "Please select a branch.";
				return;
			}
			if(selectedProduct!=="NaN"){
				params.productCode = selectedProduct;
			}
			
			Utils.showMessageBox(CONSTANTS.PROCESSING_REQ);
			//make rest call to get cotacts info
			dojo.xhrPost({
				//url : "test-data/defaultContact.json",
				url: "jaxrs/commercial/defaultContacts",
				preventCache : true,
				headers: { "Content-Type": "application/json; charset=utf-8"},
				postData: dojo.toJson(params),
				handleAs: "json",
				load: function(data) {
					var _result=data.result;
					var _contactList=data.contactList;

					if(_result.statusCode=='E'){
						//dojo.byId("errorBox").innerHTML = _result.statusMessage;
						dojo.byId("errorBox").innerHTML = "Failed to retrieve the defaultContacts list by product.";
					}
					

					if(_contactList != null && _contactList.length > 0){
						new CBgrid (_contactList, contactsGridMapper, "contacts-grid");	 
						
						var prodSel = document.getElementById("select-product");
						var selProdStr = prodSel.options[prodSel.selectedIndex].text;
						
						var branchSel = document.getElementById("select-branch");
						var selBranchStr = branchSel.options[branchSel.selectedIndex].text;
						
						if(selProdStr=='Select a Product'){
							dojo.byId("selected-branch").innerHTML= 'Chubb contacts results for Branch '+ '"'+selBranchStr +'"';
							dojo.byId("selected-product").innerHTML="";
						}else{
							dojo.byId("selected-product").innerHTML= 'Chubb contacts results for product '+ '"'+selProdStr +'"';
							dojo.byId("selected-branch").innerHTML= ' and Branch '+ '"'+selBranchStr +'"';
						}
						
						dojo.addClass('products-contacts-results', 'active');
					} else {
						dojo.addClass('products-contacts-message-container', 'active');
					}

					Utils.hideMessageBox();
				},
				error : function (error){
					Utils.hideMessageBox();
					console.log(error);
					//$('lc-ajax-loader').innerHTML = "We're sorry, but an error has occurred.";
				}
			});
		},
		emailBookOfBusiness :function(){
			var email = $('txtEmailAddress').value;
			var userId = $('txtUserId').value;
						
			dojo.byId("errorBox").innerHTML="";
			
			//make rest call to send email for Book of Business
			var params = {};
			var updProfileFlag = false;
			var updProfile = document.getElementById("update-profile").value;
			
			//Tulio 12/3/15 not a requirement as per Rebecca Gough
			//var emailFlag=validateEmail(email);
			//if(!emailFlag){
				//return;
			//}
			
			if(updProfile!=undefined && updProfile!=null){
				updProfileFlag = document.getElementById("update-profile").checked;
				if(updProfileFlag==true || updProfileFlag=='true'){
					updateProfileEmail(userId,email); //Call updateProfile for Email updattion
				}
			}
			
			if(producerNumber!==undefined && producerNumber!==''){
				console.log("emailBookOfBusiness parmeter ::::: "+producerNumber+" ::::: "+produceSubNumber+" ::::: "+email);
				params.producerNumber = producerNumber;
				params.subProducerNumber = produceSubNumber;
			}else{
				dojo.byId("errorBox").innerHTML = "A Producer Number and SubProducer Number is required to run the report.";
				return;
			}
			
			if(email=='' && email== undefined && email.indexOf('@') == -1 ){
				dojo.byId("errorBox").innerHTML = "Please provide user email before sending mail.";
				return;
			}else{
				params.emailAddress = email;
				}
			
			try{
				//for analytics
				var _date = new Date();
				var param = "ev=Submit Contacts for Book of Business" + "&userId=" + userId + "&email=" + email + "&producerCodes=" + producerNumber + "-" + produceSubNumber+ "&requestDate=" + _date;
				console.log(param);
				ntptEventTag(param);
			}catch(e){
				console.log(e);
			}
			
			Utils.showMessageBox(CONSTANTS.PROCESSING_REQ);
			dojo.xhrPost({
				url: "jaxrs/commercial/bookOfBusiness",
				preventCache : true,
				headers: { "Content-Type": "application/json; charset=utf-8"},
				postData: dojo.toJson(params),
				handleAs: "json",
				load: function(data) {
					console.log(data.statusCode);

					if(data.statusCode=='S'){
						dojo.addClass('email-msg-area', 'active');
						dojo.byId("spreadsheet-span").innerHTML = 'Your book of business spreadsheet for ';
						dojo.byId("agency-span").innerHTML =producerName;
						dojo.byId("email-span").innerHTML =' has been sent to '+ email +".";

						if(updProfileFlag==true || updProfileFlag=='true'){
							$('profile-li').style.display = 'block';
							dojo.byId("profile-span").innerHTML = 'Your email address has been successfuly updated.';
							
							try {
								PageMgr.originalUserEmail = $('txtEmailAddress').value;
							}
							catch(e) {
							    console.log(e);
							}
							
							
						} else {
							$('profile-li').style.display = 'none';
						}
					}else{
						console.log(data.statusMessage);

						//dojo.byId("errorBox").innerHTML =data.statusMessage;
						dojo.byId("errorBox").innerHTML = "Problem occurred while sending mail.";
					}
					Utils.hideMessageBox();
				},
				error : function (error){
					Utils.hideMessageBox();
					console.log(error);
					//$('lc-ajax-loader').innerHTML = "We're sorry, but an error has occurred.";
				}
			});
		}
};

/***********************************************************
********** Mapper Functions for Grids
***********************************************************/
var pasGridMapper = function(objects){
	var output = '';
	
	dojo.forEach(objects, function(obj, i){
		if(obj.producerName!=null && obj.producerName!="null" && obj.producerName!=""){
			
			output += '<div class="grid-data responsive-table"><table id="producersTable'+ i +'"><tbody><tr>';

			output += '<td class="_3"><input type="radio" name="radio-group-producers" id='+ i +' value="tbd" onclick="PageMgr.processProducerSelection('+obj.producerNumber+','+obj.producerSubNumber+','+i+');"></td>';
			output += '<td data-title="Producer Name" class="_42">' + obj.producerName.toLowerCase() + '</td>';
			output += '<td data-title="Producer Number" class="_20">' + obj.prodAndProdSubNumber + '</td>';
			output += '<td data-title="Address" class="_35">' + obj.mailingAddress + '</td>';

			output += '</tr></tbody></table></div>';
		}else{
			if(objects.length==1){
				output += '<div class="grid-data responsive-table"><table id="message"><tbody><tr>';
				output += '<td class="_42">Your search did not return any results. Please search again.</td>';
				output += '</tr></tbody></table></div>';
			}
		}
	});
	
	dojo.byId("pas-grid-items").innerHTML = output;
};
var producerGridMapper = function(objects){
	var output = '';
	
	dojo.forEach(objects, function(obj, i){
		if(obj.producerName!=null && obj.producerName!="null" && obj.producerName!=""){
			
			output += '<div class="grid-data responsive-table"><table id="producersTable'+ i +'"><tbody><tr>';

			output += '<td class="_3"><input type="radio" name="radio-group-producers" id='+ i +' value="tbd" onclick="PageMgr.processProducerSelection('+obj.producerNumber+','+obj.producerSubNumber+','+i+');"></td>';
			output += '<td data-title="Producer Name" class="_42">' + obj.producerName.toLowerCase() + '</td>';
			output += '<td data-title="Producer Number" class="_20">' + obj.prodAndProdSubNumber + '</td>';
			output += '<td data-title="Address" class="_35">' + obj.mailingAddress + '</td>';

			output += '</tr></tbody></table></div>';
		}else{
			if(objects.length==1){
				output += '<div class="grid-data responsive-table"><table id="message"><tbody><tr>';
				output += '<td class="_42">Your search did not return any results. Please search again.</td>';
				output += '</tr></tbody></table></div>';
			}
		}
	});
	
	dojo.byId("producers-grid-items").innerHTML = output;
};
//Mapper Functions for Grids
var contactsGridMapper = function(objects){
	var output = '';

		dojo.forEach(objects, function(obj, i){

		output += '<div class="grid-data responsive-table"><table><tbody><tr>';

		output += '<td data-title="Name" class="_30">' + obj.name.toLowerCase() + '</td>';
		output += '<td data-title="Role" class="_15">' + obj.role.toLowerCase() + '</td>';
		output += '<td data-title="Phone" class="_15">' + obj.phoneNumber + '</td>';
		output += '<td data-title="Mobile" class="_15">' + obj.cellPhoneNumber + '</td>';
		output += '<td data-title="Email" class="_25 email"><a href="mailto:'+obj.emailAddress+'">'+obj.emailAddress+'</a></td>';

		output += '</tr></tbody></table></div>';
	});
	
	
	dojo.byId("contacts-grid-items").innerHTML = output;
};

function updateProfileEmail(userId, email){
	var params = {};
	params.userId = userId;
	params.email = email;
	var envHost = window.location.host;
	var serviceUrl = "https://" + envHost + "/PortalResource/ws/portalUser/updateprofile";
	//console.log("userId value ::::: "+userId);
	//console.log("email value ::::: "+email);
	//console.log("serviceUrl value ::::: "+serviceUrl);
	
	dojo.xhrPost({
		url: serviceUrl,
		preventCache : true,
		headers: { "Content-Type": "application/json; charset=utf-8"},
		postData: dojo.toJson(params),
		handleAs: "json",
		load: function(data) {
			console.log(data.status);
		},
		error : function (error){
			console.log(error);
		}
	});
}

function validateEmail(email) {
	var flag=false;
    var re = /^\s*[\w\-\+_]+(\.[\w\-\+_]+)*\@[\w\-\+_]+\.[\w\-\+_]+(\.[\w\-\+_]+)*\s*$/;
    if (re.test(email)) {
        if (email.indexOf('@chubb.com', email.length - '@chubb.com'.length) !== -1) {
        	dojo.byId("errorBox").innerHTML="";
        	flag=true;
        } else {
        	dojo.byId("errorBox").innerHTML = "Email must be a Chubb e-mail address (your.name@chubb.com).";
       }
    } else {
    	dojo.byId("errorBox").innerHTML="Not a valid e-mail address.";
    }
    return flag;
}

function resetBOB(){
	dojo.byId("spreadsheet-span").innerHTML="";
	dojo.byId("profile-span").innerHTML ="";
	dojo.removeClass('email-msg-area', 'active');
	producerNumber ='';
	produceSubNumber='';
}
/***********************************************************
********** SELFT EXECUTING FUNCTION (@onpage load)
***********************************************************/
(function(){
	PageMgr.init();
})();


/***********************************************************
********** CONTACTS MODAL MANAGER
***********************************************************/
var contactReqParam = null;
var contactParam = [];
var addlPoliciesContactParams = [];
var ContactModal = {
		process : function (index, obj, event){
			
			var param = "ev=Contact Icon Link";
			console.log(param);
			ntptEventTag(param);	
				
			var policyClass = obj.getAttribute("data-pol-class");
			if(policyClass === "primary"){
				contactReqParam = contactParam[index];
			} else {
				contactReqParam = addlPoliciesContactParams[index];
			}
			
			
			if ( Modernizr.mq('(max-width: 767px)') ) {
				//mobile: set obj needed to get contacts in session storage and go to the next page
				CbStorageManager.setSessionItem('caf_mobile_contact_param', JSON.stringify(contactReqParam));
				return true;
			} else {

				// stop normal click event
				if(event.preventDefault) {
					event.preventDefault();
				}  else {
					//<= ie8
					event.returnValue = false;
				}
				
				//get the hidden node
				var node = document.getElementById('linkShowContact');
				
				//check if the broser supports the .click() method
				if(typeof node.click !== "undefined"){
					console.log('nico');
					node.click(); 
				} else {
					//way to do hidden clicks in modern browsers
					var click_ev = document.createEvent("MouseEvents");
					//initialize the event
					click_ev.initEvent("click", true /* bubble */, true /* cancelable */);
					//trigger the evevnt
					node.dispatchEvent(click_ev);
				}

			}
		
		},
		getContacts : function(param){
			var restUrl = "jaxrs/commercial/contacts";
			var modalMsg = CONSTANTS.PROCESSING_REQ;
			
			if ( Modernizr.mq('(max-width: 767px)') ) { //mobile
				restUrl = "../jaxrs/commercial/contacts";
				modalMsg = CONSTANTS.PROCESSING_REQ_MOBILE;
			}
			
			Utils.showMessageBox(modalMsg);
			
			//param will not be null when using this method from mobile
			if(param != null){
				contactReqParam = param;
			}

			dojo.byId("contactErrorBox").innerHTML="";
			dojo.xhrPost({
				url: restUrl,
				preventCache : true,
				headers: {"Content-Type": "application/json; charset=utf-8"},
				postData: dojo.toJson(contactReqParam),
				handleAs: "json",
				load: function(data) {
					var _contactList = data.contactList;
					var _policyList=data.policyList;
					var _result = data.result;
					
					if(_result.statusCode=='E'){
						//dojo.byId("contactErrorBox").innerHTML = _result.statusMessage; 
						dojo.byId("contactErrorBox").innerHTML = "An error occurred while attempting to process your request.  Please contact the eBusiness Help Desk.";
					}
					
					if(_policyList.length>0){
						//console.log("_policyList[0].policyNumber ::: "+_policyList[0].policyNumber);
						dojo.byId("policyNo").innerHTML =  _policyList[0].policyNumber;
						dojo.byId("productName").innerHTML = _policyList[0].displayProductTypeName;
						dojo.byId("policyTerm").innerHTML = _policyList[0].policyTerm;
						dojo.byId("status").innerHTML = _policyList[0].policyStatus;
					}
					
					Utils.hideMessageBox();

					if(_contactList.length==0 && dojo.byId("contactErrorBox").innerHTML==""){
						//dojo.byId("contactErrorBox").innerHTML = "We are not able to locate a contact for this account. Please contact your local Chubb office. <a href='http://www.chubb.com/marketing/chubb2345.html' target='_blank'>Click here<a> to find a Chubb office near you. ";
						$('contact-message-area').style.display = 'block';
						$('contact-grid-container').style.display = 'none';

					}
					
					new CBgrid (_contactList, contactsGridMapper, "contacts-grid");
				},
				error : function (error){
					console.log(error);
				}
			});
			contactReqParam=null;
		},
		setPolicyContactReq : function(obj,i){
			
			//creating contact object(cpnumber and role) for getting contact list for policy
			var polContacts = ContactModal.setContactDetails(obj.contacts); 
			
			var params = {};
			params.polNo = obj.policyNumber;
			params.cpNumber = obj.cpNumber; 
			params.policyTypeCode = obj.policyTypeCode;
			params.branchNumber = obj.producingBranchCode; 
			params.contacts = polContacts;
			params.policyStatus = obj.policyStatus;
			params.policyTerm = obj.policyTerm;
			params.displayProductTypeName = obj.displayProductTypeName;
			
			if(obj.policyTypeSubCode!= null && obj.policyTypeSubCode!== undefined && obj.policyTypeSubCode==''){
				params.policySubTypCode = obj.policyTypeSubCode; 
			}
			
			contactParam[i]=params;
		},
		setAdditionalPolicyContactReq : function(obj,i){
			
			//creating contact object(cpnumber and role) for getting contact list for policy
			var polContacts = ContactModal.setContactDetails(obj.contacts); 
			
			var params = {};
			params.polNo = obj.policyNumber;
			params.cpNumber = obj.cpNumber; 
			params.policyTypeCode = obj.policyTypeCode;
			params.branchNumber = obj.producingBranchCode; 
			params.contacts = polContacts;
			params.policyStatus = obj.policyStatus;
			params.policyTerm = obj.policyTerm;
			params.displayProductTypeName = obj.displayProductTypeName;
			
			if(obj.policyTypeSubCode!= null && obj.policyTypeSubCode!== undefined && obj.policyTypeSubCode==''){
				params.policySubTypCode = obj.policyTypeSubCode; 
			}
			
			addlPoliciesContactParams[i]=params;
		},
		setContactDetails : function(policyContacts){
			var contacLst = [];
				
			for(var i in policyContacts) {
				var item = policyContacts[i];
				
				contacLst.push({ 
					"cpNumber" : item.underwriterId,
					"role"  : item.role,
				});
			}
			//console.log("policy contactLst  :::: "+contacLst);
			return contacLst;
		}
		
};

//Mapper Functions for Contacts Grids
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
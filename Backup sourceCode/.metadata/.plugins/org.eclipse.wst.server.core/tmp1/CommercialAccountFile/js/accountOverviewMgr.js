/***********************************************************
********** PAGE MANAGER OBJECT
***********************************************************/
dojo.require("dojo.hash");
dojo.subscribe("/dojo/hashchange", hashHandler);

//var searchPolNo=null;

var PageMgr = {
	//declare page variable 
	inputPolNo : null,
	inputAcctName : null,
	showAccountsView : false,
	insuredNumberParam :null,
	lceDashboardUrl :null,
	//methods
	init : function () {
		
		dojo.byId("errorBox").innerHTML="";
		//1. Get params from url. if no params use obj from session storage
		var urlParams = dojo.queryToObject(window.location.search.substring(1));
		//console.log("urlParams :::::: "+urlParams.polNo);
		Utils.showMessageBox(CONSTANTS.PROCESSING_REQ);
		
		/****  
		 * POLICY NUMBER SEARCH PROCESS 
		 * ****/
		if(urlParams.polNo !== undefined){
			try{
				//for analytics
				var param = "ev=Business Account Lookup&searchType=polNo";
				console.log(param);
				ntptEventTag(param);
			}catch(e){
				console.log(e);
			}
			
			//set global variable to match policy in policy list.
			PageMgr.inputPolNo=urlParams.polNo;
			
			//Set up any necessary params
			var params = {};
			params.polNo = PageMgr.inputPolNo;  
			dojo.xhrPost({
				 //url : "test-data/policies.json",  //this will come very handy during QA. Don't delete please
				 url: "jaxrs/commercial/policies",
				 preventCache : true,
				 headers: { "Content-Type": "application/json; charset=utf-8"},
				 postData: dojo.toJson(params),
				 handleAs: "json",
				 load: function (data){
					 Utils.hideMessageBox();
					 var _policyList = data.policyList;
					 var _result = data.result;
					 
					 if(_result.statusCode=='E'){
						 PageMgr.processErrorHandler();		
						 PageMgr.inputPolNo = null;
					 }else{
						 
						if(_policyList == null || _policyList.length == 0){
							
							//no results found: display section to search again
							dojo.style('no-results-section', 'display', 'block');
							$('app-search-error-msg').innerHTML = CONSTANTS.NO_RESULTS_MSG;
							dojo.style('select-an-account-section', 'display', 'none');
							dojo.style('account-detail-section', 'display', 'none');
							$('link-select-diff-acct').style.display = "none";
							PageMgr.inputPolNo = null;
						
						} else {
							
							 PageMgr.showAccountsView = false;
							 $('link-select-diff-acct').style.display = "none";
							 dojo.addClass("account-detail-section", "active");
							 
							 //Map Account Summary module
							 if(data.accountSummary.accountName !== undefined){
								 dojo.byId("account-name").innerHTML = data.accountSummary.accountName.toLowerCase();
							 }else{
								 dojo.byId("account-name").innerHTML="";
							 }
							 
							 if(data.accountSummary.mailingAddress !== undefined){
								 dojo.byId("account-mailingAddress").innerHTML = data.accountSummary.mailingAddress;
							 }else{
								 dojo.byId("account-mailingAddress").innerHTML ="";
							 }
							 
							 //Tulio CC 20 Maps two grids (primary and additional policies)
							 PageMgr.policyGridsMaperHelper(_policyList);
							 
							 //Add the insured# and account group id to the solutions left menu
							 dojo.query("#assigned-solutions li a").forEach(function(anchor){
								var _insdNo = data.accountSummary.wipInsuredNumber ? data.accountSummary.wipInsuredNumber : "";
								var _grpId = data.accountSummary.accountGroupId ? data.accountSummary.accountGroupId : "";
								var _wipInsdName = data.accountSummary.accountName ? data.accountSummary.accountName : "";
	
								if (this.lceDashboardUrl != null)
								{
									anchor.href = this.lceDashboardUrl;
								}
								this.lceDashboardUrl = anchor.href;
							    anchor.href += "?insuredNo=" + _insdNo + "&acctGrpId=" + _grpId + "&wipInsdName=" + _wipInsdName;
							 });
							
							 //save to session storage
							 CbStorageManager.setSessionItem('caf_policy_list', JSON.stringify(data));
						
						}
						

						 
					 }

				 },
				 error : function (error){
					 console.log(error);
					 PageMgr.inputPolNo = null;
					 //$('lc-ajax-loader').innerHTML = "We're sorry, but an error has occurred.";
				 }
		   });
		
		/****  
		 * ACCOUNT NAME SEARCH PROCESS 
		 * ****/
		} else if (urlParams.acctName !== undefined){
			try{
				//for analytics
				var param = "ev=Business Account Lookup&searchType=acctName";
				console.log(param);
				ntptEventTag(param);
			}catch(e){
				console.log(e);
			}
			
			//set global variable
			this.inputAcctName = urlParams.acctName;
			
			//set up service request params
			var params = {};
			params.acctName = urlParams.acctName;  

			dojo.xhrPost({
				 //url : "test-data/accounts.json",  //this will come very handy during QA. Don't delete please
				 url: "jaxrs/commercial/accounts",
				 preventCache : true,
				 headers: { "Content-Type": "application/json; charset=utf-8"},
				 postData: dojo.toJson(params),
				 handleAs: "json",
				 load: function (data){
					PageMgr.processData(data);
				 },
				 error : function (error){
					 console.log(error);
					 PageMgr.processErrorHandler();
				 }
		   });
		
		/***
		 * Logic when user returns from another application to this page, ie: LCX ***/
		} else if (urlParams.polResults !== undefined){
			
			var storedCafPolData = CbStorageManager.getSessionStoredData('caf_policy_list');
			if(storedCafPolData){ 
				
				dojo.addClass("account-detail-section", "active");
				 
				if(storedCafPolData.accountSummary.accountName !== undefined){
					dojo.byId("account-name").innerHTML = storedCafPolData.accountSummary.accountName.toLowerCase();
				}
				if(storedCafPolData.accountSummary.mailingAddress !== undefined){
					dojo.byId("account-mailingAddress").innerHTML = storedCafPolData.accountSummary.mailingAddress;
				}
				 
				dojo.query("#assigned-solutions li a").forEach(function(anchor){
					var _insdNo = storedCafPolData.accountSummary.wipInsuredNumber ? storedCafPolData.accountSummary.wipInsuredNumber : "";
					var _grpId = storedCafPolData.accountSummary.accountGroupId ? storedCafPolData.accountSummary.accountGroupId : "";
					var _wipInsdName = storedCafPolData.accountSummary.accountName ? storedCafPolData.accountSummary.accountName : "";
					
					if (this.lceDashboardUrl != null)
					{
						anchor.href = this.lceDashboardUrl;
					}
					this.lceDashboardUrl = anchor.href;
				    anchor.href += "?insuredNo=" + _insdNo + "&acctGrpId=" + _grpId + "&wipInsdName=" + _wipInsdName;
				});
				
				
				//check if a pol no exist in storate. it would've been saved when going to the mobile contact page
				var storedSearchedPolNo = CbStorageManager.getSessionStoredData('searched_pol_no');
				if(storedSearchedPolNo){
					this.inputPolNo = storedSearchedPolNo;
				}
				//new CBgrid (storedCafPolData.policyList, policyGridMapper, "policy-grid");
				PageMgr.policyGridsMaperHelper(storedCafPolData.policyList);   //Tulio CC 20 Maps two grids (primary and additional policies)
				
				Utils.hideMessageBox();

			}
		}
		/* no parameters were passed...take them to @chubb */
		else {
			Utils.hideMessageBox();
			window.location = "/AtChubb/jsp/home.faces";
		}
	
	},
	processData : function(data){
		//check also for data.status === "S" once you start getting real data
		var _accountList = data.accountList;
		var _policyList = data.policyList;
		var _result=data.result;
		
		if(_result.statusCode=='E'){
			Utils.hideMessageBox(); //unhide loading message
			//Show an error message
			dojo.style('no-results-section', 'display', 'block');
			dojo.style('select-an-account-section', 'display', 'none');
			dojo.style('account-detail-section', 'display', 'none');
			
			//dojo.byId("errorBox").innerHTML = _result.statusMessage;
			dojo.byId("errorBox").innerHTML = "An error occurred while attempting to process your request.  Please contact the eBusiness Help Desk.";
		}else{
			if(_accountList != null){
				//No results were found show a message and search widget
				if(_accountList.length == 0){
					PageMgr.showAccountsView = false;
					
					//dojo.addClass("no-results-section", "active");
					dojo.style('no-results-section', 'display', 'block');
					$('app-search-error-msg').innerHTML = CONSTANTS.NO_RESULTS_MSG;
					dojo.style('select-an-account-section', 'display', 'none');
					dojo.style('account-detail-section', 'display', 'none');
					$('link-select-diff-acct').style.display = "none";
					Utils.hideMessageBox();
				} 
				else if (_accountList.length == 1){
					PageMgr.showAccountsView = false;
					
					//console.log("_policyList ::: "+_policyList.length);
					Utils.hideMessageBox(); //unhide loading message
					/*The search returned a single account, display the proper area w/ the policies */
					dojo.style("account-detail-section",'display', 'block');
					dojo.style('select-an-account-section', 'display', 'none');
					dojo.style('no-results-section', 'display', 'none');
					$('link-select-diff-acct').style.display = "none";
					
					if(data.accountSummary.accountName !== undefined){
						dojo.byId("account-name").innerHTML = data.accountSummary.accountName.toLowerCase();
					}
					if(data.accountSummary.mailingAddress !== undefined){
						dojo.byId("account-mailingAddress").innerHTML = data.accountSummary.mailingAddress;
					}
					 //Add the insured# and account group id to the solutions left menu
					 dojo.query("#assigned-solutions li a").forEach(function(anchor){
						var _insdNo = data.accountSummary.wipInsuredNumber ? data.accountSummary.wipInsuredNumber : "";
						var _grpId = data.accountSummary.accountGroupId ? data.accountSummary.accountGroupId : "";
						var _wipInsdName = data.accountSummary.accountName ? data.accountSummary.accountName : "";
						
						if (this.lceDashboardUrl != null)
						{
							anchor.href = this.lceDashboardUrl;
						}
						this.lceDashboardUrl = anchor.href;
					    anchor.href += "?insuredNo=" + _insdNo + "&acctGrpId=" + _grpId + "&wipInsdName=" + _wipInsdName;
					 });
					 
					 CbStorageManager.setSessionItem('caf_policy_list', JSON.stringify(data));
					//new CBgrid (_policyList, policyGridMapper, "policy-grid");
					PageMgr.policyGridsMaperHelper(_policyList);   //Tulio CC 20 Maps two grids (primary and additional policies)
				}
				else if (_accountList.length > 1){ 
					/* the search returned multiple accounts */
					PageMgr.showAccountsView = true;
					
					console.log('added hash to URL');
					location.hash = "select_an_account";
					
					
					dojo.style('select-an-account-section', 'display', 'block');
					dojo.style('account-detail-section', 'display', 'none');
					dojo.style('no-results-section', 'display', 'none');
					$('link-select-diff-acct').style.display = "block";
					
					//show the account name the user was searching for
					Utils.hideMessageBox(); //unhide loading message
					 $('select-account-message').innerHTML = "Your search for <b>" + PageMgr.inputAcctName + "</b> has returned multiple results. Please select one from the list below.";
					 //dojo.addClass("select-account-message-area", "info");
					 $('select-account-message-area').style.display = "block";
					 console.log('show area');
					 
					 //populate the account grid with all options to choose from
					new CBgrid (_accountList, accountsGridMapper, "select-account-grid");
					
				} 
			}
		}
	},
	processAccountSelection : function (insuredNumber, index,element){
		//console.log('wipInsuredNumber  for Account selection  :::: '+PageMgr.insuredNumberParam[index]);
		$('select-account-message-area').style.display = "none";
		Utils.showMessageBox(CONSTANTS.PROCESSING_REQ);
		dojo.byId("errorBox").innerHTML="";
		var params = {};
		params.insuredNumber = PageMgr.insuredNumberParam[index].toString();
		dojo.xhrPost({
			 //url : "test-data/policies.json",
			 url: "jaxrs/commercial/policies",
			 preventCache : true,
			 headers: { "Content-Type": "application/json; charset=utf-8"},
			 postData: dojo.toJson(params),
			 handleAs: "json",
			 load: function (data){ 
				 Utils.hideMessageBox();
				 var _policyList = data.policyList;
				 var _result = data.result;
				
				 if(_result.statusCode=='E'){
					 PageMgr.processErrorHandler();
				 } 
				 else if(_result.statusCode == 'W' && _result.statusMessage.toUpperCase().indexOf('NO POLICIES FOUND') > -1){
					 $('select-account-message').innerHTML = "The account you selected <span class='acct-name-highlighted'>("+element.innerHTML+")</span> does not have any current policies.";
					 $('select-account-message-area').style.display = "block";
					 document.body.scrollTop = document.documentElement.scrollTop = 0;
				 }
				 else{
					//PageMgr.processData(_policyList);
					 dojo.addClass("account-detail-section", "active");
					 
					 //console.log("Account Name ::: "+data.accountSummary.accountName+" :::: mailingAddress ::: "+data.accountSummary.mailingAddress);
					 
					 if(data.accountSummary.accountName !== undefined){
						 dojo.byId("account-name").innerHTML = data.accountSummary.accountName.toLowerCase();
					 }else{
						 dojo.byId("account-name").innerHTML="";
					 }
					 
					 if(data.accountSummary.mailingAddress !== undefined){
						 dojo.byId("account-mailingAddress").innerHTML = data.accountSummary.mailingAddress;
					 }else{
						 dojo.byId("account-mailingAddress").innerHTML ="";
					 }
					 
					//Add the insured# and account group id to the solutions left menu
					dojo.query("#assigned-solutions li a").forEach(function(anchor){
						var _insdNo = data.accountSummary.wipInsuredNumber ? data.accountSummary.wipInsuredNumber : "";
						var _grpId = data.accountSummary.accountGroupId ? data.accountSummary.accountGroupId : "";
						var _wipInsdName = data.accountSummary.accountName ? data.accountSummary.accountName : "";
						
						if (this.lceDashboardUrl != null)
							{
								anchor.href = this.lceDashboardUrl;
							}
						
						this.lceDashboardUrl = anchor.href;
					    anchor.href += "?insuredNo=" + _insdNo + "&acctGrpId=" + _grpId + "&wipInsdName=" + _wipInsdName;
					});
					 
					 //new CBgrid (_policyList, policyGridMapper, "policy-grid");
					PageMgr.policyGridsMaperHelper(_policyList);   //Tulio CC 20 Maps two grids (primary and additional policies)
					 
					 //save to session storage
					 CbStorageManager.setSessionItem('caf_policy_list', JSON.stringify(data));
					 
					 location.hash = "results";
				 }
				 
				 PageMgr.inputPolNo = null;
			 },
			 error : function (error){
				 console.log(error);
			 }
	   });
		
		//console.log('WIP number for account selected is: ' + PageMgr.insuredNumberParam[index]);
	},
	policyGridsMaperHelper : function (_policies){
		
		if(PageMgr.inputPolNo != null){
			var _keyPolNo = Utils.leftPadPolicyNo(PageMgr.inputPolNo, 12);
			console.log("pol going in: " + PageMgr.inputPolNo + " - pol going out: " + _keyPolNo);
			
			var _primaryPolList = [];
			dojo.forEach(_policies, function(policy, i){
				if(policy["policyNumber"] === _keyPolNo){
					_primaryPolList.push(policy);
				}
			});
			
			 //Map policy list to grid
			 new CBgrid (_primaryPolList, policyGridMapper, "policy-grid");
			 //PageMgr.inputPolNo = null; 
			 
			//separate additional policies
			var _additionalPolicies = [];
			dojo.forEach(_policies, function(policy, i){
				if(policy["policyNumber"] !== _keyPolNo){
					_additionalPolicies.push(policy);
				}
			});
			if(_additionalPolicies.length > 1){
				new CBgrid (_additionalPolicies, additionalPoliciesGridMapper, "additional-policy-grid");
				$("addl-pol-grid-holder").style.display = "block";
			}

			//for mobile only: need it to be able to map the screen when returning from the mobile contact page
			if ( Modernizr.mq('(max-width: 767px)') ) {		
				CbStorageManager.setSessionItem('searched_pol_no', JSON.stringify(PageMgr.inputPolNo)); 
				return true;
			} 
			
			PageMgr.inputPolNo = null; 
		
		} else {
			new CBgrid (_policies, policyGridMapper, "policy-grid");
		}
		

		
	},
	newSearch : function (obj) {
		if(obj.id === 'select-an-account-option'){
			dojo.toggleClass("search-again-block", "active");
			dojo.toggleClass("new-search-area", "active");
		} else {
			dojo.toggleClass("search-again-block-b", "active");
			dojo.toggleClass("new-search-area-b", "active");
		}
	}, 
	processNewSearch: function (section){

		//reset additional policy grid
		$("addl-pol-grid-holder").style.display = "none";
		$("additional-policy-grid-items").innerHTML = "";
		
		//reset any possible contact params
		//contactParam = [];
		//addlPoliciesContactParams = [];
		
		var searchByType='';
		var inputParam='';
		dojo.byId("errorBox").innerHTML = "";
		$('select-account-message-area').style.display = "none";
		
		if(section == 'section-a'){
			searchByType = $('select-search-options').value;
			inputParam = $('txtUserSearchInput').value;
		} else if(section == 'section-b'){
			searchByType = $('select-search-options-b').value;
			inputParam = $('txtUserSearchInput-b').value;
		} else if(section == 'section-c'){
			searchByType = $('select-search-options-c').value;
			inputParam = $('txtUserSearchInput-c').value;
		} 
		
		//console.log(searchByType + ' ' + inputParam);
		//searchPolNo = inputParam;
		//PageMgr.inputPolNo = inputParam;
		
		//validate the form
		if(inputParam == undefined || inputParam == ""){
			if(searchByType == 'account-name'){
				dojo.byId("errorBox").innerHTML = "The account name field cannot be empty.";
			}else{
				dojo.byId("errorBox").innerHTML = "The policy number field cannot be empty.";
			}
			return;
		} else if (searchByType == 'policy-number' && inputParam.length > 12){
			dojo.byId("errorBox").innerHTML = "The policy number exceeds 12 digits.  Please check and re-enter.";
			return;
		}
		
		//set global variable to match policy in policy list.
		Utils.showMessageBox(CONSTANTS.PROCESSING_REQ);
		var params = {};
		if(searchByType == 'account-name'){
			try{
				//for analytics
				var param = "ev=Business Account Lookup Search Again&searchType=acctName";
				console.log(param);
				ntptEventTag(param);
			}catch(e){
				console.log(e);
			}
			params.acctName = inputParam;
			PageMgr.inputAcctName = params.acctName;
			document.getElementById('select-search-options').value = searchByType;
			document.getElementById('txtUserSearchInput').value = inputParam;
			dojo.xhrPost({
				 //url : "test-data/accounts.json",  //this will come very handy during QA. Don't delete please
				 url: "jaxrs/commercial/accounts",
				 preventCache : true,
				 headers: { "Content-Type": "application/json; charset=utf-8"},
				 postData: dojo.toJson(params),
				 handleAs: "json",
				 load: function (data){
				 	if(data!=null && data.accountList!=null && data.accountList.length == 0){
						document.getElementById('select-search-options-c').value = searchByType;
						document.getElementById('txtUserSearchInput-c').value = inputParam;
					}
				 	PageMgr.processData(data);
				 },
				 error : function (error){
					 console.log(error);
				 }
		   });
			
		//Policy Number Search
		} else {  
			try{
				//for analytics
				var param = "ev=Business Account Lookup Search Again&searchType=polNo";
				console.log(param);
				ntptEventTag(param);
			}catch(e){
				console.log(e);
			}
			
			PageMgr.inputPolNo = inputParam;
			params.polNo = inputParam; 
			document.getElementById('select-search-options-b').value = searchByType;
			document.getElementById('txtUserSearchInput-b').value = inputParam;
			dojo.xhrPost({
				 //url : "test-data/policies.json", 
				 url: "jaxrs/commercial/policies",
				 preventCache : true,
				 headers: { "Content-Type": "application/json; charset=utf-8"},
				 postData: dojo.toJson(params),
				 handleAs: "json",
				 load: function (data){
					 Utils.hideMessageBox();
					 var _policyList = data.policyList;
					 var _result = data.result;
					 
					 if(_result.statusCode=='E'){
						 if(_result.statusMessage.indexOf(CONSTANTS.POL_NUM_MAX_LIM) > -1){
							dojo.byId("errorBox").innerHTML = "The policy number exceeds 12 digits.  Please check and re-enter.";
						 }else{
							 PageMgr.processErrorHandler();
							 PageMgr.inputPolNo = null;
						 }
					 }else{
						 
						 if(_policyList == null || _policyList.length == 0){
							 	
							 	document.getElementById('select-search-options-c').value = searchByType;
								document.getElementById('txtUserSearchInput-c').value = inputParam;
								
								dojo.style('no-results-section', 'display', 'block');
								$('app-search-error-msg').innerHTML = CONSTANTS.NO_RESULTS_MSG;
								dojo.style('select-an-account-section', 'display', 'none');
								dojo.style('account-detail-section', 'display', 'none');
								$('link-select-diff-acct').style.display = "none";
								
								PageMgr.inputPolNo = null;
							}
						 else{
							 PageMgr.showAccountsView = false;

							 //console.log("In search section Account Name ::: "+data.accountSummary.accountName+" :::: mailingAddress ::: "+data.accountSummary.mailingAddress);
							 if(data.accountSummary.accountName !== undefined){
								 dojo.byId("account-name").innerHTML = data.accountSummary.accountName.toLowerCase();
							 }else{
								 dojo.byId("account-name").innerHTML="";
							 }

							 if(data.accountSummary.mailingAddress !== undefined){
								 dojo.byId("account-mailingAddress").innerHTML = data.accountSummary.mailingAddress;
							 }else{
								 dojo.byId("account-mailingAddress").innerHTML ="";
							 }
							 
							//Add the insured# and account group id to the solutions left menu
								dojo.query("#assigned-solutions li a").forEach(function(anchor){
									var _insdNo = data.accountSummary.wipInsuredNumber ? data.accountSummary.wipInsuredNumber : "";
									var _grpId = data.accountSummary.accountGroupId ? data.accountSummary.accountGroupId : "";
									var _wipInsdName = data.accountSummary.accountName ? data.accountSummary.accountName : "";
									
									if (this.lceDashboardUrl != null)
										{
											anchor.href = this.lceDashboardUrl;
										}
									
									this.lceDashboardUrl = anchor.href;
								    anchor.href += "?insuredNo=" + _insdNo + "&acctGrpId=" + _grpId + "&wipInsdName=" + _wipInsdName;
								});
								
								 //save to session storage
								 CbStorageManager.setSessionItem('caf_policy_list', JSON.stringify(data));

							 PageMgr.showAccountsView = false;
							 $('link-select-diff-acct').style.display = "none";
							 dojo.addClass("account-detail-section", "active");

							 //new CBgrid (_policyList, policyGridMapper, "policy-grid");
							 PageMgr.policyGridsMaperHelper(_policyList);   //Tulio CC 20 Maps two grids (primary and additional policies)
						 }
					 }
					
				 },
				 error : function (error){
					 console.log(error);
				 }
		   });

		}
		//console.log('input policy::' +inputPolNo);
		//validate that all fields are valued here
			//NEW CODE NEEDED
		
		//execute new rest call to get data here.  call PageMgr.processData(data) once payload is received
			//NEW CODE NEEDED
	},
	showSelectAccountSection : function (){
		PageMgr.showAccountsView = true;
		//dojo.removeClass("select-account-message-area", "info");
		 $('select-account-message-area').style.display = "none";
		
		dojo.style('select-an-account-section', 'display', 'block');
		dojo.style('account-detail-section', 'display', 'none');
		dojo.style('no-results-section', 'display', 'none');
		
		location.hash = "select_an_account";
		
		document.body.scrollTop = document.documentElement.scrollTop = 0;
	},
	processErrorHandler : function(){
		Utils.hideMessageBox();
		dojo.style('no-results-section', 'display', 'block');
		dojo.style('select-an-account-section', 'display', 'none');
		dojo.style('account-detail-section', 'display', 'none');
		$('link-select-diff-acct').style.display = "none";
		$('app-search-error-msg').innerHTML = CONSTANTS.ERROR_MSG;
	}
};


/***********************************************************
********** Mapper Functions for Grids
***********************************************************/
//Mapper Functions for Policy Grids
var policyGridMapper = function(objects){
	dojo.style('no-results-section', 'display', 'none');
	dojo.style('select-an-account-section', 'display', 'none');
	dojo.style('account-detail-section', 'display', 'block');
	
	var output = '';
	

	dojo.forEach(objects, function(obj, i){

		ContactModal.setPolicyContactReq(obj,i);// create request prameter object for policy contact list
		
		output += '<div class="grid-data responsive-table"><table><tbody><tr>';
		output += '<td data-title="Policy Number" class="_20">' + obj.policyNumber + '</td>';
		output += '<td data-title="Product" class="_25">' + obj.displayProductTypeName.toLowerCase() + '</td>';
		output += '<td data-title="Policy Term" class="_25">' + obj.policyTerm.toLowerCase() + '</td>';
		output += '<td data-title="Status" class="_20">' + obj.policyStatus.toLowerCase() + '</td>';
		output += '<td data-title="Contact" class="_10 ca"><a data-contact-key="'+obj.policyNumber+'" data-pol-class="primary" href="html/contacts.html" onclick="ContactModal.process('+i+', this, event);"><img src="images/clear.png" class="icon-contact-small" /></a></td>';
		output += '</tr></tbody></table></div>';
		
	});
	
	dojo.byId("policy-grid-items").innerHTML = output;
	//searchPolNo=null;

};

var additionalPoliciesGridMapper = function(objects){
	dojo.style('no-results-section', 'display', 'none');
	dojo.style('select-an-account-section', 'display', 'none');
	dojo.style('account-detail-section', 'display', 'block');
	
	var output = '';
	dojo.forEach(objects, function(obj, i){
		
		ContactModal.setAdditionalPolicyContactReq(obj,i);// create request prameter object for policy contact list
	
		output += '<div class="grid-data responsive-table"><table><tbody><tr>';
		output += '<td data-title="Policy Number" class="_20">' + obj.policyNumber + '</td>';
		output += '<td data-title="Product" class="_25">' + obj.displayProductTypeName.toLowerCase() + '</td>';
		output += '<td data-title="Policy Term" class="_25">' + obj.policyTerm.toLowerCase() + '</td>';
		output += '<td data-title="Status" class="_20">' + obj.policyStatus.toLowerCase() + '</td>';
		output += '<td data-title="Contact" class="_10 ca"><a data-contact-key="'+obj.policyNumber+'" data-pol-class="additional" href="html/contacts.html" onclick="ContactModal.process('+i+', this, event);"><img src="images/clear.png" class="icon-contact-small" /></a></td>';
		output += '</tr></tbody></table></div>';
	});
	
	dojo.byId("additional-policy-grid-items").innerHTML = output;
	//searchPolNo=null;

};

//Mapper function for Account Grid
var accountsGridMapper = function(objects){
	dojo.style('select-an-account-section', 'display', 'block');
	dojo.style('account-detail-section', 'display', 'none');
	dojo.style('no-results-section', 'display', 'none');
	
	PageMgr.insuredNumberParam =new Array();
	var output = '';
	dojo.forEach(objects, function(obj, i){
		PageMgr.insuredNumberParam[i]=obj.wipInsuredNumber;
		output += '<div class="grid-data">';
		output += '<div class="responsive-table"><table><tbody><tr>';
		
		//this has to be custome to the type of data the grid is displaying
		output += '<td data-title="Name" class="_40"><a href="javascript:void(0);" data-key="" onclick="PageMgr.processAccountSelection('+obj.wipInsuredNumber+','+i+', this);">' + obj.insuredName.toLowerCase() + '</a></td>';
		output += '<td data-title="Address" class="_60">' + obj.insuredAddress + '</td>';

		output += '</tr></tbody></table></div>';
		output += '</div>';
	});
	
	dojo.byId("select-account-grid-items").innerHTML = output;
};


function cafMenuHandler (elem, event){
	window.location=targetHref;
	return false; 
};

function hashHandler(hash) {
    //hashchange event!
    var obj = dojo.queryToObject(hash);
    if (obj.select_an_account !== undefined) {
    	console.log('Hash Handler (select account) called!');
		dojo.style('select-an-account-section', 'display', 'block');
		dojo.style('account-detail-section', 'display', 'none');
		dojo.style('no-results-section', 'display', 'none');

		document.body.scrollTop = document.documentElement.scrollTop = 0;
		
    } else if (obj.results !== undefined) {
    	console.log('Hash Handler (results or other) called!');
		dojo.style("account-detail-section",'display', 'block');
		dojo.style('select-an-account-section', 'display', 'none');
		dojo.style('no-results-section', 'display', 'none');
    }
}

/***********************************************************
********** SELFT EXECUTING FUNCTION (@onpage load)
***********************************************************/
(function(){
	PageMgr.init();
})();


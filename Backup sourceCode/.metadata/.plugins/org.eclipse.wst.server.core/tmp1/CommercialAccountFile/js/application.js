/**
 * This object handles the code to be executed before or after the UI modules are loaded, or before and after a modal window is opened.
 */


CB = {
	/* Add code here that needs to be executed across ALL pages BEFORE the UI framework modules are loaded  */
	doBeforeModulesLoadWork: function(){

	},
	/* Add code here that needs to be executed across ALL pages AFTER the UI framework modules are loaded  */
	doAfterModulesLoadWork: function(){
		/* use this code if this app needs go get the important messages used in @chubb */

		
	},
	doModalAppLoadHandler: function(modal){
	/* Add any code here that needs to be executed before a modal window is shown */
		
		if(modal.modalUrl[0].indexOf("contacts") > 0){
			ContactModal.getContacts(null);
		 } 

	},
	doModalAppCloseHandler: function(modal){
		/* Add any code here that needs to be executed after a modal window is closed */
	}
};

/**
 * Application js code and/or Utils
 */
/**
 * Description
 *
 * @param  {String} id    A specific element ID
 * @return {Object}       HTML element
 */
var time;
var jsPageManager = {
	returnValue : true,

	/*this method is called when an item is clicked */
	processClick: function(obj, section){
		
		/* 1. process any js logic here if needed */

	
		/* 2. process analycis  */
		this.analyticsHandler(obj, section);
		
		var ret = this.returnValue;
		return ret;
	
	},
	analyticsHandler: function(obj, section){ 
		var param = "";
	    var itemName = "";		//Used if the anchor link has a data-analytics-key attribute
			
		try
		{
			var itemName = obj.innerHTML;  //Most of the item names we need come from the innerHTML of the links
			
			//check if the html5 data-* attribute was used
			if(obj !== null && obj.getAttribute('data-analytics-key') !== null){
				itemName = obj.getAttribute('data-analytics-key');
			} 
			else if(obj !== null && obj.href.indexOf('video-player.html') > -1){ //if it is the rec list and not mobile
				itemName = $('txtVideoTag').value;
			}

			
			//format the param and remove any invalid chars
			param = "ev=" + encodeURIComponent(section) + "&itemname=" + encodeURIComponent(itemName);

			console.log(param);
			//send tag to NetInsight
			ntptEventTag(param);
			
			//process a .5 sec delay.  this is needed if opening a link on the same window, otherwise netinsight will not record the click 
			//all modal windows must return true
			if(obj.getAttribute('data-module-type') !== null && obj.getAttribute('data-module-type') === 'Modal'){
				this.returnValue = true;
			}
			//check for links that open in the same tab/windwow by interrogating its target
			else if (obj !== null && (obj.target === "_self" || obj.target === "")) {
				time=setTimeout(function(){window.location=obj.href}, 500);
				this.returnValue = false;
			}
		} catch (e){
			console.log(e);
		}


	}
	
}; 

/*********************************************************************************************
This objects has all the methods to store and populate data to either local storage or cookies. 
**********************************************************************************************/
var CbStorageManager = {
	isStorageAvailable: function(){
		if(typeof(Storage)!=="undefined" && typeof(Storage)!== null){
		  return true;
		} else {
		  return false;
		}
	},
	getSessionStoredData: function(context){
		var retrievedObject = null;
		
		if(this.isStorageAvailable()){
			retrievedObject = sessionStorage.getItem(context);
		} 
		
		if(retrievedObject){
			return JSON.parse(retrievedObject);
		} else {
			return null;
		}

	},
	setSessionItem: function(context, data){
		console.log('Inside CbStorageManager.setSessionItem for: ' + context);
		if(this.isStorageAvailable()){
			sessionStorage.setItem(context, data);
		}
		
	},
	removeSessionStoredData: function(context){
		if(this.isStorageAvailable()){
			retrievedObject = sessionStorage.getItem(context);
		}
		if(retrievedObject){
			sessionStorage.removeItem(context);
		}
	}
};

var Utils = {
		showMessageBox : function(msg){
			$('box-message').innerHTML = msg;
			dojo.attr( 'splashWindow', 'style', {
				height: dojo.position('wrapper', true).h + 'px', 
				display: "block"});
			
			var ps = dojo.position('notice-block'); 
			//var ws = dojo.window.getBox(); 
			var w = window,
			d = document,
			e = d.documentElement,
			g = d.getElementsByTagName('body')[0],
			x = w.innerWidth || e.clientWidth || g.clientWidth,
			y = w.innerHeight|| e.clientHeight|| g.clientHeight;
				
			var client = {};
			client.innerHeight = y;
			client.innerWidth = x;
			
			dojo.attr( 'notice-block', 'style', {
				top: (client.innerHeight/2-ps.h/2)+"px", 
				left: (client.innerWidth/2-ps.w/2)+"px",
				visibility: "visible"});
		},
		hideMessageBox : function(){
			$('splashWindow').style.display = "none";
			$('notice-block').style.visibility = "hidden";
			
		},
		leftPadPolicyNo : function(number, width){
		  width -= number.toString().length;
		  if ( width > 0 )
		  {
		    return new Array( width + (/\./.test( number ) ? 2 : 1) ).join( '0' ) + number;
		  }
		  return number + ""; // always return a string
			
		}
};
//Logout functionality - modified servlet name as needed
function logout(){
	try {
		sessionStorage.clear();	
	}
	catch (e) {
		console.log('sessionstorage is not surpported for this browser. No need to clear storage.');
	}
	mywindow=window.open("/AtChubb/LogoutServlet","_self","menubar=1, resizable=1, width=650, height=500");
}
/*
 * Add any application needed constants here
 */
var CONSTANTS = {
		'PROCESSING_REQ' : '<div><img src="images/ajax/ajax.gif"> Processing your request...please wait</div>',
		'POL_NUM_MAX_LIM' : 'exceeds the maximum length',
		'PROCESSING_REQ_MOBILE' : '<div><img src="../images/ajax/ajax.gif"> Processing your request...please wait</div>',
		'ERROR_MSG' : 'An error occurred while attempting to process your request.  Please search again or contact the eBusiness Help Desk',
		'NO_RESULTS_MSG' : 'Your search did not return any results.  Please search again.'
};

(function(){
	try {
		//console.log('Positioning footer');
		var w = window,
		d = document,
		e = d.documentElement,
		g = d.getElementsByTagName('body')[0],
		x = w.innerWidth || e.clientWidth || g.clientWidth,
		y = w.innerHeight|| e.clientHeight|| g.clientHeight;
			
		var client = {};
		client.innerHeight = y;
		client.innerWidth = x;
		
		var main = document.getElementById('main-content');
		main.style.minHeight= (client.innerHeight - 152) + "px";
		
	} catch (e){
		console.log(e);
	}
})();



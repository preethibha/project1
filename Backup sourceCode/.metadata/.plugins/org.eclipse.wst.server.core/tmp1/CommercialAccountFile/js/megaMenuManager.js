/* version 1.0 */
atCbMegaMenuClientMgr = {
	/**
	 * Method called every time a page in loaded ~ from jsf template
	 * @param  none
	 */
	init: function(options){
		
		var storedData = StorageManager.getSessionStoredData('atcb_mm');
		//check if data exist in session otherwise call REST service
		storedData ?  (atCbMegaMenuClientMgr.sessionDataMapper(storedData),atCbMegaMenuClientMgr.setLogoContext())  : RestManager.execute();	
					
	},
	/**
	 * Creates all dom elements of the Mega Menu
	 * @param  {object type json} data   :  The payload received from the REST call
	 */
	createMegaMenu: function(data){

		dojo.forEach(data.megamenu, function(item, i){
			dojo.place("<li id='mm_"+item.name+"' class='nav__item nav__has__subnav'><div class='nav__link'><a href='"+item.url+"'></a><span>"+item.name+"</span></div><div id='subnav-"+i+"' data-module-type='SubNav' class='subnav'><div id='subnav-toggle-group-"+i+"' class='subnav-toggle-group'></div></div></li>", "mega-menu");
			dojo.forEach(item.children, function(drawer, x){
				/* A little weird but.. get children dom elements ready first and add them later to the dom... opposite to the jsf approach  */
				var mobileAnchors = "";
				var subNavGroups = "";
				dojo.forEach(drawer.children, function(panelItem){
					var panelLinks = "";
					dojo.forEach(panelItem.children, function(link){
						panelLinks += "<a href='"+link.url+"' target='"+link['window-target']+"'>"+link.name+"</a>";
					});
					mobileAnchors += "<a href='"+panelItem.url+"'>"+panelItem.name+"</a>";
					subNavGroups += "<div class='subnav__group'><span class='subnav-group-header'><span class='"+panelItem['image-url']+"'></span>"+panelItem.name+"</span>"+panelLinks+"</div>";
				});
			    var node = "subnav-toggle-group-" + i;
				dojo.place("<div data-module-type='Drawer' class='"+drawer['mobile-css']+"drawer-ui'><div class='subnav__toggle drawer-toggle "+drawer['css-status']+"'><a href='"+drawer.url+"' id="+drawer.id+"'></a><span>"+drawer.name+"</span></div><div class='drawer-content'>"+mobileAnchors+"</div></div>", node);
				var css_string = drawer['css-group'] + " " + drawer['css-status'];
				dojo.place("<div class='subnav__panel "+css_string+"'>"+subNavGroups+"</div>", 'subnav-'+i);
			});
		});
		
		//StorageManager.setSessionItem('atcb_mm', $('mega-menu').innerHTML);  //store mega menu html in session storage
		
		//admin menu
		var adminMenuExist = false;
		
		if(data.adminmenu !== undefined){
			dojo.forEach(data.adminmenu, function(item, i){
				dojo.forEach(item.children, function(child){
					dojo.place("<a href='"+child.url+"' id='"+child.id+"' target='"+child['window-target']+"'>"+child.name+"</a>", 'admin_menu_items');
					adminMenuExist = true;
				});
			});
			
			if(adminMenuExist){
				/* admin menu exists, show it on the screen via css class */
				dojo.addClass('administration-menu', 'show');
				
				StorageManager.setSessionItem('atcb_admin_menu', $('admin_menu_items').innerHTML);
				console.log(':: MM --> Admin menu created from REST call');
			}

		}
		
		//Store the HTML in session storage
		StorageManager.setSessionItem('atcb_mm', $('navigation-wrap').innerHTML);
		
		try {
			var _currentUrl = document.URL;
			if(_currentUrl.indexOf('account-overview') > -1){
				//solutions menu for CAF Overview Page only
				var solutionsMenusExist = false;
				
				if(data.CAFNavigation !== undefined){
					dojo.forEach(data.CAFNavigation, function(item, i){
						dojo.place("<li><a href='"+item.url+"' id='"+item.id+"' target='"+item['window-target']+"'>"+item.name+"</a></li>", 'assigned-solutions');
						solutionsMenusExist = true;
					});
					
					if(solutionsMenusExist){
						/* solutions menu exists, show it on the screen via css class */
						dojo.addClass('solutions-list', 'active');
						
						StorageManager.setSessionItem('atcb_solutions', $('assigned-solutions').innerHTML);
						console.log(':: MM --> Admin menu created from REST call');
					}
				}
			}
		} catch (e){
			console.log(e);
		}
		
		
		/* rescan the page and instantiate the js modules */
		var moduleElements = dojo.query('#navigation-wrap [data-module-type]');
	    moduleElements.forEach(function (node) {
			var moduleTypes = node.getAttribute('data-module-type').split(' ');
			if(moduleTypes[0] === "MainNav"){
				console.log(':: MM --> Processing a new: ' + moduleTypes[0]);
				var module = new CHBB.MainNav(node);
			} else if(moduleTypes[0] === "SubNav"){
				console.log(':: MM --> Processing a new: ' + moduleTypes[0]);
				var module = new CHBB.SubNav(node);
			} else if(moduleTypes[0] === "Drawer"){
				console.log(':: MM --> Processing a new: ' + moduleTypes[0]);
				var module = new CHBB.Drawer(node);
			}
		});
		
	}, 
	sessionDataMapper: function(storedData){
		//$('mega-menu').innerHTML = storedData;
		
		console.log('### Mega Menu built with sessionStorage data');
		$('navigation-wrap').innerHTML = storedData;
		var storedAdminMenuData = StorageManager.getSessionStoredData('atcb_admin_menu');
		if(storedAdminMenuData){
			$('admin_menu_items').innerHTML = storedAdminMenuData;
			console.log(':: MM --> Admin Menu built with sessionStorage data');
			
			/* admin menu exists, show it on the screen via css class */
			dojo.addClass('administration-menu', 'show');
		}
		
		try{
			var _currentUrl = document.URL;
			if(_currentUrl.indexOf('account-overview') > -1){
				var storedSolutionsMenu = StorageManager.getSessionStoredData('atcb_solutions');
				if(storedSolutionsMenu){
					$('assigned-solutions').innerHTML = storedSolutionsMenu;
					console.log(':: MM --> Solutions Left Menu built with sessionStorage data');
					
					/* CAF left menu exists, show it on the screen via css class */
					dojo.addClass('solutions-list', 'active');
				}
			}

		} catch (e){
			console.log(e);
		}
	},
	setLogoContext: function(){
		var urlContext = StorageManager.getSessionStoredData('portalContext');
		if(urlContext){
			//give the logos the correct href value, so that navigation to @chubb works
			$('navigation-heading').href = urlContext + '/jsp/home.faces';
			$('application-logo-link').href = urlContext + '/jsp/home.faces';
			$('mobile-logo-link').href = urlContext + '/jsp/home.faces';
		}
	}
};



var StorageManager = {
	site: "chubb",
	isStorageAvailable: function(){
		if(typeof(Storage)!=="undefined" && typeof(Storage)!== null){
		  return true;
		} else {
		  return false;
		}
	},
	getSessionStoredData: function(category){
		var retrievedObject = null;
		try {
			if(StorageManager.isStorageAvailable()){
				retrievedObject = sessionStorage.getItem(category);
			} 
		} catch (e){
		  console.log('Error in main.js StorageManager.getStoredData: Error is= ' + e);
		}

		return retrievedObject;
	},
	setSessionItem: function(context, data){
		if(StorageManager.isStorageAvailable()){
			sessionStorage.setItem(context, data);
		}
		
	},
	clearLocalStorage: function(){
		console.log('clearing old localStorage');
		sessionStorage.clear();
		return true;
	}
	
};

var RestManager = {
	execute: function(){
			var start = new Date().getTime();
			var end;

			//get the context of the menus call
			dojo.xhrGet({  
		  	 	 url: "/PortalResource/ws/resource/menuPath",
				 //url : $('txtPortalResourceUrl').value,
		  	 	 preventCache : true,
		  	 	 headers: { "Content-Type": "application/json; charset=utf-8"},
		  	 	 handleAs: "json",
		  	 	 load: function(reply) { 
					end = new Date().getTime();
					console.log(':: Got context URL in: ', end - start + 'ms.');
					try {
						if(reply != null && reply.responseItem != null){
							//call menus service and create the menus with json received
							var resourceUrl = reply.responseItem.resourceURL;
							RestManager.getAtChubbMenus(resourceUrl);
							
							//give the logos the correct href value, so that navigation to @chubb works
							$('navigation-heading').href = resourceUrl + '/jsp/home.faces';
							$('application-logo-link').href = resourceUrl + '/jsp/home.faces';
							$('mobile-logo-link').href = resourceUrl + '/jsp/home.faces';
							StorageManager.setSessionItem('portalContext', resourceUrl);

						}
					} catch (e) {
						// TODO: handle exception
						console.log(e);
					}
					
		  	 	 },
			     error : function (error){
			    	 //No need to show message.
			    	 console.log(error);
			     }
			});
	},
	getAtChubbMenus : function (context){
			console.log(context);
			var start = new Date().getTime();
			var end;
			var restUrl = context + '/portalService/menus/user';
			dojo.xhrPost({
		  	 	 url: restUrl,
		  	 	 preventCache : true,
		  	 	 headers: { "Content-Type": "application/json; charset=utf-8"},
		  	 	 handleAs: "json",
		  	 	 load: function(reply) {
					atCbMegaMenuClientMgr.createMegaMenu(reply);  //build the html with the json
					//StorageManager.setSessionItem('atcb_mm', $('mega-menu').innerHTML);  //store mega menu html in session storage
							
					end = new Date().getTime();
					console.log(':: MM --> @ Mega Menu created via REST/dojo in ', end - start + 'ms.');
	 	 			
		  	 	 },
			     error : function (error){
			    	 //handle ajax call errors
			    	 console.log(error);
			     }
			});
		}
};

(function(){
	atCbMegaMenuClientMgr.init();
})();

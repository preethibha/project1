<%-- tpl:insert page="/templates/CAFTemplate.jtpl" --%><!DOCTYPE HTML>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8 ie7"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9 ie8"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">

<%-- tpl:put name="headarea" --%><title>Chubb | Account Overview</title><%-- /tpl:put --%>

<link href="${pageContext.request.contextPath}/css/grid.css" media="screen" rel="stylesheet" type="text/css" />
<!--[if lte IE 8]><link href="${pageContext.request.contextPath}/css/oldie.minified.css?112814" media="screen" rel="stylesheet" type="text/css" /><![endif]-->
<!--[if gt IE 8]><!-->
    <link href="${pageContext.request.contextPath}/css/chubb.minified.css?20161201" media="screen" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/responsive.minified.css?20161205" media="" rel="stylesheet" type="text/css" />
<!--<![endif]-->

<link href="${pageContext.request.contextPath}/css/application.css?20161130" media="screen" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/cb-icons-and-alerts.css" media="screen" rel="stylesheet" type="text/css" />

<script src="https://static.chubb.com/UXF/atchub/js/head.minified.js?20161122"></script>

</head>
<f:view>
	<body>

		<h:inputHidden id="txtUserType" value="#{cafBean.userType}"></h:inputHidden>
		<h:inputHidden id="txtUserId" value="#{cafBean.userId}"></h:inputHidden>


		<div id="container">
        	
        	<div id="wrapper">
        	
        	
        		<div id="navigation-wrap"> 
				  
					<a id="navigation-heading" href="/AtChubb/jsp/home.faces"><span>Home</span></a>
					<div id="utility-dropdowns">
						<div class="drawer-ui" data-module-type="Drawer" data-drawer-type="Accordion" data-accordion-mq="(min-width: 768px)">
							<a href="#" id="account-link" class="drawer-toggle"><span id="profile-user-name">Welcome <h:outputText value="#{cafBean.userFirstName}"></h:outputText>
							</span></a>
							<div id="account-menu" class="drawer-content">
								<a href="${pageContext.request.contextPath}/html/edit-profile.html?001" data-modal-url="html/edit-profile-modal.html" data-module-type="Modal">Edit Profile</a>
								<a href="${pageContext.request.contextPath}/html/change-password.html" data-modal-url="html/change-password-modal.html" data-module-type="Modal">Change Password</a>
								<a href="https://extpga01.chubb.com/atChubb/en_US/6673401.html" target="_blank">Information Services Agreement</a>
								<a href="#" onclick="logout();">Log Out</a>
							</div>
						</div>
					
						<div id="administration-menu" class="drawer-ui" data-module-type="Drawer">
		       				<a href="#" class="drawer-toggle"><span>Administration</span></a>
					        <div id="admin_menu_items" class="drawer-content">
								
					        </div>
		   				</div>
					
					</div>
					<div id="tabs" role="navigation" data-module-type="MainNav">
						<div id="tabs-internal">
	
							<div class="nav__item logo">
								<a id="application-logo-link" href="/AtChubb/jsp/home.faces" class="nav__link"><img src="${pageContext.request.contextPath}/images/logo_2x.png" alt="Chubb logo" /></a>
							</div>
	
						</div>
						<ul class="nav__list" id="mega-menu"></ul>
					</div><!-- END #tabs -->
		
			
		
					<div id="session_nav">    				
						<ul id="utility-links">
							<li class="chubb-actual"><a href="http://www.chubb.com" onclick="return jsPageManager.processClick(this, 'HD');" target="_blank">Chubb.com</a></li>
							<li class="report-a-claim"><a href="http://www.chubb.com/businesses/claims/chubb1304.html" onclick="return jsPageManager.processClick(this, 'HD');" target="_blank">Report a Claim</a></li>
							<li class="forms-and-applications"><a href="http://search.chubb.com/formsearch/" onclick="return jsPageManager.processClick(this, 'HD');" target="_blank">Forms &amp; Applications</a></li>
							<li class="help"><a href="https://extpga01.chubb.com/atChubb/en_US/atChubbHelpPage.html" onclick="return jsPageManager.processClick(this, 'HD');" target="_blank">Help</a></li>
							<li class="help"><a href="#" onclick="oo_inline.show()">Site Feedback [+]</a></li>
						</ul>
					</div>
		 
				</div><!-- end of navigation-wrap -->
        	
		        <div id="message-bar" class="drawer-ui" data-module-type="MessageBar">
					<a href="#" class="menu-button" data-module-type="MobileMenu">
						<span>Menu</span>
					</a>
					<div id="message-bar-bottom">
						<div id="message-bar-bottom-right"></div>
						<div id="message-bar-toggle" class="drawer-toggle"><span id="message-count"></span>Important Notices</div>
						<div id="message-bar-bottom-left"></div>
					</div>
					<div id="mobile-logo">
						<a id="mobile-logo-link" href="/AtChubb/jsp/home.faces"><img src="${pageContext.request.contextPath}/images/logo.png" alt="Chubb logo for mobile" /></a>
					</div>
					<div class="drawer-content alt-version">
						<span class="drawer-toggle drawer-close">Close</span>
						<div id="importantMsgs"></div>
					</div>
				</div>
			
			
			<%-- tpl:put name="bodyarea" --%><!-- new content to be integrated starts here!! -->
			<a id="linkShowContact" data-module-type="Modal" data-modal-url="html/contacts-modal.html?1" href="html/contacts.html?1" style="display:none">Hidden Link</a>
			<div id="main-content" role="main">
				<div id="landing-layout" class="account-file">
					<div class="page-body-wrap">
						
						<div id="system-messages">
    						<span id="errorBox"></span>
    					</div>
							
						<!-- SECTION WITH MULTIPLE ACCOUNTS -->
						<div id="select-an-account-section">

							<div class="grid">
								<div class="col-6-12">
									<div class="page-title-area">
										<h2>Select an Account</h2>
									</div>
								</div>
								<div class="col-6-12">
									<div class="content ar">
										<div id="search-again-block" class="active">
											<a href="javascript:void(0);" id="select-an-account-option" onclick="PageMgr.newSearch(this);" class="link-search-again"><img src="images/clear.png" class="icon-search-again"/>Search Again</a>
										</div>
										<div id="new-search-area" class="new-search">
											<div class="search-body">
												<select id="select-search-options" class="select-search-options">
													<option value="account-name">Account Name</option>
													<option value="policy-number">Policy Number</option>
												</select>
												<input type="text" id="txtUserSearchInput" class="user-search-input" maxlength="60" tabindex="1">
												<a href="javascript:void(0)" onclick="PageMgr.processNewSearch('section-a');" class="common-button smaller">Search</a>
											</div>
										
										</div>
									</div>
								</div>
							</div>
						
							<div class="data-grid-area">
							
									<!-- error/warning or other messages -->
									<div id="select-account-message-area" class="message-area info">
										<div>
											<img src="images/clear.png">
												<div id="select-account-message"></div>
										</div>
									</div>
							
								<div class="data-grid">
									<div id="select-account-grid" class="data-headers">
										<table>
											<thead>
												<tr class="active">
													<th class="_40"><a href="javascript:void(0);" data-sort-method="alpha" data-column-name="insuredName">Account Name</a></th>
													<th class="_60"><a href="javascript:void(0);" data-sort-method="alpha" data-column-name="insuredAddress">Address</a></th>
												</tr>
											</thead>
										</table>
									</div>
									<!-- data blocks -->
									<div id="select-account-grid-items">
									</div><!--  end of #data-grid-items -->
								</div><!-- end of .data-grid -->
							</div><!-- end of .data-grid-area -->
						</div><!-- end of #select-an-account-section -->
					
						<!-- SECTION WITH 1 ACCOUNT SHOWING POLICY INFO -->
						<div id="account-detail-section">
							<div class="grid">
								<div class="col-6-12">
									<div class="page-title-area">
										<h2><img src="images/icon_account_overview.png" class="icon-acct-overview-title" /> Account Overview</h2>
									</div>	
								</div>
								<div class="col-6-12">
									<div class="content ar">
										<div id="search-again-block-b" class="active">
											<a href="javascript:void(0);" id="acct-overview-option" onclick="PageMgr.newSearch(this);" class="link-search-again"><img src="images/clear.png" class="icon-search-again"/>Search Again</a>
										</div>
										<div id="new-search-area-b" class="new-search">
											<div class="search-body">
												<select id="select-search-options-b" class="select-search-options">
													<option value="account-name">Account Name</option>
													<option value="policy-number">Policy Number</option>
												</select>
												<input type="text" id="txtUserSearchInput-b" class="user-search-input" maxlength="60" tabindex="1">
												<a href="javascript:void(0)" onclick="PageMgr.processNewSearch('section-b');" class="common-button smaller">Search</a>
											</div>
										
										</div>
									</div>
								</div>
							</div>
			
							<div class="landing-main float-options-left">
								<div class="grid">
									<div class="col-1-1">
										<div class="content">
											
											<!-- Account level info -->
											<div class="fixed-left-content">
												<div class="_module light-gray">
													<div class="header">Account Summary</div>
													<div class="body">
														<div id="account-name"></div>
														<div id="account-mailingAddress"></div>
													</div>
												</div>
												<div id="solutions-list" class="_module light-gray">
													<div class="header">Solutions</div>
													<div class="body">
														<ul id="assigned-solutions">
														</ul>
													</div>
												</div>
											</div>
										
											<!-- grid area -->
											<a href="javascript:void(0);" id="link-select-diff-acct" onclick="PageMgr.showSelectAccountSection();">&laquo; Return to search results</a>
											<h2 class="grid-title" id="pol-summary-title">Policy Summary</h2>
											<div class="data-grid-area">	
												<div class="data-grid" id="pol-grid-wrapper">
													<div id="policy-grid" class="data-headers">
														<table>
															<thead>
																<tr class="active">
																	<th class="_20"><a href="javascript:void(0);" data-sort-method="alpha" data-column-name="policyNumber">Policy Number</a></th>
																	<th class="_25"><a href="javascript:void(0);" data-sort-method="alpha" data-column-name="displayProductTypeName">Product</a></th>
																	<th class="_25"><a href="javascript:void(0);" data-sort-method="alpha" data-column-name="policyTerm">Policy Term</a></th>
																	<th class="_20"><a href="javascript:void(0);" data-sort-method="alpha" data-column-name="policyStatus">Status</a></th>
																	<th class="_10 ca">Contacts</th>
																</tr>
															</thead>
														</table>
													</div>
													<!-- data blocks -->
													<div id="policy-grid-items"></div><!--  end of #data-grid-items -->
												
												</div><!-- end of .data-grid -->
							
											</div><!-- end of .data-grid-area -->
											
											<div class="data-grid-area" id="addl-pol-grid-holder">
												<div class="grid-description">Additional policies associated with this Account</div>	
												<div class="data-grid">
													<div id="additional-policy-grid" class="data-headers">
														<table>
															<thead>
																<tr class="active">
																	<th class="_20"><a href="javascript:void(0);" data-sort-method="alpha" data-column-name="policyNumber">Policy Number</a></th>
																	<th class="_25"><a href="javascript:void(0);" data-sort-method="alpha" data-column-name="displayProductTypeName">Product</a></th>
																	<th class="_25"><a href="javascript:void(0);" data-sort-method="alpha" data-column-name="policyTerm">Policy Term</a></th>
																	<th class="_20"><a href="javascript:void(0);" data-sort-method="alpha" data-column-name="policyStatus">Status</a></th>
																	<th class="_10 ca">Contacts</th>
																</tr>
															</thead>
														</table>
													</div>
													<!-- data blocks -->
													<div id="additional-policy-grid-items"></div><!--  end of #data-grid-items -->
												
												</div><!-- end of .data-grid -->
							
											</div><!-- end of .data-grid-area -->
											
										</div><!--  end of .content -->
									</div>
								</div>
							</div><!-- end of: landing-main float-options-left -->
						</div><!-- end of #account-detail-section -->
					
						<!-- SECTION WITH NO RESULTS -->
						<div id="no-results-section">
							<div class="page-title-area">
									<h2><img src="images/icon_account_overview.png" class="icon-acct-overview-title" /> Account Overview</h2>
							</div>	
							<div class="message-area info">
								<div>
									<img src="images/clear.png">
										<span id="app-search-error-msg">Your search did not return any results.  Please search again.</span>
								</div>
							</div>
							<div id="new-search-area-c" class="new-search">
								<div class="search-body">
									<p id="searchErrorList-c"></p>
									<select id="select-search-options-c" class="select-search-options">
										<option value="account-name">Account Name</option>
										<option value="policy-number">Policy Number</option>
									</select>
									<input type="text" id="txtUserSearchInput-c" class="user-search-input" maxlength="60" tabindex="1">
									<a href="javascript:void(0)" onclick="PageMgr.processNewSearch('section-c');" class="common-button smaller">Search</a>
								</div>
							
							</div>
						</div>
					</div>
				</div>
			</div><!--end of Main-->
			
			<div class="black_overlay" id="splashWindow"></div>
			<!-- Messages Box  -->
			<div id="notice-block">
				<div class="body">
					<div id="box-message">Loading please wait</div>
				</div>
		
			</div>
			
			<%-- /tpl:put --%>
			<div id="footer">
						<div id="footer-content">
							<h2 class="footer-header">Chubb. Insured.</h2>			
							<ul>
								<li class="copyright">&copy; 
									<script type="text/javascript">document.write(new Date().getFullYear());</script> Chubb 
								</li>
								
								<li><a class="links" href="https://www2.chubb.com/us-en/terms-of-use.aspx">Legal Notices</a></li>
								<li><a class="links" href="https://www2.chubb.com/us-en/privacy.aspx">Privacy Policy</a></li>
								<li><a class="links" href="https://www2.chubb.com/us-en/agents-brokers/Producer-Compensation.aspx">Producer Compensation</a></li>
								<li><a class="links" href="https://www2.chubb.com/us-en/careers/">Careers</a></li>
								<li><a class="links" href="https://www2.chubb.com/us-en/contact-us/contact-landing-page.aspx">Contact Us</a></li>
								
							</ul>
						</div>
					</div>	
			
		    </div><!--end of wrapper -->
    	</div><!--end of container -->
    	
    	
		<script type="text/javascript">
	        /*setting dojoConfig as follow to avoid unsecure content messages to the user */
	        dojoConfig = {
	            parseOnLoad: true,
	            baseUrl: 'https://static.chubb.com/dojo-release-1.6.1/dojo/',
	            dojoBlankHtmlUrl: 'resources/blank.html',
	            modulePaths: {
	                "dojo": "https://static.chubb.com/dojo-release-1.6.1/dojo",
	                "dijit": "https://static.chubb.com/dojo-release-1.6.1/dijit",
	                "dojox": "https://static.chubb.com/dojo-release-1.6.1/dojox"
	            }
	        }; 
	
	    </script> 

	    <script src="https://static.chubb.com/dojo-release-1.6.1/dojo/dojo.xd.js"></script>
		<script src="${pageContext.request.contextPath}/js/main.minified.js?08162014"></script> 
		<script src="${pageContext.request.contextPath}/js/application.js?20161123"></script> 
		<script src="${pageContext.request.contextPath}/js/megaMenuManager.js?071715"></script> 


			<!-- Web Analytics Page Tagging Code -->
		<script type="text/javascript">
		 var NTPT_SET_IDCOOKIE = true;
		 var NTPT_IDCOOKIE_NAME = "cbSessionID";
		 var NTPT_IDCOOKIE_DOMAIN = ".chubb.com";
		</script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/chubbpt.js"></script>
		<noscript>
			<img src="${pageContext.request.contextPath}/images/cbanalytics.gif?js=0" height="1" width="1" border="0" hspace="0" vspace="0" alt="">
		</noscript>
		<!-- Web Analytics Page Tagging Code end -->
		
		
		
		<!--
		OnlineOpinion v5.7
		Released: 3/6/2013. Compiled 03/06/2013 01:59:16 PM -0600
		Branch: master 8d549bbb6d7ff935b4572cf4e62e305e6cd843d7
		Components: Full
		The following code is Copyright 1998-2013 Opinionlab, Inc.  All rights reserved. Unauthorized use is prohibited. This product and other products of OpinionLab, Inc. are protected by U.S. Patent No. 6606581, 6421724, 6785717 B1 and other patents pending. http://www.opinionlab
		-->
		
		<!-- MAIN OL STYLESHEET -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/onlineopinionv5/oo_style.css" />
		<!-- MAIN OL ENGINE -->
		<script type="text/javascript" charset="windows-1252" src="${pageContext.request.contextPath}/onlineopinionv5/oo_engine.min.js"></script>
		
		<!-- FEEDBACK CONFIGURATION -->
		<script type="text/javascript" charset="windows-1252" src="${pageContext.request.contextPath}/onlineopinionv5/oo_conf_inline.js"></script>
		<noscript>This JavaScript enables OnlineOpinion, a method for collecting secure feedback data.</noscript>
		<!-- END: OnlineOpinion v5.7 -->
		
	
		<%-- tpl:put name="additional_js" --%>
		<script src="${pageContext.request.contextPath}/js/cbDataGrid.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/contactsModalMgr.js" type="text/javascript"></script>
   		<script src="${pageContext.request.contextPath}/js/accountOverviewMgr.js" type="text/javascript"></script>

   				<script type="text/javascript">
		/* add js here for a particular page */
		</script>
   	<%-- /tpl:put --%>

	</body>
</f:view>
</html><%-- /tpl:insert --%>
<%-- jsf:pagecode language="java" location="/src/main/java/pagecode/Index.java" --%><%-- /jsf:pagecode --%>
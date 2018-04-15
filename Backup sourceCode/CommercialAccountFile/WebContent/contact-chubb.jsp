<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- tpl:insert page="/templates/StandaloneAppTemplate.jtpl" --%><!DOCTYPE HTML>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8 ie7"> <![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9 ie8"> <![endif]-->
<!--[if gt IE 8]><!--><html class="no-js"><!--<![endif]-->
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=2">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cb-icons-and-alerts.css" type="text/css">
<link href="${pageContext.request.contextPath}/css/grid.css" media="screen" rel="stylesheet" type="text/css" />
<!--[if gt IE 8]><!-->
<link href="${pageContext.request.contextPath}/css/chubb.minified.css?20161121" media="screen" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/responsive.minified.css?20161121" media="only screen and (max-width: 1023px)" rel="stylesheet" type="text/css" />
<!--<![endif]-->
<!--[if lte IE 8]><link href="css/oldie.minified.css?122324" media="screen" rel="stylesheet" type="text/css" /><![endif]-->

<link href="${pageContext.request.contextPath}/css/application.css" media="screen" rel="stylesheet" type="text/css" />

<style>
.stand-alone-options #utility-links {
    float: right;
    margin-right: 30px;}
.nav__item.logo img {
    width: 273px;}
#message-bar .menu-button {
    display: none;
    float: left;}
.book-of-biz .page-title-area {
    display: none;}
#contact-chubb-modules > div {
    margin-top: 30px;}
#mobile-logo.stand-alone-app img {
    height: 35px;
    margin-left: -22px;
    padding-bottom: 10px;
    width: 137px;}
</style>

<script src="https://static.chubb.com/UXF/atchub/js/head.minified.js?08162013"></script>
<%-- tpl:put name="headarea" --%><title>Chubb | Contact Chubb Book of Business</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/tooltip.css" type="text/css">
<%-- /tpl:put --%>

</head>
<f:view>
	<body>

		<h:inputHidden id="txtUserType" value="#{cafBean.userType}"></h:inputHidden>
		<h:inputHidden id="txtUserId" value="#{cafBean.userId}"></h:inputHidden>

		<div id="container">
			<div id="wrapper">
        	
        		<div id="navigation-wrap">
					<a id="navigation-heading" href="#"><span>Home</span></a>

					<div id="tabs" role="navigation" data-module-type="MainNav">
						<div id="tabs-internal">
	
							<div class="nav__item logo">
								<a href="#" class="nav__link"><img alt="Contact Chubb Logo" src="${pageContext.request.contextPath}/images/logo_2x_contact_cb.png" /></a>
							</div>
						</div>
					</div>
					<!-- END #tabs -->
				
					<div id="session_nav" class="stand-alone-options">
						<ul id="utility-links">
							<li><a id="contactUs" href="http://www.chubb.com/marketing/chubb2340.html">Contact Us</a></li>
							<!--li><a onclick="oo_inline.show()" href="#">Site Feedback [+]</a></li-->		 					
						</ul>
					</div>

				</div>
				<!-- end #navigation-wrap -->
				<div id="message-bar" class="drawer-ui" data-module-type="MessageBar">
					<a href="#" class="menu-button" data-module-type="MobileMenu"> <span>Menu</span> 
					</a>
					<div id="mobile-logo" class="stand-alone-app">
						<a href="#"><img alt="Chubb logo for mobile"
							src="${pageContext.request.contextPath}/images/mobile_logo.png" /></a>
					</div>
				</div>

		<%-- tpl:put name="bodyarea" --%><!-- new content to be integrated starts here!! -->
			<div id="main-content" role="main">
				<div id="landing-layout" class="account-file book-of-biz">
					<div class="page-title-area">
						<h2><img src="images/clear.png" class="icon-screen-large" /> Contact Chubb</h2>
					</div>
					<div id="system-messages">
    						<span id="errorBox"></span>
    				</div>
					<div class="landing-main">
						<div class="grid">
							<div class="col-1-1">
								<div id="contact-chubb-modules">
									
									<div id="contact-book-of-business-mod" class="_module large blue-gray">
										<div class="header"><a href="javascript:void(0);" onclick="PageMgr.toggleMods('bob-mod');"><img class="grid-arrow" src="images/clear.png"> <span>Contacts For Your Book Of Business</span></a></div>
										<div class="body">
											<!-- grid area -->
											<h2 class="">Select Producer Code</h2>
											
											<div id="non-chubb-emp-msg">Your user id is associated with the following producer code(s).  Please select one from the list below.</div>
											
											<div id="cb-emp-search">
											
												<div>Search for a Producer</div>
													<input type="text" placeholder="Producer Number *" id="txtProducerNumber" maxlength="7">
													<input type="text" placeholder="Sub Producer Number" id="txtSubProdNumber" maxlength="5">
													<a class="common-button" id="btn-search" onclick="return BookOfBusManager.processEmpSearch();" href="javascript:void(0)">Search</a>

											</div>
											<div id="book-of-bus-data" class="data-grid-area">	
												<div class="data-grid">
													<div id="producers-grid" class="data-headers">
														<table>
															<thead>
																<tr class="active">
																	<th class="_3">&nbsp;</th>
																	<th class="_42"><a href="javascript:void(0);" data-sort-method="alpha" data-column-name="producerName">Producer Name</a></th>
																	<th class="_20"><a href="javascript:void(0);" data-sort-method="alpha" data-column-name="prodAndProdSubNumber">Producer Number</a></th>
																	<th class="_35"><a href="javascript:void(0);" data-sort-method="alpha" data-column-name="mailingAddress">Address</a></th>
																</tr>
															</thead>
														</table>
													</div>
													<!-- data blocks -->
													<div id="producers-grid-items"></div><!--  end of #data-grid-items -->
												</div><!-- end of .data-grid -->
												
										<div class="email-widget">
											<div class="grid">
												<div class="col-7-12">
													<div class="content">
														A spreadsheet with details of your book will be sent to the following email address: <a id="account_icon" class="tooltip" href="javascript:void(0);"><img src="images/info_icon.png" alt="Info Icon"></a>
													</div>
												</div>
												<div class="col-5-12">
													<div class="content">
														<div id="email-addres-and-button">
															<input type="text" tabindex="1" maxlength="60" class="field-input" value="#{cafBean.emailAddress}" id="txtEmailAddress" data-placeholder="Email Address" placeholder="Email Address" onkeyup="PageMgr.checkEmailChange(this);"> <a class="common-button" href="javascript:void(0);" onclick="ContactsByProdMgr.emailBookOfBusiness();">Submit</a>
														</div>
														<div id="update-profile-query">
															<input type="checkbox" name="update-profile" id="update-profile" value="yes"> Update profile?
														</div>
													</div>
												</div>
											</div>
											
											<div id="email-msg-area">
												<ul id="email-mgs">
													<li id="spreadsheet-li"><img id="spreadsheet-img" src="images/clear.png"><span id="spreadsheet-span"></span><span id="agency-span" style="text-transform: capitalize;"></span><span id="email-span"></span></li>
													<li id="profile-li"><img id="profile-img" src="images/clear.png"><span id="profile-span"></span></li>
												</ul>
											</div>
										</div>
												
												
											</div><!-- end of .data-grid-area -->
											
																	
									</div>		
									<!-- code added for PASCode Starts -->
											<div class="body">
											<!-- grid area -->
											<h2 class="">Select PAS Code</h2>
											
											<div id="cb-emp-pas-search">
												<div>Search for a PAS</div>
													<input type="text" placeholder="PAS Number *" id="txtPasNumber" maxlength="6">
													<!-- <input type="text" placeholder="Sub PAS Number" id="txtSubPasNumber" maxlength="5"> -->
													<a class="common-button" id="btn-PASsearch" onclick="return BookOfBusManager1.processPASSearch();" href="javascript:void(0)">Search</a>

											</div>
											
											<div id="book-of-bus-PAS-data" class="data-grid-area">	
												<div class="data-grid">
													<div id="pas-grid" class="data-headers">
														<table>
															<thead>
																<tr class="active">
																	<th class="_3">&nbsp;</th>
																	<th class="_42"><a href="javascript:void(0);" data-sort-method="alpha" data-column-name="passName">PAS Name</a></th>
																	<th class="_20"><a href="javascript:void(0);" data-sort-method="alpha" data-column-name="passAndpassSubNumber">PAS Number</a></th>
																	<th class="_35"><a href="javascript:void(0);" data-sort-method="alpha" data-column-name="mailAddress">Address</a></th>
																</tr>
															</thead>
														</table>
													</div>
													<!-- data blocks -->
													<div id="pas-grid-items"></div><!--  end of #data-grid-items -->
												</div><!-- end of .data-grid -->
												
										<div class="email-widget">
											<div class="grid">
												<div class="col-7-12">
													<div class="content">
														A spreadsheet with details of your book will be sent to the following email address: <a id="account_icon" class="tooltip" href="javascript:void(0);"><img src="images/info_icon.png" alt="Info Icon"></a>
													</div>
												</div>
												<div class="col-5-12">
													<div class="content">
														<div id="email-addres-and-button">
															<input type="text" tabindex="1" maxlength="60" class="field-input" value="#{cafBean.emailAddress}" id="txtEmailAddress" data-placeholder="Email Address" placeholder="Email Address" onkeyup="PageMgr.checkEmailChange(this);"> <a class="common-button" href="javascript:void(0);" onclick="ContactsByProdMgr.emailBookOfBusiness();">Submit</a>
														</div>
														<div id="update-profile-query">
															<input type="checkbox" name="update-profile" id="update-profile" value="yes"> Update profile?
														</div>
													</div>
												</div>
											</div>
											
											<div id="email-msg-area">
												<ul id="email-mgs">
													<li id="spreadsheet-li"><img id="spreadsheet-img" src="images/clear.png"><span id="spreadsheet-span"></span><span id="agency-span" style="text-transform: capitalize;"></span><span id="email-span"></span></li>
													<li id="profile-li"><img id="profile-img" src="images/clear.png"><span id="profile-span"></span></li>
												</ul>
											</div>
										</div>
												
												
											</div><!-- end of .data-grid-area -->
											
											<!-- code added for PAScode Ends -->
										</div>					

									<div id="contact-for-product-mod" class="_module large blue-gray">
										<div class="header"><a href="javascript:void(0);" onclick="PageMgr.toggleMods('prd-mod');"><img class="grid-arrow" src="images/clear.png"> <span>Contacts By Product</span></a></div>
										<div class="body">
											<h2>Select a Product and a Branch</h2> <a id="select_branch_tip_icon" class="tooltip" href="javascript:void(0);"><img src="images/info_icon.png" alt="Info Icon"></a>
											<div id="search-by-product-area">
											   <select class="field-select" id="select-product" name="productName" onchange="ContactsByProdMgr.setProductName(this.options[this.selectedIndex].text);">
													<!-- <select id="select-product">
													<option value="">Select a Product</option> -->
												</select>
												<select class="field-select" id= "select-branch" name="branchName" onchange="ContactsByProdMgr.setBranchName(this.options[this.selectedIndex].text);">
													<!-- <option value="">Select a Branch</option> -->
												</select>
												<a class="common-button" onclick="ContactsByProdMgr.getContacts();" href="javascript:void(0)">Submit</a>
											</div>
											<div id="products-contacts-results">
												<!-- grid area -->
												<span id="selected-product"></span><span id="selected-branch"></span>
												<div class="data-grid-area">	
													<div class="data-grid">
														<div id="contacts-grid" class="data-headers">
															<table>
																<thead>
																	<tr class="active">
																		<th class="_30"><a href="javascript:void(0);" data-sort-method="alpha" data-column-name="name">Name</a></th>
																		<th class="_15"><a href="javascript:void(0);" data-sort-method="alpha" data-column-name="role">Role</a></th>
																		<th class="_15">Work Phone</th>
																		<th class="_15">Cell Phone</th>
																		<th class="_25">Email</th>
																	</tr>
																</thead>
															</table>
														</div>
														<!-- data blocks -->
														<div id="contacts-grid-items"></div><!--  end of #data-grid-items -->
													
													</div><!-- end of .data-grid -->
												</div><!-- end of .data-grid-area -->
											
											</div>
											
											<div id="products-contacts-message-container" class="message-area info">
												<div>
													<img src="images/clear.png">
														<span>We are not able to locate a contact at this branch for the product selected. Please contact your local Chubb office. <a target="_blank" href="http://www.chubb.com/marketing/chubb2345.html">Click here</a> to find a Chubb office near you.</span>
												</div>
											</div>
											
										</div>
									</div>		
								</div><!-- end of .content -->
							</div>
						</div>
					</div>

					

				</div>
			</div>
			<div class="black_overlay" id="splashWindow"></div>
			<!-- Messages Box  -->
			<div id="notice-block">
				<div class="body">
					<div id="box-message">Loading please wait</div>
				</div>
		
			</div>
			<!-- new content to be integrated ends here!! --><%-- /tpl:put --%>

			<div id="footer">
				<div id="footer-links">
					<div class="footer-link"><a href="http://www.chubb.com/marketing/chubb2275.html" onclick="return jsPageManager.processClick(this, 'FT');" target="_blank">Legal Notices</a></div>
					<div class="footer-link"><a href="http://www.chubb.com/marketing/chubb2267.html" onclick="return jsPageManager.processClick(this, 'FT');" target="_blank">Privacy Policy</a></div>			
					<!--div class="footer-link"><a href="http://www.chubb.com/marketing/chubb7450.html" onclick="return jsPageManager.processClick(this, 'FT');" target="_blank">Producer Compensation</a></div-->
					<div class="footer-link"><a href="http://jobs.chubb.com/" onclick="return jsPageManager.processClick(this, 'FT');" target="_blank">Careers</a></div>
					<div class="footer-link"><a href="http://www.chubb.com/marketing/chubb2340.html" onclick="return jsPageManager.processClick(this, 'FT');" target="_blank">Contact Us</a></div>
					<p>Copyright &copy; 1995-<script type="text/javascript">document.write(new Date().getFullYear());</script> The Chubb Corporation</p>
				</div>
				<div class="social-links">
					<a href="https://twitter.com/ChubbInsurance" onclick="return jsPageManager.processClick(this, 'SL');" target="_blank" class="social-twitter">Twitter</a>
					<a href="http://www.facebook.com/#!/pages/Chubb-Insurance/195143962298?ref=ts" onclick="return jsPageManager.processClick(this, 'SL');" target="_blank" class="social-facebook">Facebook</a>
					<a href="http://www.youtube.com/user/ChubbInsurance" onclick="return jsPageManager.processClick(this, 'SL');" target="_blank" class="social-youtube">YouTube</a>
					<a href="http://www.chubb.com/marketing/chubb9386.html" onclick="return jsPageManager.processClick(this, 'SL');" target="_blank" class="social-rss">RSS</a>
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
		<script src="${pageContext.request.contextPath}/js/application.js?08152014"></script> 



	
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
		
		<!--  Initialize process to build the Mega Menu -->
		<script type="text/javascript">

		</script>
	
		<%-- tpl:put name="additional_js" --%>
		<script src="${pageContext.request.contextPath}/js/cbDataGrid.js" type="text/javascript"></script>
      	<script src="${pageContext.request.contextPath}/js/tooltip.minified.js"></script>
   		<script src="${pageContext.request.contextPath}/js/contactChubbMgr.js?20170317" type="text/javascript"></script>
   		
		<script type="text/javascript">
		/* add js here for a particular page */
		</script>
		<%-- /tpl:put --%>
			
			
	</body>
</f:view>
</html><%-- /tpl:insert --%>
<%-- jsf:pagecode language="java" location="/src/main/java/pagecode/Contactchubb.java" --%><%-- /jsf:pagecode --%>
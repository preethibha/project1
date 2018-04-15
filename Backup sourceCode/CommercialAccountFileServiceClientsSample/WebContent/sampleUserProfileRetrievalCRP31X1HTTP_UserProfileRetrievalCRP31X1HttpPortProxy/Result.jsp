<%@page contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
com.ibm.ccl.ws.jaxws.gstc.util.OutputUtils.init(session);

boolean async       = session.getAttribute("__async__") == null ? false : true;
String methodKey    = request.getParameter("key");
String resultSuffix = methodKey != null && methodKey.length() > 0 ? " - " + methodKey : "";
%>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
<LINK rel="stylesheet" type="text/css" href="TestClient.css"/>
<script language="JavaScript">

function reloadMethods() {
    window.parent.frames["methods"].location.reload(true);
}
</script>
</HEAD>
<BODY>
<TABLE class="heading" width="100%">
<TR><TD>Result<%= org.eclipse.jst.ws.util.JspUtils.markup(resultSuffix) %></TD></TR>
</TABLE>
<P>
<jsp:useBean id="sampleUserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPortProxyid" scope="session" class="com.test.crp31x1.UserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPortProxy" />

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

boolean isDone = true;
try {
    String sourceInTemp = request.getParameter("__rawxml__");
        javax.xml.transform.Source sourceIn  = sourceInTemp != null ?
            new javax.xml.transform.stream.StreamSource(new java.io.ByteArrayInputStream(sourceInTemp.getBytes())) : null;
    javax.xml.transform.Source sourceOut = null;

    boolean bypass = (sourceIn != null);

switch (methodID){ 
case 2:
    gotMethod = true;
    com.test.crp31x1.UserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPortProxy.Descriptor returnp3mtemp = null;
    if (methodKey != null) {
        javax.xml.ws.Response resp = com.ibm.ccl.ws.jaxws.gstc.util.AsyncUtils.getResponse(session, methodKey);
        if (resp != null) {
            isDone = resp.isDone();
            if (!isDone)
                break;
            if (resp.get() != null) {
                Object o = resp.get();
                if (o instanceof javax.xml.transform.Source)
                    sourceOut = (javax.xml.transform.Source) o;
                else if (o instanceof com.test.crp31x1.UserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPortProxy.Descriptor)
                    returnp3mtemp = (com.test.crp31x1.UserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPortProxy.Descriptor) o;
            }
        }
    }
    else if (bypass) {
        javax.xml.ws.Dispatch dispatch = sampleUserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPortProxyid._getDescriptor().getDispatch();

        if (request.getParameter("__use_soapaction__") != null)
            com.ibm.ccl.ws.jaxws.gstc.util.DispatchUtils.useSoapAction(dispatch, request.getParameter("__soapaction__"));
        else
            com.ibm.ccl.ws.jaxws.gstc.util.DispatchUtils.clearSoapAction(dispatch);

        if (!async)
            sourceOut = (javax.xml.transform.Source) dispatch.invoke(sourceIn);
        else {
            // async code omitted
            break;
        }
    } else {
        if (!async) {
        try {
            returnp3mtemp = sampleUserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPortProxyid._getDescriptor();
            }catch(Exception exc){
                %>
                Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(exc.toString()) %>
                Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(exc.getMessage()) %>
                <%
break;
            }
        }
        else {
            // async code omitted
            break;
        }
    }
if (sourceOut != null) {
%>
    <TEXTAREA ROWS="8" COLs="45"><%= org.eclipse.jst.ws.util.JspUtils.markup(com.ibm.ccl.ws.jaxws.gstc.util.SourceUtils.transform(sourceOut)) %></TEXTAREA>
<%
}
else {
if (returnp3mtemp == null) {
%>
    null
<%
} else {
    %>
    <TABLE CLASS="tableform">
<TR>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">returnp:</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="1" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">proxy:</TD>
<TD>
<%
if(returnp3mtemp != null){
com.test.crp31x1.UserProfileRetrievalCRP31X1 typeproxy5 = returnp3mtemp.getProxy();
if(typeproxy5 != null){
        if(typeproxy5!= null){
        String tempproxy5 = typeproxy5.toString();
        %>
        <%=tempproxy5%>
        <%
        }}
else{
        %>
        <%= typeproxy5%>
        <%
}
}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="1" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">dispatch:</TD>
<TD>
<%
if(returnp3mtemp != null){
javax.xml.ws.Dispatch typedispatch7 = returnp3mtemp.getDispatch();
if(typedispatch7 != null){
        if(typedispatch7!= null){
        String tempdispatch7 = typedispatch7.toString();
        %>
        <%=tempdispatch7%>
        <%
        }}
else{
        %>
        <%= typedispatch7%>
        <%
}
}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="1" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">endpoint:</TD>
<TD>
<%
if(returnp3mtemp != null){
java.lang.String typeendpoint9 = returnp3mtemp.getEndpoint();
if(typeendpoint9 != null){
        String tempResultendpoint9 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeendpoint9));
        %>
        <%= tempResultendpoint9 %>
        <%
}
else{
        %>
        <%= typeendpoint9%>
        <%
}
}
%>
</TD>
    </TABLE>
    <%
}
%>
<HR/><BR/>
<%
}
break;
case 13:
    gotMethod = true;
    com.test.crp31x1.GetUserProfileReply returnp14mtemp = null;
    if (methodKey != null) {
        javax.xml.ws.Response resp = com.ibm.ccl.ws.jaxws.gstc.util.AsyncUtils.getResponse(session, methodKey);
        if (resp != null) {
            isDone = resp.isDone();
            if (!isDone)
                break;
            if (resp.get() != null) {
                Object o = resp.get();
                if (o instanceof javax.xml.transform.Source)
                    sourceOut = (javax.xml.transform.Source) o;
                else if (o instanceof com.test.crp31x1.GetUserProfileReply)
                    returnp14mtemp = (com.test.crp31x1.GetUserProfileReply) o;
            }
        }
    }
    else if (bypass) {
        javax.xml.ws.Dispatch dispatch = sampleUserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPortProxyid._getDescriptor().getDispatch();

        if (request.getParameter("__use_soapaction__") != null)
            com.ibm.ccl.ws.jaxws.gstc.util.DispatchUtils.useSoapAction(dispatch, request.getParameter("__soapaction__"));
        else
            com.ibm.ccl.ws.jaxws.gstc.util.DispatchUtils.clearSoapAction(dispatch);

        if (!async)
            sourceOut = (javax.xml.transform.Source) dispatch.invoke(sourceIn);
        else {
            // async code omitted
            break;
        }
    } else {
        %>
        <jsp:useBean id="com1test1crp31x11GetUserProfileRequest_0id" scope="session" class="com.test.crp31x1.GetUserProfileRequest" />
        <%
        String getUserProfileRequest58null = request.getParameter("getUserProfileRequest58null");
        if (getUserProfileRequest58null != null)
            com1test1crp31x11GetUserProfileRequest_0id = null;
        else {
        %>
        <jsp:useBean id="com1test1crp31x11UserProfileIdentifier_1id" scope="session" class="com.test.crp31x1.UserProfileIdentifier" />
        <%
        String userProfileIdentifier60null = request.getParameter("userProfileIdentifier60null");
        if (userProfileIdentifier60null != null)
            com1test1crp31x11UserProfileIdentifier_1id = null;
        else {
        String externalUserId_2id=  request.getParameter("externalUserId62");
        String externalUserId62null = request.getParameter("externalUserId62null");
        java.lang.String externalUserId_2idTemp;
        if (externalUserId62null != null)
            externalUserId_2idTemp = null;
        else {
         externalUserId_2idTemp  = externalUserId_2id;
        }
        String personGIN_4id=  request.getParameter("personGIN64");
        String personGIN64null = request.getParameter("personGIN64null");
        java.lang.String personGIN_4idTemp;
        if (personGIN64null != null)
            personGIN_4idTemp = null;
        else {
         personGIN_4idTemp  = personGIN_4id;
        }
        String commonUserGIN_6id=  request.getParameter("commonUserGIN66");
        String commonUserGIN66null = request.getParameter("commonUserGIN66null");
        java.lang.String commonUserGIN_6idTemp;
        if (commonUserGIN66null != null)
            commonUserGIN_6idTemp = null;
        else {
         commonUserGIN_6idTemp  = commonUserGIN_6id;
        }
        String emailAddress_8id=  request.getParameter("emailAddress68");
        String emailAddress68null = request.getParameter("emailAddress68null");
        java.lang.String emailAddress_8idTemp;
        if (emailAddress68null != null)
            emailAddress_8idTemp = null;
        else {
         emailAddress_8idTemp  = emailAddress_8id;
        }
        com1test1crp31x11UserProfileIdentifier_1id.setExternalUserId(externalUserId_2idTemp);
        com1test1crp31x11UserProfileIdentifier_1id.setPersonGIN(personGIN_4idTemp);
        com1test1crp31x11UserProfileIdentifier_1id.setCommonUserGIN(commonUserGIN_6idTemp);
        com1test1crp31x11UserProfileIdentifier_1id.setEmailAddress(emailAddress_8idTemp);
        }
        String userId_10id=  request.getParameter("userId72");
        String userId72null = request.getParameter("userId72null");
        java.lang.String userId_10idTemp;
        if (userId72null != null)
            userId_10idTemp = null;
        else {
         userId_10idTemp  = userId_10id;
        }
        String systemId_12id=  request.getParameter("systemId74");
        String systemId74null = request.getParameter("systemId74null");
        java.lang.String systemId_12idTemp;
        if (systemId74null != null)
            systemId_12idTemp = null;
        else {
         systemId_12idTemp  = systemId_12id;
        }
        String serviceConsumerSystemId_14id=  request.getParameter("serviceConsumerSystemId76");
        String serviceConsumerSystemId76null = request.getParameter("serviceConsumerSystemId76null");
        java.lang.String serviceConsumerSystemId_14idTemp;
        if (serviceConsumerSystemId76null != null)
            serviceConsumerSystemId_14idTemp = null;
        else {
         serviceConsumerSystemId_14idTemp  = serviceConsumerSystemId_14id;
        }
        String syntheticTransactionTypeCode_16id=  request.getParameter("syntheticTransactionTypeCode78");
        String syntheticTransactionTypeCode78null = request.getParameter("syntheticTransactionTypeCode78null");
        java.lang.String syntheticTransactionTypeCode_16idTemp;
        if (syntheticTransactionTypeCode78null != null)
            syntheticTransactionTypeCode_16idTemp = null;
        else {
         syntheticTransactionTypeCode_16idTemp  = syntheticTransactionTypeCode_16id;
        }
        String dataSourceOptionsText_18id=  request.getParameter("dataSourceOptionsText82");
        String dataSourceOptionsText82null = request.getParameter("dataSourceOptionsText82null");
        java.lang.String dataSourceOptionsText_18idTemp;
        if (dataSourceOptionsText82null != null)
            dataSourceOptionsText_18idTemp = null;
        else {
         dataSourceOptionsText_18idTemp  = dataSourceOptionsText_18id;
        }
        String userTypeDescription_20id=  request.getParameter("userTypeDescription84");
        String userTypeDescription84null = request.getParameter("userTypeDescription84null");
        java.lang.String userTypeDescription_20idTemp;
        if (userTypeDescription84null != null)
            userTypeDescription_20idTemp = null;
        else {
         userTypeDescription_20idTemp  = userTypeDescription_20id;
        }
        com1test1crp31x11GetUserProfileRequest_0id.setUserProfileIdentifier(com1test1crp31x11UserProfileIdentifier_1id);
        com1test1crp31x11GetUserProfileRequest_0id.setUserId(userId_10idTemp);
        com1test1crp31x11GetUserProfileRequest_0id.setSystemId(systemId_12idTemp);
        com1test1crp31x11GetUserProfileRequest_0id.setServiceConsumerSystemId(serviceConsumerSystemId_14idTemp);
        com1test1crp31x11GetUserProfileRequest_0id.setSyntheticTransactionTypeCode(syntheticTransactionTypeCode_16idTemp);
        com1test1crp31x11GetUserProfileRequest_0id.setDataSourceOptionsText(dataSourceOptionsText_18idTemp);
        com1test1crp31x11GetUserProfileRequest_0id.setUserTypeDescription(userTypeDescription_20idTemp);
        }

        if (!async) {
        try {
            returnp14mtemp = sampleUserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPortProxyid.getUserProfile(com1test1crp31x11GetUserProfileRequest_0id);
            }catch(com.test.crp31x1.GetUserProfileSimpleFaultReplyMsg GetUserProfileSimpleFaultReplyMsg86){
            com.test.crp31x1.SimpleFault SimpleFault87 = GetUserProfileSimpleFaultReplyMsg86.getFaultInfo();
                %>
<TABLE CLASS="tableform">
<TR>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">com.test.crp31x1.GetUserProfileSimpleFaultReplyMsg:</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="1" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">faultMessageText:</TD>
<TD>
<%
if(SimpleFault87 != null){
java.lang.String typefaultMessageText88 = SimpleFault87.getFaultMessageText();
if(typefaultMessageText88 != null){
        String tempResultfaultMessageText88 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefaultMessageText88));
        %>
        <%= tempResultfaultMessageText88 %>
        <%
}
else{
        %>
        <%= typefaultMessageText88%>
        <%
}
}
%>
</TD>
</TABLE>
                <%
break;
            }catch(Exception exc){
                %>
                Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(exc.toString()) %>
                Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(exc.getMessage()) %>
                <%
break;
            }
        }
        else {
            // async code omitted
            break;
        }
    }
if (sourceOut != null) {
%>
    <TEXTAREA ROWS="8" COLs="45"><%= org.eclipse.jst.ws.util.JspUtils.markup(com.ibm.ccl.ws.jaxws.gstc.util.SourceUtils.transform(sourceOut)) %></TEXTAREA>
<%
}
else {
if (returnp14mtemp == null) {
%>
    null
<%
} else {
    %>
    <TABLE CLASS="tableform">
<TR>
<TD COLSPAN="4" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">returnp:</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="3" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">userProfile:</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">user:</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="1" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">userId:</TD>
<TD>
<%
if(returnp14mtemp != null){
com.test.crp31x1.UserProfile tebece0=returnp14mtemp.getUserProfile();
if(tebece0 != null){
com.test.crp31x1.User tebece1=tebece0.getUser();
if(tebece1 != null){
java.lang.String typeuserId20 = tebece1.getUserId();
if(typeuserId20 != null){
        String tempResultuserId20 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeuserId20));
        %>
        <%= tempResultuserId20 %>
        <%
}
else{
        %>
        <%= typeuserId20%>
        <%
}
}}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="1" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">userTypeCode:</TD>
<TD>
<%
if(returnp14mtemp != null){
com.test.crp31x1.UserProfile tebece0=returnp14mtemp.getUserProfile();
if(tebece0 != null){
com.test.crp31x1.User tebece1=tebece0.getUser();
if(tebece1 != null){
java.lang.String typeuserTypeCode22 = tebece1.getUserTypeCode();
if(typeuserTypeCode22 != null){
        String tempResultuserTypeCode22 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeuserTypeCode22));
        %>
        <%= tempResultuserTypeCode22 %>
        <%
}
else{
        %>
        <%= typeuserTypeCode22%>
        <%
}
}}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="1" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">userTypeDescription:</TD>
<TD>
<%
if(returnp14mtemp != null){
com.test.crp31x1.UserProfile tebece0=returnp14mtemp.getUserProfile();
if(tebece0 != null){
com.test.crp31x1.User tebece1=tebece0.getUser();
if(tebece1 != null){
java.lang.String typeuserTypeDescription24 = tebece1.getUserTypeDescription();
if(typeuserTypeDescription24 != null){
        String tempResultuserTypeDescription24 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeuserTypeDescription24));
        %>
        <%= tempResultuserTypeDescription24 %>
        <%
}
else{
        %>
        <%= typeuserTypeDescription24%>
        <%
}
}}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="1" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">businessName:</TD>
<TD>
<%
if(returnp14mtemp != null){
com.test.crp31x1.UserProfile tebece0=returnp14mtemp.getUserProfile();
if(tebece0 != null){
com.test.crp31x1.User tebece1=tebece0.getUser();
if(tebece1 != null){
java.lang.String typebusinessName26 = tebece1.getBusinessName();
if(typebusinessName26 != null){
        String tempResultbusinessName26 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typebusinessName26));
        %>
        <%= tempResultbusinessName26 %>
        <%
}
else{
        %>
        <%= typebusinessName26%>
        <%
}
}}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="1" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">userOrganizationRoleName:</TD>
<TD>
<%
if(returnp14mtemp != null){
com.test.crp31x1.UserProfile tebece0=returnp14mtemp.getUserProfile();
if(tebece0 != null){
com.test.crp31x1.User tebece1=tebece0.getUser();
if(tebece1 != null){
java.lang.String typeuserOrganizationRoleName28 = tebece1.getUserOrganizationRoleName();
if(typeuserOrganizationRoleName28 != null){
        String tempResultuserOrganizationRoleName28 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeuserOrganizationRoleName28));
        %>
        <%= tempResultuserOrganizationRoleName28 %>
        <%
}
else{
        %>
        <%= typeuserOrganizationRoleName28%>
        <%
}
}}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">regionAndLanguageSettings:</TD>
<TD>
<%
if(returnp14mtemp != null){
com.test.crp31x1.UserProfile tebece0=returnp14mtemp.getUserProfile();
if(tebece0 != null){
java.util.List typeregionAndLanguageSettings30 = tebece0.getRegionAndLanguageSettings();
if(typeregionAndLanguageSettings30 != null){
        String tempResultregionAndLanguageSettings30 = com.ibm.ccl.ws.jaxws.gstc.util.Introspector.visit(typeregionAndLanguageSettings30);
        %>
        <%= tempResultregionAndLanguageSettings30 %>
        <%
}
else{
        %>
        <%= typeregionAndLanguageSettings30%>
        <%
}
}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">accessControlGroup:</TD>
<TD>
<%
if(returnp14mtemp != null){
com.test.crp31x1.UserProfile tebece0=returnp14mtemp.getUserProfile();
if(tebece0 != null){
java.util.List typeaccessControlGroup32 = tebece0.getAccessControlGroup();
if(typeaccessControlGroup32 != null){
        String tempResultaccessControlGroup32 = com.ibm.ccl.ws.jaxws.gstc.util.Introspector.visit(typeaccessControlGroup32);
        %>
        <%= tempResultaccessControlGroup32 %>
        <%
}
else{
        %>
        <%= typeaccessControlGroup32%>
        <%
}
}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">applicationUserProfile:</TD>
<TD>
<%
if(returnp14mtemp != null){
com.test.crp31x1.UserProfile tebece0=returnp14mtemp.getUserProfile();
if(tebece0 != null){
java.util.List typeapplicationUserProfile34 = tebece0.getApplicationUserProfile();
if(typeapplicationUserProfile34 != null){
        String tempResultapplicationUserProfile34 = com.ibm.ccl.ws.jaxws.gstc.util.Introspector.visit(typeapplicationUserProfile34);
        %>
        <%= tempResultapplicationUserProfile34 %>
        <%
}
else{
        %>
        <%= typeapplicationUserProfile34%>
        <%
}
}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">userAuthorization:</TD>
<TD>
<%
if(returnp14mtemp != null){
com.test.crp31x1.UserProfile tebece0=returnp14mtemp.getUserProfile();
if(tebece0 != null){
java.util.List typeuserAuthorization36 = tebece0.getUserAuthorization();
if(typeuserAuthorization36 != null){
        String tempResultuserAuthorization36 = com.ibm.ccl.ws.jaxws.gstc.util.Introspector.visit(typeuserAuthorization36);
        %>
        <%= tempResultuserAuthorization36 %>
        <%
}
else{
        %>
        <%= typeuserAuthorization36%>
        <%
}
}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">userProfileStatusCode:</TD>
<TD>
<%
if(returnp14mtemp != null){
com.test.crp31x1.UserProfile tebece0=returnp14mtemp.getUserProfile();
if(tebece0 != null){
java.lang.String typeuserProfileStatusCode38 = tebece0.getUserProfileStatusCode();
if(typeuserProfileStatusCode38 != null){
        String tempResultuserProfileStatusCode38 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeuserProfileStatusCode38));
        %>
        <%= tempResultuserProfileStatusCode38 %>
        <%
}
else{
        %>
        <%= typeuserProfileStatusCode38%>
        <%
}
}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">userProfileSourceName:</TD>
<TD>
<%
if(returnp14mtemp != null){
com.test.crp31x1.UserProfile tebece0=returnp14mtemp.getUserProfile();
if(tebece0 != null){
java.lang.String typeuserProfileSourceName40 = tebece0.getUserProfileSourceName();
if(typeuserProfileSourceName40 != null){
        String tempResultuserProfileSourceName40 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeuserProfileSourceName40));
        %>
        <%= tempResultuserProfileSourceName40 %>
        <%
}
else{
        %>
        <%= typeuserProfileSourceName40%>
        <%
}
}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">externalUserId:</TD>
<TD>
<%
if(returnp14mtemp != null){
com.test.crp31x1.UserProfile tebece0=returnp14mtemp.getUserProfile();
if(tebece0 != null){
java.lang.String typeexternalUserId42 = tebece0.getExternalUserId();
if(typeexternalUserId42 != null){
        String tempResultexternalUserId42 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeexternalUserId42));
        %>
        <%= tempResultexternalUserId42 %>
        <%
}
else{
        %>
        <%= typeexternalUserId42%>
        <%
}
}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">personGIN:</TD>
<TD>
<%
if(returnp14mtemp != null){
com.test.crp31x1.UserProfile tebece0=returnp14mtemp.getUserProfile();
if(tebece0 != null){
java.lang.String typepersonGIN44 = tebece0.getPersonGIN();
if(typepersonGIN44 != null){
        String tempResultpersonGIN44 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepersonGIN44));
        %>
        <%= tempResultpersonGIN44 %>
        <%
}
else{
        %>
        <%= typepersonGIN44%>
        <%
}
}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">commonUserGIN:</TD>
<TD>
<%
if(returnp14mtemp != null){
com.test.crp31x1.UserProfile tebece0=returnp14mtemp.getUserProfile();
if(tebece0 != null){
java.lang.String typecommonUserGIN46 = tebece0.getCommonUserGIN();
if(typecommonUserGIN46 != null){
        String tempResultcommonUserGIN46 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecommonUserGIN46));
        %>
        <%= tempResultcommonUserGIN46 %>
        <%
}
else{
        %>
        <%= typecommonUserGIN46%>
        <%
}
}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">customization:</TD>
<TD>
<%
if(returnp14mtemp != null){
com.test.crp31x1.UserProfile tebece0=returnp14mtemp.getUserProfile();
if(tebece0 != null){
java.util.List typecustomization48 = tebece0.getCustomization();
if(typecustomization48 != null){
        String tempResultcustomization48 = com.ibm.ccl.ws.jaxws.gstc.util.Introspector.visit(typecustomization48);
        %>
        <%= tempResultcustomization48 %>
        <%
}
else{
        %>
        <%= typecustomization48%>
        <%
}
}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">sourceSystemUserProfileId:</TD>
<TD>
<%
if(returnp14mtemp != null){
com.test.crp31x1.UserProfile tebece0=returnp14mtemp.getUserProfile();
if(tebece0 != null){
java.util.List typesourceSystemUserProfileId50 = tebece0.getSourceSystemUserProfileId();
if(typesourceSystemUserProfileId50 != null){
        String tempResultsourceSystemUserProfileId50 = com.ibm.ccl.ws.jaxws.gstc.util.Introspector.visit(typesourceSystemUserProfileId50);
        %>
        <%= tempResultsourceSystemUserProfileId50 %>
        <%
}
else{
        %>
        <%= typesourceSystemUserProfileId50%>
        <%
}
}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="3" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">statusInformation:</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">errorInformation:</TD>
<TD>
<%
if(returnp14mtemp != null){
com.test.crp31x1.StatusInformation tebece0=returnp14mtemp.getStatusInformation();
if(tebece0 != null){
java.util.List typeerrorInformation54 = tebece0.getErrorInformation();
if(typeerrorInformation54 != null){
        String tempResulterrorInformation54 = com.ibm.ccl.ws.jaxws.gstc.util.Introspector.visit(typeerrorInformation54);
        %>
        <%= tempResulterrorInformation54 %>
        <%
}
else{
        %>
        <%= typeerrorInformation54%>
        <%
}
}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">statusCode:</TD>
<TD>
<%
if(returnp14mtemp != null){
com.test.crp31x1.StatusInformation tebece0=returnp14mtemp.getStatusInformation();
if(tebece0 != null){
java.lang.String typestatusCode56 = tebece0.getStatusCode();
if(typestatusCode56 != null){
        String tempResultstatusCode56 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typestatusCode56));
        %>
        <%= tempResultstatusCode56 %>
        <%
}
else{
        %>
        <%= typestatusCode56%>
        <%
}
}}
%>
</TD>
    </TABLE>
    <%
}
%>
<HR/><BR/>
<%
}
break;
case 90:
    gotMethod = true;
    com.test.crp31x1.GetUserProfileListReply returnp91mtemp = null;
    if (methodKey != null) {
        javax.xml.ws.Response resp = com.ibm.ccl.ws.jaxws.gstc.util.AsyncUtils.getResponse(session, methodKey);
        if (resp != null) {
            isDone = resp.isDone();
            if (!isDone)
                break;
            if (resp.get() != null) {
                Object o = resp.get();
                if (o instanceof javax.xml.transform.Source)
                    sourceOut = (javax.xml.transform.Source) o;
                else if (o instanceof com.test.crp31x1.GetUserProfileListReply)
                    returnp91mtemp = (com.test.crp31x1.GetUserProfileListReply) o;
            }
        }
    }
    else if (bypass) {
        javax.xml.ws.Dispatch dispatch = sampleUserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPortProxyid._getDescriptor().getDispatch();

        if (request.getParameter("__use_soapaction__") != null)
            com.ibm.ccl.ws.jaxws.gstc.util.DispatchUtils.useSoapAction(dispatch, request.getParameter("__soapaction__"));
        else
            com.ibm.ccl.ws.jaxws.gstc.util.DispatchUtils.clearSoapAction(dispatch);

        if (!async)
            sourceOut = (javax.xml.transform.Source) dispatch.invoke(sourceIn);
        else {
            // async code omitted
            break;
        }
    } else {
        %>
        <jsp:useBean id="com1test1crp31x11GetUserProfileListRequest_22id" scope="session" class="com.test.crp31x1.GetUserProfileListRequest" />
        <%
        String getUserProfileListRequest101null = request.getParameter("getUserProfileListRequest101null");
        if (getUserProfileListRequest101null != null)
            com1test1crp31x11GetUserProfileListRequest_22id = null;
        else {
        String userId_23id=  request.getParameter("userId105");
        String userId105null = request.getParameter("userId105null");
        java.lang.String userId_23idTemp;
        if (userId105null != null)
            userId_23idTemp = null;
        else {
         userId_23idTemp  = userId_23id;
        }
        String systemId_25id=  request.getParameter("systemId107");
        String systemId107null = request.getParameter("systemId107null");
        java.lang.String systemId_25idTemp;
        if (systemId107null != null)
            systemId_25idTemp = null;
        else {
         systemId_25idTemp  = systemId_25id;
        }
        String serviceConsumerSystemId_27id=  request.getParameter("serviceConsumerSystemId109");
        String serviceConsumerSystemId109null = request.getParameter("serviceConsumerSystemId109null");
        java.lang.String serviceConsumerSystemId_27idTemp;
        if (serviceConsumerSystemId109null != null)
            serviceConsumerSystemId_27idTemp = null;
        else {
         serviceConsumerSystemId_27idTemp  = serviceConsumerSystemId_27id;
        }
        String syntheticTransactionTypeCode_29id=  request.getParameter("syntheticTransactionTypeCode111");
        String syntheticTransactionTypeCode111null = request.getParameter("syntheticTransactionTypeCode111null");
        java.lang.String syntheticTransactionTypeCode_29idTemp;
        if (syntheticTransactionTypeCode111null != null)
            syntheticTransactionTypeCode_29idTemp = null;
        else {
         syntheticTransactionTypeCode_29idTemp  = syntheticTransactionTypeCode_29id;
        }
        String dataSourceOptionsText_31id=  request.getParameter("dataSourceOptionsText115");
        String dataSourceOptionsText115null = request.getParameter("dataSourceOptionsText115null");
        java.lang.String dataSourceOptionsText_31idTemp;
        if (dataSourceOptionsText115null != null)
            dataSourceOptionsText_31idTemp = null;
        else {
         dataSourceOptionsText_31idTemp  = dataSourceOptionsText_31id;
        }
        String userTypeDescription_33id=  request.getParameter("userTypeDescription117");
        String userTypeDescription117null = request.getParameter("userTypeDescription117null");
        java.lang.String userTypeDescription_33idTemp;
        if (userTypeDescription117null != null)
            userTypeDescription_33idTemp = null;
        else {
         userTypeDescription_33idTemp  = userTypeDescription_33id;
        }
        com1test1crp31x11GetUserProfileListRequest_22id.setUserId(userId_23idTemp);
        com1test1crp31x11GetUserProfileListRequest_22id.setSystemId(systemId_25idTemp);
        com1test1crp31x11GetUserProfileListRequest_22id.setServiceConsumerSystemId(serviceConsumerSystemId_27idTemp);
        com1test1crp31x11GetUserProfileListRequest_22id.setSyntheticTransactionTypeCode(syntheticTransactionTypeCode_29idTemp);
        com1test1crp31x11GetUserProfileListRequest_22id.setDataSourceOptionsText(dataSourceOptionsText_31idTemp);
        com1test1crp31x11GetUserProfileListRequest_22id.setUserTypeDescription(userTypeDescription_33idTemp);
        }

        if (!async) {
        try {
            returnp91mtemp = sampleUserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPortProxyid.getUserProfileList(com1test1crp31x11GetUserProfileListRequest_22id);
            }catch(com.test.crp31x1.GetUserProfileListSimpleFaultReplyMsg GetUserProfileListSimpleFaultReplyMsg119){
            com.test.crp31x1.SimpleFault SimpleFault120 = GetUserProfileListSimpleFaultReplyMsg119.getFaultInfo();
                %>
<TABLE CLASS="tableform">
<TR>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">com.test.crp31x1.GetUserProfileListSimpleFaultReplyMsg:</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="1" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">faultMessageText:</TD>
<TD>
<%
if(SimpleFault120 != null){
java.lang.String typefaultMessageText121 = SimpleFault120.getFaultMessageText();
if(typefaultMessageText121 != null){
        String tempResultfaultMessageText121 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefaultMessageText121));
        %>
        <%= tempResultfaultMessageText121 %>
        <%
}
else{
        %>
        <%= typefaultMessageText121%>
        <%
}
}
%>
</TD>
</TABLE>
                <%
break;
            }catch(Exception exc){
                %>
                Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(exc.toString()) %>
                Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(exc.getMessage()) %>
                <%
break;
            }
        }
        else {
            // async code omitted
            break;
        }
    }
if (sourceOut != null) {
%>
    <TEXTAREA ROWS="8" COLs="45"><%= org.eclipse.jst.ws.util.JspUtils.markup(com.ibm.ccl.ws.jaxws.gstc.util.SourceUtils.transform(sourceOut)) %></TEXTAREA>
<%
}
else {
if (returnp91mtemp == null) {
%>
    null
<%
} else {
    %>
    <TABLE CLASS="tableform">
<TR>
<TD COLSPAN="3" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">returnp:</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">getUserProfileListOutputs:</TD>
<TD>
<%
if(returnp91mtemp != null){
java.util.List typegetUserProfileListOutputs93 = returnp91mtemp.getGetUserProfileListOutputs();
if(typegetUserProfileListOutputs93 != null){
        String tempResultgetUserProfileListOutputs93 = com.ibm.ccl.ws.jaxws.gstc.util.Introspector.visit(typegetUserProfileListOutputs93);
        %>
        <%= tempResultgetUserProfileListOutputs93 %>
        <%
}
else{
        %>
        <%= typegetUserProfileListOutputs93%>
        <%
}
}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">statusInformation:</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="1" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">errorInformation:</TD>
<TD>
<%
if(returnp91mtemp != null){
com.test.crp31x1.StatusInformation tebece0=returnp91mtemp.getStatusInformation();
if(tebece0 != null){
java.util.List typeerrorInformation97 = tebece0.getErrorInformation();
if(typeerrorInformation97 != null){
        String tempResulterrorInformation97 = com.ibm.ccl.ws.jaxws.gstc.util.Introspector.visit(typeerrorInformation97);
        %>
        <%= tempResulterrorInformation97 %>
        <%
}
else{
        %>
        <%= typeerrorInformation97%>
        <%
}
}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="1" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">statusCode:</TD>
<TD>
<%
if(returnp91mtemp != null){
com.test.crp31x1.StatusInformation tebece0=returnp91mtemp.getStatusInformation();
if(tebece0 != null){
java.lang.String typestatusCode99 = tebece0.getStatusCode();
if(typestatusCode99 != null){
        String tempResultstatusCode99 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typestatusCode99));
        %>
        <%= tempResultstatusCode99 %>
        <%
}
else{
        %>
        <%= typestatusCode99%>
        <%
}
}}
%>
</TD>
    </TABLE>
    <%
}
%>
<HR/><BR/>
<%
}
break;
case 123:
    gotMethod = true;
    com.test.crp31x1.GetUserProfileListByEmailReply returnp124mtemp = null;
    if (methodKey != null) {
        javax.xml.ws.Response resp = com.ibm.ccl.ws.jaxws.gstc.util.AsyncUtils.getResponse(session, methodKey);
        if (resp != null) {
            isDone = resp.isDone();
            if (!isDone)
                break;
            if (resp.get() != null) {
                Object o = resp.get();
                if (o instanceof javax.xml.transform.Source)
                    sourceOut = (javax.xml.transform.Source) o;
                else if (o instanceof com.test.crp31x1.GetUserProfileListByEmailReply)
                    returnp124mtemp = (com.test.crp31x1.GetUserProfileListByEmailReply) o;
            }
        }
    }
    else if (bypass) {
        javax.xml.ws.Dispatch dispatch = sampleUserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPortProxyid._getDescriptor().getDispatch();

        if (request.getParameter("__use_soapaction__") != null)
            com.ibm.ccl.ws.jaxws.gstc.util.DispatchUtils.useSoapAction(dispatch, request.getParameter("__soapaction__"));
        else
            com.ibm.ccl.ws.jaxws.gstc.util.DispatchUtils.clearSoapAction(dispatch);

        if (!async)
            sourceOut = (javax.xml.transform.Source) dispatch.invoke(sourceIn);
        else {
            // async code omitted
            break;
        }
    } else {
        %>
        <jsp:useBean id="com1test1crp31x11GetUserProfileListByEmailRequest_35id" scope="session" class="com.test.crp31x1.GetUserProfileListByEmailRequest" />
        <%
        String getUserProfileListByEmailRequest136null = request.getParameter("getUserProfileListByEmailRequest136null");
        if (getUserProfileListByEmailRequest136null != null)
            com1test1crp31x11GetUserProfileListByEmailRequest_35id = null;
        else {
        String userId_36id=  request.getParameter("userId138");
        String userId138null = request.getParameter("userId138null");
        java.lang.String userId_36idTemp;
        if (userId138null != null)
            userId_36idTemp = null;
        else {
         userId_36idTemp  = userId_36id;
        }
        String systemId_38id=  request.getParameter("systemId140");
        String systemId140null = request.getParameter("systemId140null");
        java.lang.String systemId_38idTemp;
        if (systemId140null != null)
            systemId_38idTemp = null;
        else {
         systemId_38idTemp  = systemId_38id;
        }
        String serviceConsumerSystemId_40id=  request.getParameter("serviceConsumerSystemId142");
        String serviceConsumerSystemId142null = request.getParameter("serviceConsumerSystemId142null");
        java.lang.String serviceConsumerSystemId_40idTemp;
        if (serviceConsumerSystemId142null != null)
            serviceConsumerSystemId_40idTemp = null;
        else {
         serviceConsumerSystemId_40idTemp  = serviceConsumerSystemId_40id;
        }
        String syntheticTransactionTypeCode_42id=  request.getParameter("syntheticTransactionTypeCode144");
        String syntheticTransactionTypeCode144null = request.getParameter("syntheticTransactionTypeCode144null");
        java.lang.String syntheticTransactionTypeCode_42idTemp;
        if (syntheticTransactionTypeCode144null != null)
            syntheticTransactionTypeCode_42idTemp = null;
        else {
         syntheticTransactionTypeCode_42idTemp  = syntheticTransactionTypeCode_42id;
        }
        String dataSourceOptionsText_44id=  request.getParameter("dataSourceOptionsText148");
        String dataSourceOptionsText148null = request.getParameter("dataSourceOptionsText148null");
        java.lang.String dataSourceOptionsText_44idTemp;
        if (dataSourceOptionsText148null != null)
            dataSourceOptionsText_44idTemp = null;
        else {
         dataSourceOptionsText_44idTemp  = dataSourceOptionsText_44id;
        }
        String userTypeDescription_46id=  request.getParameter("userTypeDescription150");
        String userTypeDescription150null = request.getParameter("userTypeDescription150null");
        java.lang.String userTypeDescription_46idTemp;
        if (userTypeDescription150null != null)
            userTypeDescription_46idTemp = null;
        else {
         userTypeDescription_46idTemp  = userTypeDescription_46id;
        }
        String emailAddress_48id=  request.getParameter("emailAddress152");
        String emailAddress152null = request.getParameter("emailAddress152null");
        java.lang.String emailAddress_48idTemp;
        if (emailAddress152null != null)
            emailAddress_48idTemp = null;
        else {
         emailAddress_48idTemp  = emailAddress_48id;
        }
        com1test1crp31x11GetUserProfileListByEmailRequest_35id.setUserId(userId_36idTemp);
        com1test1crp31x11GetUserProfileListByEmailRequest_35id.setSystemId(systemId_38idTemp);
        com1test1crp31x11GetUserProfileListByEmailRequest_35id.setServiceConsumerSystemId(serviceConsumerSystemId_40idTemp);
        com1test1crp31x11GetUserProfileListByEmailRequest_35id.setSyntheticTransactionTypeCode(syntheticTransactionTypeCode_42idTemp);
        com1test1crp31x11GetUserProfileListByEmailRequest_35id.setDataSourceOptionsText(dataSourceOptionsText_44idTemp);
        com1test1crp31x11GetUserProfileListByEmailRequest_35id.setUserTypeDescription(userTypeDescription_46idTemp);
        com1test1crp31x11GetUserProfileListByEmailRequest_35id.setEmailAddress(emailAddress_48idTemp);
        }

        if (!async) {
        try {
            returnp124mtemp = sampleUserProfileRetrievalCRP31X1HTTP_UserProfileRetrievalCRP31X1HttpPortProxyid.getUserProfileListByEmail(com1test1crp31x11GetUserProfileListByEmailRequest_35id);
            }catch(com.test.crp31x1.GetUserProfileListByEmailSimpleFaultReplyMsg GetUserProfileListByEmailSimpleFaultReplyMsg154){
            com.test.crp31x1.SimpleFault SimpleFault155 = GetUserProfileListByEmailSimpleFaultReplyMsg154.getFaultInfo();
                %>
<TABLE CLASS="tableform">
<TR>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">com.test.crp31x1.GetUserProfileListByEmailSimpleFaultReplyMsg:</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="1" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">faultMessageText:</TD>
<TD>
<%
if(SimpleFault155 != null){
java.lang.String typefaultMessageText156 = SimpleFault155.getFaultMessageText();
if(typefaultMessageText156 != null){
        String tempResultfaultMessageText156 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefaultMessageText156));
        %>
        <%= tempResultfaultMessageText156 %>
        <%
}
else{
        %>
        <%= typefaultMessageText156%>
        <%
}
}
%>
</TD>
</TABLE>
                <%
break;
            }catch(Exception exc){
                %>
                Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(exc.toString()) %>
                Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(exc.getMessage()) %>
                <%
break;
            }
        }
        else {
            // async code omitted
            break;
        }
    }
if (sourceOut != null) {
%>
    <TEXTAREA ROWS="8" COLs="45"><%= org.eclipse.jst.ws.util.JspUtils.markup(com.ibm.ccl.ws.jaxws.gstc.util.SourceUtils.transform(sourceOut)) %></TEXTAREA>
<%
}
else {
if (returnp124mtemp == null) {
%>
    null
<%
} else {
    %>
    <TABLE CLASS="tableform">
<TR>
<TD COLSPAN="3" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">returnp:</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">userProfile:</TD>
<TD>
<%
if(returnp124mtemp != null){
java.util.List typeuserProfile126 = returnp124mtemp.getUserProfile();
if(typeuserProfile126 != null){
        String tempResultuserProfile126 = com.ibm.ccl.ws.jaxws.gstc.util.Introspector.visit(typeuserProfile126);
        %>
        <%= tempResultuserProfile126 %>
        <%
}
else{
        %>
        <%= typeuserProfile126%>
        <%
}
}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">statusInformation:</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="1" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">errorInformation:</TD>
<TD>
<%
if(returnp124mtemp != null){
com.test.crp31x1.StatusInformation tebece0=returnp124mtemp.getStatusInformation();
if(tebece0 != null){
java.util.List typeerrorInformation130 = tebece0.getErrorInformation();
if(typeerrorInformation130 != null){
        String tempResulterrorInformation130 = com.ibm.ccl.ws.jaxws.gstc.util.Introspector.visit(typeerrorInformation130);
        %>
        <%= tempResulterrorInformation130 %>
        <%
}
else{
        %>
        <%= typeerrorInformation130%>
        <%
}
}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="1" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">statusCode:</TD>
<TD>
<%
if(returnp124mtemp != null){
com.test.crp31x1.StatusInformation tebece0=returnp124mtemp.getStatusInformation();
if(tebece0 != null){
java.lang.String typestatusCode132 = tebece0.getStatusCode();
if(typestatusCode132 != null){
        String tempResultstatusCode132 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typestatusCode132));
        %>
        <%= tempResultstatusCode132 %>
        <%
}
else{
        %>
        <%= typestatusCode132%>
        <%
}
}}
%>
</TD>
<TR>
<TD CLASS="spacercol">&nbsp;</TD>
<TD COLSPAN="2" VALIGN="TOP" ALIGN="LEFT" CLASS="headingcol">emailAddress:</TD>
<TD>
<%
if(returnp124mtemp != null){
java.lang.String typeemailAddress134 = returnp124mtemp.getEmailAddress();
if(typeemailAddress134 != null){
        String tempResultemailAddress134 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemailAddress134));
        %>
        <%= tempResultemailAddress134 %>
        <%
}
else{
        %>
        <%= typeemailAddress134%>
        <%
}
}
%>
</TD>
    </TABLE>
    <%
}
%>
<HR/><BR/>
<%
}
break;
}
} catch (Exception e) { 
%>
exception: <%=org.eclipse.jst.ws.util.JspUtils.markup(e.toString())%>
<%
return;
}
if(!gotMethod){
%>
Result: N/A
<%
} else if (!isDone) {
%>
No results available yet.
<%
} else if (async && methodKey == null) {
%>
The service has been invoked.
<script language="JavaScript">reloadMethods();</script>
<%
}
%>
</BODY>
</HTML>
<%@page contentType="text/html;charset=UTF-8"%>
<%!
private static final String ENVELOPE_TEMPLATE =
    "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
    "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
    "<soapenv:Header>\n" +
    "</soapenv:Header>\n" +
    "<soapenv:Body>\n\n" +
    "</soapenv:Body>\n" +
    "</soapenv:Envelope>";
%>
<%
boolean bypass = session.getAttribute("__bypass__") == null ? false : true;
request.setCharacterEncoding("UTF-8");
String methodName = request.getParameter("methodName");
if (methodName == null || methodName.trim().length() == 0) methodName = "Inputs";
%>
<HTML>
<HEAD>
<TITLE>Inputs</TITLE>
<LINK rel="stylesheet" type="text/css" href="TestClient.css"/>
<script language="JavaScript">
function saveFullPath(fileInput, hiddenInput) {
    hiddenInput.value = fileInput.value;
}

function noBinding() {
    var doc  = window.parent.frames["config"].document;
    var form = doc.getElementById("configForm");
    form.bypass.click();
}

function triggerSoapAction() {
    var chk = document.getElementById("__use_soapaction__");
    var txt = document.getElementById("__soapaction__");
    txt.disabled = !chk.checked;
}
</script>
</HEAD>
<BODY>
<TABLE class="heading" width="100%">
<TR><TD><%= org.eclipse.jst.ws.util.JspUtils.markup(methodName) %></TD></TR>
</TABLE>
<BR/>
<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

boolean valid = true;

if(methodID != -1) methodID = Integer.parseInt(method);
switch (methodID){ 
case 2:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=method%>">
[This method takes no parameters]
<BR/>
<BR/>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 13:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=method%>">
<% if (bypass) { %>
<INPUT TYPE="checkbox" ID="__use_soapaction__" NAME="__use_soapaction__" onclick="triggerSoapAction();"/>
<label for="__use_soapaction__">Use SOAPAction HTTP header</label>
<BR/>
<INPUT TYPE="text" ID="__soapaction__" NAME="__soapaction__" SIZE="70" DISABLED/>
<BR/>
<BR/>
<TEXTAREA NAME="__rawxml__" ROWS="8" COLs="45"><%= ENVELOPE_TEMPLATE %></TEXTAREA>
<BR/>
<% } else { %>
<TABLE CLASS="tableform">
<TR><TD ALIGN="LEFT" CLASS="headingcol">null?</TD></TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="getUserProfileRequest58null" value="getUserProfileRequest58null"></TD>
<TD COLSPAN="3" ALIGN="LEFT" CLASS="headingcol">getUserProfileRequest:</TD>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="userProfileIdentifier60null" value="userProfileIdentifier60null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="2" ALIGN="LEFT" CLASS="headingcol">userProfileIdentifier:</TD>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="externalUserId62null" value="externalUserId62null"></TD>
<TD CLASS="spacercol"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">externalUserId:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="externalUserId62" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="personGIN64null" value="personGIN64null"></TD>
<TD CLASS="spacercol"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">personGIN:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="personGIN64" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="commonUserGIN66null" value="commonUserGIN66null"></TD>
<TD CLASS="spacercol"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">commonUserGIN:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="commonUserGIN66" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="emailAddress68null" value="emailAddress68null"></TD>
<TD CLASS="spacercol"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">emailAddress:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="emailAddress68" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="userId72null" value="userId72null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="2" ALIGN="LEFT" CLASS="headingcol">userId:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="userId72" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="systemId74null" value="systemId74null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="2" ALIGN="LEFT" CLASS="headingcol">systemId:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="systemId74" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="serviceConsumerSystemId76null" value="serviceConsumerSystemId76null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="2" ALIGN="LEFT" CLASS="headingcol">serviceConsumerSystemId:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="serviceConsumerSystemId76" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="syntheticTransactionTypeCode78null" value="syntheticTransactionTypeCode78null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="2" ALIGN="LEFT" CLASS="headingcol">syntheticTransactionTypeCode:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="syntheticTransactionTypeCode78" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="dataSourceOptionsText82null" value="dataSourceOptionsText82null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="2" ALIGN="LEFT" CLASS="headingcol">dataSourceOptionsText:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="dataSourceOptionsText82" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="userTypeDescription84null" value="userTypeDescription84null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="2" ALIGN="LEFT" CLASS="headingcol">userTypeDescription:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="userTypeDescription84" SIZE=20></TD>
</TR>
</TABLE>
<% } %>
<BR/>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 90:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=method%>">
<% if (bypass) { %>
<INPUT TYPE="checkbox" ID="__use_soapaction__" NAME="__use_soapaction__" onclick="triggerSoapAction();"/>
<label for="__use_soapaction__">Use SOAPAction HTTP header</label>
<BR/>
<INPUT TYPE="text" ID="__soapaction__" NAME="__soapaction__" SIZE="70" DISABLED/>
<BR/>
<BR/>
<TEXTAREA NAME="__rawxml__" ROWS="8" COLs="45"><%= ENVELOPE_TEMPLATE %></TEXTAREA>
<BR/>
<% } else { %>
<TABLE CLASS="tableform">
<TR><TD ALIGN="LEFT" CLASS="headingcol">null?</TD></TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="getUserProfileListRequest101null" value="getUserProfileListRequest101null"></TD>
<TD COLSPAN="2" ALIGN="LEFT" CLASS="headingcol">getUserProfileListRequest:</TD>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="userId105null" value="userId105null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">userId:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="userId105" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="systemId107null" value="systemId107null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">systemId:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="systemId107" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="serviceConsumerSystemId109null" value="serviceConsumerSystemId109null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">serviceConsumerSystemId:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="serviceConsumerSystemId109" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="syntheticTransactionTypeCode111null" value="syntheticTransactionTypeCode111null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">syntheticTransactionTypeCode:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="syntheticTransactionTypeCode111" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="dataSourceOptionsText115null" value="dataSourceOptionsText115null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">dataSourceOptionsText:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="dataSourceOptionsText115" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="userTypeDescription117null" value="userTypeDescription117null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">userTypeDescription:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="userTypeDescription117" SIZE=20></TD>
</TR>
</TABLE>
<% } %>
<BR/>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 123:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=method%>">
<% if (bypass) { %>
<INPUT TYPE="checkbox" ID="__use_soapaction__" NAME="__use_soapaction__" onclick="triggerSoapAction();"/>
<label for="__use_soapaction__">Use SOAPAction HTTP header</label>
<BR/>
<INPUT TYPE="text" ID="__soapaction__" NAME="__soapaction__" SIZE="70" DISABLED/>
<BR/>
<BR/>
<TEXTAREA NAME="__rawxml__" ROWS="8" COLs="45"><%= ENVELOPE_TEMPLATE %></TEXTAREA>
<BR/>
<% } else { %>
<TABLE CLASS="tableform">
<TR><TD ALIGN="LEFT" CLASS="headingcol">null?</TD></TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="getUserProfileListByEmailRequest136null" value="getUserProfileListByEmailRequest136null"></TD>
<TD COLSPAN="2" ALIGN="LEFT" CLASS="headingcol">getUserProfileListByEmailRequest:</TD>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="userId138null" value="userId138null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">userId:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="userId138" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="systemId140null" value="systemId140null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">systemId:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="systemId140" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="serviceConsumerSystemId142null" value="serviceConsumerSystemId142null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">serviceConsumerSystemId:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="serviceConsumerSystemId142" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="syntheticTransactionTypeCode144null" value="syntheticTransactionTypeCode144null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">syntheticTransactionTypeCode:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="syntheticTransactionTypeCode144" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="dataSourceOptionsText148null" value="dataSourceOptionsText148null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">dataSourceOptionsText:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="dataSourceOptionsText148" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="userTypeDescription150null" value="userTypeDescription150null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">userTypeDescription:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="userTypeDescription150" SIZE=20></TD>
</TR>
<TR>
<TD ALIGN="left" CLASS="nullcol"><input type="checkbox" name="emailAddress152null" value="emailAddress152null"></TD>
<TD CLASS="spacercol"></TD>
<TD COLSPAN="1" ALIGN="LEFT" CLASS="headingcol">emailAddress:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="emailAddress152" SIZE=20></TD>
</TR>
</TABLE>
<% } %>
<BR/>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
}
if (valid) {
%>
Select a method to test
<%
}
%>

</BODY>
</HTML>

<%@page import="com.login.Auth"%>
<%@page import="com.login.CookieChecker" %>
<link rel="stylesheet" href="style.css" type="text/css"></link>


<div class="container">
<%
Auth bean = (Auth)request.getAttribute("Auth");
String name = bean.getName();
// sends to method getCookie and assign the return value to value for printing.
String value = CookieChecker.getCookie(request, name);
%>
<h1 style="text-align: center"><% out.print("Welcome " + bean.getName()); %></h1><br><br><br>
<h3>What is Lorem Ipsum?</h3><br>
 <p style="text-align: left">
Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
when an unknown printer took a galley of type and scrambled it to make a type specimen book. 
It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. 
It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, 
and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p><br>
<h3 style="text-align: center"><% out.print("Cookie Value: " + value); %></h3>
 <br><br><a href="index.html">Return to login </a>
 </div>
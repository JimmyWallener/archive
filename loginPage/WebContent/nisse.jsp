<%@page import="com.login.Auth"%>
<%@page import="com.login.CookieChecker" %>
<link rel="stylesheet" href="style.css" type="text/css"></link>


<div class="container">
<%
Auth bean = (Auth)request.getAttribute("Auth");
String name = bean.getName();
//sends to method getCookie and assign the return value to value for printing.
String value = CookieChecker.getCookie(request, name);
%>
<h1 style="text-align: center"><% out.print("Welcome " + bean.getName()); %></h1><br><br><br>
<h3>Where can I get some?</h3><br>
 <p style="text-align: left">
There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.</p><br>
<h3 style="text-align: center"><% out.print("Cookie Value: " + value); %></h3>
 <br><br><a href="index.html">Return to login </a>
 </div>
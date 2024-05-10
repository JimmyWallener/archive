<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="se.gritacademy.search.ControllerServlet" %>
    
<!DOCTYPE html>
<html>
<head>
<style><%@include file="style.css"%></style>
<meta charset="UTF-8">
<title>Astlavista Search Engine</title>
</head>
<body>

<div class="search_center">
<div class="header_title">
<h1>ASTLAVISTA</h1>
<h4>The Retro Search Engine</h4><br><br>
</div>
<div class="form_search">
<form action="Controller" method="post">
<br><br><input type="text" id="search" name="search" placeholder="Don't be afraid.. just do it" required>
<input type="submit" class="search_btn" value="SEND">
<input type="reset" class="search_btn" value="RESET"><br><br><br>
</form>
</div>
</div>


</body>
</html>
<%@page import="easterEgg.getChuckNorris"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Style.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Travel</title>
</head>
<body>
<!--
     ____.                           __                       __   .__                         _______________  ____ ________ 
    |    |____ ___  _______   __ ___/  |____  __ ____   ____ |  | _|  | _____ _______   ____   \_____  \   _  \/_   /   __   \
    |    \__  \\  \/ /\__  \ |  |  \   __\  \/ // __ \_/ ___\|  |/ /  | \__  \\_  __ \_/ __ \   /  ____/  /_\  \|   \____    /
/\__|    |/ __ \\   /  / __ \|  |  /|  |  \   /\  ___/\  \___|    <|  |__/ __ \|  | \/\  ___/  /       \  \_/   \   |  /    / 
\________(____  /\_/  (____  /____/ |__|   \_/  \___  >\___  >__|_ \____(____  /__|    \___  > \_______ \_____  /___| /____/  
              \/           \/                       \/     \/     \/         \/            \/          \/     \/              
   _____ ___.  ___.                   _____  .__                                                                              
  /  _  \\_ |__\_ |__   ____         /  _  \ |  |   ____ ___  ___                                                             
 /  /_\  \| __ \| __ \_/ __ \       /  /_\  \|  | _/ __ \\  \/  /                                                             
/    |    \ \_\ \ \_\ \  ___/      /    |    \  |_\  ___/ >    <                                                              
\____|__  /___  /___  /\___  > /\  \____|__  /____/\___  >__/\_ \                                                             
        \/    \/    \/     \/  )/          \/          \/      \/                                                             
     ____.__                          ____    __________       .__  .__                                                       
    |    |__| _____   _____ ___.__.  /  _ \   \______   \ ____ |  | |  |   ____                                               
    |    |  |/     \ /     <   |  |  >  _ </\  |     ___// __ \|  | |  | _/ __ \                                              
/\__|    |  |  Y Y  \  Y Y  \___  | /  <_\ \/  |    |   \  ___/|  |_|  |_\  ___/                                              
\________|__|__|_|  /__|_|  / ____| \_____\ \  |____|    \___  >____/____/\___  >                                             
                  \/      \/\/             \/                \/               \/                                              
 __      __     /\                                                                                                            
/  \    /  \ ___)/______   ____   _____________  ____   ________________    _____   _____   ___________  ______               
\   \/\/   // __ \_  __ \_/ __ \  \____ \_  __ \/  _ \ / ___\_  __ \__  \  /     \ /     \_/ __ \_  __ \/  ___/               
 \        /\  ___/|  | \/\  ___/  |  |_> >  | \(  <_> ) /_/  >  | \// __ \|  Y Y  \  Y Y  \  ___/|  | \/\___ \                
  \__/\  /  \___  >__|    \___  > |   __/|__|   \____/\___  /|__|  (____  /__|_|  /__|_|  /\___  >__|  /____  >               
       \/       \/            \/  |__|               /_____/            \/      \/      \/     \/           \/                
__________._______________________   ___ ___                                                                                  
\______   \   \__    ___/\_   ___ \ /   |   \                                                                                 
 |    |  _/   | |    |   /    \  \//    ~    \                                                                                
 |    |   \   | |    |   \     \___\    Y    /                                                                                
 |______  /___| |____|    \______  /\___|_  /                                                                                 
        \/                       \/       \/                                                                                  
        -->
	<div class="header">
		<h1>Transportation Locator in Skane</h1>
		<h3>Home of Sustainable Travel | Start your journey now‎.</h3>
	</div>

	<div class="topnav">
		<a href="#">Home</a> <a href="#">Plan a journey</a> <a href="#">Status
			updates</a> <a href="#">Maps</a>
	</div>

	<br>
<div class="input">	
<form action="getStations" method="post"> 
<div id="myDropdown" class="dropdown-content">
	<div class="from">
    From: <input type=text list=browsers placeholder="Search.." id="myInput" name="from" onkeyup="filterFunction()" required>
	<datalist id=browsers >
	   	<option value="78114">Båstad station</option>
		<option value="95006">Göteborg C</option>
		<option value="13003">Halmstad C</option>
		<option value="83241">Helsingborg C</option>
		<option value="93070">Hässleholm C</option>
		<option value="10007">Karlskrona C</option>
		<option value="90042">Kristianstad C</option>
		<option value="45007">Köpenhamn H</option>
		<option value="82000">Landskrona Station</option>
		<option value="81216">Lund C</option>
		<option value="80000">Malmö C</option>
		<option value="80040">Malmö Hyllie</option>
		<option value="80140">Malmö Triangeln</option>
		<option value="87071">Trelleborg C</option>
		<option value="86239">Ystads station</option>
		<option value="92010">Ängelholm station</option>
	</datalist>
	<br>
	</div>
	<div class="to">
	To: <input type=text list=browsers placeholder="Search.." id="myInput" name="to" onkeyup="filterFunction()" required>
	<datalist id=browsers >
	   	<option value="78114">Båstad station</option>
		<option value="95006">Göteborg C</option>
		<option value="13003">Halmstad C</option>
		<option value="83241">Helsingborg C</option>
		<option value="93070">Hässleholm C</option>
		<option value="10007">Karlskrona C</option>
		<option value="90042">Kristianstad C</option>
		<option value="45007">Köpenhamn H</option>
		<option value="82000">Landskrona Station</option>
		<option value="81216">Lund C</option>
		<option value="80000">Malmö C</option>
		<option value="80040">Malmö Hyllie</option>
		<option value="80140">Malmö Triangeln</option>
		<option value="87071">Trelleborg C</option>
		<option value="86239">Ystads station</option>
		<option value="92010">Ängelholm station</option>
	</datalist>
	</div>
	<br>
	<br>
	<input type="submit" class="myButton" value="Let's go">
  </div>
</form>
</div>

	<div class="row">
		<div class="column side">
			<h2>Plan A Trip</h2>
			<p>Our journey planner allows you to plan journeys by public transport across Skane. If you want to know about bus or train routes in your area, search our wide range of local area maps.</p>
		</div>

		<div class="column middle">

			<h2>Using public Transportation in Skane</h2>
			<p>When you travel on a Skane train or bus, we want you to have the best
				experience possible. If you haven't used our services before, or it
				has been some time since your last trip, here are some tips on using
				our services. Over 1 million people use Skane’s bus services every
				day and your safety is our priority.
				<br>
				<br>
				
				 We are investing in improving
				Skane's bus services, this includes making live information
				available online at bus and train stops, customer service training for our
				drivers and using the latest technology for new, greener train and buses.</p>

		</div>

		<div class="column side">
<%
getChuckNorris chuck = new getChuckNorris();
out.println(chuck.setChuck());
%>
		</div>
	</div>
	<br>	<br>	<br>	<br>
	<div class="footer">
		<p>Follow Us</p> 
	<a href="#" class="fa fa-facebook"></a>
	<a href="#" class="fa fa-twitter"></a>
	<a href="#" class="fa fa-google"></a>
	<a href="#" class="fa fa-linkedin"></a>
	<a href="#" class="fa fa-youtube"></a>
	<a href="#" class="fa fa-instagram"></a>	
	</div>
<script>

function filterFunction() {
  var input, filter, ul, li, a, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  div = document.getElementById("myDropdown");
  a = div.getElementsByTagName("option");
  for (i = 0; i < a.length; i++) {
    txtValue = a[i].textContent || a[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      a[i].style.display = "";
    } else {
      a[i].style.display = "none";
    }
  }
}
(function() {
	if (!localStorage.getItem('cookieconsent')) {
		document.body.innerHTML += '\
		<div class="cookieconsent" style="position:fixed;padding:20px;left:0;bottom:0;background-color:#000;color:#FFF;text-align:center;width:100%;z-index:99999;">\
			This site uses cookies. If you enter, you agree to let us keep all cookies!  \
			<a href="#" style="color:#CCCCCC;">I Understand, Pepehands!</a>\
		</div>\
		';
		document.querySelector('.cookieconsent a').onclick = function(e) {
			e.preventDefault();
			document.querySelector('.cookieconsent').style.display = 'none';
			localStorage.setItem('cookieconsent', true);
		};
	}
})();	
</script>
</body>
</html>

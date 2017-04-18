<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	<meta http-equiv="X-UA-Compatible" content="IE=edge">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Nosophobic</title>
	<link rel="stylesheet" href="style.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="main.js"></script>
<title>Nosophobic</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col col-md-12">
				<h1 id="header">nosophobic</h1>
			</div>
		</div>
		 <form name="nosophobicForm" action="nosphobicServlet" method="POST" role="form" class="form-horizontal">
		   <div class="form-group row">
		   	<div class="col-xs-2">
		     <label for="sel1">Select US State:</label>
		     <select name="state" class="form-control" id="sel1">
				<option>Alabama</option>
				<option>Alaska</option>
				<option>Arizona</option>
				<option>Arkansas</option>
				<option>California</option>
				<option>Colorado</option>
				<option>Connecticut</option>
				<option>Delaware</option>
				<option>Florida</option>
				<option>Georgia</option>
				<option>Hawaii</option>
				<option>Idaho</option>
				<option>Illinois</option>
				<option>Indiana</option>
				<option>Iowa</option>
				<option>Kansas</option>
				<option>Kentucky</option>
				<option>Louisiana</option>
				<option>Maine</option>
				<option>Maryland</option>
				<option>Massachusetts</option>
				<option>Michigan</option>
				<option>Minnesota</option>
				<option>Mississipi</option>
				<option>Missouri</option>
				<option>Montana</option>
				<option>Nebraska</option>
				<option>Nevada</option>
				<option>New Hampshire</option>
				<option>New Jersey</option>
				<option>New Mexico</option>
				<option>New York</option>
				<option>North Carolina</option>
				<option>Ohio</option>
				<option>Oklahoma</option>
				<option>Oregon</option>
				<option>Pennsylvania</option>
				<option>Rhode Island</option>
				<option>South Carolina</option>
				<option>South Dakota</option>
				<option>Tennesee</option>
				<option>Texas</option>
				<option>Utah</option>
				<option>Vermont</option>
				<option>Virginia</option>
				<option>Washington</option>
				<option>West Virginia</option>
				<option>Wisconsin</option>
				<option>Wyoming</option>
		     </select>
		    </div>
		    <div class="col-xs-2">
		     <label for="sel2">Select disease:</label>
		     <select name="disease" class="form-control" id="sel2">
				<option>Alcoholism</option>
				<option>Depression</option>
				<option>Cancer</option>
		     </select>
		    </div>
		   	<br>
		    <div class="col-xs-2">
		     <button type="submit" class="btn btn-default">Submit</button>
		    </div>
		   </div>
		 </form>
		 <div id="map"></div>
		<script async defer
    	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBzsp8urNsDvRxkev_T_MxNs6PPhthBo7w&callback=initMap">
    	</script>
	</div>
</body>
</html>

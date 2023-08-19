<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.digit.javaTraining.bean.Plans"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="sty.css">
<title>Insert title here</title>
 <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4; /* Light gray background */
            color: #333; /* Dark gray text color */
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff; /* White background */
            border-radius: 8px;
  
        }

        h2 {
            text-align: center;
            margin-bottom: 0px;
            color: #333; /* Dark gray heading color */
        }

        label {
            font-weight: bold;
            color: #555; /* Medium gray label text color */
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-bottom: 20px;
        }
        
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-bottom: 20px;
        }
        
        button {
            background-color: #008080; /* Dark teal button background color */
            color: #fff; /* White button text color */
            border: none;
            border-radius: 4px;
            padding: 12px 20px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
            width: 100%;
        }

        button:hover {
            background-color: #006666; /* Lighter teal on hover */
        }

        .home-link {
            text-align: center;
            margin-top: 20px;
            display: block;
            color: #008080; /* Dark teal link color */
            text-decoration: none;
        }

        .home-link:hover {
            color: #006666; /* Lighter teal link color on hover */
        }

    </style>
</head>
<body>
	<div class="container">
	<%
	session = request.getSession();
	ArrayList<Plans> a = (ArrayList<Plans>) session.getAttribute("plans");
	%>
	<center>
		<h1 align="center">All Plans</h1>
		<br>
		<table border="1">
			<tr>
				<th>Subscription ID</th>
				<th>Plan</th>
				<th>Amount</th>
			</tr>
			<%
			for (Plans curp : a) {
			%>
			<tr>
				<td><%=curp.getSub_id()%></td>
				<td><%=curp.getPlan()%></td>
				<td><%=curp.getAmount()%></td>
			</tr>
			<%
			}
			%>

		</table>
	</center>
	
		<h2>Select Plan</h2>
	 <form class="form-horizontal" role="form" action="subcription" method="post">
		<label>Subscription ID :</label><br>
		<input type="text" name="sid"><br><br>
		<h2>Bank Login</h2>
		<label>Bank ID :</label><br>
		<input type="text" name="bid"><br>
		<label>Password :</label><br>
		<input type="password" name="pin"><br>
        <button type="submit" class="btn btn-primary btn-dark">Subscribe</button>
    </form>
  
    <!-- Bootstrap JS (optional) -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	
	
	
	<br> <a href="userHome.html">Go To Home</a>
		</div>
</body>
</html>
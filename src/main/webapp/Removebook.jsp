<%@ page import="java.sql.ResultSet"%>

<%@ page import="java.sql.Statement"%>

<%@ page import="java.sql.DriverManager"%>

<%@ page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,com.digit.javaTraining.bean.Plans,com.digit.hibernateServlet.Model.HibernateManager,com.digit.javaTraining.bean.Book"
	%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Transaction History</title>

<link rel="stylesheet" type="text/css" href="sty.css">
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
            margin-bottom: 30px;
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

		<h1>Select Book to Remove</h1>
		<%
		ArrayList<Book> allBook = HibernateManager.getAllBooks();
		%>

		<table>

			<tr>

				<th>Book ID</th>

				<th>Book Name</th>

				<th>Book Author</th>

				<th>Book Cost</th>

				<th>Book Category</th>
				
				<th>Book Status</th>

			</tr>

			<%
			for (Book curBook : allBook) {
			%>
			<tr>
				<td><%=curBook.getBid()%></td>
				<td><%=curBook.getBname()%></td>
				<td><%=curBook.getAuthor()%></td>
				<td><%=curBook.getCost()%></td>
				<td><%=curBook.getCategory()%></td>
				<td><%=curBook.getStatus()%></td>
			</tr>
			<%
			}
			%>

		</table>
		 <form class="form-horizontal" role="form" action="RemoveBook" method="post">
		<label>Enter the Book Id</label><br>
		<input type="text" name="bid"><br><br>
        <button type="submit" class="btn btn-primary btn-dark">Remove</button>
    </form>
  
    <!-- Bootstrap JS (optional) -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>



		<br> <a href="adminHome.html">Go To Home</a>

	</div>

</body>

</html>
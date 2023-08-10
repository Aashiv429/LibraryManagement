<%@ page import="java.sql.ResultSet"%>

<%@ page import="java.sql.Statement"%>

<%@ page import="java.sql.DriverManager"%>

<%@ page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Transaction History</title>

<link rel="stylesheet" type="text/css" href="sty.css">

</head>

<body>

	<div class="container">

		<h1>All Users</h1>

		<table>

			<tr>

				<th>User ID</th>

				<th>User Name</th>

				<th>User Phone</th>

				<th>User Email</th>

				<th>User Status</th>

			</tr>

			<%
			String url = "jdbc:mysql://localhost:3306/Library";

			String user = "root";

			String pwd = "Minion@29";

			try {

				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con = DriverManager.getConnection(url, user, pwd);

				Statement pstmt = con.createStatement();

				ResultSet resultSet = pstmt.executeQuery("SELECT * FROM user");

				while (resultSet.next()== true) {
			%>

			<tr>

				<td><%=resultSet.getInt(1)%></td>

				<td><%=resultSet.getString(2)%></td>

				<td><%=resultSet.getInt(5)%></td>
				<td><%=resultSet.getString(6)%></td>

				<td><%=resultSet.getInt(7)%></td>


			</tr>

			<%
			}

			con.close();

			} catch (Exception e) {

			e.printStackTrace();

			}
			%>

		</table>

		<form action="authUser" align="center">

			<br>
			<br> <label>Enter User Id to Select</label><br> <input
				type="text" name="user_id"><br> <br> <input
				type="submit">

		</form>



		<br> <a href="index.html">Go To Home</a>

	</div>

</body>

</html>
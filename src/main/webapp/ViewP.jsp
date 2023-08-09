<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.digit.javaTraining.bean.Plans"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	session = request.getSession();
	ArrayList<Plans> p = (ArrayList<Plans>) session.getAttribute("Allplans");
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
			for (Plans curp : p) {
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
		<br>
		<br>
	</center>
	<center>
		<h2>Select Plan</h2>
	</center>
	<form action="" method="post">
		<center>
			<label>Subscription ID : </label><input type="text" name="sid"><br>
			<br> <input type="submit"><br> <br>
		</center>
	</form>
</body>
</html>
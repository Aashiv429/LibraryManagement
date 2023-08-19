<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.digit.javaTraining.bean.Plans,com.digit.hibernateServlet.Model.HibernateManager,com.digit.javaTraining.bean.Subscription"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="sty.css">
</head>
<body>

	<div class="container">
	<h1>Subscription History</h1>
	<%
	ArrayList<Subscription> allSubscriptions = HibernateManager.getAllSubscriptions();
	%>
<br>
<table>
<tr>
<th>Subscription_Id</th>
<th>Amount</th>
<th>Invoice</th>
<th>UserId</th>
<th>Date</th>
</tr>

	<%
	for (Subscription curSub : allSubscriptions) { %>
	    <tr>
		<td><%=curSub.getSub_id()%></td>
		<td><%=curSub.getAmount()%></td>
		<td><%=curSub.getInvoice()%></td>
		<td><%=curSub.getUser_id()%></td>
		<td><%=curSub.getDate()%></td>
		</tr>
	<%
	}
	%>
	</table>
		<br> <a href="adminHome.html">Go To Home</a>
</div>
</body>
</html>